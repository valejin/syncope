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
package org.apache.syncope.core.provisioning.java.data;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.syncope.common.lib.to.NotificationTO;
import org.apache.syncope.core.persistence.api.dao.AnyTypeDAO;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.MailTemplateDAO;
import org.apache.syncope.core.persistence.api.entity.AnyAbout;
import org.apache.syncope.core.persistence.api.entity.AnyType;
import org.apache.syncope.core.persistence.api.entity.EntityFactory;
import org.apache.syncope.core.persistence.api.entity.MailTemplate;
import org.apache.syncope.core.persistence.api.entity.Notification;
import org.apache.syncope.core.provisioning.api.IntAttrNameParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Suite di raffinamento strutturale (Fase 2) per NotificationDataBinderImpl

@ExtendWith(MockitoExtension.class)
class NotificationDataBinderImplWBTest {

    @Mock
    private MailTemplateDAO mailTemplateDAO;

    @Mock
    private AnyTypeDAO anyTypeDAO;

    @Mock
    private ImplementationDAO implementationDAO;

    @Mock
    private EntityFactory entityFactory;

    @Mock
    private IntAttrNameParser intAttrNameParser;

    @InjectMocks
    private NotificationDataBinderImpl binder;

    /**
     * Origine: report JaCoCo su NotificationDataBinderImpl.java, righe 151 e 164 —
     * entrambe segnalate "1 of 2 branches missed" dopo l'esecuzione della suite black-box di
     * Fase 1.
     * Un solo scenario chiude entrambi i rami: uno stato iniziale di
     * notification.getAbouts(} con un AnyAbout il cui AnyType è
     * PRESENTE anche in notificationTO.getAbouts().
     * Oracolo: nessuna eccezione; l'about esistente viene aggiornato in-place (nessuna nuova
     * istanza creata da entityFactory, nessuna chiamata a notification.add(...));
     * l'about resta nella lista dopo la riconciliazione (non rimosso).
     */
    @Test
    @DisplayName("RF1: about esistente con AnyType ancora presente nella TO -> aggiornato e mantenuto")
    void rf1_existingAboutUpdatedAndKept() {
        // Arrange
        Notification notification = mock(Notification.class);
        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());

        NotificationTO to = new NotificationTO();
        to.setTemplate("mail-template-1");
        to.getEvents().add("userCreate");
        to.getAbouts().put("USER", "cond==true");

        doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");

        AnyType anyType = mock(AnyType.class);
        when(anyType.getKey()).thenReturn("USER");
        doReturn(Optional.of(anyType)).when(anyTypeDAO).findById("USER");

        AnyAbout existingAbout = mock(AnyAbout.class);
        when(existingAbout.getAnyType()).thenReturn(anyType);
        doReturn(Optional.of(existingAbout)).when(notification).getAbout(eq(anyType));

        List<AnyAbout> abouts = new ArrayList<>(List.of(existingAbout));
        doReturn(abouts).when(notification).getAbouts();

        // Act
        assertDoesNotThrow(() -> binder.update(notification, to));

        // Assert
        verify(existingAbout).set("cond==true");
        verify(entityFactory, never()).newEntity(AnyAbout.class);
        verify(notification, never()).add(any());
        assertTrue(abouts.contains(existingAbout));
    }
}