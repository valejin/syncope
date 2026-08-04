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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.syncope.common.lib.to.NotificationTO;
import org.apache.syncope.common.lib.types.TraceLevel;
import org.apache.syncope.core.persistence.api.dao.AnyTypeDAO;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.MailTemplateDAO;
import org.apache.syncope.core.persistence.api.entity.AnyAbout;
import org.apache.syncope.core.persistence.api.entity.AnyType;
import org.apache.syncope.core.persistence.api.entity.EntityFactory;
import org.apache.syncope.core.persistence.api.entity.Implementation;
import org.apache.syncope.core.persistence.api.entity.MailTemplate;
import org.apache.syncope.core.persistence.api.entity.Notification;
import org.apache.syncope.core.provisioning.api.IntAttrNameParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Suite di raffinamento guidata dal Mutation Testing (PIT) per {@link NotificationDataBinderImpl}.
 *
 * <p>Separata da {@code NotificationDataBinderImplBBTest} e {@code NotificationDataBinderImplWBTest}
 * per lo stesso motivo gia' documentato per {@code CommandLogic}: questi test nascono da mutanti
 * sopravvissuti su righe gia' coperte, non da un ragionamento sul contratto del metodo o da un
 * ramo mai eseguito. Le versioni originali dei TF corrispondenti restano intatte nel file BB.
 *
 * <p>19 mutanti sopravvissuti nel primo run di PIT, tutti {@code VoidMethodCallMutator} (rimozione
 * di una chiamata a un setter void), riconducibili a 3 pattern:
 * <ul>
 *   <li><b>MT1</b> — 8 mutanti su {@code getNotificationTO(...)} (L73,76,78-83): i campi "generici"
 *       (key, recipientsFIQL, recipientAttrName, selfAsRecipient, sender, subject, traceLevel,
 *       active), mai asseriti nella suite black-box perche' classificati come "senza ramo
 *       dichiarato osservabile" nel documento di progettazione.</li>
 *   <li><b>MT2</b> — 9 mutanti su {@code update(...)} (L104,109-114,153-154): stessi campi
 *       generici, lato opposto (setter su un mock mai verificati con {@code verify(...)}), piu'
 *       {@code about.setAnyType(...)}/{@code setNotification(...)} nel ramo "crea nuovo about".</li>
 *   <li><b>MT3</b> — 2 mutanti su {@code update(...)} (L106,116): {@code removed call to
 *       List::clear} su {@code staticRecipients}/{@code events}. Nella suite black-box lo stato
 *       iniziale di quelle liste e' sempre vuoto, quindi rimuovere {@code .clear()} non cambia
 *       nulla di osservabile — serve uno scenario con contenuto preesistente.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
class NotificationDataBinderImplMTTest {

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

    private static Notification mockNotification() {
        Notification notification = mock(Notification.class);
        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        return notification;
    }

    private static NotificationTO validNotificationTO() {
        NotificationTO to = new NotificationTO();
        to.setTemplate("mail-template-1");
        to.getEvents().add("userCreate");
        to.setRecipientAttrName("username");
        return to;
    }

    /**
     * MT1: rafforza lo scenario nominale di getNotificationTO() (equivalente a TF1 in
     * NotificationDataBinderImplBBTest) verificando anche gli 8 campi "generici" mai controllati
     * in Fase 1. notificationTO e' un oggetto reale: bastano asserzioni dirette sui campi.
     */
    @Test
    @DisplayName("MT1: getNotificationTO copia fedelmente anche i campi generici (key, FIQL, ecc.)")
    void mt1_getNotificationTO_genericFieldsCopiedCorrectly() {
        // Arrange
        Notification notification = mock(Notification.class);
        when(notification.getKey()).thenReturn("notif-1");
        MailTemplate template = mock(MailTemplate.class);
        when(template.getKey()).thenReturn("tmpl-1");
        when(notification.getTemplate()).thenReturn(template);
        when(notification.getEvents()).thenReturn(List.of("userCreate"));
        when(notification.getRecipientsFIQL()).thenReturn("fiql-expr");
        when(notification.getStaticRecipients()).thenReturn(List.of("user@example.com"));
        when(notification.getRecipientAttrName()).thenReturn("username");
        when(notification.isSelfAsRecipient()).thenReturn(true);
        when(notification.getSender()).thenReturn("noreply@example.com");
        when(notification.getSubject()).thenReturn("Subject");
        when(notification.getTraceLevel()).thenReturn(TraceLevel.SUMMARY);
        when(notification.isActive()).thenReturn(true);
        // abouts e recipientsProvider non stubbati: default mock (lista vuota / null) sufficiente,
        // non sono oggetto di questo test (gia' coperti da TF1 in Fase 1)

        // Act
        NotificationTO to = binder.getNotificationTO(notification);

        // Assert
        assertEquals("notif-1", to.getKey());
        assertEquals("fiql-expr", to.getRecipientsFIQL());
        assertEquals("username", to.getRecipientAttrName());
        assertTrue(to.isSelfAsRecipient());
        assertEquals("noreply@example.com", to.getSender());
        assertEquals("Subject", to.getSubject());
        assertEquals(TraceLevel.SUMMARY, to.getTraceLevel());
        assertTrue(to.isActive());
    }

