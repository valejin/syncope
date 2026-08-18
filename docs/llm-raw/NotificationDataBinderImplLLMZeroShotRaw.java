package org.apache.syncope.core.provisioning.java.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
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

class NotificationDataBinderImplTest {

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
    void getNotificationTOCopiesAllNotificationFields() {
        Notification notification = mock(Notification.class);

        MailTemplate template = mock(MailTemplate.class);
        when(template.getKey()).thenReturn("welcomeTemplate");

        Implementation recipientsProvider = mock(Implementation.class);
        when(recipientsProvider.getKey()).thenReturn("recipientsProviderImpl");

        AnyType userType = mock(AnyType.class);
        when(userType.getKey()).thenReturn("USER");

        AnyAbout about = mock(AnyAbout.class);
        when(about.getAnyType()).thenReturn(userType);
        when(about.get()).thenReturn("username==john");

        Set<String> events = new LinkedHashSet<>();
        events.add("event1");
        events.add("event2");

        Set<String> staticRecipients = new LinkedHashSet<>();
        staticRecipients.add("admin@example.com");
        staticRecipients.add("audit@example.com");

        Set<AnyAbout> abouts = new LinkedHashSet<>();
        abouts.add(about);

        when(notification.getKey()).thenReturn("notificationKey");
        when(notification.getTemplate()).thenReturn(template);
        when(notification.getEvents()).thenReturn(events);
        when(notification.getRecipientsFIQL()).thenReturn("username==john");
        when(notification.getStaticRecipients()).thenReturn(staticRecipients);
        when(notification.getRecipientAttrName()).thenReturn("email");
        when(notification.isSelfAsRecipient()).thenReturn(true);
        when(notification.getSender()).thenReturn("sender@example.com");
        when(notification.getSubject()).thenReturn("Subject");
        when(notification.getTraceLevel()).thenReturn(TraceLevel.ALL);
        when(notification.isActive()).thenReturn(true);
        when(notification.getAbouts()).thenReturn(abouts);
        when(notification.getRecipientsProvider()).thenReturn(recipientsProvider);

        NotificationTO actual = binder.getNotificationTO(notification);

        assertEquals("notificationKey", actual.getKey());
        assertEquals("welcomeTemplate", actual.getTemplate());
        assertEquals(events, actual.getEvents());
        assertEquals("username==john", actual.getRecipientsFIQL());
        assertEquals(staticRecipients, actual.getStaticRecipients());
        assertEquals("email", actual.getRecipientAttrName());
        assertTrue(actual.isSelfAsRecipient());
        assertEquals("sender@example.com", actual.getSender());
        assertEquals("Subject", actual.getSubject());
        assertEquals(TraceLevel.ALL, actual.getTraceLevel());
        assertTrue(actual.isActive());
        assertEquals("username==john", actual.getAbouts().get("USER"));
        assertEquals("recipientsProviderImpl", actual.getRecipientsProvider());
    }

    @Test
    void getNotificationTODoesNotSetRecipientsProviderWhenMissing() {
        Notification notification = mock(Notification.class);

        MailTemplate template = mock(MailTemplate.class);
        when(template.getKey()).thenReturn("template");

        when(notification.getKey()).thenReturn("notification");
        when(notification.getTemplate()).thenReturn(template);
        when(notification.getEvents()).thenReturn(new LinkedHashSet<>());
        when(notification.getRecipientsFIQL()).thenReturn(null);
        when(notification.getStaticRecipients()).thenReturn(new LinkedHashSet<>());
        when(notification.getRecipientAttrName()).thenReturn("email");
        when(notification.isSelfAsRecipient()).thenReturn(false);
        when(notification.getSender()).thenReturn("sender@example.com");
        when(notification.getSubject()).thenReturn("subject");
        when(notification.getTraceLevel()).thenReturn(TraceLevel.FAILURES);
        when(notification.isActive()).thenReturn(false);
        when(notification.getAbouts()).thenReturn(new LinkedHashSet<>());
        when(notification.getRecipientsProvider()).thenReturn(null);

        NotificationTO actual = binder.getNotificationTO(notification);

        assertNull(actual.getRecipientsProvider());
    }

