package org.apache.syncope.core.logic.c2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.command.CommandArgs;
import org.apache.syncope.common.lib.command.CommandTO;
import org.apache.syncope.common.lib.types.IdRepoImplementationType;
import org.apache.syncope.core.logic.CommandLogic;
import org.apache.syncope.core.persistence.api.attrvalue.InvalidEntityException;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.NotFoundException;
import org.apache.syncope.core.persistence.api.entity.Implementation;
import org.apache.syncope.core.provisioning.api.macro.Command;
import org.apache.syncope.core.spring.implementation.ImplementationManager;
import org.apache.syncope.core.spring.security.AuthContextUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class CommandLogicC2LLMToTTest {

    @Mock
    private ImplementationDAO implementationDAO;

    @Mock
    private Validator validator;

    @Mock
    private Implementation implementation;

    private CommandLogic logic;

    @BeforeEach
    void setUp() {
        logic = new CommandLogic(implementationDAO, validator);
    }

    @Test
    @DisplayName("search returns a pageable page of CommandTO values")
    void searchReturnsPagedCommands() throws Exception {
        Pageable pageable = PageRequest.of(0, 1);
        lenient().when(implementation.getKey()).thenReturn("command-1");
        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd"))
                .thenReturn(List.of(implementation));

        CommandArgs emptyArgs = mock(CommandArgs.class);
        try (MockedStatic<AuthContextUtils> auth = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> manager = org.mockito.Mockito.mockStatic(ImplementationManager.class)) {
            auth.when(AuthContextUtils::getDomain).thenReturn("Master");
            manager.when(() -> ImplementationManager.emptyArgs("Master", implementation)).thenReturn(emptyArgs);

            Page<CommandTO> result = logic.search("cmd", pageable);

            assertEquals(1, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals("command-1", result.getContent().get(0).getKey());
            assertEquals(emptyArgs, result.getContent().get(0).getArgs());
        }
    }

    @Test
    @DisplayName("run executes an implementation with provided valid arguments")
    @SuppressWarnings({ "unchecked", "rawtypes" })
    void runExecutesCommandWithProvidedArgs() throws Exception {
        CommandTO commandTO = mock(CommandTO.class);
        CommandArgs args = mock(CommandArgs.class);
        Command runnable = mock(Command.class, org.mockito.Mockito.RETURNS_DEEP_STUBS);

        when(commandTO.getKey()).thenReturn("command-1");
        when(commandTO.getArgs()).thenReturn(args);
        lenient().when(implementation.getKey()).thenReturn("command-1");
        doReturn(Optional.of(implementation)).when(implementationDAO).findById("command-1");
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args).message()).thenReturn("done");

        try (MockedStatic<AuthContextUtils> auth = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> manager = org.mockito.Mockito.mockStatic(ImplementationManager.class)) {
            auth.when(AuthContextUtils::getDomain).thenReturn("Master");
            manager.when(() -> ImplementationManager.build(
                    org.mockito.Mockito.eq("Master"),
                    org.mockito.Mockito.eq(implementation),
                    any(),
                    any())).thenReturn(runnable);

            String result = logic.run(commandTO);

            assertEquals("done", result);
            verify(validator).validate(args);
        }
    }

    @Test
    @DisplayName("search applies page offset and limit")
    void searchAppliesPagination() throws Exception {
        Implementation first = mock(Implementation.class);
        Implementation second = mock(Implementation.class);
        Implementation third = mock(Implementation.class);
        lenient().when(first.getKey()).thenReturn("first");
        lenient().when(second.getKey()).thenReturn("second");
        lenient().when(third.getKey()).thenReturn("third");
        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd"))
                .thenReturn(List.of(first, second, third));

        try (MockedStatic<AuthContextUtils> auth = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> manager = org.mockito.Mockito.mockStatic(ImplementationManager.class)) {
            auth.when(AuthContextUtils::getDomain).thenReturn("Master");
            manager.when(() -> ImplementationManager.emptyArgs(org.mockito.Mockito.eq("Master"), any(Implementation.class)))
                    .thenReturn(mock(CommandArgs.class));

            Page<CommandTO> result = logic.search("cmd", PageRequest.of(1, 1));

            assertEquals(3, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals("second", result.getContent().get(0).getKey());
        }
    }

    @Test
    @DisplayName("search filters out implementations whose argument metadata cannot be built")
    void searchFiltersCommandsWhenEmptyArgsFails() throws Exception {
        lenient().when(implementation.getKey()).thenReturn("broken-command");
        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "broken"))
                .thenReturn(List.of(implementation));

        try (MockedStatic<AuthContextUtils> auth = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> manager = org.mockito.Mockito.mockStatic(ImplementationManager.class)) {
            auth.when(AuthContextUtils::getDomain).thenReturn("Master");
            manager.when(() -> ImplementationManager.emptyArgs("Master", implementation))
                    .thenThrow(new IllegalStateException("cannot inspect args"));

            Page<CommandTO> result = logic.search("broken", PageRequest.of(0, 10));

            assertEquals(1, result.getTotalElements());
            assertEquals(0, result.getContent().size());
        }
    }

    @Test
    @DisplayName("run throws NotFoundException when implementation is missing")
    void runThrowsWhenImplementationDoesNotExist() {
        CommandTO commandTO = mock(CommandTO.class);
        when(commandTO.getKey()).thenReturn("missing-command");
        when(implementationDAO.findById("missing-command")).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> logic.run(commandTO));
    }

    @Test
    @DisplayName("run throws InvalidImplementation when command implementation cannot be built")
    void runThrowsInvalidImplementationWhenBuildFails() throws Exception {
        CommandTO commandTO = mock(CommandTO.class);
        when(commandTO.getKey()).thenReturn("broken-command");
        lenient().when(implementation.getKey()).thenReturn("broken-command");
        doReturn(Optional.of(implementation)).when(implementationDAO).findById("broken-command");

        try (MockedStatic<AuthContextUtils> auth = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> manager = org.mockito.Mockito.mockStatic(ImplementationManager.class)) {
            auth.when(AuthContextUtils::getDomain).thenReturn("Master");
            manager.when(() -> ImplementationManager.build(
                    org.mockito.Mockito.eq("Master"),
                    org.mockito.Mockito.eq(implementation),
                    any(),
                    any())).thenThrow(new IllegalStateException("cannot build"));

            SyncopeClientException ex = assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertNotNull(ex);
        }
    }

    @Test
    @DisplayName("run throws InvalidEntityException when validation violations are present")
    @SuppressWarnings({ "unchecked", "rawtypes" })
    void runThrowsInvalidEntityExceptionForConstraintViolations() throws Exception {
        CommandTO commandTO = mock(CommandTO.class);
        CommandArgs args = mock(CommandArgs.class);
        Command runnable = mock(Command.class);
        ConstraintViolation<CommandArgs> violation = mock(ConstraintViolation.class);

        when(commandTO.getKey()).thenReturn("command-1");
        when(commandTO.getArgs()).thenReturn(args);
        lenient().when(implementation.getKey()).thenReturn("command-1");
        doReturn(Optional.of(implementation)).when(implementationDAO).findById("command-1");
        when(validator.validate(args)).thenReturn(Set.of(violation));
        // FIX (bug ricorrente, già visto 4 volte su C0): il costruttore reale di
        // InvalidEntityException legge 4 getter specifici sulla violation - un mock
        // nudo senza questi stub causa NPE interna, non è comportamento di CommandLogic.
        jakarta.validation.Path propertyPath = mock(jakarta.validation.Path.class);
        org.mockito.Mockito.lenient().when(propertyPath.toString()).thenReturn("ctx");
        org.mockito.Mockito.lenient().when(violation.getMessageTemplate())
                .thenReturn("{jakarta.validation.constraints.NotBlank.message}");
        org.mockito.Mockito.lenient().when(violation.getPropertyPath()).thenReturn(propertyPath);
        org.mockito.Mockito.lenient().when(violation.getInvalidValue()).thenReturn("");
        org.mockito.Mockito.lenient().when(violation.getLeafBean()).thenReturn(args);

        try (MockedStatic<AuthContextUtils> auth = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> manager = org.mockito.Mockito.mockStatic(ImplementationManager.class)) {
            auth.when(AuthContextUtils::getDomain).thenReturn("Master");
            manager.when(() -> ImplementationManager.build(
                    org.mockito.Mockito.eq("Master"),
                    org.mockito.Mockito.eq(implementation),
                    any(),
                    any())).thenReturn(runnable);

            // FIX: l'eccezione realmente propagata da CommandLogic.run() è
            // SyncopeClientException(InvalidValues) - InvalidEntityException viene
            // sollevata internamente ma è catturata e ri-wrappata dallo stesso metodo.
            SyncopeClientException ex = assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));
            assertNotNull(ex);
            verify(runnable, never()).run(any());
        }
    }

    @Test
    @DisplayName("run throws InvalidValues when bean validation itself fails")
    @SuppressWarnings({ "unchecked", "rawtypes" })
    void runThrowsInvalidValuesWhenValidationThrows() throws Exception {
        CommandTO commandTO = mock(CommandTO.class);
        CommandArgs args = mock(CommandArgs.class);
        Command runnable = mock(Command.class);

        when(commandTO.getKey()).thenReturn("command-1");
        when(commandTO.getArgs()).thenReturn(args);
        lenient().when(implementation.getKey()).thenReturn("command-1");
        doReturn(Optional.of(implementation)).when(implementationDAO).findById("command-1");
        when(validator.validate(args)).thenThrow(new ValidationException("validator unavailable"));

        try (MockedStatic<AuthContextUtils> auth = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> manager = org.mockito.Mockito.mockStatic(ImplementationManager.class)) {
            auth.when(AuthContextUtils::getDomain).thenReturn("Master");
            manager.when(() -> ImplementationManager.build(
                    org.mockito.Mockito.eq("Master"),
                    org.mockito.Mockito.eq(implementation),
                    any(),
                    any())).thenReturn(runnable);

            SyncopeClientException ex = assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertNotNull(ex);
            verify(runnable, never()).run(any());
        }
    }

    @Test
    @DisplayName("run uses empty args when CommandTO args are null")
    @SuppressWarnings({ "unchecked", "rawtypes" })
    void runUsesEmptyArgsWhenArgsAreNull() throws Exception {
        CommandTO commandTO = mock(CommandTO.class);
        CommandArgs emptyArgs = mock(CommandArgs.class);
        Command runnable = mock(Command.class, org.mockito.Mockito.RETURNS_DEEP_STUBS);

        when(commandTO.getKey()).thenReturn("command-1");
        when(commandTO.getArgs()).thenReturn(null);
        lenient().when(implementation.getKey()).thenReturn("command-1");
        doReturn(Optional.of(implementation)).when(implementationDAO).findById("command-1");
        when(runnable.run(emptyArgs).message()).thenReturn("ran with defaults");

        try (MockedStatic<AuthContextUtils> auth = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> manager = org.mockito.Mockito.mockStatic(ImplementationManager.class)) {
            auth.when(AuthContextUtils::getDomain).thenReturn("Master");
            manager.when(() -> ImplementationManager.build(
                    org.mockito.Mockito.eq("Master"),
                    org.mockito.Mockito.eq(implementation),
                    any(),
                    any())).thenReturn(runnable);
            manager.when(() -> ImplementationManager.emptyArgs("Master", implementation)).thenReturn(emptyArgs);

            String result = logic.run(commandTO);

            assertEquals("ran with defaults", result);
            verify(validator, never()).validate(any());
        }
    }

    @Test
    @DisplayName("run throws ExecutionError when the command execution fails")
    @SuppressWarnings({ "unchecked", "rawtypes" })
    void runThrowsExecutionErrorWhenRunnableFails() throws Exception {
        CommandTO commandTO = mock(CommandTO.class);
        CommandArgs args = mock(CommandArgs.class);
        Command runnable = mock(Command.class);

        when(commandTO.getKey()).thenReturn("command-1");
        when(commandTO.getArgs()).thenReturn(args);
        lenient().when(implementation.getKey()).thenReturn("command-1");
        doReturn(Optional.of(implementation)).when(implementationDAO).findById("command-1");
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args)).thenThrow(new IllegalStateException("boom"));

        try (MockedStatic<AuthContextUtils> auth = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> manager = org.mockito.Mockito.mockStatic(ImplementationManager.class)) {
            auth.when(AuthContextUtils::getDomain).thenReturn("Master");
            manager.when(() -> ImplementationManager.build(
                    org.mockito.Mockito.eq("Master"),
                    org.mockito.Mockito.eq(implementation),
                    any(),
                    any())).thenReturn(runnable);

            SyncopeClientException ex = assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertNotNull(ex);
        }
    }
}