    /**
     * MT2: rafforza lo scenario nominale di update() (equivalente a TF1 in
     * NotificationDataBinderImplBBTest), aggiungendo verify(...) sui setter "generici" di
     * notification (mock) e sui setter di un about di nuova creazione, mai controllati in Fase 1.
     */
    @Test
    @DisplayName("MT2: update invoca tutti i setter generici su notification, non solo quelli categorizzati")
    void mt2_update_genericSettersInvoked() {
        // Arrange
        Notification notification = mockNotification();

        NotificationTO to = validNotificationTO();
        to.setRecipientsFIQL("fiql-expr");
        to.setSelfAsRecipient(true);
        to.setSender("noreply@example.com");
        to.setSubject("Subject");
        to.setTraceLevel(TraceLevel.SUMMARY);
        to.setActive(true);
        to.getStaticRecipients().add("user@example.com");
        to.getAbouts().put("USER", "cond==true");
        to.setRecipientsProvider("provider-1");

        doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");

        AnyType anyType = mock(AnyType.class);
        doReturn(Optional.of(anyType)).when(anyTypeDAO).findById("USER");
        doReturn(Optional.empty()).when(notification).getAbout(eq(anyType));
        AnyAbout newAbout = mock(AnyAbout.class);
        when(entityFactory.newEntity(AnyAbout.class)).thenReturn(newAbout);

        doReturn(Optional.of(mock(Implementation.class))).when(implementationDAO).findById("provider-1");

        // Act
        assertDoesNotThrow(() -> binder.update(notification, to));

        // Assert
        verify(notification).setRecipientsFIQL("fiql-expr");
        verify(notification).setRecipientAttrName("username");
        verify(notification).setSelfAsRecipient(true);
        verify(notification).setSender("noreply@example.com");
        verify(notification).setSubject("Subject");
        verify(notification).setTraceLevel(TraceLevel.SUMMARY);
        verify(notification).setActive(true);
        verify(newAbout).setAnyType(anyType);
        verify(newAbout).setNotification(notification);
    }

    /**
     * MT3: notification.getStaticRecipients()/getEvents() iniziano con contenuto preesistente
     * (a differenza di ogni scenario in Fase 1, dove partono sempre vuoti). Se update() non
     * chiamasse .clear() prima di .addAll(...), il contenuto vecchio sopravviverebbe insieme
     * al nuovo - l'asserzione sul contenuto finale esatto lo rileva.
     */
    @Test
    @DisplayName("MT3: update sostituisce (clear+addAll) il contenuto di staticRecipients/events, non lo accoda")
    void mt3_update_clearsListsBeforeReplacing() {
        // Arrange
        Notification notification = mock(Notification.class);
        List<String> staticRecipients = new ArrayList<>(List.of("old@example.com"));
        when(notification.getStaticRecipients()).thenReturn(staticRecipients);
        List<String> events = new ArrayList<>(List.of("oldEvent"));
        when(notification.getEvents()).thenReturn(events);

        NotificationTO to = validNotificationTO(); // events=[userCreate], staticRecipients vuota

        doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");

        // Act
        assertDoesNotThrow(() -> binder.update(notification, to));

        // Assert: stesse istanze di lista passate al mock, mutate in place da clear()+addAll()
        assertEquals(List.of("userCreate"), events);
        assertEquals(List.of(), staticRecipients);
    }
}