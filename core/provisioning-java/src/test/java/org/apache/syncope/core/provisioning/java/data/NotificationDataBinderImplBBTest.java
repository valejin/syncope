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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.to.NotificationTO;
import org.apache.syncope.common.lib.types.ClientExceptionType;
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
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Suite manuale Black-Box (Category Partition, Fase 1) per {@link NotificationDataBinderImpl}.
 *
 * Struttura e convenzioni identiche a {@code CommandLogicBBTest}: {@code @Mock}/{@code @InjectMocks}
 * con {@code @ExtendWith(MockitoExtension.class)}, corpo Arrange/Act/Assert, Javadoc per ogni test
 * con scenario e oracolo atteso (rif. CategoryPartition_NotificationDataBinderImpl.md).
 *
 * <p><b>Nota su {@code notification} come mock.</b> {@code Notification} e' un'interfaccia di
 * persistenza priva di implementazione leggera utilizzabile nei test: resta quindi un mock, non un
 * campo {@code @Mock} (varia da test a test). Due dei suoi getter — {@code getEvents()} e
 * {@code getStaticRecipients()} — non hanno un setter corrispondente sull'interfaccia: il metodo
 * sotto test li muta *in place* con {@code .clear()} + {@code .addAll(...)}, quindi lo stub deve
 * restituire *sempre la stessa* lista mutabile (non una nuova ad ogni chiamata), altrimenti le due
 * chiamate opererebbero su istanze diverse. {@code getAbouts()}/{@code getAbout(...)} restituiscono
 * tipi con wildcard ({@code List<? extends AnyAbout>} / {@code Optional<? extends AnyAbout>}), quindi
 * richiedono {@code doReturn(...).when(...)} invece di {@code when(...).thenReturn(...)} — stesso
 * problema di generics gia' incontrato con {@code ImplementationDAO.findById(...)}.
 */
@ExtendWith(MockitoExtension.class)
class NotificationDataBinderImplBBTest {

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
     * Notification mockata con getEvents()/getStaticRecipients()/getAbouts() gia' agganciati a
     * liste mutabili condivise tra le chiamate (necessario perché update() le muta in place).
     * lenient(): non tutti gli scenari arrivano a leggere getAbouts() (es. valori obbligatori
     * mancanti fanno uscire il metodo prima), quindi in quei casi lo stub resterebbe inutilizzato.
     */
    private static Notification mockNotification() {
        Notification notification = mock(Notification.class);
        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        lenient().doReturn(new ArrayList<AnyAbout>()).when(notification).getAbouts();
        return notification;
    }

    /** NotificationTO con i soli campi obbligatori valorizzati (template, events, recipientAttrName). */
    private static NotificationTO validNotificationTO() {
        NotificationTO to = new NotificationTO();
        to.setTemplate("mail-template-1");
        to.getEvents().add("userCreate");
        to.setRecipientAttrName("username");
        return to;
    }

    @Nested
    @DisplayName("update(Notification, NotificationTO)")
    class Update {

        /**
         * Scenario: notification valida, template con corrispondenza, events non vuota,
         * staticRecipients con indirizzo conforme, abouts con chiave risolvibile e valore
         * non-blank, recipientAttrName parsabile, recipientsProvider con corrispondenza.
         * Oracolo atteso (O1): nessuna eccezione; notification aggiornata coerentemente
         * (verificato tramite interazione, dato che notification è un mock senza stato reale).
         */
        @Test
        @DisplayName("TF1: scenario nominale, tutti i campi validi -> nessuna eccezione (O1)")
        void tf1_nominal() {
            // Arrange
            Notification notification = mockNotification();

            NotificationTO to = validNotificationTO();
            to.getStaticRecipients().add("user@example.com");
            to.getAbouts().put("USER", "cond==true");
            to.setRecipientsProvider("provider-1");

            MailTemplate template = mock(MailTemplate.class);
            doReturn(Optional.of(template)).when(mailTemplateDAO).findById("mail-template-1");

            AnyType anyType = mock(AnyType.class);
            doReturn(Optional.of(anyType)).when(anyTypeDAO).findById("USER");
            doReturn(Optional.empty()).when(notification).getAbout(eq(anyType));
            AnyAbout newAbout = mock(AnyAbout.class);
            when(entityFactory.newEntity(AnyAbout.class)).thenReturn(newAbout);

            Implementation provider = mock(Implementation.class);
            doReturn(Optional.of(provider)).when(implementationDAO).findById("provider-1");

            // intAttrNameParser.parse(...) non stubbato -> comportamento di default (nessuna eccezione)

            // Act
            assertDoesNotThrow(() -> binder.update(notification, to));

            // Assert
            verify(notification).setTemplate(template);
            verify(notification).add(newAbout);
            verify(notification).setRecipientsProvider(provider);
        }

