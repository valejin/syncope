package org.apache.syncope.core.logic.llm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
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
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

class CommandLogicLLMZeroShotTest {

    private static final String DOMAIN = "Master";

    private ImplementationDAO implementationDAO;

    private Validator validator;

    private CommandLogic logic;

    @BeforeEach
    void setUp() {
        implementationDAO = mock(ImplementationDAO.class);
        validator = mock(Validator.class);
        logic = new CommandLogic(implementationDAO, validator);
    }

    @Test
    void searchReturnsRequestedPageWithCommandTransferObjects() {
        Implementation first = implementation("command-1");
        Implementation second = implementation("command-2");
        Implementation third = implementation("command-3");

        CommandArgs argsForFirst = mock(CommandArgs.class);
        CommandArgs argsForSecond = mock(CommandArgs.class);

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd")).
                thenReturn(List.of(first, second, third));

        try (MockedStatic<AuthContextUtils> authContextUtils = Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> implementationManager =
                     Mockito.mockStatic(ImplementationManager.class)) {

            authContextUtils.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            implementationManager.when(() -> ImplementationManager.emptyArgs(DOMAIN, first)).
                    thenReturn(argsForFirst);
            implementationManager.when(() -> ImplementationManager.emptyArgs(DOMAIN, second)).
                    thenReturn(argsForSecond);

            Page<CommandTO> result = logic.search("cmd", PageRequest.of(0, 2));

            assertEquals(3L, result.getTotalElements());
            assertEquals(0, result.getNumber());
            assertEquals(2, result.getSize());
            assertEquals(2, result.getContent().size());
            assertEquals("command-1", result.getContent().get(0).getKey());
            assertSame(argsForFirst, result.getContent().get(0).getArgs());
            assertEquals("command-2", result.getContent().get(1).getKey());
            assertSame(argsForSecond, result.getContent().get(1).getArgs());

            implementationManager.verify(() -> ImplementationManager.emptyArgs(DOMAIN, first));
            implementationManager.verify(() -> ImplementationManager.emptyArgs(DOMAIN, second));
        }
    }

