package org.apache.syncope.core.provisioning.java.data;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
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
import org.apache.syncope.common.lib.types.AnyTypeKind;
import org.apache.syncope.common.lib.types.ClientExceptionType;
import org.apache.syncope.core.persistence.api.dao.AnyTypeDAO;
import org.apache.syncope.core.persistence.api.dao.ImplementationDAO;
import org.apache.syncope.core.persistence.api.dao.MailTemplateDAO;
import org.apache.syncope.core.persistence.api.entity.AnyAbout;
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
    @DisplayName("update: scenario nominale con template, eventi, about e provider validi")
    void updateNominal() {
        // Arrange
        Notification notification = mockNotification("email");

        NotificationTO to = validNotificationTO();
        to.getStaticRecipients().add("user@example.com");
        to.getAbouts().put("USER", "cond==true");
        to.setRecipientsProvider("provider-1");

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("tmpl-1");

        org.apache.syncope.core.persistence.api.entity.AnyType anyType =
                mock(org.apache.syncope.core.persistence.api.entity.AnyType.class);
        doReturn(Optional.of(anyType)).when(anyTypeDAO).findById("USER");
        doReturn(Optional.empty()).when(notification).getAbout(eq(anyType));

        AnyAbout newAbout = mock(AnyAbout.class);
        when(entityFactory.newEntity(AnyAbout.class)).thenReturn(newAbout);

        Implementation provider = mock(Implementation.class);
        doReturn(Optional.of(provider)).when(implementationDAO).findById("provider-1");

        // Act
        assertDoesNotThrow(() -> binder.update(notification, to));

        // Assert
        verify(notification).setRecipientsFIQL("username==john");
        verify(notification).setRecipientAttrName("email");
        verify(notification).setSelfAsRecipient(true);
        verify(notification).setSender("admin@example.com");
        verify(notification).setSubject("Subject");
        verify(notification).setActive(true);

        verify(notification).setTemplate(template);

        verify(newAbout).setAnyType(anyType);
        verify(newAbout).setNotification(notification);
        verify(newAbout).set("cond==true");
        verify(notification).add(newAbout);

        verify(intAttrNameParser).parse("email", AnyTypeKind.USER);
        verify(notification).setRecipientsProvider(provider);
    }

    @Test
    @DisplayName("update: template mancante genera RequiredValuesMissing con elemento template")
    void updateMissingTemplateThrowsRequiredValuesMissing() {
        // Arrange
        Notification notification = mockNotification("email");

        NotificationTO to = validNotificationTO();

        doReturn(Optional.empty()).when(mailTemplateDAO).findById("tmpl-1");

        // Act
        SyncopeClientException ex = assertThrows(
                SyncopeClientException.class,
                () -> binder.update(notification, to));

        // Assert
        assertEquals(ClientExceptionType.RequiredValuesMissing, ex.getType());
        assertTrue(ex.getElements().contains("template"));
        verify(notification).setTemplate(null);
    }

    @Test
    @DisplayName("update: lista eventi vuota genera RequiredValuesMissing con elemento events")
    void updateEmptyEventsThrowsRequiredValuesMissing() {
        // Arrange
        Notification notification = mockNotification("email");

        NotificationTO to = validNotificationTO();
        to.getEvents().clear();

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("tmpl-1");

        // Act
        SyncopeClientException ex = assertThrows(
                SyncopeClientException.class,
                () -> binder.update(notification, to));

        // Assert
        assertEquals(ClientExceptionType.RequiredValuesMissing, ex.getType());
        assertTrue(ex.getElements().contains("events"));
    }

    @Test
    @DisplayName("update: destinatario statico non valido genera RequiredValuesMissing")
    void updateInvalidStaticRecipientThrowsRequiredValuesMissing() {
        // Arrange
        Notification notification = mockNotification("email");

        NotificationTO to = validNotificationTO();
        to.getStaticRecipients().add("not-an-email");

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("tmpl-1");

        // Act
        SyncopeClientException ex = assertThrows(
                SyncopeClientException.class,
                () -> binder.update(notification, to));

        // Assert
        assertEquals(ClientExceptionType.RequiredValuesMissing, ex.getType());
        assertTrue(ex.getElements().contains("staticRecipients: not-an-email"));
    }

    @Test
    @DisplayName("update: about esistente viene aggiornato")
    void updateExistingAbout() {
        // Arrange
        Notification notification = mockNotification("email");

        NotificationTO to = validNotificationTO();
        to.getAbouts().put("USER", "updated==true");

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("tmpl-1");

        org.apache.syncope.core.persistence.api.entity.AnyType anyType =
                mock(org.apache.syncope.core.persistence.api.entity.AnyType.class);
        doReturn(Optional.of(anyType)).when(anyTypeDAO).findById("USER");

        AnyAbout existingAbout = mock(AnyAbout.class);
        doReturn(Optional.of(existingAbout)).when(notification).getAbout(eq(anyType));

        // Act
        assertDoesNotThrow(() -> binder.update(notification, to));

        // Assert
        verify(existingAbout).set("updated==true");
        verify(notification, never()).add(existingAbout);
    }

    @Test
    @DisplayName("update: AnyType non valido negli about viene ignorato")
    void updateInvalidAnyTypeIsIgnored() {
        // Arrange
        Notification notification = mockNotification("email");

        NotificationTO to = validNotificationTO();
        to.getAbouts().put("UNKNOWN", "cond==true");

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("tmpl-1");

        doReturn(Optional.empty()).when(anyTypeDAO).findById("UNKNOWN");

        // Act
        assertDoesNotThrow(() -> binder.update(notification, to));

        // Assert
        verify(entityFactory, never()).newEntity(AnyAbout.class);
    }

    @Test
    @DisplayName("update: about con valore blank viene ignorato")
    void updateBlankAboutValueIsIgnored() {
        // Arrange
        Notification notification = mockNotification("email");

        NotificationTO to = validNotificationTO();
        to.getAbouts().put("USER", "   ");

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("tmpl-1");

        // Act
        assertDoesNotThrow(() -> binder.update(notification, to));

        // Assert
        verify(anyTypeDAO, never()).findById("USER");
        verify(entityFactory, never()).newEntity(AnyAbout.class);
    }

    @Test
    @DisplayName("update: about non presente nel TO viene rimosso dalla notification")
    void updateRemovesAboutsNotContainedInTO() {
        // Arrange
        Notification notification = mockNotification("email");

        org.apache.syncope.core.persistence.api.entity.AnyType anyType =
                mock(org.apache.syncope.core.persistence.api.entity.AnyType.class);
        when(anyType.getKey()).thenReturn("USER");

        AnyAbout existingAbout = mock(AnyAbout.class);
        when(existingAbout.getAnyType()).thenReturn(anyType);

        notification.getAbouts().add(existingAbout);

        NotificationTO to = validNotificationTO();

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("tmpl-1");

        // Act
        assertDoesNotThrow(() -> binder.update(notification, to));

        // Assert
        assertFalse(notification.getAbouts().contains(existingAbout));
    }

    @Test
    @DisplayName("update: recipientAttrName non parsabile genera InvalidRequest")
    void updateInvalidRecipientAttrNameThrowsInvalidRequest() throws Exception {
        // Arrange
        Notification notification = mockNotification("badAttr");

        NotificationTO to = validNotificationTO();
        to.setRecipientAttrName("badAttr");

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("tmpl-1");

        when(intAttrNameParser.parse("badAttr", AnyTypeKind.USER)).
                thenThrow(new ParseException("Invalid internal attribute name", 0));

        // Act
        SyncopeClientException ex = assertThrows(
                SyncopeClientException.class,
                () -> binder.update(notification, to));

        // Assert
        assertEquals(ClientExceptionType.InvalidRequest, ex.getType());
        assertTrue(ex.getElements().contains("Invalid internal attribute name"));
    }

    @Test
    @DisplayName("update: recipientsProvider null azzera il provider nella notification")
    void updateNullRecipientsProviderClearsProvider() {
        // Arrange
        Notification notification = mockNotification("email");

        NotificationTO to = validNotificationTO();
        to.setRecipientsProvider(null);

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("tmpl-1");

        // Act
        assertDoesNotThrow(() -> binder.update(notification, to));

        // Assert
        verify(notification).setRecipientsProvider(null);
    }

    @Test
    @DisplayName("update: recipientsProvider inesistente viene ignorato")
    void updateInvalidRecipientsProviderIsIgnored() {
        // Arrange
        Notification notification = mockNotification("email");

        NotificationTO to = validNotificationTO();
        to.setRecipientsProvider("missing-provider");

        MailTemplate template = mock(MailTemplate.class);
        doReturn(Optional.of(template)).when(mailTemplateDAO).findById("tmpl-1");

        doReturn(Optional.empty()).when(implementationDAO).findById("missing-provider");

        // Act
        assertDoesNotThrow(() -> binder.update(notification, to));

        // Assert
        verify(notification, never()).setRecipientsProvider(
                org.mockito.ArgumentMatchers.any(Implementation.class));
    }

    @Test
    @DisplayName("getNotificationTO: scenario nominale, tutti i campi valorizzati")
    void getNotificationTONominal() {
        // Arrange
        Notification notification = mock(Notification.class);

        MailTemplate template = mock(MailTemplate.class);
        when(template.getKey()).thenReturn("tmpl-1");
        when(notification.getTemplate()).thenReturn(template);

        org.apache.syncope.core.persistence.api.entity.AnyType anyType =
                mock(org.apache.syncope.core.persistence.api.entity.AnyType.class);
        when(anyType.getKey()).thenReturn("USER");

        AnyAbout about = mock(AnyAbout.class);
        when(about.getAnyType()).thenReturn(anyType);
        when(about.get()).thenReturn("cond==true");

        Implementation provider = mock(Implementation.class);
        when(provider.getKey()).thenReturn("provider-1");

        when(notification.getKey()).thenReturn("notification-1");
        when(notification.getEvents()).thenReturn(List.of("userCreate"));
        when(notification.getRecipientsFIQL()).thenReturn("username==john");
        when(notification.getStaticRecipients()).thenReturn(List.of("user@example.com"));
        when(notification.getRecipientAttrName()).thenReturn("email");
        when(notification.isSelfAsRecipient()).thenReturn(true);
        when(notification.getSender()).thenReturn("admin@example.com");
        when(notification.getSubject()).thenReturn("Subject");
        when(notification.isActive()).thenReturn(true);
        when(notification.getAbouts()).thenReturn(List.of(about));
        when(notification.getRecipientsProvider()).thenReturn(provider);

        // Act
        NotificationTO to = binder.getNotificationTO(notification);

        // Assert
        assertEquals("notification-1", to.getKey());
        assertEquals("tmpl-1", to.getTemplate());
        assertEquals(List.of("userCreate"), to.getEvents());
        assertEquals("username==john", to.getRecipientsFIQL());
        assertEquals(List.of("user@example.com"), to.getStaticRecipients());
        assertEquals("email", to.getRecipientAttrName());
        assertTrue(to.isSelfAsRecipient());
        assertEquals("admin@example.com", to.getSender());
        assertEquals("Subject", to.getSubject());
        assertTrue(to.isActive());
        assertEquals(Map.of("USER", "cond==true"), to.getAbouts());
        assertEquals("provider-1", to.getRecipientsProvider());
    }

    @Test
    @DisplayName("getNotificationTO: recipientsProvider null non valorizza il campo nel TO")
    void getNotificationTOWithoutRecipientsProvider() {
        // Arrange
        Notification notification = mock(Notification.class);

        MailTemplate template = mock(MailTemplate.class);
        when(template.getKey()).thenReturn("tmpl-1");

        when(notification.getTemplate()).thenReturn(template);
        when(notification.getEvents()).thenReturn(List.of("userCreate"));
        when(notification.getStaticRecipients()).thenReturn(List.of());
        when(notification.getAbouts()).thenReturn(List.of());
        when(notification.getRecipientsProvider()).thenReturn(null);

        // Act
        NotificationTO to = binder.getNotificationTO(notification);

        // Assert
        assertEquals("tmpl-1", to.getTemplate());
        assertEquals(List.of("userCreate"), to.getEvents());
        assertTrue(to.getStaticRecipients().isEmpty());
        assertTrue(to.getAbouts().isEmpty());
        assertNull(to.getRecipientsProvider());
    }

    private NotificationTO validNotificationTO() {
        NotificationTO to = new NotificationTO();
        to.setTemplate("tmpl-1");
        to.getEvents().add("userCreate");
        to.setRecipientsFIQL("username==john");
        to.setRecipientAttrName("email");
        to.setSelfAsRecipient(true);
        to.setSender("admin@example.com");
        to.setSubject("Subject");
        to.setActive(true);
        return to;
    }

    private Notification mockNotification(final String recipientAttrName) {
        Notification notification = mock(Notification.class);

        List<String> events = new ArrayList<>();
        List<String> staticRecipients = new ArrayList<>();
        List<AnyAbout> abouts = new ArrayList<>();

        doReturn(events).when(notification).getEvents();
        doReturn(staticRecipients).when(notification).getStaticRecipients();
        doReturn(abouts).when(notification).getAbouts();
        doReturn(recipientAttrName).when(notification).getRecipientAttrName();

        return notification;
    }
}