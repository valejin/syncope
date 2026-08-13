package org.apache.syncope.core.logic.c1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.command.CommandArgs;
import org.apache.syncope.common.lib.command.CommandTO;
import org.apache.syncope.common.lib.types.IdRepoImplementationType;
import org.apache.syncope.core.logic.CommandLogic;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.NotFoundException;
import org.apache.syncope.core.persistence.api.entity.Implementation;
import org.apache.syncope.core.provisioning.api.macro.Command;
import org.apache.syncope.core.spring.implementation.ImplementationManager;
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
class CommandLogicC1LLMZeroShotTest {

    @Mock
    private ImplementationDAO implementationDAO;

    @Mock
    private Validator validator;

    @Mock
    private Implementation implementation1;

    @Mock
    private Implementation implementation2;

    @Mock
    private Implementation implementation3;

    private CommandLogic logic;

    @BeforeEach
    void setUp() {
        logic = new CommandLogic(implementationDAO, validator);
    }

    @Test
    void searchReturnsPagedCommandTOsAndKeepsTotalCount() throws Exception {
        Pageable pageable = PageRequest.of(1, 2);
        CommandArgs args3 = new CommandArgs();

        // FIX: con pageable=page1/size2, skip(2).limit(2) esclude implementation1/2 dallo
        // stream PRIMA della map() - i loro getKey() non vengono mai letti. Stub non
        // necessari per questo scenario specifico ma tenuti come documentazione del setup
        // a 3 elementi -> lenient() invece di UnnecessaryStubbingException.
        lenient().when(implementation1.getKey()).thenReturn("command-1");
        lenient().when(implementation2.getKey()).thenReturn("command-2");
        when(implementation3.getKey()).thenReturn("command-3");
        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "command"))
                .thenReturn(List.of(implementation1, implementation2, implementation3));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.emptyArgs(any(String.class), eq(implementation3)))
                    .thenReturn(args3);

            Page<CommandTO> result = logic.search("command", pageable);

            assertEquals(3L, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals("command-3", result.getContent().get(0).getKey());
            assertEquals(args3, result.getContent().get(0).getArgs());
            verify(implementationDAO).findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "command");
            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(implementation3)));
        }
    }

    @Test
    void searchFiltersOutCommandsWhoseDefaultArgsCannotBeBuilt() throws Exception {
        Pageable pageable = PageRequest.of(0, 2);
        CommandArgs args1 = new CommandArgs();

        when(implementation1.getKey()).thenReturn("good-command");
        when(implementation2.getKey()).thenReturn("bad-command");
        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd"))
                .thenReturn(List.of(implementation1, implementation2));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.emptyArgs(any(String.class), eq(implementation1)))
                    .thenReturn(args1);
            implementationManager.when(() -> ImplementationManager.emptyArgs(any(String.class), eq(implementation2)))
                    .thenThrow(new IllegalStateException("Cannot create default args"));

            Page<CommandTO> result = logic.search("cmd", pageable);

            assertEquals(2L, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals("good-command", result.getContent().get(0).getKey());
            assertEquals(args1, result.getContent().get(0).getArgs());
            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(implementation1)));
            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(implementation2)));
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    void runBuildsCommandValidatesArgsAndReturnsMessage() {
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO.Builder("cached-command").args(args).build();
        Command<CommandArgs> runnable = mock(Command.class);

        // FIX: findById ritorna Optional<? extends Implementation> -> doReturn, non when().thenReturn()
        // Nota: implementation1.getKey() NON va stubbato qui - viene letto solo dentro le
        // lambda Supplier/Consumer passate a build(), mai invocate perche' build() e' mockato
        // per restituire direttamente `runnable` (il suo corpo reale, che chiamerebbe
        // supplier.get(), non gira mai). Stub morto -> UnnecessaryStubbingException.
        doReturn(Optional.of(implementation1)).when(implementationDAO).findById("cached-command");
        when(validator.validate(args)).thenReturn(Collections.emptySet());
        when(runnable.run(args)).thenReturn(new Command.Result(
                "command completed",
                Collections.<String, Serializable>emptyMap()));

        String result;
        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            // FIX: run() chiama SEMPRE ImplementationManager.build(...), incondizionatamente -
            // popolare perContextCommands a mano (come nell'originale generato da Copilot) non
            // ha alcun effetto: la cache e' gestita internamente da build(), non da CommandLogic.
            implementationManager.when(() -> ImplementationManager.<Command<CommandArgs>>build(
                            anyString(), eq(implementation1), any(), any()))
                    .thenReturn(runnable);

            result = logic.run(commandTO);
        }

        assertEquals("command completed", result);
        verify(implementationDAO).findById("cached-command");
        verify(validator).validate(args);
        verify(runnable).run(args);
    }

    @Test
    @SuppressWarnings("unchecked")
    void runWrapsValidationFailureAsSyncopeClientException() {
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO.Builder("invalid-command").args(args).build();
        Command<CommandArgs> runnable = mock(Command.class);
        ConstraintViolation<CommandArgs> violation = mock(ConstraintViolation.class);
        // I 4 getter restano necessari: InvalidEntityException itera sulle ConstraintViolation
        // nel proprio costruttore per assemblare il messaggio (bug gia' catalogato nel progetto).
        jakarta.validation.Path propertyPath = mock(jakarta.validation.Path.class);
        when(propertyPath.toString()).thenReturn("someField");
        when(violation.getMessageTemplate()).thenReturn("{javax.validation.constraints.NotNull.message}");
        when(violation.getPropertyPath()).thenReturn(propertyPath);
        when(violation.getInvalidValue()).thenReturn("invalid");
        when(violation.getLeafBean()).thenReturn(args);
        Set<ConstraintViolation<CommandArgs>> violations = Set.of(violation);

        doReturn(Optional.of(implementation1)).when(implementationDAO).findById("invalid-command");
        when(validator.validate(args)).thenReturn(violations);

        SyncopeClientException thrown;
        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.<Command<CommandArgs>>build(
                            anyString(), eq(implementation1), any(), any()))
                    .thenReturn(runnable);

            // FIX: InvalidEntityException estende jakarta.validation.ValidationException, quindi
            // viene ricatturata dentro lo stesso blocco try di run() e incartata in
            // SyncopeClientException(InvalidValues) - non esce mai da run() come tipo proprio.
            thrown = assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));
        }

        assertTrue(thrown.getElements().iterator().next().contains("someField"));
        verify(implementationDAO).findById("invalid-command");
        verify(validator).validate(args);
        verify(runnable, never()).run(any());
    }

    @Test
    void runThrowsNotFoundExceptionWhenImplementationDoesNotExist() {
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO.Builder("missing-command").args(args).build();

        when(implementationDAO.findById("missing-command")).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> logic.run(commandTO));

        verify(implementationDAO).findById("missing-command");
        verify(validator, never()).validate(any());
    }

    @Test
    @SuppressWarnings("unchecked")
    void runWrapsCommandExecutionFailureAsSyncopeClientException() {
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO.Builder("failing-command").args(args).build();
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation1)).when(implementationDAO).findById("failing-command");
        when(validator.validate(args)).thenReturn(Collections.emptySet());
        when(runnable.run(args)).thenThrow(new IllegalStateException("boom"));

        SyncopeClientException thrown;
        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.<Command<CommandArgs>>build(
                            anyString(), eq(implementation1), any(), any()))
                    .thenReturn(runnable);

            thrown = assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));
        }

        assertTrue(thrown.getElements().contains("boom"));
        verify(implementationDAO).findById("failing-command");
        verify(validator).validate(args);
        verify(runnable).run(args);
    }

    @Test
    void runWrapsCommandBuildFailureAsSyncopeClientExceptionWhenCommandIsNotCached() throws Exception {
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO.Builder("uncached-command").args(args).build();

        when(implementation1.getKey()).thenReturn("uncached-command");
        doReturn(Optional.of(implementation1)).when(implementationDAO).findById("uncached-command");

        SyncopeClientException thrown;
        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.<Command<CommandArgs>>build(
                            anyString(), eq(implementation1), any(), any()))
                    .thenThrow(new IllegalStateException("build failed"));

            thrown = assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));
        }

        assertTrue(thrown.getElements().contains("Could not build uncached-command"));
        verify(implementationDAO).findById("uncached-command");
        verify(validator, never()).validate(any());
    }

}