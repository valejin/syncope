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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.List;
import org.apache.syncope.common.lib.command.CommandArgs;
import org.apache.syncope.common.lib.command.CommandTO;
import org.apache.syncope.common.lib.types.IdRepoImplementationType;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.entity.Implementation;
import org.apache.syncope.core.spring.implementation.ImplementationManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import jakarta.validation.Validator;


// Suite di raffinamento strutturale (Fase 2) per CommandLogic, guidata dal report
// JaCoCo generato dall'esecuzione di CommandLogicBBTest (Fase 1, black-box).

@ExtendWith(MockitoExtension.class)
class CommandLogicWBTest {

    @Mock
    private ImplementationDAO implementationDAO;

    @Mock
    private Validator validator;

    @InjectMocks
    private CommandLogic commandLogic;

    private static Implementation mockImplementation(final String key) {
        Implementation impl = mock(Implementation.class);
        when(impl.getKey()).thenReturn(key);
        return impl;
    }

    /**
     * Scenario: keyword con match, pageable nominale, DAO con 3 elementi di cui uno fa
     * fallire ImplementationManager.emptyArgs(...).
     * Oracolo: nessuna eccezione; {content} ha 2 elementi (quello fallace filtrato in
     * silenzio), ma {count} resta 3 — conferma sperimentale del candidato bug
     * (incoerenza tra dimensione della pagina restituita e conteggio totale).
     */
    @Test
    @DisplayName("RF1: DAO con un elemento che fallisce la build -> content=2 ma count=3")
    void rf1_oneElementFailsToBuild() {
        // Arrange
        Implementation impl1 = mockImplementation("cmd1");
        Implementation impl2 = mockImplementation("cmd2");
        Implementation impl3 = mockImplementation("cmd3");
        when(implementationDAO.findByTypeAndKeyword(IdRepoImplementationType.COMMAND, "%backup%")).
                thenReturn(List.of(impl1, impl2, impl3));

        try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
            im.when(() -> ImplementationManager.emptyArgs(anyString(), eq(impl1))).
                    thenReturn(new CommandArgs());
            im.when(() -> ImplementationManager.emptyArgs(anyString(), eq(impl2))).
                    thenThrow(new RuntimeException("boom"));
            im.when(() -> ImplementationManager.emptyArgs(anyString(), eq(impl3))).
                    thenReturn(new CommandArgs());

            // Act
            Page<CommandTO> page = commandLogic.search("%backup%", PageRequest.of(0, 10));

            // Assert
            assertEquals(2, page.getContent().size());
            assertEquals(3, page.getTotalElements());
        }
    }
}