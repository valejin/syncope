package org.apache.syncope.core.provisioning.java.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.to.NotificationTO;
import org.apache.syncope.common.lib.types.AnyTypeKind;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificationDataBinderImplC1LLMZeroShotTest {

    private MailTemplateDAO mailTemplateDAO;

    private AnyTypeDAO anyTypeDAO;

    private ImplementationDAO implementationDAO;

    private EntityFactory entityFactory;

    private IntAttrNameParser intAttrNameParser;

    private NotificationDataBinderImpl binder;

    @BeforeEach
    void setUp() {
        mailTemplateDAO = mock(MailTemplateDAO.class);
        anyTypeDAO = mock(AnyTypeDAO.class);
        implementationDAO = mock(ImplementationDAO.class);
        entityFactory = mock(EntityFactory.class);
        intAttrNameParser = mock(IntAttrNameParser.class);

        binder = new NotificationDataBinderImpl(
                mailTemplateDAO,
                anyTypeDAO,
                implementationDAO,
                entityFactory,
                intAttrNameParser);
    }

    @Test
    void getNotificationTOReturnsCompleteTransferObject() {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        Implementation recipientsProvider = mock(Implementation.class);
        AnyType anyTypeUser = mock(AnyType.class);
        AnyType anyTypeGroup = mock(AnyType.class);
        AnyAbout aboutUser = mock(AnyAbout.class);
        AnyAbout aboutGroup = mock(AnyAbout.class);

        when(notification.getKey()).thenReturn("notification-key");
        when(notification.getEvents()).thenReturn(new ArrayList<>(List.of("CUSTOM_EVENT", "USER_CREATE")));
        when(notification.isSelfAsRecipient()).thenReturn(true);
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>(List.of("one@example.com", "two@example.com")));
        when(notification.getRecipientAttrName()).thenReturn("email");
        when(notification.getRecipientsFIQL()).thenReturn("username==alice");
        when(notification.getRecipientsProvider()).thenReturn(recipientsProvider);
        when(recipientsProvider.getKey()).thenReturn("recipient-provider-key");
        when(notification.getSender()).thenReturn("sender@example.com");
        when(notification.getSubject()).thenReturn("Welcome");
        when(notification.getTemplate()).thenReturn(template);
        when(template.getKey()).thenReturn("mail-template-key");
        when(notification.getTraceLevel()).thenReturn(TraceLevel.ALL);
        when(notification.isActive()).thenReturn(true);

        when(anyTypeUser.getKey()).thenReturn(AnyTypeKind.USER.name());
        when(anyTypeGroup.getKey()).thenReturn(AnyTypeKind.GROUP.name());
        when(aboutUser.getAnyType()).thenReturn(anyTypeUser);
        when(aboutUser.get()).thenReturn("username==alice");
        when(aboutGroup.getAnyType()).thenReturn(anyTypeGroup);
        when(aboutGroup.get()).thenReturn("name==managers");
        // FIX (a): List<? extends AnyAbout> a bound wildcard, when().thenReturn() non compila
        // con un ArrayList costruito da elementi concreti -> doReturn().when().
        doReturn(new ArrayList<>(List.of(aboutUser, aboutGroup))).when(notification).getAbouts();

        NotificationTO actual = binder.getNotificationTO(notification);

        assertNotNull(actual);
        assertEquals("notification-key", actual.getKey());
        assertEquals(List.of("CUSTOM_EVENT", "USER_CREATE"), actual.getEvents());
        assertTrue(actual.isSelfAsRecipient());
        assertEquals(List.of("one@example.com", "two@example.com"), actual.getStaticRecipients());
        assertEquals("email", actual.getRecipientAttrName());
        assertEquals("username==alice", actual.getRecipientsFIQL());
        assertEquals("recipient-provider-key", actual.getRecipientsProvider());
        assertEquals("sender@example.com", actual.getSender());
        assertEquals("Welcome", actual.getSubject());
        assertEquals("mail-template-key", actual.getTemplate());
        assertEquals(TraceLevel.ALL, actual.getTraceLevel());
        assertTrue(actual.isActive());
        assertEquals("username==alice", actual.getAbouts().get(AnyTypeKind.USER.name()));
        assertEquals("name==managers", actual.getAbouts().get(AnyTypeKind.GROUP.name()));
    }

    // FIX (e): il file grezzo assumeva che template == null producesse un NotificationTO
    // con template == null, senza eccezione. Il sorgente reale fa
    // notification.getTemplate().getKey() senza null-check: NullPointerException.
    // Stesso identico finding già documentato per C0 via Randoop (vedi
    // Randoop_Resoconto_Report.md, "getNotificationTO() con Notification mockato nudo").
    @Test
    void getNotificationTOThrowsNPEWhenTemplateIsNull() {
        Notification notification = mock(Notification.class);
        when(notification.getTemplate()).thenReturn(null);

        assertThrows(NullPointerException.class, () -> binder.getNotificationTO(notification));
    }

    // Riscritto per non dipendere da template == null (che ora è coperto a parte,
    // vedi sopra): verifica il resto delle associazioni opzionali/vuote con un
    // template valido, cosi' da arrivare davvero in fondo al metodo.
    @Test
    void getNotificationTOHandlesEmptyCollectionsAndNullRecipientsProvider() {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        when(template.getKey()).thenReturn("mail-template-key");

        when(notification.getKey()).thenReturn("notification-key");
        when(notification.getTemplate()).thenReturn(template);
        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        doReturn(new ArrayList<>()).when(notification).getAbouts();
        when(notification.getRecipientsProvider()).thenReturn(null);
        when(notification.getTraceLevel()).thenReturn(TraceLevel.FAILURES);

        NotificationTO actual = binder.getNotificationTO(notification);

        assertEquals("notification-key", actual.getKey());
        assertEquals("mail-template-key", actual.getTemplate());
        assertNull(actual.getRecipientsProvider());
        assertEquals(TraceLevel.FAILURES, actual.getTraceLevel());
        assertTrue(actual.getEvents().isEmpty());
        assertTrue(actual.getStaticRecipients().isEmpty());
        assertTrue(actual.getAbouts().isEmpty());
    }

    // FIX: il file grezzo pre-costruiva userAbout/groupAbout e assumeva che
    // entityFactory.newEntity(...) li restituisse nello stesso ordine in cui
    // notificationTO.getAbouts() (una Map) viene iterata - non garantito da una Map
    // generica. Quando l'ordine di iterazione e' invertito, l'about sbagliato riceve
    // il tipo sbagliato, e i verify() legati a un'identita' fissa (userAbout/groupAbout)
    // falliscono per mismatch di argomenti, anche se il comportamento della classe e'
    // corretto. Riscritto con mock "auto-consistenti" (getAnyType() rispecchia sempre
    // l'ultimo setAnyType() ricevuto) e verifiche per contenuto, non per posizione.
    @Test
    void updateCopiesTransferObjectValuesAndResolvesReferences() throws Exception {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        Implementation recipientsProvider = mock(Implementation.class);
        AnyType userType = mock(AnyType.class);
        AnyType groupType = mock(AnyType.class);

        List<String> notificationEvents = new ArrayList<>(List.of("OLD_EVENT"));
        List<String> notificationStaticRecipients = new ArrayList<>(List.of("old@example.com"));
        List<AnyAbout> notificationAbouts = new ArrayList<>();
        List<AnyAbout> createdAbouts = new ArrayList<>();

        when(notification.getEvents()).thenReturn(notificationEvents);
        when(notification.getStaticRecipients()).thenReturn(notificationStaticRecipients);
        when(notification.getRecipientAttrName()).thenReturn("email");
        doReturn(notificationAbouts).when(notification).getAbouts();
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("template-key");
        doReturn(Optional.of(recipientsProvider)).when(implementationDAO).findById("provider-key");
        doReturn(Optional.of(userType)).when(anyTypeDAO).findById(AnyTypeKind.USER.name());
        doReturn(Optional.of(groupType)).when(anyTypeDAO).findById(AnyTypeKind.GROUP.name());
        // FIX: perso nella riscrittura precedente. removeIf (passo 2 di update()) valuta
        // anyAbout.getAnyType().getKey() per decidere se mantenere l'about - senza questi
        // stub userType.getKey()/groupType.getKey() ritornano null, null non e' una chiave
        // presente in notificationTO.getAbouts() ("USER"/"GROUP") -> removeIf rimuove
        // entrambi gli about appena creati (size 0 invece di 2).
        when(userType.getKey()).thenReturn(AnyTypeKind.USER.name());
        when(groupType.getKey()).thenReturn(AnyTypeKind.GROUP.name());
        doAnswer(invocation -> {
            AnyAbout about = mock(AnyAbout.class);
            doAnswer(setTypeInvocation -> {
                doReturn(setTypeInvocation.getArgument(0)).when(about).getAnyType();
                return null;
            }).when(about).setAnyType(any());
            createdAbouts.add(about);
            return about;
        }).when(entityFactory).newEntity(AnyAbout.class);
        // FIX (b): notification e' un mock nudo, notification.add(about) di default e' un
        // no-op e non muta notificationAbouts. Senza questo stub l'assertEquals(2, ...)
        // sotto fallirebbe (size() resterebbe 0) nonostante la logica reale della classe
        // sia corretta - stesso bug gia' documentato per il batch ToT su C0
        // (Resoconto_NotificationDataBinderImpl_JaCoCo_PIT.md).
        doAnswer(invocation -> {
            AnyAbout about = invocation.getArgument(0);
            notificationAbouts.add(about);
            return null;
        }).when(notification).add(any(AnyAbout.class));

        NotificationTO notificationTO = new NotificationTO();
        notificationTO.getEvents().add("USER_CREATE");
        notificationTO.getEvents().add("USER_UPDATE");
        notificationTO.setSelfAsRecipient(true);
        notificationTO.getStaticRecipients().add("alice@example.com");
        notificationTO.getStaticRecipients().add("bob@example.com");
        notificationTO.setRecipientAttrName("email");
        notificationTO.setRecipientsFIQL("username==alice");
        notificationTO.setRecipientsProvider("provider-key");
        notificationTO.getAbouts().put(AnyTypeKind.USER.name(), "username==alice");
        notificationTO.getAbouts().put(AnyTypeKind.GROUP.name(), "name==managers");
        notificationTO.setSender("sender@example.com");
        notificationTO.setSubject("Subject");
        notificationTO.setTemplate("template-key");
        notificationTO.setTraceLevel(TraceLevel.ALL);
        notificationTO.setActive(false);

        binder.update(notification, notificationTO);

        assertEquals(List.of("USER_CREATE", "USER_UPDATE"), notificationEvents);
        assertEquals(List.of("alice@example.com", "bob@example.com"), notificationStaticRecipients);
        assertEquals(2, notificationAbouts.size());
        assertEquals(2, createdAbouts.size());

        AnyAbout aboutForUser = createdAbouts.stream()
                .filter(a -> a.getAnyType() == userType).findFirst().orElseThrow();
        AnyAbout aboutForGroup = createdAbouts.stream()
                .filter(a -> a.getAnyType() == groupType).findFirst().orElseThrow();

        verify(intAttrNameParser).parse("email", AnyTypeKind.USER);
        verify(notification).setSelfAsRecipient(true);
        verify(notification).setRecipientAttrName("email");
        verify(notification).setRecipientsFIQL("username==alice");
        verify(notification).setRecipientsProvider(recipientsProvider);
        verify(notification).setSender("sender@example.com");
        verify(notification).setSubject("Subject");
        verify(notification).setTemplate(template);
        verify(notification).setTraceLevel(TraceLevel.ALL);
        verify(notification).setActive(false);

        verify(aboutForUser).setNotification(notification);
        verify(aboutForUser).set("username==alice");
        verify(aboutForGroup).setNotification(notification);
        verify(aboutForGroup).set("name==managers");
        verify(notification).add(aboutForUser);
        verify(notification).add(aboutForGroup);
    }

    // FIX (d), riscritto: il file grezzo assumeva un controllo esplicito su stringa
    // blank per recipientsProvider, inesistente nel sorgente (il controllo reale e'
    // "== null", non blank/isBlank). Con notificationTO minimale (solo
    // recipientsProvider + traceLevel), template ed events mancanti fanno scattare
    // RequiredValuesMissing PRIMA di arrivare al blocco recipientsProvider - quindi
    // servono anche template/events validi per raggiungere davvero il ramo sotto
    // test. Comportamento reale verificato: "   " (non null) fa comunque chiamare
    // implementationDAO.findById(...); se non trovato, il provider resta non
    // impostato (nessuna eccezione).
    @Test
    void updateCallsRecipientsProviderDaoAndLeavesItUnsetWhenProviderIsBlankAndNotFound() throws Exception {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        doReturn(new ArrayList<>()).when(notification).getAbouts();
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("template-key");

        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("template-key");
        notificationTO.getEvents().add("USER_CREATE");
        notificationTO.setRecipientsProvider("   ");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        binder.update(notification, notificationTO);

        verify(implementationDAO).findById("   ");
        verify(notification, never()).setRecipientsProvider(any());
    }

    // FIX (d), riscritto: stessa causa del caso precedente. Il sorgente non ha
    // alcuna guardia sul template, ne' null ne' blank: mailTemplateDAO.findById(...)
    // viene sempre chiamato. Con una chiave blank non stubbata, la risoluzione
    // fallisce (Optional.empty()) e la validazione lancia RequiredValuesMissing.
    @Test
    void updateThrowsClientExceptionWhenTemplateIsBlank() {
        Notification notification = mock(Notification.class);
        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());

        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("");
        notificationTO.getEvents().add("USER_CREATE");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
        verify(mailTemplateDAO).findById("");
    }

    @Test
    void updateThrowsClientExceptionWhenTemplateDoesNotExist() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("missing-template");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        when(mailTemplateDAO.findById("missing-template")).thenReturn(Optional.empty());

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
    }

    // FIX: come i due test blank sopra, mancava un template valido -> throw
    // immediato prima di raggiungere la logica sotto test, e in piu' l'assunzione
    // stessa era sbagliata: un recipientsProvider non trovato NON lancia
    // un'eccezione, viene ignorato silenziosamente (LOG.debug) - stesso identico
    // comportamento gia' verificato sopra per il caso "blank" (duplicato genuino,
    // valore diverso in input, mantenuto per la policy di non scartare per sola
    // ridondanza).
    @Test
    void updateLeavesRecipientsProviderUnsetWhenItDoesNotExist() {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("template-key");
        notificationTO.getEvents().add("USER_CREATE");
        notificationTO.setRecipientsProvider("missing-provider");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        doReturn(new ArrayList<>()).when(notification).getAbouts();
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("template-key");
        when(implementationDAO.findById("missing-provider")).thenReturn(Optional.empty());

        binder.update(notification, notificationTO);

        verify(implementationDAO).findById("missing-provider");
        verify(notification, never()).setRecipientsProvider(any());
    }

    // FIX: stessa causa - mancava template valido. In piu', l'assunzione era
    // sbagliata: un AnyType non risolvibile per un about viene ignorato
    // silenziosamente (LOG.debug "Invalid AnyType..."), non genera eccezione.
    @Test
    void updateIgnoresAboutEntryWhenAnyTypeDoesNotExist() {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("template-key");
        notificationTO.getEvents().add("USER_CREATE");
        notificationTO.getAbouts().put("MISSING", "name==anything");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        doReturn(new ArrayList<>()).when(notification).getAbouts();
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("template-key");
        when(anyTypeDAO.findById("MISSING")).thenReturn(Optional.empty());

        binder.update(notification, notificationTO);

        verify(anyTypeDAO).findById("MISSING");
        verify(entityFactory, never()).newEntity(AnyAbout.class);
        verify(notification, never()).add(any());
    }

    // FIX: mancava template valido -> throw immediato prima di raggiungere
    // intAttrNameParser.parse(...). L'assunzione sull'eccezione era invece corretta
    // (il sorgente rilancia davvero SyncopeClientException su ParseException).
    @Test
    void updateWrapsParseExceptionRaisedForRecipientAttributeName() throws Exception {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("template-key");
        notificationTO.getEvents().add("USER_CREATE");
        notificationTO.setRecipientAttrName("invalid.attr");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        doReturn(new ArrayList<>()).when(notification).getAbouts();
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("template-key");
        // FIX: mancava lo stub di notification.getRecipientAttrName() — il sorgente
        // legge il valore dal parametro notification (mock), non dalla notificationTO
        // passata; senza questo stub la chiamata reale e' parse(null, USER), diversa
        // da quella stubbata sotto -> PotentialStubbingProblem in strict mode.
        when(notification.getRecipientAttrName()).thenReturn("invalid.attr");
        when(intAttrNameParser.parse(eq("invalid.attr"), eq(AnyTypeKind.USER)))
                .thenThrow(new ParseException("invalid", 0));

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
    }

    // FIX: mancava template valido. In piu', l'assunzione "never() parse" era
    // sbagliata - il sorgente chiama intAttrNameParser.parse(...) incondizionatamente,
    // anche con recipientAttrName == null, nessun null-check locale.
    @Test
    void updateParsesNullRecipientAttributeNameWithoutThrowing() throws Exception {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("template-key");
        notificationTO.getEvents().add("USER_CREATE");
        notificationTO.setRecipientAttrName(null);
        notificationTO.setTraceLevel(TraceLevel.NONE);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        doReturn(new ArrayList<>()).when(notification).getAbouts();
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("template-key");

        binder.update(notification, notificationTO);

        verify(intAttrNameParser).parse(null, AnyTypeKind.USER);
        verify(notification).setRecipientAttrName(null);
        verify(notification).setTraceLevel(TraceLevel.NONE);
    }

    @Test
    void updateReplacesExistingCollectionsWithTransferObjectCollections() {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        List<String> events = new ArrayList<>(List.of("OLD_ONE", "OLD_TWO"));
        List<String> staticRecipients = new ArrayList<>(List.of("old1@example.com", "old2@example.com"));

        AnyType existingAboutType = mock(AnyType.class);
        when(existingAboutType.getKey()).thenReturn("EXISTING");
        AnyAbout existingAbout = mock(AnyAbout.class);
        when(existingAbout.getAnyType()).thenReturn(existingAboutType);
        List<AnyAbout> abouts = new ArrayList<>(List.of(existingAbout));

        when(notification.getEvents()).thenReturn(events);
        when(notification.getStaticRecipients()).thenReturn(staticRecipients);
        doReturn(abouts).when(notification).getAbouts();
        // FIX: mancava template valido -> RequiredValuesMissing[template] immediato.
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("template-key");

        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("template-key");
        notificationTO.getEvents().add("NEW_EVENT");
        notificationTO.getStaticRecipients().add("new@example.com");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);
        notificationTO.setActive(true);

        binder.update(notification, notificationTO);

        assertEquals(List.of("NEW_EVENT"), events);
        assertEquals(List.of("new@example.com"), staticRecipients);
        assertTrue(abouts.isEmpty());
        verify(notification).setActive(true);
        verify(notification).setTraceLevel(TraceLevel.FAILURES);
    }
}