        /**
         * Scenario: notification = null.
         * Oracolo atteso (O2): NullPointerException alla prima dereferenziazione, ipotesi iniziale
         * (nessun controllo esplicito di null-safety nel metodo).
         */
        @Test
        @DisplayName("TF2: notification nulla -> NullPointerException (O2)")
        void tf2_notificationNull() {
            // Arrange
            NotificationTO to = validNotificationTO();

            // Act & Assert
            assertThrows(NullPointerException.class, () -> binder.update(null, to));
        }

        /**
         * Scenario: template valorizzato ma senza corrispondenza in mailTemplateDAO; resto nominale.
         * Oracolo atteso (O3): SyncopeClientException di tipo RequiredValuesMissing, elemento "template".
         */
        @Test
        @DisplayName("TF3: template senza corrispondenza -> SyncopeClientException RequiredValuesMissing (O3)")
        void tf3_templateNotFound() {
            // Arrange
            Notification notification = mockNotification();
            NotificationTO to = validNotificationTO();
            to.setTemplate("missing-template");
            doReturn(Optional.empty()).when(mailTemplateDAO).findById("missing-template");

            // Act
            SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                    () -> binder.update(notification, to));

            // Assert
            assertEquals(ClientExceptionType.RequiredValuesMissing, sce.getType());
            assertTrue(sce.getElements().contains("template"));
        }

        /**
         * Scenario: events vuota; resto nominale (template valido).
         * Oracolo atteso (O3): SyncopeClientException di tipo RequiredValuesMissing, elemento "events".
         */
        @Test
        @DisplayName("TF4: events vuota -> SyncopeClientException RequiredValuesMissing (O3)")
        void tf4_eventsEmpty() {
            // Arrange
            Notification notification = mockNotification();
            NotificationTO to = validNotificationTO();
            to.getEvents().clear();
            doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");

            // Act
            SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                    () -> binder.update(notification, to));

