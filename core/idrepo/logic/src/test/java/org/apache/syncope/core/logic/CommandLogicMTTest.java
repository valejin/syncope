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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.apache.syncope.common.lib.command.CommandArgs;
import org.apache.syncope.common.lib.command.CommandTO;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.entity.Implementation;
import org.apache.syncope.core.provisioning.api.macro.Command;
import org.apache.syncope.core.spring.implementation.ImplementationManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.validation.Validator;


// Suite di raffinamento guidata dal Mutation Testing (PIT) per CommandLogic.

@ExtendWith(MockitoExtension.class)
class CommandLogicMTTest {

    @Mock
    private ImplementationDAO implementationDAO;

    @Mock
    private Validator validator;

    @InjectMocks
    private CommandLogic commandLogic;

    private static Implementation mockImplementation(final String key) {
        Implementation impl = mock(Implementation.class);
        // lenient: .getKey() sta solo dentro le lambda passate a ImplementationManager.build(...),
        // che qui è mockato - quelle lambda non vengono mai davvero invocate.
        lenient().when(impl.getKey()).thenReturn(key);
        return impl;
    }

    /**
     * Versione rafforzata di TF1 (args=null). A differenza dell'originale, lo stub di
     * {runnable.run(...)} e la verifica finale usano l'istanza esatta di
     * {emptyArgs}, non {any()}: se il mutante scambiasse i rami del ternario,
     * {runnable.run(...)} riceverebbe {null} invece di {emptyArgs}, lo
     * stub non troverebbe corrispondenza, e {.message()} su un {Result} nullo
     * lancerebbe {NullPointerException} — il test fallirebbe, uccidendo il mutante.
     */
    @Test
    @DisplayName("MT1 (rafforza TF1): runnable.run riceve esattamente emptyArgs, non un argomento qualunque")
    void mt1_argsNullSuccess_verifiesExactArgument() {
        // Arrange
        Implementation impl = mockImplementation("clear-cache");
        doReturn(Optional.of(impl)).when(implementationDAO).findById("clear-cache");

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);
        CommandArgs emptyArgs = new CommandArgs();
        when(runnable.run(emptyArgs)).thenReturn(new Command.Result("OK", Map.of()));

        CommandTO command = new CommandTO.Builder("clear-cache").build();

        try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
            im.when(() -> ImplementationManager.build(anyString(), eq(impl), any(), any())).
                    thenReturn(runnable);
            im.when(() -> ImplementationManager.emptyArgs(anyString(), eq(impl))).
                    thenReturn(emptyArgs);

            // Act
            String result = commandLogic.run(command);

            // Assert
            assertEquals("OK", result);
            verify(runnable).run(emptyArgs);
        }
    }

    /**
     * Versione rafforzata di TF2 (args non nullo). Stesso principio, ramo opposto del
     * ternario: la verifica conferma che venga passato esattamente {command.getArgs()},
     * non {emptyArgs()} né un argomento qualunque.
     */
    @Test
    @DisplayName("MT2 (rafforza TF2): runnable.run riceve esattamente command.getArgs(), non un argomento qualunque")
    void mt2_argsValidSuccess_verifiesExactArgument() {
        // Arrange
        Implementation impl = mockImplementation("clear-cache");
        doReturn(Optional.of(impl)).when(implementationDAO).findById("clear-cache");
        when(validator.validate(any())).thenReturn(Set.of());

        @SuppressWarnings("unchecked")
        Command<CommandArgs> runnable = mock(Command.class);
        CommandArgs args = new CommandArgs();
        when(runnable.run(args)).thenReturn(new Command.Result("OK", Map.of()));

        CommandTO command = new CommandTO.Builder("clear-cache").args(args).build();

        try (MockedStatic<ImplementationManager> im = mockStatic(ImplementationManager.class)) {
            im.when(() -> ImplementationManager.build(anyString(), eq(impl), any(), any())).
                    thenReturn(runnable);

            // Act
            String result = commandLogic.run(command);

            // Assert
            assertEquals("OK", result);
            verify(runnable).run(args);
        }
    }
}