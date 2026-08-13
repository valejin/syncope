package org.apache.syncope.core.logic.c1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.List;
import java.util.Map;
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
class CommandLogicC1LLMToTTest {

    /*
     * Extracted method signatures under test:
     * - public Page<CommandTO> search(String keyword, Pageable pageable)
     * - public String run(CommandTO command)
     */

    @Mock
    private ImplementationDAO implementationDAO;

    @Mock
    private Validator validator;

    private CommandLogic logic;

    @BeforeEach
    void setUp() {
        logic = new CommandLogic(implementationDAO, validator);
    }

    private static Implementation implementation(final String key) {
        Implementation implementation = mock(Implementation.class);
        // lenient(): nella maggior parte dei test run() questo valore non viene mai letto,
        // perche' le lambda che lo userebbero (dentro ImplementationManager.build(), sempre
        // mockato) non vengono mai invocate - stesso motivo gia' isolato su Zero-shot.
        lenient().when(implementation.getKey()).thenReturn(key);
        return implementation;
    }

    @Test
    @DisplayName("Expert 1 basic search: maps implementations to CommandTO objects and preserves total count")
    void searchReturnsCommandTOPage() throws Exception {
        Implementation first = implementation("command-1");
        Implementation second = implementation("command-2");
        Pageable pageable = PageRequest.of(0, 10);

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "command"))
                .thenReturn(List.of(first, second));

        try (MockedStatic<ImplementationManager> manager = mockStatic(ImplementationManager.class)) {
            // FIX: emptyArgs richiede (String domain, Implementation) - domain come matcher
            manager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(first))).thenReturn(new CommandArgs());
            manager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(second))).thenReturn(new CommandArgs());

            Page<CommandTO> result = logic.search("command", pageable);

            assertEquals(2, result.getTotalElements());
            assertEquals(2, result.getContent().size());
            assertEquals("command-1", result.getContent().get(0).getKey());
            assertEquals("command-2", result.getContent().get(1).getKey());
        }
    }

    @Test
    @DisplayName("Expert 2 search edge case: honors Pageable offset and limit")
    void searchAppliesPagination() throws Exception {
        Implementation first = implementation("command-1");
        Implementation second = implementation("command-2");
        Implementation third = implementation("command-3");
        Pageable pageable = PageRequest.of(1, 2);

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, null))
                .thenReturn(List.of(first, second, third));

        try (MockedStatic<ImplementationManager> manager = mockStatic(ImplementationManager.class)) {
            manager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(third))).thenReturn(new CommandArgs());

            Page<CommandTO> result = logic.search(null, pageable);

            assertEquals(3, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals("command-3", result.getContent().get(0).getKey());
        }
    }

    @Test
    @DisplayName("Expert 3 search exception path: skips implementations whose argument metadata cannot be built")
    void searchFiltersOutCommandsWhenEmptyArgsFails() throws Exception {
        Implementation valid = implementation("valid-command");
        Implementation broken = implementation("broken-command");

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd"))
                .thenReturn(List.of(valid, broken));

        try (MockedStatic<ImplementationManager> manager = mockStatic(ImplementationManager.class)) {
            manager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(valid))).thenReturn(new CommandArgs());
            manager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(broken)))
                    .thenThrow(new IllegalStateException("bad args"));

            Page<CommandTO> result = logic.search("cmd", PageRequest.of(0, 10));

            assertEquals(2, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals("valid-command", result.getContent().get(0).getKey());
        }
    }

    @Test
    @DisplayName("Search edge case: null Pageable is rejected by current implementation")
    void searchWithNullPageableThrowsNullPointerException() {
        Implementation implementation = implementation("command-1");
        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "cmd"))
                .thenReturn(List.of(implementation));

        assertThrows(NullPointerException.class, () -> logic.search("cmd", null));
    }

    @Test
    @DisplayName("Expert 1 basic run: builds a command, validates args, executes it, and returns the message")
    @SuppressWarnings("unchecked")
    void runBuildsValidatesAndExecutesCommand() throws Exception {
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO();
        commandTO.setKey("echo");
        commandTO.setArgs(args);

        Implementation implementation = implementation("echo");
        Command<CommandArgs> runnable = mock(Command.class);

        // FIX: findById ritorna Optional<? extends Implementation> -> doReturn, non when().thenReturn()
        doReturn(Optional.of(implementation)).when(implementationDAO).findById("echo");
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args)).thenReturn(new Command.Result("done", Map.of()));

        try (MockedStatic<ImplementationManager> manager = mockStatic(ImplementationManager.class)) {
            // FIX: build richiede (String domain, Implementation, Supplier<T>, Consumer<T>),
            // non solo (Implementation) - domain e le due lambda come matcher
            manager.when(() -> ImplementationManager.<Command<CommandArgs>>build(
                            anyString(), eq(implementation), any(), any()))
                    .thenReturn(runnable);

            assertEquals("done", logic.run(commandTO));
        }
    }

    @Test
    @DisplayName("Expert 2 run edge case: build() is invoked on every call, once per run()")
    @SuppressWarnings("unchecked")
    void runInvokesBuildOnEveryCall() throws Exception {
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO();
        commandTO.setKey("cached");
        commandTO.setArgs(args);

        Implementation implementation = implementation("cached");
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById("cached");
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args))
                .thenReturn(new Command.Result("first", Map.of()))
                .thenReturn(new Command.Result("second", Map.of()));

        try (MockedStatic<ImplementationManager> manager = mockStatic(ImplementationManager.class)) {
            manager.when(() -> ImplementationManager.<Command<CommandArgs>>build(
                            anyString(), eq(implementation), any(), any()))
                    .thenReturn(runnable);

            assertEquals("first", logic.run(commandTO));
            assertEquals("second", logic.run(commandTO));

            // FIX: run() chiama SEMPRE ImplementationManager.build(...), incondizionatamente -
            // il caching (se esiste) e' interno a build() stesso, non osservabile da CommandLogic.
            // Con due chiamate a run(), build() viene invocato due volte, non una sola come
            // assumeva il test originale (stessa assunzione sbagliata gia' corretta su Zero-shot).
            manager.verify(() -> ImplementationManager.<Command<CommandArgs>>build(
                    anyString(), eq(implementation), any(), any()), times(2));
        }
    }

    @Test
    @DisplayName("Expert 3 run edge case: when args are null, execution uses empty args")
    @SuppressWarnings("unchecked")
    void runWithNullArgsUsesEmptyArgsForExecution() throws Exception {
        CommandTO commandTO = new CommandTO();
        commandTO.setKey("default-args");
        commandTO.setArgs(null);

        Implementation implementation = implementation("default-args");
        CommandArgs defaultArgs = new CommandArgs();
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById("default-args");
        // FIX: rimosso lo stub su validator.validate(isNull(...)) - il codice di produzione
        // salta validate() del tutto quando command.getArgs() == null (if (args != null) {...}),
        // quindi quello stub non veniva mai raggiunto -> UnnecessaryStubbingException.
        when(runnable.run(defaultArgs)).thenReturn(new Command.Result("used defaults", Map.of()));

        try (MockedStatic<ImplementationManager> manager = mockStatic(ImplementationManager.class)) {
            manager.when(() -> ImplementationManager.<Command<CommandArgs>>build(
                            anyString(), eq(implementation), any(), any()))
                    .thenReturn(runnable);
            manager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(implementation))).thenReturn(defaultArgs);

            assertEquals("used defaults", logic.run(commandTO));
        }
    }

    @Test
    @DisplayName("Run exception path: missing implementation throws NotFoundException")
    void runThrowsNotFoundWhenImplementationDoesNotExist() {
        CommandTO commandTO = new CommandTO();
        commandTO.setKey("missing");

        when(implementationDAO.findById("missing")).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> logic.run(commandTO));
    }

    @Test
    @DisplayName("Run exception path: ImplementationManager build failure becomes SyncopeClientException")
    void runWrapsBuildFailureAsSyncopeClientException() throws Exception {
        CommandTO commandTO = new CommandTO();
        commandTO.setKey("bad-build");
        commandTO.setArgs(new CommandArgs());

        Implementation implementation = implementation("bad-build");
        doReturn(Optional.of(implementation)).when(implementationDAO).findById("bad-build");

        try (MockedStatic<ImplementationManager> manager = mockStatic(ImplementationManager.class)) {
            manager.when(() -> ImplementationManager.build(anyString(), eq(implementation), any(), any()))
                    .thenThrow(new IllegalStateException("build failed"));

            assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));
        }
    }

    @Test
    @DisplayName("Run exception path: validation violations become SyncopeClientException(InvalidValues)")
    @SuppressWarnings("unchecked")
    void runWrapsValidationViolationsAsSyncopeClientException() throws Exception {
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO();
        commandTO.setKey("invalid");
        commandTO.setArgs(args);

        Implementation implementation = implementation("invalid");
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

        doReturn(Optional.of(implementation)).when(implementationDAO).findById("invalid");
        when(validator.validate(args)).thenReturn(Set.of(violation));

        try (MockedStatic<ImplementationManager> manager = mockStatic(ImplementationManager.class)) {
            manager.when(() -> ImplementationManager.<Command<CommandArgs>>build(
                            anyString(), eq(implementation), any(), any()))
                    .thenReturn(runnable);

            // FIX: InvalidEntityException estende jakarta.validation.ValidationException, quindi
            // viene ricatturata dentro lo stesso blocco try di run() e incartata in
            // SyncopeClientException(InvalidValues) - non esce mai da run() come tipo proprio
            // (stesso fix gia' applicato su Zero-shot).
            assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));
            verify(runnable, never()).run(args);
        }
    }

    @Test
    @DisplayName("Run exception path: command execution failure becomes SyncopeClientException")
    @SuppressWarnings("unchecked")
    void runWrapsExecutionFailureAsSyncopeClientException() throws Exception {
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO();
        commandTO.setKey("boom");
        commandTO.setArgs(args);

        Implementation implementation = implementation("boom");
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById("boom");
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args)).thenThrow(new IllegalStateException("boom"));

        try (MockedStatic<ImplementationManager> manager = mockStatic(ImplementationManager.class)) {
            manager.when(() -> ImplementationManager.<Command<CommandArgs>>build(
                            anyString(), eq(implementation), any(), any()))
                    .thenReturn(runnable);

            assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));
        }
    }

    @Test
    @DisplayName("Run edge case: null CommandTO is rejected by current implementation")
    void runWithNullCommandThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> logic.run(null));
    }
}