    @Test
    void updateCopiesFieldsValidatesAndCreatesUpdatesAndRemovesAbouts() throws Exception {
        NotificationState state = notificationState();
        Notification notification = state.notification;

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("template")).thenReturn(Optional.of(template));

        Implementation recipientsProvider = mock(Implementation.class);
        when(implementationDAO.findById("recipientsProvider")).thenReturn(Optional.of(recipientsProvider));

        AnyType userType = anyType("USER");
        AnyType groupType = anyType("GROUP");
        AnyType anyObjectType = anyType("ANY_OBJECT");

        AnyAbout existingUserAbout = about(userType, "old-user-fiql");
        AnyAbout removedGroupAbout = about(groupType, "old-group-fiql");
        state.abouts.add(existingUserAbout);
        state.abouts.add(removedGroupAbout);

        AnyAbout newAnyObjectAbout = about(null, null);
        when(entityFactory.newEntity(AnyAbout.class)).thenReturn(newAnyObjectAbout);

        when(anyTypeDAO.findById("USER")).thenReturn(Optional.of(userType));
        when(anyTypeDAO.findById("ANY_OBJECT")).thenReturn(Optional.of(anyObjectType));

        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("template");
        notificationTO.getEvents().add("event1");
        notificationTO.getEvents().add("event2");
        notificationTO.setRecipientsFIQL("username==john");
        notificationTO.getStaticRecipients().add("admin@example.com");
        notificationTO.setRecipientAttrName("email");
        notificationTO.setSelfAsRecipient(true);
        notificationTO.setSender("sender@example.com");
        notificationTO.setSubject("subject");
        notificationTO.setTraceLevel(TraceLevel.ALL);
        notificationTO.setActive(true);
        notificationTO.getAbouts().put("USER", "username==john");
        notificationTO.getAbouts().put("ANY_OBJECT", "name==printer");
        notificationTO.setRecipientsProvider("recipientsProvider");

        binder.update(notification, notificationTO);

        assertEquals("username==john", state.recipientsFIQL);
        assertEquals(Set.of("admin@example.com"), state.staticRecipients);
        assertEquals("email", state.recipientAttrName);
        assertTrue(state.selfAsRecipient);
        assertEquals("sender@example.com", state.sender);
        assertEquals("subject", state.subject);
        assertEquals(TraceLevel.ALL, state.traceLevel);
        assertTrue(state.active);
        assertEquals(Set.of("event1", "event2"), state.events);
        assertSame(template, state.template);
        assertSame(recipientsProvider, state.recipientsProvider);

        assertEquals(2, state.abouts.size());
        assertTrue(state.abouts.contains(existingUserAbout));
        assertTrue(state.abouts.contains(newAnyObjectAbout));
        assertEquals("username==john", existingUserAbout.get());
        assertEquals("name==printer", newAnyObjectAbout.get());
        assertEquals("ANY_OBJECT", newAnyObjectAbout.getAnyType().getKey());

