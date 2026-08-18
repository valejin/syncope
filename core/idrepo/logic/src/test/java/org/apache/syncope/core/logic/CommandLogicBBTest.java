/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.core.logic;

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
import static org.mockito.Mockito.when;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.command.CommandArgs;
import org.apache.syncope.common.lib.command.CommandTO;
import org.apache.syncope.common.lib.types.ClientExceptionType;
import org.apache.syncope.common.lib.types.IdRepoImplementationType;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.NotFoundException;
import org.apache.syncope.core.persistence.api.entity.Implementation;
import org.apache.syncope.core.provisioning.api.macro.Command;
import org.apache.syncope.core.spring.implementation.ImplementationManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


// Suite manuale Black-Box (Category Partition, Fase 1) per CommandLogic.

@ExtendWith(MockitoExtension.class)
class CommandLogicBBTest {

    @Mock
    private ImplementationDAO implementationDAO;

    @Mock
    private Validator validator;

    @InjectMocks
    private CommandLogic commandLogic;

    private static Implementation mockImplementation(final String key) {
        Implementation impl = mock(Implementation.class);
        lenient().when(impl.getKey()).thenReturn(key);
        return impl;
    }

    private static Pageable mockPageable(final int pageNumber, final int pageSize) {
        Pageable pageable = mock(Pageable.class, Answers.CALLS_REAL_METHODS);
        when(pageable.getPageNumber()).thenReturn(pageNumber);
        when(pageable.getPageSize()).thenReturn(pageSize);
        return pageable;
    }

    @SuppressWarnings("unchecked")
    private static ConstraintViolation<Object> mockViolation() {
        ConstraintViolation<Object> violation = mock(ConstraintViolation.class);
        // stub necessario: InvalidEntityException itera su questi getter nel costruttore,
        // un mock non stubbato produrrebbe una NullPointerException nel test stesso, non nel SUT.
        when(violation.getMessageTemplate()).thenReturn("dummy;dummy message");
        when(violation.getPropertyPath()).thenReturn(mock(Path.class));
        when(violation.getInvalidValue()).thenReturn("dummy");
        when(violation.getLeafBean()).thenReturn(new Object());
        return violation;
    }

    @Nested
    @DisplayName("search(String, Pageable)")
    class Search {

        /**
         * Scenario: keyword valorizzata con wildcard e match, pageable nominale, DAO con 3 elementi
         * tutti costruibili in CommandTO.
         * Oracolo atteso (O1): pagina popolata con i 3 elementi, count = 3, nessuna eccezione.
         */
        @Test
        @DisplayName("TF1: keyword con wildcard/match, pageable nominale, 3 elementi -> pagina popolata (O1)")
        void tf1_nominal() {
            // Arrange
            Implementation impl1 = mockImplementation("cmd1");
            Implementation impl2 = mockImplementation("cmd2");
            Implementation impl3 = mockImplementation("cmd3");
            when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "%backup%")).
                    thenReturn(List.of(impl1, impl2, impl3));

            try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
                im.when(() -> ImplementationManager.emptyArgs(anyString(), any(Implementation.class))).
                        thenReturn(new CommandArgs());

                // Act
                Page<CommandTO> page = commandLogic.search("%backup%", PageRequest.of(0, 10));

