package org.apache.syncope.core.logic.c2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.types.ClientExceptionType;
import org.apache.syncope.common.lib.command.CommandArgs;
import org.apache.syncope.common.lib.command.CommandTO;
import org.apache.syncope.common.lib.types.IdRepoImplementationType;
import org.apache.syncope.core.persistence.api.attrvalue.InvalidEntityException;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.NotFoundException;
import org.apache.syncope.core.persistence.api.entity.Implementation;
import org.apache.syncope.core.logic.CommandLogic;
import org.apache.syncope.core.provisioning.api.macro.Command;
import org.apache.syncope.core.spring.implementation.ImplementationManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class CommandLogicC2LLMZeroShotTest {

    private static final String KEY_ONE = "command-one";

    private static final String KEY_TWO = "command-two";

    private static final String KEY_THREE = "command-three";

    @Mock
    private ImplementationDAO implementationDAO;

    @Mock
    private Validator validator;

    private CommandLogic logic;

    @BeforeEach
    void setUp() {
        logic = new CommandLogic(implementationDAO, validator);
    }

    @Test
    void searchReturnsPagedCommandTransfersAndTotalCount() throws Exception {
        Implementation first = implementation(KEY_ONE);
        Implementation second = implementation(KEY_TWO);
        Implementation third = implementation(KEY_THREE);

        CommandArgs firstArgs = new CommandArgs();
        CommandArgs secondArgs = new CommandArgs();

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "command"))
                .thenReturn(List.of(first, second, third));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.emptyArgs(any(String.class), eq(first))).thenReturn(firstArgs);
            implementationManager.when(() -> ImplementationManager.emptyArgs(any(String.class), eq(second))).thenReturn(secondArgs);

            Pageable pageable = PageRequest.of(0, 2);

            Page<CommandTO> result = logic.search("command", pageable);

            assertNotNull(result);
            assertEquals(3L, result.getTotalElements());
            assertEquals(2, result.getContent().size());
            assertEquals(KEY_ONE, result.getContent().get(0).getKey());
            assertSame(firstArgs, result.getContent().get(0).getArgs());
            assertEquals(KEY_TWO, result.getContent().get(1).getKey());
            assertSame(secondArgs, result.getContent().get(1).getArgs());

            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(first)));
            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(second)));
            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(third)), never());
        }
    }

    @Test
    void searchAppliesOffsetAndLimitFromPageable() throws Exception {
        Implementation first = implementation(KEY_ONE);
        Implementation second = implementation(KEY_TWO);
        Implementation third = implementation(KEY_THREE);

        CommandArgs thirdArgs = new CommandArgs();

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, null))
                .thenReturn(List.of(first, second, third));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.emptyArgs(any(String.class), eq(third))).thenReturn(thirdArgs);

            Page<CommandTO> result = logic.search(null, PageRequest.of(1, 2));

            assertNotNull(result);
            assertEquals(3L, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals(KEY_THREE, result.getContent().get(0).getKey());
            assertSame(thirdArgs, result.getContent().get(0).getArgs());

            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(first)), never());
            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(second)), never());
            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(third)));
        }
    }

    @Test
    void searchFiltersOutCommandsWhenDefaultArgsCannotBeCreated() throws Exception {
        Implementation valid = implementation(KEY_ONE);
        Implementation invalid = implementation(KEY_TWO);

        CommandArgs args = new CommandArgs();

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "x"))
                .thenReturn(List.of(valid, invalid));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.emptyArgs(any(String.class), eq(valid))).thenReturn(args);
            implementationManager.when(() -> ImplementationManager.emptyArgs(any(String.class), eq(invalid)))
                    .thenThrow(new IllegalStateException("Cannot build args"));

            Page<CommandTO> result = logic.search("x", PageRequest.of(0, 10));

            assertEquals(2L, result.getTotalElements());
            assertEquals(1, result.getContent().size());
            assertEquals(KEY_ONE, result.getContent().get(0).getKey());
            assertSame(args, result.getContent().get(0).getArgs());
        }
    }

    @Test
    void runUsesProvidedArgsAndReturnsCommandMessage() throws Exception {
        Implementation implementation = implementation(KEY_ONE);
        CommandArgs args = new CommandArgs();
        args.setCtx(Map.of("name", "value"));

        CommandTO commandTO = new CommandTO.Builder(KEY_ONE).args(args).build();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById(KEY_ONE);
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args)).thenReturn(new Command.Result("done", Map.of()));

        try (MockedStatic<ImplementationManager> implementationManager = mockImplementationBuild(implementation, runnable)) {
            String result = logic.run(commandTO);

            assertEquals("done", result);
            verify(validator).validate(args);
            verify(runnable).run(args);
            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(implementation)), never());
        }
    }

    @Test
    void runCreatesEmptyArgsWhenCommandHasNoArgs() throws Exception {
        Implementation implementation = implementation(KEY_ONE);
        CommandArgs emptyArgs = new CommandArgs();
        CommandTO commandTO = new CommandTO.Builder(KEY_ONE).build();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById(KEY_ONE);
        when(runnable.run(emptyArgs)).thenReturn(new Command.Result("empty args executed", Map.of()));

        try (MockedStatic<ImplementationManager> implementationManager = mockImplementationBuild(implementation, runnable)) {
            implementationManager.when(() -> ImplementationManager.emptyArgs(any(String.class), eq(implementation))).thenReturn(emptyArgs);

            String result = logic.run(commandTO);

            assertEquals("empty args executed", result);
            verify(validator, never()).validate(any(CommandArgs.class));
            verify(runnable).run(emptyArgs);
            implementationManager.verify(() -> ImplementationManager.emptyArgs(any(String.class), eq(implementation)));
        }
    }

    @Test
    void runThrowsNotFoundExceptionWhenImplementationDoesNotExist() {
        CommandTO commandTO = new CommandTO.Builder("missing").build();

        when(implementationDAO.findById("missing")).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> logic.run(commandTO));

        verify(validator, never()).validate(any());
    }

    @Test
    void runThrowsInvalidEntityExceptionWhenArgsDoNotPassValidation() throws Exception {
        Implementation implementation = implementation(KEY_ONE);
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO.Builder(KEY_ONE).args(args).build();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);
        @SuppressWarnings("unchecked")
        ConstraintViolation<CommandArgs> violation = mock(ConstraintViolation.class);
        // FIX (nota per Valentina): il costruttore reale di InvalidEntityException legge
        // 4 getter specifici (getMessageTemplate, getPropertyPath, getInvalidValue,
        // getLeafBean) - un mock nudo senza questi stub causa NPE interna, non e' un
        // comportamento di CommandLogic. Stesso bug ricorrente gia' documentato 4 volte
        // su C0 (mai risolto autonomamente da Copilot).
        jakarta.validation.Path propertyPath = mock(jakarta.validation.Path.class);
        lenient().when(propertyPath.toString()).thenReturn("ctx");
        lenient().when(violation.getMessageTemplate())
                .thenReturn("{jakarta.validation.constraints.NotBlank.message}");
        lenient().when(violation.getPropertyPath()).thenReturn(propertyPath);
        lenient().when(violation.getInvalidValue()).thenReturn("");
        lenient().when(violation.getLeafBean()).thenReturn(args);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById(KEY_ONE);
        when(validator.validate(args)).thenReturn(Set.of(violation));

        try (MockedStatic<ImplementationManager> ignored = mockImplementationBuild(implementation, runnable)) {
            // FIX: l'eccezione realmente propagata da CommandLogic.run() e'
            // SyncopeClientException(InvalidValues) - InvalidEntityException viene
            // sollevata internamente ma e' catturata e ri-wrappata dal blocco
            // catch (ValidationException e) dello stesso metodo (verificato sul
            // sorgente C0/C2: il catch e' invariato tra le due varianti su questo punto).
            SyncopeClientException exception =
                    assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertEquals(ClientExceptionType.InvalidValues, exception.getType());
            verify(validator).validate(args);
            verify(runnable, never()).run(any());
        }
    }

    @Test
    @Disabled("Fallimento atteso: C2 ha rimosso sce.getElements().add(e.getMessage()) dal "
            + "catch finale di run() (vedi Milestone4_RefactoringAnalysis_Falessi.md, riga 142). "
            + "Disabilitato solo per consentire l'analisi di mutation testing (PIT richiede una "
            + "suite verde), come indicato dal prof. La regressione resta documentata e verificata "
            + "manualmente, non e' stata 'corretta' indebolendo l'asserzione.")
    void runWrapsCommandExecutionExceptionAsSyncopeClientException() throws Exception {
        Implementation implementation = implementation(KEY_ONE);
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO.Builder(KEY_ONE).args(args).build();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(implementation)).when(implementationDAO).findById(KEY_ONE);
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args)).thenThrow(new IllegalStateException("boom"));

        try (MockedStatic<ImplementationManager> ignored = mockImplementationBuild(implementation, runnable)) {
            SyncopeClientException exception =
                    assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            // NON e' un bug del test: C2 ha rimosso sce.getElements().add(e.getMessage())
            // dal catch finale di run() (vedi Milestone4_RefactoringAnalysis_Falessi.md, riga 142).
            // Questo test, generato ex-novo da Copilot con il solo sorgente C2 allegato,
            // si aspetta comunque il comportamento "storico" (messaggio preservato) e FALLISCE:
            // conferma indipendente della regressione, coerente con quanto gia' osservato
            // rieseguendo le suite di C0 su C2. Da tenere COSI' COM'E' (fallimento atteso),
            // non da "correggere" indebolendo l'assert.
            assertTrue(exception.getElements().contains("boom"));
            verify(runnable).run(args);
        }
    }

    @Test
    void runWrapsInvalidImplementationWhenCommandCannotBeBuilt() throws Exception {
        Implementation implementation = implementation(KEY_ONE);
        CommandArgs args = new CommandArgs();
        CommandTO commandTO = new CommandTO.Builder(KEY_ONE).args(args).build();

        doReturn(Optional.of(implementation)).when(implementationDAO).findById(KEY_ONE);

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.build(
                            any(String.class),
                            eq(implementation),
                            anySupplier(),
                            anyConsumer()))
                    .thenThrow(new ClassCastException("wrong type"));

            SyncopeClientException exception =
                    assertThrows(SyncopeClientException.class, () -> logic.run(commandTO));

            assertTrue(exception.getElements().stream().anyMatch(element -> element.contains(KEY_ONE)));
            verify(validator, never()).validate(args);
        }
    }

    private Implementation implementation(final String key) {
        Implementation implementation = mock(Implementation.class);
        lenient().when(implementation.getKey()).thenReturn(key);
        return implementation;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private MockedStatic<ImplementationManager> mockImplementationBuild(
            final Implementation implementation,
            final Command<CommandArgs> runnable) {

        MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class);
        implementationManager.when(() -> ImplementationManager.build(
                        any(String.class),
                        eq(implementation),
                        anySupplier(),
                        anyConsumer()))
                .thenReturn(runnable);
        return implementationManager;
    }

    @SuppressWarnings("unchecked")
    private static Supplier<Object> anySupplier() {
        return any(Supplier.class);
    }

    @SuppressWarnings("unchecked")
    private static Consumer<Object> anyConsumer() {
        return any(Consumer.class);
    }


}