        verify(intAttrNameParser).parse("email", AnyTypeKind.USER);
    }

    @Test
    void updateIgnoresBlankAboutValuesAndInvalidAnyTypes() throws Exception {
        NotificationState state = notificationState();
        Notification notification = state.notification;

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("template")).thenReturn(Optional.of(template));

        AnyType userType = anyType("USER");
        AnyAbout existingUserAbout = about(userType, "old-user-fiql");
        state.abouts.add(existingUserAbout);

        when(anyTypeDAO.findById("UNKNOWN")).thenReturn(Optional.empty());

        NotificationTO notificationTO = minimumValidNotificationTO();
        notificationTO.getAbouts().put("USER", " ");
        notificationTO.getAbouts().put("UNKNOWN", "name==ignored");

        binder.update(notification, notificationTO);

        assertTrue(state.abouts.isEmpty(), "Existing abouts not present as valid non-blank TO abouts should be removed");
        verify(intAttrNameParser).parse("email", AnyTypeKind.USER);
    }

    @Test
    void updateClearsRecipientsProviderWhenTransferObjectProviderIsNull() throws Exception {
        NotificationState state = notificationState();
        Notification notification = state.notification;
        state.recipientsProvider = mock(Implementation.class);

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("template")).thenReturn(Optional.of(template));

        NotificationTO notificationTO = minimumValidNotificationTO();
        notificationTO.setRecipientsProvider(null);

        binder.update(notification, notificationTO);

        assertNull(state.recipientsProvider);
        verify(intAttrNameParser).parse("email", AnyTypeKind.USER);
    }

    @Test
    void updateIgnoresInvalidRecipientsProviderKeepingExistingProvider() throws Exception {
        NotificationState state = notificationState();
        Notification notification = state.notification;

        Implementation existingProvider = mock(Implementation.class);
        state.recipientsProvider = existingProvider;

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("template")).thenReturn(Optional.of(template));
        when(implementationDAO.findById("missingProvider")).thenReturn(Optional.empty());

        NotificationTO notificationTO = minimumValidNotificationTO();
        notificationTO.setRecipientsProvider("missingProvider");

        binder.update(notification, notificationTO);

        assertSame(existingProvider, state.recipientsProvider);
        verify(intAttrNameParser).parse("email", AnyTypeKind.USER);
    }

    @Test
    void updateThrowsRequiredValuesMissingWhenTemplateIsMissing() {
        NotificationState state = notificationState();

        when(mailTemplateDAO.findById("missingTemplate")).thenReturn(Optional.empty());

        NotificationTO notificationTO = minimumValidNotificationTO();
        notificationTO.setTemplate("missingTemplate");

        SyncopeClientException thrown = assertThrows(
                SyncopeClientException.class,
                () -> binder.update(state.notification, notificationTO));

        assertTrue(thrown.getElements().contains("template"));
        assertNull(state.template);
    }

    @Test
    void updateThrowsRequiredValuesMissingWhenEventsAreMissing() {
        NotificationState state = notificationState();

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("template")).thenReturn(Optional.of(template));

        NotificationTO notificationTO = minimumValidNotificationTO();
        notificationTO.getEvents().clear();

        SyncopeClientException thrown = assertThrows(
                SyncopeClientException.class,
                () -> binder.update(state.notification, notificationTO));

        assertTrue(thrown.getElements().contains("events"));
    }

    @Test
    void updateThrowsRequiredValuesMissingWhenStaticRecipientEmailIsInvalid() {
        NotificationState state = notificationState();

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("template")).thenReturn(Optional.of(template));

        NotificationTO notificationTO = minimumValidNotificationTO();
        notificationTO.getStaticRecipients().add("not-an-email");

        SyncopeClientException thrown = assertThrows(
                SyncopeClientException.class,
                () -> binder.update(state.notification, notificationTO));

        assertTrue(thrown.getElements().contains("staticRecipients: not-an-email"));
    }

    @Test
    void updateThrowsInvalidRequestWhenRecipientAttrNameCannotBeParsed() throws Exception {
        NotificationState state = notificationState();

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("template")).thenReturn(Optional.of(template));

        doThrow(new ParseException("Invalid internal attribute name", 0)).
                when(intAttrNameParser).parse("badAttr", AnyTypeKind.USER);

        NotificationTO notificationTO = minimumValidNotificationTO();
        notificationTO.setRecipientAttrName("badAttr");

        SyncopeClientException thrown = assertThrows(
                SyncopeClientException.class,
                () -> binder.update(state.notification, notificationTO));

        assertTrue(thrown.getElements().contains("Invalid internal attribute name"));
    }

    private NotificationTO minimumValidNotificationTO() {
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("template");
        notificationTO.getEvents().add("event");
        notificationTO.setRecipientsFIQL("username==john");
        notificationTO.setRecipientAttrName("email");
        notificationTO.setSelfAsRecipient(false);
        notificationTO.setSender("sender@example.com");
        notificationTO.setSubject("subject");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);
        notificationTO.setActive(true);
        return notificationTO;
    }

    private NotificationState notificationState() {
        NotificationState state = new NotificationState();
        Notification notification = mock(Notification.class);
        state.notification = notification;

        when(notification.getEvents()).thenReturn(state.events);
        when(notification.getStaticRecipients()).thenReturn(state.staticRecipients);
        when(notification.getAbouts()).thenReturn(state.abouts);

        doAnswer(invocation -> {
            state.recipientsFIQL = invocation.getArgument(0);
            return null;
        }).when(notification).setRecipientsFIQL(any());

        doAnswer(invocation -> {
            state.recipientAttrName = invocation.getArgument(0);
            return null;
        }).when(notification).setRecipientAttrName(any());

        when(notification.getRecipientAttrName()).thenAnswer(invocation -> state.recipientAttrName);

        doAnswer(invocation -> {
            state.selfAsRecipient = invocation.getArgument(0);
            return null;
        }).when(notification).setSelfAsRecipient(any(Boolean.class));

        doAnswer(invocation -> {
            state.sender = invocation.getArgument(0);
            return null;
        }).when(notification).setSender(any());

        doAnswer(invocation -> {
            state.subject = invocation.getArgument(0);
            return null;
        }).when(notification).setSubject(any());

        doAnswer(invocation -> {
            state.traceLevel = invocation.getArgument(0);
            return null;
        }).when(notification).setTraceLevel(any());

        doAnswer(invocation -> {
            state.active = invocation.getArgument(0);
            return null;
        }).when(notification).setActive(any(Boolean.class));

        doAnswer(invocation -> {
            state.template = invocation.getArgument(0);
            return null;
        }).when(notification).setTemplate(any());

        doAnswer(invocation -> {
            state.recipientsProvider = invocation.getArgument(0);
            return null;
        }).when(notification).setRecipientsProvider(any());

        when(notification.getAbout(any(AnyType.class))).thenAnswer(invocation -> {
            AnyType anyType = invocation.getArgument(0);
            return state.abouts.stream().
                    filter(about -> about.getAnyType() != null).
                    filter(about -> about.getAnyType().getKey().equals(anyType.getKey())).
                    findFirst();
        });

        doAnswer(invocation -> {
            state.abouts.add(invocation.getArgument(0));
            return true;
        }).when(notification).add(any(AnyAbout.class));

        return state;
    }

    private AnyType anyType(final String key) {
        AnyType anyType = mock(AnyType.class);
        when(anyType.getKey()).thenReturn(key);
        return anyType;
    }

    private AnyAbout about(final AnyType initialAnyType, final String initialFiql) {
        AnyAbout about = mock(AnyAbout.class);

        final AnyType[] anyType = new AnyType[] { initialAnyType };
        final Notification[] notification = new Notification[1];
        final String[] fiql = new String[] { initialFiql };

        when(about.getAnyType()).thenAnswer(invocation -> anyType[0]);
        when(about.get()).thenAnswer(invocation -> fiql[0]);

        doAnswer(invocation -> {
            anyType[0] = invocation.getArgument(0);
            return null;
        }).when(about).setAnyType(any(AnyType.class));

        doAnswer(invocation -> {
            notification[0] = invocation.getArgument(0);
            return null;
        }).when(about).setNotification(any(Notification.class));

        doAnswer(invocation -> {
            fiql[0] = invocation.getArgument(0);
            return null;
        }).when(about).set(any(String.class));

        return about;
    }

    private static final class NotificationState {

        private Notification notification;

        private String recipientsFIQL;

        private final Set<String> staticRecipients = new LinkedHashSet<>();

        private String recipientAttrName;

        private boolean selfAsRecipient;

        private String sender;

        private String subject;

        private TraceLevel traceLevel;

        private boolean active;

        private final Set<String> events = new LinkedHashSet<>();

        private MailTemplate template;

        private final Set<AnyAbout> abouts = new HashSet<>();

        private Implementation recipientsProvider;
    }
}