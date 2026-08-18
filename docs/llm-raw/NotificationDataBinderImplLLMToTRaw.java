package org.apache.syncope.core.provisioning.java.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

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
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificationDataBinderImplTest {

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

    @Test
    void getNotificationTOShouldMapNotificationFields() {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        Implementation recipientsProvider = mock(Implementation.class);

        AnyType anyType = mock(AnyType.class);
        AnyAbout about = mock(AnyAbout.class);

        Set<String> events = new LinkedHashSet<>();
        events.add("user:create");

        Set<String> staticRecipients = new LinkedHashSet<>();
        staticRecipients.add("admin@example.com");

        Set<AnyAbout> abouts = new LinkedHashSet<>();
        abouts.add(about);

        when(notification.getKey()).thenReturn("notification-key");
        when(notification.getTemplate()).thenReturn(template);
        when(template.getKey()).thenReturn("template-key");
        when(notification.getEvents()).thenReturn(events);
        when(notification.getRecipientsFIQL()).thenReturn("username==jdoe");
        when(notification.getStaticRecipients()).thenReturn(staticRecipients);
        when(notification.getRecipientAttrName()).thenReturn("email");
        when(notification.isSelfAsRecipient()).thenReturn(true);
        when(notification.getSender()).thenReturn("sender@example.com");
        when(notification.getSubject()).thenReturn("Welcome");
        when(notification.getTraceLevel()).thenReturn(TraceLevel.ALL);
        when(notification.isActive()).thenReturn(true);
        when(notification.getAbouts()).thenReturn(abouts);

        when(about.getAnyType()).thenReturn(anyType);
        when(anyType.getKey()).thenReturn("USER");
        when(about.get()).thenReturn("username==jdoe");

        when(notification.getRecipientsProvider()).thenReturn(recipientsProvider);
        when(recipientsProvider.getKey()).thenReturn("recipients-provider-key");

        NotificationTO result = binder.getNotificationTO(notification);

        assertEquals("notification-key", result.getKey());
        assertEquals("template-key", result.getTemplate());
        assertTrue(result.getEvents().contains("user:create"));
        assertEquals("username==jdoe", result.getRecipientsFIQL());
        assertTrue(result.getStaticRecipients().contains("admin@example.com"));
        assertEquals("email", result.getRecipientAttrName());
        assertTrue(result.isSelfAsRecipient());
        assertEquals("sender@example.com", result.getSender());
        assertEquals("Welcome", result.getSubject());
        assertEquals(TraceLevel.ALL, result.getTraceLevel());
        assertTrue(result.isActive());
        assertEquals("username==jdoe", result.getAbouts().get("USER"));
        assertEquals("recipients-provider-key", result.getRecipientsProvider());
    }

    @Test
    void getNotificationTOShouldHandleNullRecipientsProvider() {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);

        when(notification.getKey()).thenReturn("notification-key");
        when(notification.getTemplate()).thenReturn(template);
        when(template.getKey()).thenReturn("template-key");
        when(notification.getEvents()).thenReturn(new LinkedHashSet<>());
        when(notification.getStaticRecipients()).thenReturn(new LinkedHashSet<>());
        when(notification.getAbouts()).thenReturn(new LinkedHashSet<>());
        when(notification.getRecipientsProvider()).thenReturn(null);

        NotificationTO result = binder.getNotificationTO(notification);

        assertEquals("notification-key", result.getKey());
        assertEquals("template-key", result.getTemplate());
        assertEquals(null, result.getRecipientsProvider());
    }

    @Test
    void createShouldCreateAndPopulateNotification() throws Exception {
        Notification notification = mockMutableNotification();
        MailTemplate template = mock(MailTemplate.class);

        NotificationTO notificationTO = validNotificationTO();

        when(entityFactory.newEntity(Notification.class)).thenReturn(notification);
        when(mailTemplateDAO.findById("template-key")).thenReturn(Optional.of(template));

        Object parsedAttrName = mock(Object.class);
        when(intAttrNameParser.parse("email", AnyTypeKind.USER)).thenReturn(parsedAttrName);

        Notification result = binder.create(notificationTO);

        assertSame(notification, result);
        verify(entityFactory).newEntity(Notification.class);
        verify(notification).setRecipientsFIQL("username==jdoe");
        verify(notification).setRecipientAttrName("email");
        verify(notification).setSelfAsRecipient(true);
        verify(notification).setSender("sender@example.com");
        verify(notification).setSubject("Welcome");
        verify(notification).setTraceLevel(TraceLevel.ALL);
        verify(notification).setActive(true);
        verify(notification).setTemplate(template);
        verify(notification).setRecipientsProvider(isNull());
        assertTrue(notification.getEvents().contains("user:create"));
        assertTrue(notification.getStaticRecipients().contains("admin@example.com"));
    }

    @Test
    void createShouldThrowWhenTemplateIsMissing() {
        Notification notification = mockMutableNotification();
        NotificationTO notificationTO = validNotificationTO();

        when(entityFactory.newEntity(Notification.class)).thenReturn(notification);
        when(mailTemplateDAO.findById("template-key")).thenReturn(Optional.empty());

        SyncopeClientException exception = assertThrows(
                SyncopeClientException.class,
                () -> binder.create(notificationTO));

        assertTrue(exception.getElements().contains("template"));
    }

    @Test
    void createShouldThrowWhenEventsAreMissing() {
        Notification notification = mockMutableNotification();
        MailTemplate template = mock(MailTemplate.class);

        NotificationTO notificationTO = validNotificationTO();
        notificationTO.getEvents().clear();

        when(entityFactory.newEntity(Notification.class)).thenReturn(notification);
        when(mailTemplateDAO.findById("template-key")).thenReturn(Optional.of(template));

        SyncopeClientException exception = assertThrows(
                SyncopeClientException.class,
                () -> binder.create(notificationTO));

        assertTrue(exception.getElements().contains("events"));
    }

    @Test
    void createShouldThrowWhenStaticRecipientEmailIsInvalid() {
        Notification notification = mockMutableNotification();
        MailTemplate template = mock(MailTemplate.class);

        NotificationTO notificationTO = validNotificationTO();
        notificationTO.getStaticRecipients().clear();
        notificationTO.getStaticRecipients().add("not-an-email-address");

        when(entityFactory.newEntity(Notification.class)).thenReturn(notification);
        when(mailTemplateDAO.findById("template-key")).thenReturn(Optional.of(template));

        SyncopeClientException exception = assertThrows(
                SyncopeClientException.class,
                () -> binder.create(notificationTO));

        assertTrue(exception.getElements().contains("staticRecipients: not-an-email-address"));
    }

    @Test
    void createShouldThrowInvalidRequestWhenRecipientAttrNameCannotBeParsed() throws Exception {
        Notification notification = mockMutableNotification();
        MailTemplate template = mock(MailTemplate.class);

        NotificationTO notificationTO = validNotificationTO();

        when(entityFactory.newEntity(Notification.class)).thenReturn(notification);
        when(mailTemplateDAO.findById("template-key")).thenReturn(Optional.of(template));

        doThrow(new ParseException("Invalid recipient attribute", 0))
                .when(intAttrNameParser)
                .parse("email", AnyTypeKind.USER);

        SyncopeClientException exception = assertThrows(
                SyncopeClientException.class,
                () -> binder.create(notificationTO));

        assertTrue(exception.getElements().contains("Invalid recipient attribute"));
    }

    @Test
    void createShouldSetRecipientsProviderWhenValidProviderIsSpecified() throws Exception {
        Notification notification = mockMutableNotification();
        MailTemplate template = mock(MailTemplate.class);
        Implementation recipientsProvider = mock(Implementation.class);

        NotificationTO notificationTO = validNotificationTO();
        notificationTO.setRecipientsProvider("provider-key");

        when(entityFactory.newEntity(Notification.class)).thenReturn(notification);
        when(mailTemplateDAO.findById("template-key")).thenReturn(Optional.of(template));
        when(implementationDAO.findById("provider-key")).thenReturn(Optional.of(recipientsProvider));

        binder.create(notificationTO);

        verify(notification).setRecipientsProvider(recipientsProvider);
    }

    @Test
    void createShouldIgnoreInvalidRecipientsProvider() throws Exception {
        Notification notification = mockMutableNotification();
        MailTemplate template = mock(MailTemplate.class);

        NotificationTO notificationTO = validNotificationTO();
        notificationTO.setRecipientsProvider("missing-provider");

        when(entityFactory.newEntity(Notification.class)).thenReturn(notification);
        when(mailTemplateDAO.findById("template-key")).thenReturn(Optional.of(template));
        when(implementationDAO.findById("missing-provider")).thenReturn(Optional.empty());

        binder.create(notificationTO);

        verify(implementationDAO).findById("missing-provider");
    }

    @Test
    void createShouldAddValidAboutEntry() throws Exception {
        Notification notification = mockMutableNotification();
        MailTemplate template = mock(MailTemplate.class);
        AnyType anyType = mock(AnyType.class);
        AnyAbout anyAbout = mock(AnyAbout.class);

        NotificationTO notificationTO = validNotificationTO();
        notificationTO.getAbouts().put("USER", "username==jdoe");

        when(entityFactory.newEntity(Notification.class)).thenReturn(notification);
        when(entityFactory.newEntity(AnyAbout.class)).thenReturn(anyAbout);
        when(mailTemplateDAO.findById("template-key")).thenReturn(Optional.of(template));
        when(anyTypeDAO.findById("USER")).thenReturn(Optional.of(anyType));
        when(notification.getAbout(anyType)).thenReturn(Optional.empty());

        binder.create(notificationTO);

        verify(anyAbout).setAnyType(anyType);
        verify(anyAbout).setNotification(notification);
        verify(notification).add(anyAbout);
        verify(anyAbout).set("username==jdoe");
    }

    @Test
    void createShouldIgnoreInvalidAnyTypeInAbouts() throws Exception {
        Notification notification = mockMutableNotification();
        MailTemplate template = mock(MailTemplate.class);

        NotificationTO notificationTO = validNotificationTO();
        notificationTO.getAbouts().put("MISSING_TYPE", "name==test");

        when(entityFactory.newEntity(Notification.class)).thenReturn(notification);
        when(mailTemplateDAO.findById("template-key")).thenReturn(Optional.of(template));
        when(anyTypeDAO.findById("MISSING_TYPE")).thenReturn(Optional.empty());

        binder.create(notificationTO);

        verify(anyTypeDAO).findById("MISSING_TYPE");
    }

    private NotificationTO validNotificationTO() {
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("template-key");
        notificationTO.getEvents().add("user:create");
        notificationTO.setRecipientsFIQL("username==jdoe");
        notificationTO.getStaticRecipients().add("admin@example.com");
        notificationTO.setRecipientAttrName("email");
        notificationTO.setSelfAsRecipient(true);
        notificationTO.setSender("sender@example.com");
        notificationTO.setSubject("Welcome");
        notificationTO.setTraceLevel(TraceLevel.ALL);
        notificationTO.setActive(true);
        notificationTO.setRecipientsProvider(null);
        return notificationTO;
    }

    private Notification mockMutableNotification() {
        Notification notification = mock(Notification.class);

        Set<String> events = new LinkedHashSet<>();
        Set<String> staticRecipients = new LinkedHashSet<>();
        Set<AnyAbout> abouts = new LinkedHashSet<>();

        AtomicReference<String> recipientAttrName = new AtomicReference<>();

        when(notification.getEvents()).thenReturn(events);
        when(notification.getStaticRecipients()).thenReturn(staticRecipients);
        when(notification.getAbouts()).thenReturn(abouts);
        when(notification.getRecipientAttrName()).thenAnswer(invocation -> recipientAttrName.get());

        doAnswer(invocation -> {
            recipientAttrName.set(invocation.getArgument(0));
            return null;
        }).when(notification).setRecipientAttrName(any());

        return notification;
    }
}
``