    @Test
    void searchFiltersOutCommandsWhoseArgumentsCannotBeBuilt() {
        Implementation valid = implementation("valid-command");
        Implementation invalid = implementation("invalid-command");
        CommandArgs validArgs = mock(CommandArgs.class);

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd")).
                thenReturn(List.of(valid, invalid));

        try (MockedStatic<AuthContextUtils> authContextUtils = Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> implementationManager =
                     Mockito.mockStatic(ImplementationManager.class)) {

            authContextUtils.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            implementationManager.when(() -> ImplementationManager.emptyArgs(DOMAIN, valid)).
                    thenReturn(validArgs);
            implementationManager.when(() -> ImplementationManager.emptyArgs(DOMAIN, invalid)).
                    thenThrow(new IllegalStateException("cannot inspect args"));

            Page<CommandTO> result = logic.search("cmd", PageRequest.of(0, 10));

            assertEquals(2L, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals("valid-command", result.getContent().get(0).getKey());
            assertSame(validArgs, result.getContent().get(0).getArgs());
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    void runBuildsCommandValidatesProvidedArgsAndReturnsMessage() throws Exception {
        Implementation implementation = implementation("echo");
        CommandArgs commandArgs = mock(CommandArgs.class);
        CommandTO commandTO = new CommandTO.Builder("echo").args(commandArgs).build();
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById("echo");
        doReturn(Set.of()).when(validator).validate(commandArgs);
        when(runnable.run(commandArgs)).
                thenReturn(new Command.Result("executed", Map.<String, Serializable>of()));

        try (MockedStatic<AuthContextUtils> authContextUtils = Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> implementationManager =
                     Mockito.mockStatic(ImplementationManager.class)) {

            authContextUtils.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            implementationManager.when(() -> ImplementationManager.build(
                            eq(DOMAIN),
                            same(implementation),
                            any(),
                            any())).
                    thenReturn(runnable);

            String result = logic.run(commandTO);

            assertEquals("executed", result);
            verify(validator).validate(commandArgs);
            verify(runnable).run(commandArgs);
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    void runUsesEmptyArgumentsWhenCommandArgumentsAreNull() throws Exception {
        Implementation implementation = implementation("no-args");
        CommandArgs emptyArgs = mock(CommandArgs.class);
        CommandTO commandTO = new CommandTO.Builder("no-args").build();
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById("no-args");
        when(runnable.run(emptyArgs)).
                thenReturn(new Command.Result("executed-with-empty-args", Map.<String, Serializable>of()));

        try (MockedStatic<AuthContextUtils> authContextUtils = Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> implementationManager =
                     Mockito.mockStatic(ImplementationManager.class)) {

            authContextUtils.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            implementationManager.when(() -> ImplementationManager.build(
                            eq(DOMAIN),
                            same(implementation),
                            any(),
                            any())).
                    thenReturn(runnable);
            implementationManager.when(() -> ImplementationManager.emptyArgs(DOMAIN, implementation)).
                    thenReturn(emptyArgs);

            String result = logic.run(commandTO);

            assertEquals("executed-with-empty-args", result);
            verify(runnable).run(emptyArgs);
            implementationManager.verify(() -> ImplementationManager.emptyArgs(DOMAIN, implementation));
        }
    }

    @Test
    void runThrowsNotFoundWhenImplementationDoesNotExist() {
        CommandTO commandTO = new CommandTO.Builder("missing").build();

        doReturn(Optional.empty()).when(implementationDAO).findById("missing");

        NotFoundException exception = assertThrows(NotFoundException.class, () -> logic.run(commandTO));

        assertTrue(exception.getMessage().contains("Implementation missing"));
    }

    @Test
    void runWrapsImplementationBuildFailureAsInvalidImplementation() {
        Implementation implementation = implementation("broken");
        CommandTO commandTO = new CommandTO.Builder("broken").build();

        doReturn(Optional.of(implementation)).when(implementationDAO).findById("broken");

        try (MockedStatic<AuthContextUtils> authContextUtils = Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> implementationManager =
                     Mockito.mockStatic(ImplementationManager.class)) {

            authContextUtils.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            implementationManager.when(() -> ImplementationManager.build(
                            eq(DOMAIN),
                            same(implementation),
                            any(),
                            any())).
                    thenThrow(new IllegalStateException("build failed"));

            SyncopeClientException exception =
                    assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertEquals(ClientExceptionType.InvalidImplementation, exception.getType());
            assertTrue(exception.getElements().contains("Could not build broken"));
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    void runThrowsInvalidEntityExceptionWhenValidationViolationsExist() throws Exception {
        Implementation implementation = implementation("validate");
        CommandArgs commandArgs = mock(CommandArgs.class);
        CommandTO commandTO = new CommandTO.Builder("validate").args(commandArgs).build();
        Command<CommandArgs> runnable = mock(Command.class);
        ConstraintViolation<CommandArgs> violation = mock(ConstraintViolation.class);
        // Stub sui 4 getter letti dal costruttore di InvalidEntityException:
        // getMessageTemplate() (non getMessage()!), getPropertyPath(), getInvalidValue(), getLeafBean().
        when(violation.getMessageTemplate()).thenReturn("dummy;dummy message");
        when(violation.getPropertyPath()).thenReturn(mock(Path.class));
        when(violation.getInvalidValue()).thenReturn("dummy");
        when(violation.getLeafBean()).thenReturn(new Object());

        doReturn(Optional.of(implementation)).when(implementationDAO).findById("validate");
        doReturn(Set.of(violation)).when(validator).validate(commandArgs);

        try (MockedStatic<AuthContextUtils> authContextUtils = Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> implementationManager =
                     Mockito.mockStatic(ImplementationManager.class)) {

            authContextUtils.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            implementationManager.when(() -> ImplementationManager.build(
                            eq(DOMAIN),
                            same(implementation),
                            any(),
                            any())).
                    thenReturn(runnable);

            // InvalidEntityException è una ValidationException: viene intercettata dal
            // catch(ValidationException e) di CommandLogic.run(...) e ri-lanciata come
            // SyncopeClientException(InvalidValues).
            SyncopeClientException exception =
                    assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertEquals(ClientExceptionType.InvalidValues, exception.getType());
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    void runWrapsValidatorExceptionAsInvalidValues() throws Exception {
        Implementation implementation = implementation("validation-error");
        CommandArgs commandArgs = mock(CommandArgs.class);
        CommandTO commandTO = new CommandTO.Builder("validation-error").args(commandArgs).build();
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById("validation-error");
        doThrow(new ValidationException("invalid values")).when(validator).validate(commandArgs);

        try (MockedStatic<AuthContextUtils> authContextUtils = Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> implementationManager =
                     Mockito.mockStatic(ImplementationManager.class)) {

            authContextUtils.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            implementationManager.when(() -> ImplementationManager.build(
                            eq(DOMAIN),
                            same(implementation),
                            any(),
                            any())).
                    thenReturn(runnable);

            SyncopeClientException exception =
                    assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertEquals(ClientExceptionType.InvalidValues, exception.getType());
            assertTrue(exception.getElements().contains("invalid values"));
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    void runWrapsCommandExecutionFailureAsExecutionError() throws Exception {
        Implementation implementation = implementation("explode");
        CommandArgs commandArgs = mock(CommandArgs.class);
        CommandTO commandTO = new CommandTO.Builder("explode").args(commandArgs).build();
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById("explode");
        doReturn(Set.of()).when(validator).validate(commandArgs);
        when(runnable.run(commandArgs)).thenThrow(new IllegalStateException("boom"));

        try (MockedStatic<AuthContextUtils> authContextUtils = Mockito.mockStatic(AuthContextUtils.class);
             MockedStatic<ImplementationManager> implementationManager =
                     Mockito.mockStatic(ImplementationManager.class)) {

            authContextUtils.when(AuthContextUtils::getDomain).thenReturn(DOMAIN);
            implementationManager.when(() -> ImplementationManager.build(
                            eq(DOMAIN),
                            same(implementation),
                            any(),
                            any())).
                    thenReturn(runnable);

            SyncopeClientException exception =
                    assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertEquals(ClientExceptionType.ExecutionError, exception.getType());
            assertTrue(exception.getElements().contains("boom"));
        }
    }

    private static Implementation implementation(final String key) {
        Implementation implementation = mock(Implementation.class);
        when(implementation.getKey()).thenReturn(key);
        return implementation;
    }


}