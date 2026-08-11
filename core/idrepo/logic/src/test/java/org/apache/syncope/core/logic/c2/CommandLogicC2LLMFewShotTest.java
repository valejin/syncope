package org.apache.syncope.core.logic.c2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.command.CommandArgs;
import org.apache.syncope.common.lib.command.CommandTO;
import org.apache.syncope.common.lib.types.ClientExceptionType;
import org.apache.syncope.common.lib.types.IdRepoImplementationType;
import org.apache.syncope.core.persistence.api.attrvalue.InvalidEntityException;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.NotFoundException;
import org.apache.syncope.core.persistence.api.entity.Implementation;
import org.apache.syncope.core.logic.CommandLogic;
import org.apache.syncope.core.provisioning.api.macro.Command;
import org.apache.syncope.core.spring.implementation.ImplementationManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@ExtendWith(MockitoExtension.class)
class CommandLogicC2LLMFewShotTest {

    private static final String KEY_ONE = "commandOne";

    private static final String KEY_TWO = "commandTwo";

    private static final String KEY_THREE = "commandThree";

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
    void searchReturnsPagedCommandTransfersAndTotalCount() throws Exception {
        Implementation first = implementation(KEY_ONE);
        Implementation second = implementation(KEY_TWO);
        Implementation third = implementation(KEY_THREE);

        CommandArgs firstArgs = new CommandArgs();
        CommandArgs secondArgs = new CommandArgs();

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "command"))
                .thenReturn(List.of(first, second, third));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(first))).thenReturn(firstArgs);
            implementationManager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(second))).thenReturn(secondArgs);

            Page<CommandTO> result = logic.search("command", PageRequest.of(0, 2));

            assertNotNull(result);
            assertEquals(3L, result.getTotalElements());
            assertEquals(2, result.getContent().size());

            assertEquals(KEY_ONE, result.getContent().get(0).getKey());
            assertSame(firstArgs, result.getContent().get(0).getArgs());

            assertEquals(KEY_TWO, result.getContent().get(1).getKey());
            assertSame(secondArgs, result.getContent().get(1).getArgs());

            implementationManager.verify(() -> ImplementationManager.emptyArgs(anyString(), eq(first)));
            implementationManager.verify(() -> ImplementationManager.emptyArgs(anyString(), eq(second)));
            implementationManager.verify(() -> ImplementationManager.emptyArgs(anyString(), eq(third)), never());
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
            implementationManager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(third))).thenReturn(thirdArgs);

            Page<CommandTO> result = logic.search(null, PageRequest.of(1, 2));

            assertNotNull(result);
            assertEquals(3L, result.getTotalElements());
            assertEquals(1, result.getContent().size());

            assertEquals(KEY_THREE, result.getContent().get(0).getKey());
            assertSame(thirdArgs, result.getContent().get(0).getArgs());

            implementationManager.verify(() -> ImplementationManager.emptyArgs(anyString(), eq(first)), never());
            implementationManager.verify(() -> ImplementationManager.emptyArgs(anyString(), eq(second)), never());
            implementationManager.verify(() -> ImplementationManager.emptyArgs(anyString(), eq(third)));
        }
    }

    @Test
    void searchFiltersOutCommandsWhoseArgsCannotBeBuiltButKeepsTotalCount() throws Exception {
        Implementation first = implementation(KEY_ONE);
        Implementation second = implementation(KEY_TWO);
        Implementation third = implementation(KEY_THREE);

        CommandArgs firstArgs = new CommandArgs();
        CommandArgs thirdArgs = new CommandArgs();

        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "command"))
                .thenReturn(List.of(first, second, third));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(first))).thenReturn(firstArgs);
            implementationManager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(second)))
                    .thenThrow(new IllegalStateException("broken args"));
            implementationManager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(third))).thenReturn(thirdArgs);

            Page<CommandTO> result = logic.search("command", PageRequest.of(0, 10));

            assertNotNull(result);
            assertEquals(3L, result.getTotalElements());
            assertEquals(2, result.getContent().size());

            assertEquals(KEY_ONE, result.getContent().get(0).getKey());
            assertSame(firstArgs, result.getContent().get(0).getArgs());

            assertEquals(KEY_THREE, result.getContent().get(1).getKey());
            assertSame(thirdArgs, result.getContent().get(1).getArgs());
        }
    }

    @Test
    void searchReturnsEmptyPageWhenNoImplementationsMatch() {
        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "missing"))
                .thenReturn(List.of());

        Page<CommandTO> result = logic.search("missing", PageRequest.of(0, 5));

        assertNotNull(result);
        assertEquals(0L, result.getTotalElements());
        assertEquals(0, result.getContent().size());
    }

    @Test
    void runWithProvidedArgsBuildsValidatesExecutesAndReturnsMessage() throws Exception {
        Implementation impl = implementation(KEY_ONE);
        CommandArgs args = new CommandArgs();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(impl)).when(implementationDAO).findById(KEY_ONE);
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args)).thenReturn(new Command.Result("done", Map.of()));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.build(
                            anyString(),
                            eq(impl),
                            any(Supplier.class),
                            any(Consumer.class))).
                    thenReturn(runnable);

            String result = logic.run(new CommandTO.Builder(KEY_ONE).args(args).build());

            assertEquals("done", result);

            verify(implementationDAO).findById(KEY_ONE);
            verify(validator).validate(args);
            verify(runnable).run(args);

            implementationManager.verify(() -> ImplementationManager.build(
                    anyString(),
                    eq(impl),
                    any(Supplier.class),
                    any(Consumer.class)));

            implementationManager.verify(() -> ImplementationManager.emptyArgs(anyString(), eq(impl)), never());
        }
    }

    @Test
    void runWithNullArgsSkipsValidationUsesEmptyArgsAndReturnsMessage() throws Exception {
        Implementation impl = implementation(KEY_ONE);
        CommandArgs emptyArgs = new CommandArgs();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(impl)).when(implementationDAO).findById(KEY_ONE);
        when(runnable.run(emptyArgs)).thenReturn(new Command.Result("empty args used", Map.of()));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.build(
                            anyString(),
                            eq(impl),
                            any(Supplier.class),
                            any(Consumer.class))).
                    thenReturn(runnable);

            implementationManager.when(() -> ImplementationManager.emptyArgs(anyString(), eq(impl))).thenReturn(emptyArgs);

            String result = logic.run(new CommandTO.Builder(KEY_ONE).build());

            assertEquals("empty args used", result);

            verifyNoInteractions(validator);
            verify(runnable).run(emptyArgs);

            implementationManager.verify(() -> ImplementationManager.emptyArgs(anyString(), eq(impl)));
        }
    }

    @Test
    void runThrowsNotFoundExceptionWhenImplementationDoesNotExist() {
        when(implementationDAO.findById(KEY_ONE)).thenReturn(Optional.empty());

        NotFoundException ex = assertThrows(
                NotFoundException.class,
                () -> logic.run(new CommandTO.Builder(KEY_ONE).build()));

        assertEquals("Implementation " + KEY_ONE, ex.getMessage());
        verify(implementationDAO).findById(KEY_ONE);
        verifyNoInteractions(validator);
    }

    @Test
    void runThrowsInvalidImplementationWhenCommandCannotBeBuilt() throws Exception {
        Implementation impl = implementation(KEY_ONE);

        doReturn(Optional.of(impl)).when(implementationDAO).findById(KEY_ONE);

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.build(
                            anyString(),
                            eq(impl),
                            any(Supplier.class),
                            any(Consumer.class))).
                    thenThrow(new IllegalStateException("cannot build"));

            SyncopeClientException ex = assertThrows(
                    SyncopeClientException.class,
                    () -> logic.run(new CommandTO.Builder(KEY_ONE).build()));

            assertEquals(ClientExceptionType.InvalidImplementation, ex.getType());
            verifyNoInteractions(validator);
        }
    }

    @Test
    void runThrowsInvalidEntityExceptionWhenValidationViolationsExist() throws Exception {
        Implementation impl = implementation(KEY_ONE);
        CommandArgs args = new CommandArgs();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        @SuppressWarnings("unchecked")
        ConstraintViolation<CommandArgs> violation = mock(ConstraintViolation.class);

        doReturn(Optional.of(impl)).when(implementationDAO).findById(KEY_ONE);
        when(validator.validate(args)).thenReturn(Set.of(violation));

        jakarta.validation.Path propertyPath = mock(jakarta.validation.Path.class);
        lenient().when(propertyPath.toString()).thenReturn("ctx");
        lenient().when(violation.getMessageTemplate())
                .thenReturn("{jakarta.validation.constraints.NotBlank.message}");
        lenient().when(violation.getPropertyPath()).thenReturn(propertyPath);
        lenient().when(violation.getInvalidValue()).thenReturn("");
        lenient().when(violation.getLeafBean()).thenReturn(args);

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.build(
                            anyString(),
                            eq(impl),
                            any(Supplier.class),
                            any(Consumer.class))).
                    thenReturn(runnable);

            // FIX: l'eccezione realmente propagata da CommandLogic.run() e'
            // SyncopeClientException(InvalidValues) - InvalidEntityException viene
            // sollevata internamente ma e' catturata e ri-wrappata dallo stesso metodo.
            SyncopeClientException ex = assertThrows(
                    SyncopeClientException.class,
                    () -> logic.run(new CommandTO.Builder(KEY_ONE).args(args).build()));

            assertEquals(ClientExceptionType.InvalidValues, ex.getType());
            verify(validator).validate(args);
            verify(runnable, never()).run(any());
        }
    }

    @Test
    void runThrowsInvalidValuesWhenValidatorThrowsValidationException() throws Exception {
        Implementation impl = implementation(KEY_ONE);
        CommandArgs args = new CommandArgs();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(impl)).when(implementationDAO).findById(KEY_ONE);
        when(validator.validate(args)).thenThrow(new ValidationException("validator failure"));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.build(
                            anyString(),
                            eq(impl),
                            any(Supplier.class),
                            any(Consumer.class))).
                    thenReturn(runnable);

            SyncopeClientException ex = assertThrows(
                    SyncopeClientException.class,
                    () -> logic.run(new CommandTO.Builder(KEY_ONE).args(args).build()));

            assertEquals(ClientExceptionType.InvalidValues, ex.getType());
            verify(runnable, never()).run(any());
        }
    }

    @Test
    void runThrowsExecutionErrorWhenRunnableFails() throws Exception {
        Implementation impl = implementation(KEY_ONE);
        CommandArgs args = new CommandArgs();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(impl)).when(implementationDAO).findById(KEY_ONE);
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args)).thenThrow(new IllegalStateException("boom"));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.build(
                            anyString(),
                            eq(impl),
                            any(Supplier.class),
                            any(Consumer.class))).
                    thenReturn(runnable);

            SyncopeClientException ex = assertThrows(
                    SyncopeClientException.class,
                    () -> logic.run(new CommandTO.Builder(KEY_ONE).args(args).build()));

            assertEquals(ClientExceptionType.ExecutionError, ex.getType());
            verify(validator).validate(args);
            verify(runnable).run(args);
        }
    }

    @Test
    void runPassesCacheSupplierAndConsumerToImplementationManager() throws Exception {
        Implementation impl = implementation(KEY_ONE);
        CommandArgs args = new CommandArgs();

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);

        doReturn(Optional.of(impl)).when(implementationDAO).findById(KEY_ONE);
        when(validator.validate(args)).thenReturn(Set.of());
        when(runnable.run(args))
                .thenReturn(new Command.Result("first", Map.of()))
                .thenReturn(new Command.Result("second", Map.of()));

        try (MockedStatic<ImplementationManager> implementationManager = mockStatic(ImplementationManager.class)) {
            implementationManager.when(() -> ImplementationManager.build(
                            anyString(),
                            eq(impl),
                            any(Supplier.class),
                            any(Consumer.class))).
                    thenAnswer(invocation -> {
                        @SuppressWarnings("unchecked")
                        Supplier<Command<?>> supplier = invocation.getArgument(2, Supplier.class);

                        @SuppressWarnings("unchecked")
                        Consumer<Command<?>> consumer = invocation.getArgument(3, Consumer.class);

                        Command<?> cached = supplier.get();
                        if (cached == null) {
                            consumer.accept(runnable);
                        } else {
                            assertSame(runnable, cached);
                        }

                        return runnable;
                    });

            CommandTO command = new CommandTO.Builder(KEY_ONE).args(args).build();

            assertEquals("first", logic.run(command));
            assertEquals("second", logic.run(command));

            // FIX: lo scenario chiama logic.run() due volte di proposito (per testare
            // il meccanismo di caching supplier/consumer) - l'asserzione originale
            // controllava una sola invocazione, in contraddizione con lo scenario stesso.
            verify(runnable, times(2)).run(args);
        }
    }

    private Implementation implementation(final String key) {
        Implementation implementation = mock(Implementation.class);
        lenient().when(implementation.getKey()).thenReturn(key);
        return implementation;
    }
}