                // Assert
                assertEquals(3, page.getContent().size());
                assertEquals(3, page.getTotalElements());
                assertEquals(List.of("cmd1", "cmd2", "cmd3"),
                        page.getContent().stream().map(CommandTO::getKey).toList());
            }
        }

        /**
         * Scenario: keyword nulla (classe "blank"), pageable nominale, DAO restituisce l'intero
         * catalogo di 5 elementi (nessun filtro applicato lato query, verificato sui sorgenti JPA).
         * Oracolo atteso (O3): pagina con tutti e 5 gli elementi, count = 5, nessuna eccezione.
         */
        @Test
        @DisplayName("TF2: keyword blank (null) -> nessun filtro, tutti i risultati (O3)")
        void tf2_keywordBlank() {
            // Arrange
            Implementation impl1 = mockImplementation("cmd1");
            Implementation impl2 = mockImplementation("cmd2");
            Implementation impl3 = mockImplementation("cmd3");
            Implementation impl4 = mockImplementation("cmd4");
            Implementation impl5 = mockImplementation("cmd5");
            when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, null)).
                    thenReturn(List.of(impl1, impl2, impl3, impl4, impl5));

            try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
                im.when(() -> ImplementationManager.emptyArgs(anyString(), any(Implementation.class))).
                        thenReturn(new CommandArgs());

                // Act
                Page<CommandTO> page = commandLogic.search(null, PageRequest.of(0, 10));

                // Assert
                assertEquals(5, page.getContent().size());
                assertEquals(5, page.getTotalElements());
            }
        }

        /**
         * Scenario: keyword valorizzata ma senza corrispondenza esatta (DAO restituisce lista vuota),
         * pageable nominale.
         * Oracolo atteso (O2): pagina vuota, count = 0, nessuna eccezione.
         */
        @Test
        @DisplayName("TF3: keyword valorizzata senza match esatto -> pagina vuota, count 0 (O2)")
        void tf3_noMatch() {
            // Arrange
            when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "nonexistent-cmd")).
                    thenReturn(List.of());

            // Act
            Page<CommandTO> page = commandLogic.search("nonexistent-cmd", PageRequest.of(0, 10));

            // Assert
            assertTrue(page.getContent().isEmpty());
            assertEquals(0, page.getTotalElements());
        }

        /**
         * Scenario: offset (pageNumber*pageSize) esattamente pari alla dimensione del risultato DAO
         * (3 elementi, offset=3) - confine esatto della "prima pagina vuota".
         * Oracolo atteso (O4): pagina vuota ma count = 3 (il conteggio non riflette la paginazione).
         */
        @Test
        @DisplayName("TF4: offset esattamente = dimensione risultato -> vuota ma count>0 (O4)")
        void tf4_offsetExact() {
            // Arrange
            Implementation impl1 = mockImplementation("cmd1");
            Implementation impl2 = mockImplementation("cmd2");
            Implementation impl3 = mockImplementation("cmd3");
            when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "%backup%")).
                    thenReturn(List.of(impl1, impl2, impl3));

            // Act: PageRequest.of(pageNumber=3, pageSize=1) -> offset = 1*3 = 3 = dimensione risultato
            Page<CommandTO> page = commandLogic.search("%backup%", PageRequest.of(3, 1));

            // Assert
            assertTrue(page.getContent().isEmpty());
            assertEquals(3, page.getTotalElements());
        }

        /**
         * Scenario: pageSize=0 (valore di frontiera sotto il minimo legale di Pageable/PageRequest,
         * raggiungibile solo tramite mock diretto), DAO con 3 elementi.
         * Oracolo atteso (O4): stesso esito di TF4 - pagina vuota ma count = 3, nessuna eccezione.
         */
        @Test
        @DisplayName("TF5: pageSize=0 (mock) -> vuota ma count>0 (O4)")
        void tf5_pageSizeZero() {
            // Arrange
            Implementation impl1 = mockImplementation("cmd1");
            Implementation impl2 = mockImplementation("cmd2");
            Implementation impl3 = mockImplementation("cmd3");
            when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "%backup%")).
                    thenReturn(List.of(impl1, impl2, impl3));

            // Act
            Page<CommandTO> page = commandLogic.search("%backup%", mockPageable(0, 0));

            // Assert
            assertTrue(page.getContent().isEmpty());
            assertEquals(3, page.getTotalElements());
        }

        /**
         * Scenario: pageable = Pageable.unpaged() (istanza reale di Spring Data, non un mock).
         * Oracolo atteso (O5): UnsupportedOperationException, comportamento documentato di
         * Unpaged.getPageSize()/getPageNumber() in Spring Data Commons.
         */
        @Test
        @DisplayName("TF6: Pageable.unpaged() -> UnsupportedOperationException (O5)")
        void tf6_unpaged() {
            // Arrange
            Implementation impl1 = mockImplementation("cmd1");
            when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "%backup%")).
                    thenReturn(List.of(impl1));

            // Act & Assert (assertThrows esegue l'azione e verifica l'oracolo in un solo passo)
            assertThrows(UnsupportedOperationException.class,
                    () -> commandLogic.search("%backup%", Pageable.unpaged()));
        }

        /**
         * Scenario: pageable = null.
         * Oracolo atteso (O6): NullPointerException alla prima dereferenziazione di pageable,
         * nessun controllo esplicito di null-safety nel metodo.
         */
        @Test
        @DisplayName("TF7: pageable nullo -> NullPointerException (O6)")
        void tf7_pageableNull() {
            // Arrange
            Implementation impl1 = mockImplementation("cmd1");
            when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "%backup%")).
                    thenReturn(List.of(impl1));

            // Act & Assert
            assertThrows(NullPointerException.class,
                    () -> commandLogic.search("%backup%", null));
        }

        /**
         * Scenario (BVA): pageNumber = -1, valore di frontiera sotto il minimo pubblico dichiarato
         * da Pageable/PageRequest (>=0), raggiungibile solo tramite mock diretto.
         * Oracolo atteso (O7): eccezione attesa - era un'ipotesi da verificare sperimentalmente in
         * fase di progettazione black-box; l'esecuzione (vedi documento) l'ha confermata come
         * IllegalArgumentException.
         */
        @Test
        @DisplayName("TF8 (BVA): pageNumber=-1 -> eccezione attesa, ipotesi iniziale confermata (O7)")
        void tf8_pageNumberNegative() {
            // Arrange
            Implementation impl1 = mockImplementation("cmd1");
            Implementation impl2 = mockImplementation("cmd2");
            Implementation impl3 = mockImplementation("cmd3");
            when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "%backup%")).
                    thenReturn(List.of(impl1, impl2, impl3));

            // Act & Assert
            assertThrows(IllegalArgumentException.class,
                    () -> commandLogic.search("%backup%", mockPageable(-1, 10)));
        }

        /**
         * Scenario (BVA): pageSize = 1, minimo valido consentito da PageRequest.of, DAO con 3 elementi.
         * Oracolo atteso (O1): pagina con esattamente 1 elemento, count = 3, nessuna eccezione.
         */
        @Test
        @DisplayName("TF9 (BVA): pageSize=1, minimo valido -> pagina con 1 elemento (O1)")
        void tf9_pageSizeMinimum() {
            // Arrange
            Implementation impl1 = mockImplementation("cmd1");
            Implementation impl2 = mockImplementation("cmd2");
            Implementation impl3 = mockImplementation("cmd3");
            when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "%backup%")).
                    thenReturn(List.of(impl1, impl2, impl3));

            try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
                im.when(() -> ImplementationManager.emptyArgs(anyString(), any(Implementation.class))).
                        thenReturn(new CommandArgs());

                // Act
                Page<CommandTO> page = commandLogic.search("%backup%", PageRequest.of(0, 1));

                // Assert
                assertEquals(1, page.getContent().size());
                assertEquals(3, page.getTotalElements());
            }
        }

        /**
         * Scenario (BVA): offset = dimensione risultato - 1 (ultimo elemento incluso), confine
         * "appena sotto" l'esaurimento della lista, DAO con 3 elementi.
         * Oracolo atteso (O1): pagina con esattamente 1 elemento (l'ultimo, "cmd3"), count = 3.
         */
        @Test
        @DisplayName("TF10 (BVA): offset = dimensione risultato - 1 -> ultimo elemento incluso (O1)")
        void tf10_lastElementIncluded() {
            // Arrange
            Implementation impl1 = mockImplementation("cmd1");
            Implementation impl2 = mockImplementation("cmd2");
            Implementation impl3 = mockImplementation("cmd3");
            when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "%backup%")).
                    thenReturn(List.of(impl1, impl2, impl3));

            try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
                im.when(() -> ImplementationManager.emptyArgs(anyString(), any(Implementation.class))).
                        thenReturn(new CommandArgs());

                // Act: PageRequest.of(pageNumber=2, pageSize=1) -> offset = 1*2 = 2 = size-1
                Page<CommandTO> page = commandLogic.search("%backup%", PageRequest.of(2, 1));

                // Assert
                assertEquals(1, page.getContent().size());
                assertEquals("cmd3", page.getContent().get(0).getKey());
                assertEquals(3, page.getTotalElements());
            }
        }
    }

    @Nested
    @DisplayName("run(CommandTO)")
    class Run {

        /**
         * Scenario: key presente nel DAO, build dell'implementazione riuscito, args = null
         * (verra' usato ImplementationManager.emptyArgs internamente), esecuzione riuscita.
         * Oracolo atteso (O1): stringa non nulla restituita (il message() del Result), nessuna eccezione.
         */
        @Test
        @DisplayName("TF1: key presente, build ok, args=null, run ok -> messaggio (O1)")
        void tf1_argsNullSuccess() {
            // Arrange
            Implementation impl = mockImplementation("clear-cache");
            doReturn(Optional.of(impl)).when(implementationDAO).findById("clear-cache");

            @SuppressWarnings("unchecked")
            Command<CommandArgs> runnable = mock(Command.class);
            when(runnable.run(any())).thenReturn(new Command.Result("OK", Map.of()));

            CommandTO command = new CommandTO.Builder("clear-cache").build();

            try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
                im.when(() -> ImplementationManager.build(anyString(), eq(impl), any(), any())).
                        thenReturn(runnable);
                im.when(() -> ImplementationManager.emptyArgs(anyString(), eq(impl))).
                        thenReturn(new CommandArgs());

                // Act
                String result = commandLogic.run(command);

                // Assert
                assertEquals("OK", result);
            }
        }

        /**
         * Scenario: key presente, build riuscito, args non nullo e valido (nessuna violazione
         * rilevata dal validator), esecuzione riuscita.
         * Oracolo atteso (O1): stringa non nulla restituita, nessuna eccezione.
         */
        @Test
        @DisplayName("TF2: key presente, build ok, args validi (nessuna violazione), run ok -> messaggio (O1)")
        void tf2_argsValidSuccess() {
            // Arrange
            Implementation impl = mockImplementation("clear-cache");
            doReturn(Optional.of(impl)).when(implementationDAO).findById("clear-cache");
            when(validator.validate(any())).thenReturn(Set.of());

            @SuppressWarnings("unchecked")
            Command<CommandArgs> runnable = mock(Command.class);
            when(runnable.run(any())).thenReturn(new Command.Result("OK", Map.of()));

            CommandTO command = new CommandTO.Builder("clear-cache").args(new CommandArgs()).build();

            try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
                im.when(() -> ImplementationManager.build(anyString(), eq(impl), any(), any())).
                        thenReturn(runnable);

                // Act
                String result = commandLogic.run(command);

                // Assert
                assertEquals("OK", result);
            }
        }

        /**
         * Scenario: command = null.
         * Oracolo atteso (O2): NullPointerException alla prima dereferenziazione (command.getKey()),
         * nessun controllo esplicito di null sul parametro.
         */
        @Test
        @DisplayName("TF3: command nullo -> NullPointerException (O2)")
        void tf3_commandNull() {
            // Arrange: nessuno stub necessario, l'eccezione scatta prima di toccare i collaboratori

            // Act & Assert
            assertThrows(NullPointerException.class, () -> commandLogic.run(null));
        }

        /**
         * Scenario: command.key = null (il DAO mockato restituisce Optional.empty() per chiave nulla:
         * poiche' il DAO e' mockato, questa scelta e' sotto il nostro controllo).
         * Oracolo atteso (O3): NotFoundException("Implementation " + key).
         */
        @Test
        @DisplayName("TF4: key nulla -> NotFoundException (O3)")
        void tf4_keyNull() {
            // Arrange
            doReturn(Optional.empty()).when(implementationDAO).findById(null);
            CommandTO command = new CommandTO.Builder(null).build();

            // Act & Assert
            assertThrows(NotFoundException.class, () -> commandLogic.run(command));
        }

        /**
         * Scenario: command.key valorizzata ma assente nel DAO.
         * Oracolo atteso (O3): NotFoundException("Implementation " + key).
         */
        @Test
        @DisplayName("TF5: key assente nel DAO -> NotFoundException (O3)")
        void tf5_keyNotFound() {
            // Arrange
            doReturn(Optional.empty()).when(implementationDAO).findById("missing-cmd");
            CommandTO command = new CommandTO.Builder("missing-cmd").build();

            // Act & Assert
            assertThrows(NotFoundException.class, () -> commandLogic.run(command));
        }

        /**
         * Scenario: key presente nel DAO, ma ImplementationManager.build(...) fallisce
         * (simulato con ClassNotFoundException, l'eccezione dichiarata dalla firma del metodo).
         * Oracolo atteso (O4): SyncopeClientException di tipo InvalidImplementation.
         */
        @Test
        @DisplayName("TF6: build fallisce -> SyncopeClientException InvalidImplementation (O4)")
        void tf6_buildFails() {
            // Arrange
            Implementation impl = mockImplementation("broken-cmd");
            doReturn(Optional.of(impl)).when(implementationDAO).findById("broken-cmd");
            CommandTO command = new CommandTO.Builder("broken-cmd").build();

            try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
                im.when(() -> ImplementationManager.build(anyString(), eq(impl), any(), any())).
                        thenThrow(new ClassNotFoundException("boom"));

                // Act
                SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                        () -> commandLogic.run(command));

                // Assert
                assertEquals(ClientExceptionType.InvalidImplementation, sce.getType());
            }
        }

        /**
         * Scenario: key presente, build riuscito, args non nullo con violazioni di vincolo rilevate
         * dal validator (Set non vuoto di ConstraintViolation).
         * Oracolo atteso (O5): SyncopeClientException di tipo InvalidValues (InvalidEntityException,
         * sottoclasse di ValidationException, viene intercettata dallo stesso blocco catch che gestisce
         * anche un fallimento diretto del validator).
         */
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

            try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
                im.when(() -> ImplementationManager.build(anyString(), eq(impl), any(), any())).
                        thenReturn(runnable);

                // Act
                SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                        () -> commandLogic.run(command));

                // Assert
                assertEquals(ClientExceptionType.InvalidValues, sce.getType());
            }
        }

        /**
         * Scenario: key presente, build riuscito, args validi, ma runnable.run(...) lancia
         * un'eccezione generica durante l'esecuzione del comando.
         * Oracolo atteso (O6): SyncopeClientException di tipo ExecutionError.
         */
        @Test
        @DisplayName("TF8: run(...) lancia eccezione generica -> SyncopeClientException ExecutionError (O6)")
        void tf8_runThrows() {
            // Arrange
            Implementation impl = mockImplementation("clear-cache");
            doReturn(Optional.of(impl)).when(implementationDAO).findById("clear-cache");
            when(validator.validate(any())).thenReturn(Set.of());

            @SuppressWarnings("unchecked")
            Command<CommandArgs> runnable = mock(Command.class);
            when(runnable.run(any())).thenThrow(new RuntimeException("boom"));

            CommandTO command = new CommandTO.Builder("clear-cache").args(new CommandArgs()).build();

            try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
                im.when(() -> ImplementationManager.build(anyString(), eq(impl), any(), any())).
                        thenReturn(runnable);

                // Act
                SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                        () -> commandLogic.run(command));

                // Assert
                assertEquals(ClientExceptionType.ExecutionError, sce.getType());
            }
        }
    }
}