package org.apache.syncope.core.provisioning.java.data.c1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.syncope.common.lib.SyncopeClientException;
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
import org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificationDataBinderImplC1LLMToTTest {

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

    private NotificationDataBinderImpl binder;

    @BeforeEach
    void setUp() {
        binder = new NotificationDataBinderImpl(
                mailTemplateDAO,
                anyTypeDAO,
                implementationDAO,
                entityFactory,
                intAttrNameParser);
    }

    // Helper che stubba notification con liste persistenti reali per
    // getEvents()/getStaticRecipients()/getAbouts(). Senza questo, ogni chiamata a un
    // metodo non stubbato che ritorna una List da' una nuova lista vuota ad ogni
    // invocazione (non la stessa istanza) - clear()+addAll() scriverebbero su un'istanza
    // e isEmpty() ne leggerebbe un'altra, sempre vuota: ogni update() lancerebbe
    // RequiredValuesMissing[events] a prescindere da cosa il test vuole verificare.
    // FIX: helper condiviso usato in scenari diversi - alcuni test (es.
    // updateThrowsWhenTemplateDoesNotExist) escono con throw prima di arrivare alla
    // logica sugli abouts, quindi lo stub su getAbouts() risulterebbe "non usato" in
    // quei casi specifici -> UnnecessaryStubbingException in strict mode. Stesso
    // pattern gia' catalogato nel progetto (UnnecessaryStubbingException su chiamate
    // dentro lambda/branch non sempre raggiunti), stessa correzione: lenient().
    private static void stubMutableCollections(Notification notification) {
        org.mockito.Mockito.lenient().when(notification.getEvents()).thenReturn(new ArrayList<>());
        org.mockito.Mockito.lenient().when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        org.mockito.Mockito.lenient().doReturn(new ArrayList<>()).when(notification).getAbouts();
    }

    @Test
    @DisplayName("Expert A: update copies a valid transfer object into the notification entity")
    void updateCopiesBasicFieldsFromTransferObject() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        stubMutableCollections(notification);

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("welcomeTemplate");

        binder.update(notification, notificationTO);

        verify(notification).setTemplate(template);
        verify(notification).setRecipientsFIQL("username==alice");
        verify(notification).setSelfAsRecipient(true);
        verify(notification).setRecipientAttrName("email");
        verify(notification).setSender("noreply@example.org");
        verify(notification).setSubject("Welcome");
        verify(notification).setTraceLevel(TraceLevel.ALL);
        verify(notification).setActive(true);
    }

    @Test
    @DisplayName("Expert B: getNotificationTO maps a notification entity into a transfer object")
    void getNotificationTOCopiesBasicFieldsFromEntity() {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);

        when(notification.getKey()).thenReturn("notification-key");
        when(notification.getTemplate()).thenReturn(template);
        when(template.getKey()).thenReturn("welcomeTemplate");
        when(notification.getRecipientsFIQL()).thenReturn("username==alice");
        when(notification.isSelfAsRecipient()).thenReturn(true);
        when(notification.getRecipientAttrName()).thenReturn("email");
        when(notification.getSender()).thenReturn("noreply@example.org");
        when(notification.getSubject()).thenReturn("Welcome");
        when(notification.getTraceLevel()).thenReturn(TraceLevel.ALL);
        when(notification.isActive()).thenReturn(true);

        NotificationTO actual = binder.getNotificationTO(notification);

        assertEquals("notification-key", actual.getKey());
        assertEquals("welcomeTemplate", actual.getTemplate());
        assertEquals("username==alice", actual.getRecipientsFIQL());
        assertTrue(actual.isSelfAsRecipient());
        assertEquals("email", actual.getRecipientAttrName());
        assertEquals("noreply@example.org", actual.getSender());
        assertEquals("Welcome", actual.getSubject());
        assertEquals(TraceLevel.ALL, actual.getTraceLevel());
        assertTrue(actual.isActive());
    }

    // FIX: notification.setTemplate(template) e' incondizionato nel sorgente reale,
    // eseguito subito dopo il controllo null e PRIMA del throw finale - viene quindi
    // chiamato comunque, con null. never() era sbagliato.
    @Test
    @DisplayName("Expert C: update rejects a missing template reference")
    void updateThrowsWhenTemplateDoesNotExist() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        stubMutableCollections(notification);

        when(mailTemplateDAO.findById("welcomeTemplate")).thenReturn(Optional.empty());

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
        verify(notification).setTemplate(null);
    }

    @Test
    @DisplayName("Edge case: update clears optional recipients provider when TO does not specify one")
    void updateClearsRecipientsProviderWhenMissing() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.setRecipientsProvider(null);
        stubMutableCollections(notification);

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("welcomeTemplate");

        binder.update(notification, notificationTO);

        verify(notification).setRecipientsProvider(null);
        verify(implementationDAO, never()).findById(anyString());
    }

    // FIX: rimossi gli stub su Implementation.getType()/ImplementationType - il sorgente
    // reale non chiama mai getType(), accetta qualunque Implementation trovato dal DAO
    // incondizionatamente.
    @Test
    @DisplayName("Edge case: update applies a valid recipients provider implementation")
    void updateSetsValidRecipientsProvider() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.setRecipientsProvider("recipientsProviderKey");
        stubMutableCollections(notification);

        MailTemplate template = mock(MailTemplate.class);
        Implementation recipientsProvider = mock(Implementation.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("welcomeTemplate");
        doReturn(Optional.of(recipientsProvider)).when(implementationDAO).findById("recipientsProviderKey");

        binder.update(notification, notificationTO);

        verify(notification).setRecipientsProvider(recipientsProvider);
    }

    // RIMOSSO: "updateThrowsWhenRecipientsProviderHasWrongType" testava una validazione
    // di tipo (ImplementationType) inesistente nel sorgente reale - nessun controllo di
    // tipo viene mai eseguito su recipientsProvider. Nessun comportamento reale
    // equivalente a cui riscriverlo; allucinazione pura, non un bug del test.

    // FIX: riscritto. Il sorgente non valida mai recipientsFIQL (copia diretta, nessun
    // controllo blank/null) - il test originale assumeva una validazione inesistente.
    @Test
    @DisplayName("Edge case: update accepts a blank recipientsFIQL without validation")
    void updateAcceptsBlankRecipientsFIQL() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.setRecipientsFIQL(" ");
        stubMutableCollections(notification);

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("welcomeTemplate");

        binder.update(notification, notificationTO);

        verify(notification).setRecipientsFIQL(" ");
    }

    @Test
    @DisplayName("Edge case: update ignores about clauses targeting unknown AnyType values")
    void updateIgnoresAboutClauseForUnknownAnyType() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.getAbouts().put("USER", "username==alice");
        stubMutableCollections(notification);

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("welcomeTemplate");
        when(anyTypeDAO.findById("USER")).thenReturn(Optional.empty());

        binder.update(notification, notificationTO);

        verify(entityFactory, never()).newEntity(AnyAbout.class);
    }

    // FIX: verify(anyAbout).set(eq(notification)) confondeva set(String) con
    // setNotification(Notification) - due metodi distinti nel sorgente reale
    // (about.setNotification(notification); ... about.set(entry.getValue());).
    @Test
    @DisplayName("Edge case: update creates an AnyAbout entity for a known AnyType")
    void updateCreatesAnyAboutForKnownAnyType() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.getAbouts().put("USER", "username==alice");
        stubMutableCollections(notification);

        MailTemplate template = mock(MailTemplate.class);
        AnyType anyType = mock(AnyType.class);
        AnyAbout anyAbout = mock(AnyAbout.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("welcomeTemplate");
        doReturn(Optional.of(anyType)).when(anyTypeDAO).findById("USER");
        when(entityFactory.newEntity(AnyAbout.class)).thenReturn(anyAbout);

        binder.update(notification, notificationTO);

        verify(anyAbout).setAnyType(anyType);
        verify(anyAbout).setNotification(notification);
        verify(anyAbout).set("username==alice");
        verify(notification).add(anyAbout);
    }

    @Test
    @DisplayName("Exception scenario: getNotificationTO propagates NullPointerException for null input")
    void getNotificationTOThrowsWhenNotificationIsNull() {
        assertThrows(NullPointerException.class, () -> binder.getNotificationTO(null));
    }

    // FIX: il file grezzo assumeva che template == null producesse un NotificationTO con
    // template == null, senza eccezione. Il sorgente reale fa
    // notification.getTemplate().getKey() senza null-check: NullPointerException. Stesso
    // identico finding gia' documentato per C0 via Randoop e riscontrato anche nel batch
    // Zero-shot di C1 - terza conferma indipendente, buon segnale di convergenza.
    @Test
    @DisplayName("Exception scenario: getNotificationTO throws NullPointerException when template is null")
    void getNotificationTOThrowsWhenTemplateIsNull() {
        Notification notification = mock(Notification.class);
        when(notification.getTemplate()).thenReturn(null);

        assertThrows(NullPointerException.class, () -> binder.getNotificationTO(notification));
    }

    // Riscritto per non dipendere da template == null (coperto a parte sopra): verifica
    // il resto delle associazioni opzionali con un template valido, cosi' da arrivare
    // davvero in fondo al metodo.
    @Test
    @DisplayName("Edge case: getNotificationTO handles a notification without recipients provider")
    void getNotificationTOAllowsNullRecipientsProvider() {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        when(template.getKey()).thenReturn("welcomeTemplate");

        when(notification.getKey()).thenReturn("notification-key");
        when(notification.getTemplate()).thenReturn(template);
        when(notification.getRecipientsProvider()).thenReturn(null);

        NotificationTO actual = binder.getNotificationTO(notification);

        assertNotNull(actual);
        assertEquals("notification-key", actual.getKey());
        assertEquals("welcomeTemplate", actual.getTemplate());
        assertNull(actual.getRecipientsProvider());
        assertFalse(actual.isSelfAsRecipient());
    }

    // FIX: mancava un evento in TO - senza questo, notification.getEvents() (stubbato a
    // lista persistente vuota) resta vuoto dopo l'addAll, e OGNI update() basato su
    // questo helper lancerebbe RequiredValuesMissing[events] a prescindere da cosa il
    // test sta verificando.
    private static NotificationTO baseNotificationTO() {
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("welcomeTemplate");
        notificationTO.getEvents().add("USER_CREATE");
        notificationTO.setRecipientsFIQL("username==alice");
        notificationTO.setSelfAsRecipient(true);
        notificationTO.setRecipientAttrName("email");
        notificationTO.setSender("noreply@example.org");
        notificationTO.setSubject("Welcome");
        notificationTO.setTraceLevel(TraceLevel.ALL);
        notificationTO.setActive(true);
        return notificationTO;
    }
}