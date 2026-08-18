package org.apache.syncope.core.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
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
import org.apache.syncope.core.persistence.api.attrvalue.InvalidEntityException;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.NotFoundException;
import org.apache.syncope.core.persistence.api.entity.Implementation;
import org.apache.syncope.core.spring.implementation.ImplementationManager;
import org.apache.syncope.core.spring.security.AuthContextUtils;
import org.apache.syncope.core.provisioning.api.macro.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class CommandLogicToTTest {

    @Mock
    private ImplementationDAO implementationDAO;

    @Mock
    private Validator validator;

    private CommandLogic logic;

    @BeforeEach
    void setUp() {
        logic = new CommandLogic(implementationDAO, validator);
    }

    private Implementation implementation(final String key) {
        Implementation impl = mock(Implementation.class);
        when(impl.getKey()).thenReturn(key);
        return impl;
    }

    private CommandArgs commandArgs() {
        return mock(CommandArgs.class);
    }

    // ---------------------------------------------------------------------
    // search(String keyword, Pageable pageable)
    // ---------------------------------------------------------------------

    @Test
    void searchShouldReturnMatchingCommands() throws Exception {
        Implementation impl = implementation("command1");
        CommandArgs args = commandArgs();
        Pageable pageable = PageRequest.of(0, 10);

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "audit"))
                .thenReturn(List.of(impl));

        try (
                MockedStatic<AuthContextUtils> authContext = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
                MockedStatic<ImplementationManager> implementationManager =
                        org.mockito.Mockito.mockStatic(ImplementationManager.class)
        ) {
            authContext.when(AuthContextUtils::getDomain).thenReturn("Master");
            implementationManager.when(() -> ImplementationManager.emptyArgs("Master", impl)).thenReturn(args);

            Page<CommandTO> result = logic.search("audit", pageable);

            assertNotNull(result);
            assertEquals(1, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals("command1", result.getContent().get(0).getKey());
        }

        verify(implementationDAO).findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "audit");
    }

    @Test
    void searchShouldApplyPagination() throws Exception {
        Implementation impl1 = implementation("command1");
        Implementation impl2 = implementation("command2");
        Implementation impl3 = implementation("command3");

        CommandArgs args1 = commandArgs();
        CommandArgs args2 = commandArgs();
        CommandArgs args3 = commandArgs();

        Pageable pageable = PageRequest.of(1, 2);

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd"))
                .thenReturn(List.of(impl1, impl2, impl3));

        try (
                MockedStatic<AuthContextUtils> authContext = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
                MockedStatic<ImplementationManager> implementationManager =
                        org.mockito.Mockito.mockStatic(ImplementationManager.class)
        ) {
            authContext.when(AuthContextUtils::getDomain).thenReturn("Master");

            implementationManager.when(() -> ImplementationManager.emptyArgs("Master", impl1)).thenReturn(args1);
            implementationManager.when(() -> ImplementationManager.emptyArgs("Master", impl2)).thenReturn(args2);
            implementationManager.when(() -> ImplementationManager.emptyArgs("Master", impl3)).thenReturn(args3);

            Page<CommandTO> result = logic.search("cmd", pageable);

            assertNotNull(result);
            assertEquals(3, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals("command3", result.getContent().get(0).getKey());
        }
    }

    @Test
    void searchShouldReturnEmptyPageWhenNoImplementationMatches() {
        Pageable pageable = PageRequest.of(0, 10);

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "missing"))
                .thenReturn(List.of());

        Page<CommandTO> result = logic.search("missing", pageable);

        assertNotNull(result);
        assertEquals(0, result.getTotalElements());
        assertEquals(0, result.getContent().size());
    }

    @Test
    void searchShouldSkipImplementationWhenEmptyArgsCannotBeResolved() throws Exception {
        Implementation goodImpl = implementation("goodCommand");
        Implementation badImpl = implementation("badCommand");

        CommandArgs args = commandArgs();
        Pageable pageable = PageRequest.of(0, 10);

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd"))
                .thenReturn(List.of(goodImpl, badImpl));

        try (
                MockedStatic<AuthContextUtils> authContext = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
                MockedStatic<ImplementationManager> implementationManager =
                        org.mockito.Mockito.mockStatic(ImplementationManager.class)
        ) {
            authContext.when(AuthContextUtils::getDomain).thenReturn("Master");

            implementationManager.when(() -> ImplementationManager.emptyArgs("Master", goodImpl)).thenReturn(args);
            implementationManager.when(() -> ImplementationManager.emptyArgs("Master", badImpl))
                    .thenThrow(new RuntimeException("Cannot resolve args"));

            Page<CommandTO> result = logic.search("cmd", pageable);

            assertNotNull(result);
            assertEquals(2, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals("goodCommand", result.getContent().get(0).getKey());
        }
    }

    @Test
    void searchShouldThrowNullPointerExceptionWhenPageableIsNull() {
        Implementation impl = implementation("command1");

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd"))
                .thenReturn(List.of(impl));

        assertThrows(NullPointerException.class, () -> logic.search("cmd", null));
    }

    @Test
    void searchShouldPropagateDaoException() {
        Pageable pageable = PageRequest.of(0, 10);

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd"))
                .thenThrow(new RuntimeException("DAO failure"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> logic.search("cmd", pageable));

        assertEquals("DAO failure", exception.getMessage());
    }

    // ---------------------------------------------------------------------
    // run(CommandTO command)
    // ---------------------------------------------------------------------

    @Test
    @SuppressWarnings("unchecked")
    void runShouldExecuteCommandWithProvidedArgs() throws Exception {
        Implementation impl = implementation("command1");
        CommandArgs args = commandArgs();

        CommandTO commandTO = new CommandTO.Builder("command1").args(args).build();

        Command<CommandArgs> runnable = mock(Command.class, RETURNS_DEEP_STUBS);

        when(implementationDAO.findById("command1")).thenReturn(Optional.of(impl));
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args).message()).thenReturn("Command executed");

        try (
                MockedStatic<AuthContextUtils> authContext = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
                MockedStatic<ImplementationManager> implementationManager =
                        org.mockito.Mockito.mockStatic(ImplementationManager.class)
        ) {
            authContext.when(AuthContextUtils::getDomain).thenReturn("Master");

            implementationManager.when(() ->
                            ImplementationManager.build(anyString(), same(impl), any(), any()))
                    .thenReturn(runnable);

            String result = logic.run(commandTO);

            assertEquals("Command executed", result);
        }

        verify(implementationDAO).findById("command1");
        verify(validator).validate(args);
    }

    @Test
    @SuppressWarnings("unchecked")
    void runShouldUseEmptyArgsWhenCommandArgsAreNull() throws Exception {
        Implementation impl = implementation("command1");
        CommandArgs emptyArgs = commandArgs();

        CommandTO commandTO = new CommandTO.Builder("command1").build();

        Command<CommandArgs> runnable = mock(Command.class, RETURNS_DEEP_STUBS);

        when(implementationDAO.findById("command1")).thenReturn(Optional.of(impl));
        when(runnable.run(emptyArgs).message()).thenReturn("Executed with empty args");

        try (
                MockedStatic<AuthContextUtils> authContext = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
                MockedStatic<ImplementationManager> implementationManager =
                        org.mockito.Mockito.mockStatic(ImplementationManager.class)
        ) {
            authContext.when(AuthContextUtils::getDomain).thenReturn("Master");

            implementationManager.when(() ->
                            ImplementationManager.build(anyString(), same(impl), any(), any()))
                    .thenReturn(runnable);

            implementationManager.when(() -> ImplementationManager.emptyArgs("Master", impl))
                    .thenReturn(emptyArgs);

            String result = logic.run(commandTO);

            assertEquals("Executed with empty args", result);
        }
    }

    @Test
    void runShouldThrowNotFoundExceptionWhenImplementationDoesNotExist() {
        CommandTO commandTO = new CommandTO.Builder("missingCommand").build();

        when(implementationDAO.findById("missingCommand")).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> logic.run(commandTO));

        assertNotNull(exception);
    }

    @Test
    void runShouldThrowSyncopeClientExceptionWhenImplementationCannotBeBuilt() throws Exception {
        Implementation impl = implementation("brokenCommand");
        CommandTO commandTO = new CommandTO.Builder("brokenCommand").build();

        when(implementationDAO.findById("brokenCommand")).thenReturn(Optional.of(impl));

        try (
                MockedStatic<AuthContextUtils> authContext = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
                MockedStatic<ImplementationManager> implementationManager =
                        org.mockito.Mockito.mockStatic(ImplementationManager.class)
        ) {
            authContext.when(AuthContextUtils::getDomain).thenReturn("Master");

            implementationManager.when(() ->
                            ImplementationManager.build(anyString(), same(impl), any(), any()))
                    .thenThrow(new RuntimeException("Build failure"));

            SyncopeClientException exception =
                    assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertNotNull(exception);
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    void runShouldThrowInvalidEntityExceptionWhenValidatorReturnsViolations() throws Exception {
        Implementation impl = implementation("command1");
        CommandArgs args = commandArgs();

        CommandTO commandTO = new CommandTO.Builder("command1").args(args).build();

        Command<CommandArgs> runnable = mock(Command.class);
        ConstraintViolation<Object> violation = mock(ConstraintViolation.class);

        when(implementationDAO.findById("command1")).thenReturn(Optional.of(impl));
        when(validator.validate(args)).thenReturn(Set.of(violation));

        try (
                MockedStatic<AuthContextUtils> authContext = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
                MockedStatic<ImplementationManager> implementationManager =
                        org.mockito.Mockito.mockStatic(ImplementationManager.class)
        ) {
            authContext.when(AuthContextUtils::getDomain).thenReturn("Master");

            implementationManager.when(() ->
                            ImplementationManager.build(anyString(), same(impl), any(), any()))
                    .thenReturn(runnable);

            assertThrows(InvalidEntityException.class, () -> logic.run(commandTO));
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    void runShouldThrowSyncopeClientExceptionWhenValidatorThrowsValidationException() throws Exception {
        Implementation impl = implementation("command1");
        CommandArgs args = commandArgs();

        CommandTO commandTO = new CommandTO.Builder("command1").args(args).build();

        Command<CommandArgs> runnable = mock(Command.class);

        when(implementationDAO.findById("command1")).thenReturn(Optional.of(impl));
        when(validator.validate(args)).thenThrow(new ValidationException("Invalid values"));

        try (
                MockedStatic<AuthContextUtils> authContext = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
                MockedStatic<ImplementationManager> implementationManager =
                        org.mockito.Mockito.mockStatic(ImplementationManager.class)
        ) {
            authContext.when(AuthContextUtils::getDomain).thenReturn("Master");

            implementationManager.when(() ->
                            ImplementationManager.build(anyString(), same(impl), any(), any()))
                    .thenReturn(runnable);

            SyncopeClientException exception =
                    assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertNotNull(exception);
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    void runShouldThrowSyncopeClientExceptionWhenRunnableThrowsException() throws Exception {
        Implementation impl = implementation("command1");
        CommandArgs args = commandArgs();

        CommandTO commandTO = new CommandTO.Builder("command1").args(args).build();

        Command<CommandArgs> runnable = mock(Command.class);

        when(implementationDAO.findById("command1")).thenReturn(Optional.of(impl));
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args)).thenThrow(new RuntimeException("Execution failed"));

        try (
                MockedStatic<AuthContextUtils> authContext = org.mockito.Mockito.mockStatic(AuthContextUtils.class);
                MockedStatic<ImplementationManager> implementationManager =
                        org.mockito.Mockito.mockStatic(ImplementationManager.class)
        ) {
            authContext.when(AuthContextUtils::getDomain).thenReturn("Master");

            implementationManager.when(() ->
                            ImplementationManager.build(anyString(), same(impl), any(), any()))
                    .thenReturn(runnable);

            SyncopeClientException exception =
                    assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertNotNull(exception);
        }
    }
}