package org.apache.syncope.core.provisioning.java.data;

import static org.junit.jupiter.api.Assertions.assertEquals; import static org.junit.jupiter.api.Assertions.assertFalse; import static org.junit.jupiter.api.Assertions.assertNotNull; import static org.junit.jupiter.api.Assertions.assertNull; import static org.junit.jupiter.api.Assertions.assertSame; import static org.junit.jupiter.api.Assertions.assertThrows; import static org.junit.jupiter.api.Assertions.assertTrue; import static org.mockito.ArgumentMatchers.eq; import static org.mockito.Mockito.any; import static org.mockito.Mockito.mock; import static org.mockito.Mockito.never; import static org.mockito.Mockito.verify; import static org.mockito.Mockito.when;

import java.text.ParseException; import java.util.ArrayList; import java.util.List; import java.util.Optional; import org.apache.syncope.common.lib.SyncopeClientException; import org.apache.syncope.common.lib.to.NotificationTO; import org.apache.syncope.common.lib.types.AnyTypeKind; import org.apache.syncope.common.lib.types.TraceLevel; import org.apache.syncope.core.persistence.api.dao.AnyTypeDAO; import org.apache.syncope.core.persistence.api.dao.ImplementationDAO; import org.apache.syncope.core.persistence.api.dao.MailTemplateDAO; import org.apache.syncope.core.persistence.api.entity.AnyAbout; import org.apache.syncope.core.persistence.api.entity.AnyType; import org.apache.syncope.core.persistence.api.entity.EntityFactory; import org.apache.syncope.core.persistence.api.entity.Implementation; import org.apache.syncope.core.persistence.api.entity.MailTemplate; import org.apache.syncope.core.persistence.api.entity.Notification; import org.apache.syncope.core.provisioning.api.IntAttrNameParser; import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test; import org.junit.jupiter.api.extension.ExtendWith; import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) class NotificationDataBinderImplC1LLMZeroShotTest {

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
        when(notification.getAbouts()).thenReturn(new ArrayList<>(List.of(aboutUser, aboutGroup)));

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

    @Test
    void getNotificationTOHandlesOptionalNullAssociations() {
        Notification notification = mock(Notification.class);

        when(notification.getKey()).thenReturn("notification-key");
        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        when(notification.getAbouts()).thenReturn(new ArrayList<>());
        when(notification.getRecipientsProvider()).thenReturn(null);
        when(notification.getTemplate()).thenReturn(null);
        when(notification.getTraceLevel()).thenReturn(TraceLevel.FAILURES);

        NotificationTO actual = binder.getNotificationTO(notification);

        assertEquals("notification-key", actual.getKey());
        assertNull(actual.getRecipientsProvider());
        assertNull(actual.getTemplate());
        assertEquals(TraceLevel.FAILURES, actual.getTraceLevel());
        assertTrue(actual.getEvents().isEmpty());
        assertTrue(actual.getStaticRecipients().isEmpty());
        assertTrue(actual.getAbouts().isEmpty());
    }

    @Test
    void updateCopiesTransferObjectValuesAndResolvesReferences() throws Exception {
        Notification notification = mock(Notification.class);
        MailTemplate template = mock(MailTemplate.class);
        Implementation recipientsProvider = mock(Implementation.class);
        AnyType userType = mock(AnyType.class);
        AnyType groupType = mock(AnyType.class);
        AnyAbout userAbout = mock(AnyAbout.class);
        AnyAbout groupAbout = mock(AnyAbout.class);

        List<String> notificationEvents = new ArrayList<>(List.of("OLD_EVENT"));
        List<String> notificationStaticRecipients = new ArrayList<>(List.of("old@example.com"));
        List<AnyAbout> notificationAbouts = new ArrayList<>();

        when(notification.getEvents()).thenReturn(notificationEvents);
        when(notification.getStaticRecipients()).thenReturn(notificationStaticRecipients);
        when(notification.getAbouts()).thenReturn(notificationAbouts);
        when(mailTemplateDAO.findById("template-key")).thenReturn(Optional.of(template));
        when(implementationDAO.findById("provider-key")).thenReturn(Optional.of(recipientsProvider));
        when(anyTypeDAO.findById(AnyTypeKind.USER.name())).thenReturn(Optional.of(userType));
        when(anyTypeDAO.findById(AnyTypeKind.GROUP.name())).thenReturn(Optional.of(groupType));
        when(entityFactory.newEntity(AnyAbout.class)).thenReturn(userAbout, groupAbout);

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
        assertSame(userAbout, notificationAbouts.get(0));
        assertSame(groupAbout, notificationAbouts.get(1));

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

        verify(userAbout).setNotification(notification);
        verify(userAbout).setAnyType(userType);
        verify(userAbout).set("username==alice");
        verify(groupAbout).setNotification(notification);
        verify(groupAbout).setAnyType(groupType);
        verify(groupAbout).set("name==managers");
        verify(notification).add(userAbout);
        verify(notification).add(groupAbout);
    }

    @Test
    void updateClearsRecipientsProviderWhenTransferObjectHasBlankProvider() {
        Notification notification = mock(Notification.class);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        when(notification.getAbouts()).thenReturn(new ArrayList<>());

        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setRecipientsProvider("   ");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        binder.update(notification, notificationTO);

        verify(notification).setRecipientsProvider(null);
        verify(implementationDAO, never()).findById(any());
    }

    @Test
    void updateClearsTemplateWhenTransferObjectHasBlankTemplate() {
        Notification notification = mock(Notification.class);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        when(notification.getAbouts()).thenReturn(new ArrayList<>());

        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        binder.update(notification, notificationTO);

        verify(notification).setTemplate(null);
        verify(mailTemplateDAO, never()).findById(any());
    }

    @Test
    void updateThrowsClientExceptionWhenTemplateDoesNotExist() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setTemplate("missing-template");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        when(notification.getAbouts()).thenReturn(new ArrayList<>());
        when(mailTemplateDAO.findById("missing-template")).thenReturn(Optional.empty());

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
    }

    @Test
    void updateThrowsClientExceptionWhenRecipientsProviderDoesNotExist() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setRecipientsProvider("missing-provider");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        when(notification.getAbouts()).thenReturn(new ArrayList<>());
        when(implementationDAO.findById("missing-provider")).thenReturn(Optional.empty());

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
    }

    @Test
    void updateThrowsClientExceptionWhenAnyTypeDoesNotExistForAbout() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.getAbouts().put("MISSING", "name==anything");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        when(notification.getAbouts()).thenReturn(new ArrayList<>());
        when(anyTypeDAO.findById("MISSING")).thenReturn(Optional.empty());

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
    }

    @Test
    void updateWrapsParseExceptionRaisedForRecipientAttributeName() throws Exception {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setRecipientAttrName("invalid.attr");
        notificationTO.setTraceLevel(TraceLevel.FAILURES);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        when(notification.getAbouts()).thenReturn(new ArrayList<>());
        when(intAttrNameParser.parse(eq("invalid.attr"), eq(AnyTypeKind.USER)))
                .thenThrow(new ParseException("invalid", 0));

        assertThrows(SyncopeClientException.class, () -> binder.update(notification, notificationTO));
    }

    @Test
    void updateAcceptsNullRecipientAttributeNameWithoutParsing() {
        Notification notification = mock(Notification.class);
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setRecipientAttrName(null);
        notificationTO.setTraceLevel(TraceLevel.NONE);

        when(notification.getEvents()).thenReturn(new ArrayList<>());
        when(notification.getStaticRecipients()).thenReturn(new ArrayList<>());
        when(notification.getAbouts()).thenReturn(new ArrayList<>());

        binder.update(notification, notificationTO);

        verify(intAttrNameParser, never()).parse(any(), any());
        verify(notification).setRecipientAttrName(null);
        verify(notification).setTraceLevel(TraceLevel.NONE);
    }

    @Test
    void updateReplacesExistingCollectionsWithTransferObjectCollections() {
        Notification notification = mock(Notification.class);
        List<String> events = new ArrayList<>(List.of("OLD_ONE", "OLD_TWO"));
        List<String> staticRecipients = new ArrayList<>(List.of("old1@example.com", "old2@example.com"));
        List<AnyAbout> abouts = new ArrayList<>(List.of(mock(AnyAbout.class)));

        when(notification.getEvents()).thenReturn(events);
        when(notification.getStaticRecipients()).thenReturn(staticRecipients);
        when(notification.getAbouts()).thenReturn(abouts);

        NotificationTO notificationTO = new NotificationTO();
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