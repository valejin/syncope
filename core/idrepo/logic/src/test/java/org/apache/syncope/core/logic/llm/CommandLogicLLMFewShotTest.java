package org.apache.syncope.core.logic.llm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.command.CommandArgs;
import org.apache.syncope.common.lib.command.CommandTO;
import org.apache.syncope.common.lib.types.ClientExceptionType;
import org.apache.syncope.common.lib.types.IdRepoImplementationType;
import org.apache.syncope.core.logic.CommandLogic;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.NotFoundException;
import org.apache.syncope.core.persistence.api.entity.Implementation;
import org.apache.syncope.core.provisioning.api.macro.Command;
import org.apache.syncope.core.spring.implementation.ImplementationManager;
import org.apache.syncope.core.spring.security.AuthContextUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import jakarta.validation.Path;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
class CommandLogicLLMFewShotTest {

    private static final String DOMAIN = "Master";

    private ImplementationDAO implementationDAO;

    private Validator validator;

    private CommandLogic commandLogic;

    @BeforeEach
    void setUp() {
        implementationDAO = mock(ImplementationDAO.class);
        validator = mock(Validator.class);
        commandLogic = new CommandLogic(implementationDAO, validator);
    }

    @Test
    @DisplayName("TF1: keyword con wildcard/match, pageable nominale, 3 elementi -> pagina popolata (O1)")
    void tf1_nominalSearch() {
        // Arrange
        Implementation impl1 = mockImplementation("cmd1");
        Implementation impl2 = mockImplementation("cmd2");
        Implementation impl3 = mockImplementation("cmd3");

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "%backup%")).
                thenReturn(List.of(impl1, impl2, impl3));

        try (MockedStatic<AuthContextUtils> acu = mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {

            acu.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            im.when(() -> ImplementationManager.emptyArgs(eq(DOMAIN), eq(impl1))).thenReturn(new CommandArgs());
            im.when(() -> ImplementationManager.emptyArgs(eq(DOMAIN), eq(impl2))).thenReturn(new CommandArgs());
            im.when(() -> ImplementationManager.emptyArgs(eq(DOMAIN), eq(impl3))).thenReturn(new CommandArgs());

            // Act
            Page<CommandTO> page = commandLogic.search("%backup%", PageRequest.of(0, 10));

            // Assert
            assertEquals(3, page.getContent().size());
            assertEquals(3, page.getTotalElements());
            assertEquals(List.of("cmd1", "cmd2", "cmd3"),
                    page.getContent().stream().map(CommandTO::getKey).toList());
        }
    }

    @Test
    @DisplayName("TF2: search con seconda pagina -> solo elementi della pagina richiesta (O1)")
    void tf2_searchSecondPage() {
        // Arrange
        Implementation impl1 = mockImplementation("cmd1");
        Implementation impl2 = mockImplementation("cmd2");
        Implementation impl3 = mockImplementation("cmd3");

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd")).
                thenReturn(List.of(impl1, impl2, impl3));

        try (MockedStatic<AuthContextUtils> acu = mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {

            acu.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            im.when(() -> ImplementationManager.emptyArgs(eq(DOMAIN), eq(impl3))).thenReturn(new CommandArgs());

            // Act
            Page<CommandTO> page = commandLogic.search("cmd", PageRequest.of(1, 2));

            // Assert
            assertEquals(1, page.getContent().size());
            assertEquals(3, page.getTotalElements());
            assertEquals(List.of("cmd3"),
                    page.getContent().stream().map(CommandTO::getKey).toList());
        }
    }

    @Test
    @DisplayName("TF3: search senza risultati -> pagina vuota (O2)")
    void tf3_searchEmptyResult() {
        // Arrange
        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "missing")).
                thenReturn(List.of());

        // Act
        Page<CommandTO> page = commandLogic.search("missing", PageRequest.of(0, 10));

        // Assert
        assertEquals(0, page.getContent().size());
        assertEquals(0, page.getTotalElements());
    }

    @Test
    @DisplayName("TF4: search con offset oltre la dimensione della lista -> contenuto vuoto ma totale valorizzato (O2)")
    void tf4_searchPageOutOfRange() {
        // Arrange
        Implementation impl1 = mockImplementation("cmd1");
        Implementation impl2 = mockImplementation("cmd2");

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd")).
                thenReturn(List.of(impl1, impl2));

        // Act
        Page<CommandTO> page = commandLogic.search("cmd", PageRequest.of(2, 10));

        // Assert
        assertEquals(0, page.getContent().size());
        assertEquals(2, page.getTotalElements());
    }

    @Test
    @DisplayName("TF5: search con emptyArgs che fallisce per un comando -> comando scartato (O3)")
    void tf5_searchSkipsCommandWhenEmptyArgsFails() {
        // Arrange
        Implementation ok = mockImplementation("ok");
        Implementation ko = mockImplementation("ko");

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd")).
                thenReturn(List.of(ok, ko));

        try (MockedStatic<AuthContextUtils> acu = mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {

            acu.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            im.when(() -> ImplementationManager.emptyArgs(eq(DOMAIN), eq(ok))).thenReturn(new CommandArgs());
            im.when(() -> ImplementationManager.emptyArgs(eq(DOMAIN), eq(ko))).
                    thenThrow(new IllegalStateException("Cannot resolve args"));

            // Act
            Page<CommandTO> page = commandLogic.search("cmd", PageRequest.of(0, 10));

            // Assert
            assertEquals(1, page.getContent().size());
            assertEquals(2, page.getTotalElements());
            assertEquals(List.of("ok"), page.getContent().stream().map(CommandTO::getKey).toList());
        }
    }

    @Test
    @DisplayName("TF6: run nominale con args validi -> messaggio restituito (O4)")
    void tf6_runWithValidArgs() {
        // Arrange
        Implementation impl = mockImplementation("clear-cache");
        doReturn(Optional.of(impl)).when(implementationDAO).findById("clear-cache");

        CommandArgs args = new CommandArgs();
        CommandTO command = new CommandTO.Builder("clear-cache").args(args).build();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(same(args))).thenReturn(new Command.Result("Cache cleared", Map.<String, Serializable>of()));

        try (MockedStatic<AuthContextUtils> acu = mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {

            acu.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            im.when(() -> ImplementationManager.build(eq(DOMAIN), eq(impl), any(), any())).
                    thenReturn(runnable);

            // Act
            String result = commandLogic.run(command);

            // Assert
            assertEquals("Cache cleared", result);
            verify(validator).validate(args);
        }
    }

    @Test
    @DisplayName("TF7: args con violazioni di vincolo -> SyncopeClientException InvalidValues (O5)")
    void tf7_argsWithViolations() {
        // Arrange
        Implementation impl = mockImplementation("clear-cache");
        doReturn(Optional.of(impl)).when(implementationDAO).findById("clear-cache");

        ConstraintViolation<Object> violation = mockViolation();
        when(validator.validate(any())).thenReturn(Set.of(violation));

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        CommandTO command = new CommandTO.Builder("clear-cache").args(new CommandArgs()).build();

        try (MockedStatic<AuthContextUtils> acu = mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {

            acu.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            im.when(() -> ImplementationManager.build(eq(DOMAIN), eq(impl), any(), any())).
                    thenReturn(runnable);

            // Act
            SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                    () -> commandLogic.run(command));

            // Assert
            assertEquals(ClientExceptionType.InvalidValues, sce.getType());
        }
    }

    @Test
    @DisplayName("TF8: run con command non esistente -> NotFoundException (O6)")
    void tf8_runCommandNotFound() {
        // Arrange
        doReturn(Optional.empty()).when(implementationDAO).findById("missing");

        CommandTO command = new CommandTO.Builder("missing").args(new CommandArgs()).build();

        // Act
        NotFoundException nfe = assertThrows(NotFoundException.class, () -> commandLogic.run(command));

        // Assert
        assertEquals("Implementation missing", nfe.getMessage());
    }

    @Test
    @DisplayName("TF9: build del comando fallisce -> SyncopeClientException InvalidImplementation (O7)")
    void tf9_runBuildFails() {
        // Arrange
        Implementation impl = mockImplementation("broken");
        doReturn(Optional.of(impl)).when(implementationDAO).findById("broken");

        CommandTO command = new CommandTO.Builder("broken").args(new CommandArgs()).build();

        try (MockedStatic<AuthContextUtils> acu = mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {

            acu.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            im.when(() -> ImplementationManager.build(eq(DOMAIN), eq(impl), any(), any())).
                    thenThrow(new IllegalStateException("Cannot build command"));

            // Act
            SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                    () -> commandLogic.run(command));

            // Assert
            assertEquals(ClientExceptionType.InvalidImplementation, sce.getType());
            assertEquals(Set.of("Could not build broken"), sce.getElements());
        }
    }

    @Test
    @DisplayName("TF10: validator solleva ValidationException -> SyncopeClientException InvalidValues (O5)")
    void tf10_validatorThrowsValidationException() {
        // Arrange
        Implementation impl = mockImplementation("validate-error");
        doReturn(Optional.of(impl)).when(implementationDAO).findById("validate-error");

        CommandArgs args = new CommandArgs();
        CommandTO command = new CommandTO.Builder("validate-error").args(args).build();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        when(validator.validate(args)).thenThrow(new ValidationException("Validation engine failure"));

        try (MockedStatic<AuthContextUtils> acu = mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {

            acu.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            im.when(() -> ImplementationManager.build(eq(DOMAIN), eq(impl), any(), any())).
                    thenReturn(runnable);

            // Act
            SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                    () -> commandLogic.run(command));

            // Assert
            assertEquals(ClientExceptionType.InvalidValues, sce.getType());
            assertEquals(Set.of("Validation engine failure"), sce.getElements());
        }
    }

    @Test
    @DisplayName("TF11: run senza args -> usa emptyArgs e restituisce il messaggio (O4)")
    void tf11_runWithoutArgsUsesEmptyArgs() {
        // Arrange
        Implementation impl = mockImplementation("defaults");
        doReturn(Optional.of(impl)).when(implementationDAO).findById("defaults");

        CommandArgs defaultArgs = new CommandArgs();
        CommandTO command = new CommandTO.Builder("defaults").build();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        when(runnable.run(same(defaultArgs))).thenReturn(new Command.Result("Ran with defaults", Map.<String, Serializable>of()));

        try (MockedStatic<AuthContextUtils> acu = mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {

            acu.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            im.when(() -> ImplementationManager.build(eq(DOMAIN), eq(impl), any(), any())).
                    thenReturn(runnable);
            im.when(() -> ImplementationManager.emptyArgs(eq(DOMAIN), eq(impl))).thenReturn(defaultArgs);

            // Act
            String result = commandLogic.run(command);

            // Assert
            assertEquals("Ran with defaults", result);
            verify(validator, never()).validate(any());
            im.verify(() -> ImplementationManager.emptyArgs(eq(DOMAIN), eq(impl)));
        }
    }

    @Test
    @DisplayName("TF12: runnable fallisce durante l'esecuzione -> SyncopeClientException ExecutionError (O8)")
    void tf12_runnableThrowsExecutionError() {
        // Arrange
        Implementation impl = mockImplementation("explode");
        doReturn(Optional.of(impl)).when(implementationDAO).findById("explode");

        CommandArgs args = new CommandArgs();
        CommandTO command = new CommandTO.Builder("explode").args(args).build();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(same(args))).thenThrow(new IllegalStateException("Boom"));

        try (MockedStatic<AuthContextUtils> acu = mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {

            acu.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            im.when(() -> ImplementationManager.build(eq(DOMAIN), eq(impl), any(), any())).
                    thenReturn(runnable);

            // Act
            SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                    () -> commandLogic.run(command));

            // Assert
            assertEquals(ClientExceptionType.ExecutionError, sce.getType());
            assertEquals(Set.of("Boom"), sce.getElements());
        }
    }

    private Implementation mockImplementation(final String key) {
        Implementation implementation = mock(Implementation.class);
        Mockito.lenient().when(implementation.getKey()).thenReturn(key);
        return implementation;
    }


    @SuppressWarnings("unchecked")
    private ConstraintViolation<Object> mockViolation() {
        ConstraintViolation<Object> violation = mock(ConstraintViolation.class);
        when(violation.getMessageTemplate()).thenReturn("dummy;dummy message");
        when(violation.getPropertyPath()).thenReturn(mock(Path.class));
        when(violation.getInvalidValue()).thenReturn("dummy");
        when(violation.getLeafBean()).thenReturn(new Object());
        return violation;
    }
}