            // Assert
            assertEquals(ClientExceptionType.RequiredValuesMissing, sce.getType());
            assertTrue(sce.getElements().contains("events"));
        }

        /**
         * Scenario: staticRecipients con un indirizzo non conforme a Entity.EMAIL_PATTERN;
         * resto nominale.
         * Oracolo atteso (O3): SyncopeClientException di tipo RequiredValuesMissing,
         * elemento "staticRecipients: not-an-email".
         */
        @Test
        @DisplayName("TF5: staticRecipients con indirizzo non valido -> SyncopeClientException RequiredValuesMissing (O3)")
        void tf5_staticRecipientInvalid() {
            // Arrange
            Notification notification = mockNotification();
            NotificationTO to = validNotificationTO();
            to.getStaticRecipients().add("not-an-email");
            doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");

            // Act
            SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                    () -> binder.update(notification, to));

            // Assert
            assertEquals(ClientExceptionType.RequiredValuesMissing, sce.getType());
            assertTrue(sce.getElements().contains("staticRecipients: not-an-email"));
        }

        /**
         * Scenario: recipientAttrName non parsabile da IntAttrNameParser; resto nominale (template
         * valido, quindi si supera la validazione dei valori obbligatori e si arriva al parsing).
         * Oracolo atteso (O4): SyncopeClientException di tipo InvalidRequest.
         */
        @Test
        @DisplayName("TF6: recipientAttrName non parsabile -> SyncopeClientException InvalidRequest (O4)")
        void tf6_recipientAttrNameNotParsable() throws ParseException {
            // Arrange
            Notification notification = mockNotification();
            NotificationTO to = validNotificationTO();
            doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");
            when(intAttrNameParser.parse(any(), any())).thenThrow(new ParseException("bad attr name", 0));

            // Act
            SyncopeClientException sce = assertThrows(SyncopeClientException.class,
                    () -> binder.update(notification, to));

            // Assert
            assertEquals(ClientExceptionType.InvalidRequest, sce.getType());
        }

        /**
         * Scenario: abouts con una chiave (AnyType) non risolvibile in anyTypeDAO; resto nominale.
         * Oracolo atteso (O5): nessuna eccezione; l'about anomalo viene ignorato (notification.add(...)
         * mai invocato).
         */
        @Test
        @DisplayName("TF7: abouts con chiave non risolvibile -> ignorato, nessuna eccezione (O5)")
        void tf7_aboutsUnresolvableKey() {
            // Arrange
            Notification notification = mockNotification();
            NotificationTO to = validNotificationTO();
            to.getAbouts().put("MISSING_TYPE", "cond==true");
            doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");
            doReturn(Optional.empty()).when(anyTypeDAO).findById("MISSING_TYPE");

            // Act
            assertDoesNotThrow(() -> binder.update(notification, to));

            // Assert
            verify(notification, never()).add(any());
        }

        /**
         * Scenario: abouts con un valore blank per una chiave altrimenti valida; resto nominale.
         * Oracolo atteso (O5): nessuna eccezione; l'entry viene filtrata prima ancora di interrogare
         * anyTypeDAO (StringUtils.isNotBlank sul valore).
         */
        @Test
        @DisplayName("TF8: abouts con valore blank -> ignorato, nessuna eccezione (O5)")
        void tf8_aboutsBlankValue() {
            // Arrange
            Notification notification = mockNotification();
            NotificationTO to = validNotificationTO();
            to.getAbouts().put("USER", "");
            doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");

            // Act
            assertDoesNotThrow(() -> binder.update(notification, to));

            // Assert
            verify(anyTypeDAO, never()).findById(any());
        }

        /**
         * Scenario: recipientsProvider valorizzato ma senza corrispondenza in implementationDAO;
         * resto nominale.
         * Oracolo atteso (O6): nessuna eccezione; recipientsProvider ignorato
         * (notification.setRecipientsProvider(...) mai invocato).
         */
        @Test
        @DisplayName("TF9: recipientsProvider senza corrispondenza -> ignorato, nessuna eccezione (O6)")
        void tf9_recipientsProviderNotFound() {
            // Arrange
            Notification notification = mockNotification();
            NotificationTO to = validNotificationTO();
            to.setRecipientsProvider("missing-provider");
            doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");
            doReturn(Optional.empty()).when(implementationDAO).findById("missing-provider");

            // Act
            assertDoesNotThrow(() -> binder.update(notification, to));

            // Assert
            verify(notification, never()).setRecipientsProvider(any());
        }

        /**
         * Scenario: recipientsProvider esplicitamente nullo; resto nominale.
         * Oracolo atteso (O6): nessuna eccezione; notification.setRecipientsProvider(null) invocato
         * esplicitamente (ramo distinto da "non risolvibile": qui implementationDAO non viene
         * nemmeno interrogato).
         */
        @Test
        @DisplayName("TF10: recipientsProvider esplicitamente nullo -> impostato a null (O6)")
        void tf10_recipientsProviderExplicitNull() {
            // Arrange
            Notification notification = mockNotification();
            NotificationTO to = validNotificationTO();
            doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");

            // Act
            assertDoesNotThrow(() -> binder.update(notification, to));

            // Assert
            verify(notification).setRecipientsProvider(null);
            verify(implementationDAO, never()).findById(any());
        }

        /**
         * Scenario: stato iniziale di notification.getAbouts() con un elemento per un AnyType non
         * presente in notificationTO.getAbouts() (vuota in questo test); resto nominale.
         * Oracolo atteso (O7, ipotesi iniziale): coerentemente con una semantica di sostituzione
         * completa, l'about non più presente nella TO viene rimosso dall'entità.
         */
        @Test
        @DisplayName("TF11: about iniziale non presente nella TO -> rimosso (O7, ipotesi da verificare)")
        void tf11_aboutRemovedWhenNotInTO() {
            // Arrange
            Notification notification = mockNotification();
            NotificationTO to = validNotificationTO(); // abouts vuota di default

            AnyType existingType = mock(AnyType.class);
            when(existingType.getKey()).thenReturn("OTHER_TYPE");
            AnyAbout existingAbout = mock(AnyAbout.class);
            when(existingAbout.getAnyType()).thenReturn(existingType);
            List<AnyAbout> abouts = new ArrayList<>(List.of(existingAbout));
            doReturn(abouts).when(notification).getAbouts();

            doReturn(Optional.of(mock(MailTemplate.class))).when(mailTemplateDAO).findById("mail-template-1");

            // Act
            assertDoesNotThrow(() -> binder.update(notification, to));

            // Assert: stessa istanza di lista passata al mock, mutata in place da removeIf(...)
            assertTrue(abouts.isEmpty());
        }
    }

    @Nested
    @DisplayName("getNotificationTO(Notification)")
    class GetNotificationTO {

        /**
         * Notification mockata con template, events e staticRecipients già validi (non nulli),
         * abouts vuota. Ogni test la specializza sovrascrivendo lo stub del campo sotto esame.
         */
        private static Notification mockValidNotification() {
            Notification notification = mock(Notification.class);
            MailTemplate template = mock(MailTemplate.class);
            lenient().when(template.getKey()).thenReturn("tmpl-1");
            lenient().when(notification.getTemplate()).thenReturn(template);
            lenient().when(notification.getEvents()).thenReturn(List.of("userCreate"));
            lenient().when(notification.getStaticRecipients()).thenReturn(List.of("user@example.com"));
            lenient().doReturn(List.<AnyAbout>of()).when(notification).getAbouts();
            return notification;
        }

        /**
         * Scenario: tutti i campi valorizzati coerentemente (template non nullo, events e
         * staticRecipients non vuote, abouts non vuota con AnyType non nullo, recipientsProvider
         * non nullo).
         * Oracolo atteso (O1): NotificationTO popolato fedelmente, nessuna eccezione.
         */
        @Test
        @DisplayName("TF1: scenario nominale, tutti i campi valorizzati -> mappatura fedele (O1)")
        void tf1_nominal() {
            // Arrange
            Notification notification = mockValidNotification();

            AnyType anyType = mock(AnyType.class);
            when(anyType.getKey()).thenReturn("USER");
            AnyAbout about = mock(AnyAbout.class);
            when(about.getAnyType()).thenReturn(anyType);
            when(about.get()).thenReturn("cond==true");
            doReturn(List.of(about)).when(notification).getAbouts();

            Implementation provider = mock(Implementation.class);
            when(provider.getKey()).thenReturn("provider-1");
            when(notification.getRecipientsProvider()).thenReturn(provider);

            // Act
            NotificationTO to = binder.getNotificationTO(notification);

            // Assert
            assertEquals("tmpl-1", to.getTemplate());
            assertEquals(List.of("userCreate"), to.getEvents());
            assertEquals(List.of("user@example.com"), to.getStaticRecipients());
            assertEquals(Map.of("USER", "cond==true"), to.getAbouts());
            assertEquals("provider-1", to.getRecipientsProvider());
        }

        /**
         * Scenario: notification.getTemplate() = null.
         * Oracolo atteso (O2, ipotesi iniziale): NullPointerException, poiche' il metodo chiama
         * .getKey() direttamente sul risultato di getTemplate() senza controllo di null.
         */
        @Test
        @DisplayName("TF2: notification.template nullo -> NullPointerException (O2)")
        void tf2_templateNull() {
            // Arrange
            Notification notification = mock(Notification.class);
            when(notification.getTemplate()).thenReturn(null);

            // Act & Assert
            assertThrows(NullPointerException.class, () -> binder.getNotificationTO(notification));
        }

        /**
         * Scenario: notification.getEvents() = null (template valido, per superare la riga precedente).
         * Oracolo atteso (O2, ipotesi iniziale): NullPointerException da addAll(null).
         */
        @Test
        @DisplayName("TF3: notification.events nullo -> NullPointerException (O2)")
        void tf3_eventsNull() {
            // Arrange
            Notification notification = mockValidNotification();
            when(notification.getEvents()).thenReturn(null);

            // Act & Assert
            assertThrows(NullPointerException.class, () -> binder.getNotificationTO(notification));
        }

        /**
         * Scenario: notification.getStaticRecipients() = null (template ed events validi).
         * Oracolo atteso (O2, ipotesi iniziale): NullPointerException da addAll(null).
         */
        @Test
        @DisplayName("TF4: notification.staticRecipients nullo -> NullPointerException (O2)")
        void tf4_staticRecipientsNull() {
            // Arrange
            Notification notification = mockValidNotification();
            when(notification.getStaticRecipients()).thenReturn(null);

            // Act & Assert
            assertThrows(NullPointerException.class, () -> binder.getNotificationTO(notification));
        }

        /**
         * Scenario: notification.getAbouts() con un elemento il cui AnyType è null (template,
         * events, staticRecipients validi).
         * Oracolo atteso (O2, ipotesi iniziale): NullPointerException da about.getAnyType().getKey().
         */
        @Test
        @DisplayName("TF5: about con AnyType nullo -> NullPointerException (O2)")
        void tf5_aboutAnyTypeNull() {
            // Arrange
            Notification notification = mockValidNotification();
            AnyAbout about = mock(AnyAbout.class);
            when(about.getAnyType()).thenReturn(null);
            doReturn(List.of(about)).when(notification).getAbouts();

            // Act & Assert
            assertThrows(NullPointerException.class, () -> binder.getNotificationTO(notification));
        }

        /**
         * Scenario: notification.getAbouts() vuota (template, events, staticRecipients validi).
         * Oracolo atteso (O3): notificationTO.getAbouts() vuota, nessuna eccezione.
         */
        @Test
        @DisplayName("TF6: abouts vuota -> NotificationTO.abouts vuota, nessuna eccezione (O3)")
        void tf6_aboutsEmpty() {
            // Arrange
            Notification notification = mockValidNotification();

            // Act
            NotificationTO to = binder.getNotificationTO(notification);

            // Assert
            assertTrue(to.getAbouts().isEmpty());
        }

        /**
         * Scenario: notification.getRecipientsProvider() = null (resto nominale).
         * Oracolo atteso (O4): notificationTO.getRecipientsProvider() resta null, nessuna eccezione
         * (unico campo con un ramo esplicito, distinto dalla copia diretta).
         */
        @Test
        @DisplayName("TF7: recipientsProvider nullo -> NotificationTO.recipientsProvider nullo (O4)")
        void tf7_recipientsProviderNull() {
            // Arrange
            Notification notification = mockValidNotification();

            // Act
            NotificationTO to = binder.getNotificationTO(notification);

            // Assert
            assertNull(to.getRecipientsProvider());
        }

        /**
         * Scenario: notification.getEvents() = lista vuota, non nulla (resto nominale).
         * Oracolo atteso (O5): notificationTO.getEvents() vuota, nessuna eccezione - distingue
         * l'esito da quello del campo sorgente nullo (TF3, O2).
         */
        @Test
        @DisplayName("TF8: events vuota (non nulla) -> NotificationTO.events vuota (O5)")
        void tf8_eventsEmptyNotNull() {
            // Arrange
            Notification notification = mockValidNotification();
            when(notification.getEvents()).thenReturn(List.of());

            // Act
            NotificationTO to = binder.getNotificationTO(notification);

            // Assert
            assertTrue(to.getEvents().isEmpty());
        }

        /**
         * Scenario: notification.getStaticRecipients() = lista vuota, non nulla (resto nominale).
         * Oracolo atteso (O5): notificationTO.getStaticRecipients() vuota, nessuna eccezione -
         * distingue l'esito da quello del campo sorgente nullo (TF4, O2).
         */
        @Test
        @DisplayName("TF9: staticRecipients vuota (non nulla) -> NotificationTO.staticRecipients vuota (O5)")
        void tf9_staticRecipientsEmptyNotNull() {
            // Arrange
            Notification notification = mockValidNotification();
            when(notification.getStaticRecipients()).thenReturn(List.of());

            // Act
            NotificationTO to = binder.getNotificationTO(notification);

            // Assert
            assertTrue(to.getStaticRecipients().isEmpty());
        }
    }
}