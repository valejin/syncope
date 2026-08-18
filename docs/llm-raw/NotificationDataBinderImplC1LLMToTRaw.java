package org.apache.syncope.core.provisioning.java.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.apache.syncope.common.lib.SyncopeClientException;
import org.apache.syncope.common.lib.to.NotificationTO;
import org.apache.syncope.common.lib.types.ImplementationType;
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
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Expert A: update copies a valid transfer object into the notification entity")
    void updateCopiesBasicFieldsFromTransferObject() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("welcomeTemplate")).thenReturn(Optional.of(template));

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

    @Test
    @DisplayName("Expert C: update rejects a missing template reference")
    void updateThrowsWhenTemplateDoesNotExist() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();

        when(mailTemplateDAO.findById("welcomeTemplate")).thenReturn(Optional.empty());

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
        verify(notification, never()).setTemplate(org.mockito.ArgumentMatchers.any());
    }

    @Test
    @DisplayName("Edge case: update clears optional recipients provider when TO does not specify one")
    void updateClearsRecipientsProviderWhenMissing() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.setRecipientsProvider(null);

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("welcomeTemplate")).thenReturn(Optional.of(template));

        binder.update(notification, notificationTO);

        verify(notification).setRecipientsProvider(null);
        verify(implementationDAO, never()).findById(org.mockito.ArgumentMatchers.anyString());
    }

    @Test
    @DisplayName("Edge case: update applies a valid recipients provider implementation")
    void updateSetsValidRecipientsProvider() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.setRecipientsProvider("recipientsProviderKey");

        MailTemplate template = mock(MailTemplate.class);
        Implementation recipientsProvider = mock(Implementation.class);
        when(mailTemplateDAO.findById("welcomeTemplate")).thenReturn(Optional.of(template));
        when(implementationDAO.findById("recipientsProviderKey")).thenReturn(Optional.of(recipientsProvider));
        when(recipientsProvider.getType()).thenReturn(ImplementationType.RECIPIENTS_PROVIDER);

        binder.update(notification, notificationTO);

        verify(notification).setRecipientsProvider(recipientsProvider);
    }

    @Test
    @DisplayName("Edge case: update rejects an implementation with the wrong type as recipients provider")
    void updateThrowsWhenRecipientsProviderHasWrongType() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.setRecipientsProvider("wrongTypeImplementation");

        MailTemplate template = mock(MailTemplate.class);
        Implementation implementation = mock(Implementation.class);
        when(mailTemplateDAO.findById("welcomeTemplate")).thenReturn(Optional.of(template));
        when(implementationDAO.findById("wrongTypeImplementation")).thenReturn(Optional.of(implementation));
        when(implementation.getType()).thenReturn(ImplementationType.ACCOUNT_RULE);

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
    }

    @Test
    @DisplayName("Edge case: update rejects a missing recipients FIQL expression")
    void updateThrowsWhenRecipientsFIQLIsBlank() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.setRecipientsFIQL(" ");

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("welcomeTemplate")).thenReturn(Optional.of(template));

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
    }

    @Test
    @DisplayName("Edge case: update ignores about clauses targeting unknown AnyType values")
    void updateIgnoresAboutClauseForUnknownAnyType() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.getAbouts().put("USER", "username==alice");

        MailTemplate template = mock(MailTemplate.class);
        when(mailTemplateDAO.findById("welcomeTemplate")).thenReturn(Optional.of(template));
        when(anyTypeDAO.findById("USER")).thenReturn(Optional.empty());

        binder.update(notification, notificationTO);

        verify(entityFactory, never()).newEntity(AnyAbout.class);
    }

    @Test
    @DisplayName("Edge case: update creates an AnyAbout entity for a known AnyType")
    void updateCreatesAnyAboutForKnownAnyType() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = baseNotificationTO();
        notificationTO.getAbouts().put("USER", "username==alice");

        MailTemplate template = mock(MailTemplate.class);
        AnyType anyType = mock(AnyType.class);
        AnyAbout anyAbout = mock(AnyAbout.class);
        when(mailTemplateDAO.findById("welcomeTemplate")).thenReturn(Optional.of(template));
        when(anyTypeDAO.findById("USER")).thenReturn(Optional.of(anyType));
        when(entityFactory.newEntity(AnyAbout.class)).thenReturn(anyAbout);

        binder.update(notification, notificationTO);

        verify(anyAbout).setAnyType(anyType);
        verify(anyAbout).set(eq(notification));
        verify(anyAbout).set("username==alice");
        verify(notification).add(anyAbout);
    }

    @Test
    @DisplayName("Exception scenario: getNotificationTO propagates NullPointerException for null input")
    void getNotificationTOThrowsWhenNotificationIsNull() {
        assertThrows(NullPointerException.class, () -> binder.getNotificationTO(null));
    }

    @Test
    @DisplayName("Edge case: getNotificationTO handles a notification without template or recipients provider")
    void getNotificationTOAllowsNullOptionalAssociations() {
        Notification notification = mock(Notification.class);
        when(notification.getKey()).thenReturn("notification-key");
        when(notification.getTemplate()).thenReturn(null);
        when(notification.getRecipientsProvider()).thenReturn(null);

        NotificationTO actual = binder.getNotificationTO(notification);

        assertNotNull(actual);
        assertEquals("notification-key", actual.getKey());
        assertNull(actual.getTemplate());
        assertNull(actual.getRecipientsProvider());
        assertFalse(actual.isSelfAsRecipient());
    }

    private static NotificationTO baseNotificationTO() {
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("welcomeTemplate");
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
