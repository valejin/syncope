import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotificationDataBinderImplRandoopRaw0 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test001");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap3 = notificationTO2.getAbouts();
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertNotNull(strMap3);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test002");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        java.lang.Class<?> wildcardClass4 = notificationTO0.getClass();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test003");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.util.List<java.lang.String> strList7 = notificationTO0.getEvents();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList7);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test004");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = null;
        notificationTO0.setTraceLevel(traceLevel4);
        notificationTO0.setSelfAsRecipient(true);
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test005");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = notificationDataBinderImpl0.getNotificationTO(notification1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.core.persistence.api.entity.Notification.getKey()\" because \"notification\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test006");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setRecipientsFIQL("hi!");
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getKey();
        notificationTO0.setRecipientsProvider("hi!");
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test007");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setRecipientsFIQL("hi!");
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.Class<?> wildcardClass4 = notificationTO0.getClass();
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test008");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        java.lang.String str8 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test009");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        java.lang.String str4 = notificationTO0.getRecipientAttrName();
        java.util.List<java.lang.String> strList5 = notificationTO0.getStaticRecipients();
        java.lang.String str6 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test010");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("hi!");
        java.util.List<java.lang.String> strList6 = notificationTO0.getStaticRecipients();
        java.lang.Class<?> wildcardClass7 = notificationTO0.getClass();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNotNull(strList6);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test011");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        java.lang.String str5 = notificationTO0.getSubject();
        boolean boolean6 = notificationTO0.isSelfAsRecipient();
        java.lang.Class<?> wildcardClass7 = notificationTO0.getClass();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test012");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap3 = notificationTO2.getAbouts();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = null;
        notificationTO2.setTraceLevel(traceLevel4);
        java.lang.String str6 = notificationTO2.getTemplate();
        notificationTO2.setTemplate("hi!");
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertNotNull(strMap3);
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test013");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str3 = notificationTO2.getSender();
        java.lang.String str4 = notificationTO2.getRecipientsProvider();
        java.util.List<java.lang.String> strList5 = notificationTO2.getEvents();
        java.lang.String str6 = notificationTO2.getTemplate();
        java.lang.String str7 = notificationTO2.getSubject();
        boolean boolean8 = notificationTO2.isSelfAsRecipient();
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertNull(str6);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test014");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.lang.String str5 = notificationTO0.getSender();
        notificationTO0.setActive(true);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test015");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        java.lang.String str8 = notificationTO0.getSender();
        boolean boolean10 = notificationTO0.equals((java.lang.Object) (-1.0f));
        notificationTO0.setSelfAsRecipient(true);
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test016");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        java.lang.String str4 = notificationTO0.getTemplate();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO5 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO5.setTemplate("");
        notificationTO5.setRecipientsProvider("hi!");
        boolean boolean10 = notificationTO0.equals((java.lang.Object) "hi!");
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test017");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        java.lang.String str4 = notificationTO0.getRecipientAttrName();
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test018");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        boolean boolean3 = notificationTO0.isSelfAsRecipient();
        java.lang.Class<?> wildcardClass4 = notificationTO0.getClass();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test019");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        java.lang.String str7 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO8 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str9 = notificationTO8.getSender();
        java.lang.String str10 = notificationTO8.getRecipientsProvider();
        java.util.List<java.lang.String> strList11 = notificationTO8.getEvents();
        java.lang.String str12 = notificationTO8.getTemplate();
        java.lang.String str13 = notificationTO8.getSubject();
        boolean boolean14 = notificationTO0.equals((java.lang.Object) str13);
        java.util.List<java.lang.String> strList15 = notificationTO0.getStaticRecipients();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str10);
        org.junit.Assert.assertNotNull(strList11);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertNull(str13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(strList15);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test020");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setRecipientsFIQL("hi!");
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getKey();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = notificationTO0.getTraceLevel();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass6 = traceLevel5.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"Object.getClass()\" because \"o\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(traceLevel5);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test021");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        java.lang.String str4 = notificationTO0.getRecipientAttrName();
        notificationTO0.setTemplate("");
        notificationTO0.setSelfAsRecipient(true);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test022");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str3 = notificationTO2.getSender();
        java.lang.String str4 = notificationTO2.getRecipientsProvider();
        java.util.List<java.lang.String> strList5 = notificationTO2.getEvents();
        notificationTO2.setSubject("hi!");
        java.lang.String str8 = notificationTO2.getKey();
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test023");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str3 = notificationTO2.getSender();
        java.lang.String str4 = notificationTO2.getRecipientsProvider();
        boolean boolean5 = notificationTO2.isActive();
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test024");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = null;
        notificationTO0.setTraceLevel(traceLevel4);
        notificationTO0.setSubject("hi!");
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test025");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        boolean boolean4 = notificationTO0.isActive();
        java.util.List<java.lang.String> strList5 = notificationTO0.getStaticRecipients();
        java.lang.String str6 = notificationTO0.getTemplate();
        java.lang.String str7 = notificationTO0.getKey();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertNull(str6);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test026");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        notificationTO0.setSender("hi!");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test027");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        boolean boolean4 = notificationTO0.isActive();
        java.util.List<java.lang.String> strList5 = notificationTO0.getStaticRecipients();
        notificationTO0.setRecipientsFIQL("hi!");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(strList5);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test028");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        java.lang.Class<?> wildcardClass8 = notificationTO0.getClass();
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test029");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        boolean boolean5 = notificationTO0.isSelfAsRecipient();
        notificationTO0.setRecipientAttrName("");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel8 = null;
        notificationTO0.setTraceLevel(traceLevel8);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test030");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        notificationTO0.setSelfAsRecipient(false);
        notificationTO0.setActive(true);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test031");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        java.lang.String str4 = notificationTO0.getSubject();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test032");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        java.lang.String str6 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test033");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getTemplate();
        java.lang.Class<?> wildcardClass3 = notificationTO0.getClass();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test034");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        boolean boolean3 = notificationTO0.isSelfAsRecipient();
        notificationTO0.setRecipientAttrName("");
        notificationTO0.setSubject("hi!");
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test035");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.Class<?> wildcardClass2 = notificationTO0.getClass();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test036");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        boolean boolean4 = notificationTO0.isActive();
        boolean boolean5 = notificationTO0.isActive();
        notificationTO0.setActive(false);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test037");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        notificationTO0.setSender("");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test038");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(true);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        notificationTO0.setActive(true);
        java.lang.String str11 = notificationTO0.getTemplate();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test039");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str7 = notificationTO0.getKey();
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test040");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        boolean boolean2 = notificationTO0.isActive();
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.Class<?> wildcardClass5 = notificationTO0.getClass();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test041");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel9 = notificationTO0.getTraceLevel();
        java.lang.String str10 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(traceLevel9);
        org.junit.Assert.assertNull(str10);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test042");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getKey();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = null;
        notificationTO0.setTraceLevel(traceLevel4);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test043");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        boolean boolean12 = notificationTO0.isActive();
        java.util.List<java.lang.String> strList13 = notificationTO0.getStaticRecipients();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(strList13);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test044");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str3 = notificationTO2.getSender();
        java.lang.String str4 = notificationTO2.getRecipientsProvider();
        java.util.List<java.lang.String> strList5 = notificationTO2.getEvents();
        notificationTO2.setSubject("hi!");
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test045");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = null;
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.common.lib.to.NotificationTO.getRecipientsFIQL()\" because \"notificationTO\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test046");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        notificationTO0.setSender("");
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test047");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        java.lang.String str5 = notificationTO0.getSubject();
        java.util.List<java.lang.String> strList6 = notificationTO0.getEvents();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNotNull(strList6);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test048");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.lang.String str2 = notificationTO0.getSubject();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test049");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO2.setTemplate("");
        notificationTO2.setRecipientsProvider("hi!");
        java.lang.String str7 = notificationTO2.getRecipientsFIQL();
        notificationTO2.setSubject("");
        java.lang.String str10 = notificationTO2.getSender();
        notificationTO2.setKey("hi!");
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNull(str10);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test050");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        boolean boolean7 = notificationTO0.isActive();
        notificationTO0.setSender("");
        notificationTO0.setSelfAsRecipient(false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test051");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        boolean boolean1 = notificationTO0.isSelfAsRecipient();
        java.util.List<java.lang.String> strList2 = notificationTO0.getStaticRecipients();
        java.lang.String str3 = notificationTO0.getTemplate();
        notificationTO0.setSubject("hi!");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(strList2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test052");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        notificationTO0.setRecipientsProvider("");
        java.lang.String str8 = notificationTO0.getTemplate();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test053");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setActive(true);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel3 = null;
        notificationTO0.setTraceLevel(traceLevel3);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test054");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        java.lang.String str9 = notificationTO0.getKey();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test055");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = notificationTO0.getTraceLevel();
        java.lang.String str8 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(traceLevel7);
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test056");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("hi!");
        java.util.List<java.lang.String> strList6 = notificationTO0.getStaticRecipients();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO7 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap8 = notificationTO7.getAbouts();
        boolean boolean9 = notificationTO7.isActive();
        notificationTO7.setRecipientsProvider("hi!");
        boolean boolean12 = notificationTO0.equals((java.lang.Object) notificationTO7);
        notificationTO0.setRecipientsFIQL("hi!");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNotNull(strList6);
        org.junit.Assert.assertNotNull(strMap8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test057");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        java.util.Map<java.lang.String, java.lang.String> strMap12 = notificationTO0.getAbouts();
        java.util.List<java.lang.String> strList13 = notificationTO0.getStaticRecipients();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNotNull(strMap12);
        org.junit.Assert.assertNotNull(strList13);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test058");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.lang.String str5 = notificationTO0.getSender();
        java.lang.String str6 = notificationTO0.getSender();
        java.util.Map<java.lang.String, java.lang.String> strMap7 = notificationTO0.getAbouts();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNull(str6);
        org.junit.Assert.assertNotNull(strMap7);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test059");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        boolean boolean4 = notificationTO0.isActive();
        java.util.List<java.lang.String> strList5 = notificationTO0.getStaticRecipients();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel6 = null;
        notificationTO0.setTraceLevel(traceLevel6);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(strList5);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test060");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setRecipientsFIQL("hi!");
        java.lang.Class<?> wildcardClass3 = notificationTO0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test061");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.Class<?> wildcardClass3 = notificationTO0.getClass();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test062");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = null;
        notificationTO0.setTraceLevel(traceLevel4);
        java.lang.String str6 = notificationTO0.getTemplate();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test063");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        boolean boolean1 = notificationTO0.isSelfAsRecipient();
        notificationTO0.setSender("");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = null;
        notificationTO0.setTraceLevel(traceLevel4);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test064");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        notificationTO0.setTemplate("hi!");
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test065");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setRecipientsProvider("hi!");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test066");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        java.lang.String str4 = notificationTO0.getTemplate();
        java.lang.Class<?> wildcardClass5 = notificationTO0.getClass();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test067");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        notificationTO0.setRecipientsProvider("hi!");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test068");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        boolean boolean3 = notificationTO0.isActive();
        java.util.Map<java.lang.String, java.lang.String> strMap4 = notificationTO0.getAbouts();
        java.lang.String str5 = notificationTO0.getTemplate();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(strMap4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test069");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        boolean boolean4 = notificationTO0.isActive();
        java.util.List<java.lang.String> strList5 = notificationTO0.getStaticRecipients();
        boolean boolean6 = notificationTO0.isActive();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test070");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        java.lang.String str7 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO8 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str9 = notificationTO8.getSender();
        java.lang.String str10 = notificationTO8.getRecipientsProvider();
        java.util.List<java.lang.String> strList11 = notificationTO8.getEvents();
        java.lang.String str12 = notificationTO8.getTemplate();
        java.lang.String str13 = notificationTO8.getSubject();
        boolean boolean14 = notificationTO0.equals((java.lang.Object) str13);
        java.util.List<java.lang.String> strList15 = notificationTO0.getEvents();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str10);
        org.junit.Assert.assertNotNull(strList11);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertNull(str13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(strList15);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test071");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(true);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        notificationTO0.setSubject("");
        java.lang.String str11 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSelfAsRecipient(true);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test072");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        boolean boolean12 = notificationTO0.isActive();
        java.util.Map<java.lang.String, java.lang.String> strMap13 = notificationTO0.getAbouts();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(strMap13);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test073");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        java.lang.String str9 = notificationTO0.getRecipientAttrName();
        notificationTO0.setRecipientsProvider("");
        java.lang.String str12 = notificationTO0.getTemplate();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "" + "'", str12, "");
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test074");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(true);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        notificationTO0.setSubject("");
        java.lang.String str11 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSelfAsRecipient(false);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test075");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO2.setTemplate("");
        notificationTO2.setRecipientsProvider("hi!");
        java.lang.String str7 = notificationTO2.getRecipientsFIQL();
        notificationTO2.setSubject("");
        java.lang.String str10 = notificationTO2.getSender();
        boolean boolean12 = notificationTO2.equals((java.lang.Object) (-1.0f));
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNull(str10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test076");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO2.setTemplate("");
        java.lang.String str5 = notificationTO2.getTemplate();
        java.lang.String str6 = notificationTO2.getSender();
        notificationTO2.setKey("hi!");
        boolean boolean9 = notificationTO2.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel10 = notificationTO2.getTraceLevel();
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNull(str6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNull(traceLevel10);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test077");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSender("");
        notificationTO0.setKey("");
        boolean boolean6 = notificationTO0.isSelfAsRecipient();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test078");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getKey();
        notificationTO0.setActive(false);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test079");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        java.lang.String str8 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel11 = null;
        notificationTO0.setTraceLevel(traceLevel11);
        boolean boolean13 = notificationTO0.isActive();
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test080");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test081");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        notificationTO0.setTemplate("");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test082");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        java.lang.String str4 = notificationTO0.getRecipientAttrName();
        java.util.List<java.lang.String> strList5 = notificationTO0.getStaticRecipients();
        notificationTO0.setRecipientAttrName("hi!");
        notificationTO0.setTemplate("hi!");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test083");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        boolean boolean1 = notificationTO0.isSelfAsRecipient();
        java.util.List<java.lang.String> strList2 = notificationTO0.getStaticRecipients();
        java.lang.String str3 = notificationTO0.getTemplate();
        notificationTO0.setTemplate("");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(strList2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test084");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        java.util.List<java.lang.String> strList6 = notificationTO0.getStaticRecipients();
        notificationTO0.setActive(true);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNotNull(strList6);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test085");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setSubject("hi!");
        java.lang.String str7 = notificationTO0.getSubject();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test086");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        notificationTO0.setSubject("hi!");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test087");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        java.lang.String str10 = notificationTO0.getSender();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test088");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO2.setTemplate("");
        notificationTO2.setRecipientsProvider("hi!");
        boolean boolean7 = notificationTO2.isSelfAsRecipient();
        java.lang.String str8 = notificationTO2.getRecipientsProvider();
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test089");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        java.lang.String str6 = notificationTO0.getKey();
        notificationTO0.setActive(false);
        boolean boolean9 = notificationTO0.isSelfAsRecipient();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test090");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("hi!");
        java.util.List<java.lang.String> strList6 = notificationTO0.getStaticRecipients();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO7 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap8 = notificationTO7.getAbouts();
        boolean boolean9 = notificationTO7.isActive();
        notificationTO7.setRecipientsProvider("hi!");
        boolean boolean12 = notificationTO0.equals((java.lang.Object) notificationTO7);
        org.apache.syncope.common.lib.to.NotificationTO notificationTO13 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO13.setTemplate("");
        java.lang.String str16 = notificationTO13.getTemplate();
        java.lang.String str17 = notificationTO13.getSender();
        java.util.List<java.lang.String> strList18 = notificationTO13.getEvents();
        boolean boolean19 = notificationTO13.isActive();
        java.lang.String str20 = notificationTO13.getRecipientAttrName();
        java.util.List<java.lang.String> strList21 = notificationTO13.getStaticRecipients();
        boolean boolean22 = notificationTO0.equals((java.lang.Object) notificationTO13);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNotNull(strList6);
        org.junit.Assert.assertNotNull(strMap8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
        org.junit.Assert.assertNull(str17);
        org.junit.Assert.assertNotNull(strList18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNull(str20);
        org.junit.Assert.assertNotNull(strList21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test091");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        java.lang.String str5 = notificationTO0.getSubject();
        boolean boolean6 = notificationTO0.isSelfAsRecipient();
        boolean boolean7 = notificationTO0.isActive();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test092");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        java.lang.String str8 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        notificationTO0.setSender("");
        notificationTO0.setRecipientsFIQL("");
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test093");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        boolean boolean2 = notificationTO0.isSelfAsRecipient();
        notificationTO0.setSender("");
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test094");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(true);
        java.lang.String str7 = notificationTO0.getRecipientAttrName();
        boolean boolean8 = notificationTO0.isSelfAsRecipient();
        java.lang.String str9 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test095");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList2 = notificationTO0.getStaticRecipients();
        java.lang.String str3 = notificationTO0.getKey();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = null;
        notificationTO0.setTraceLevel(traceLevel4);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strList2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test096");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO6 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO6.setRecipientsFIQL("hi!");
        java.util.List<java.lang.String> strList9 = notificationTO6.getEvents();
        boolean boolean10 = notificationTO0.equals((java.lang.Object) strList9);
        java.lang.String str11 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNotNull(strList9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "hi!" + "'", str11, "hi!");
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test097");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        java.util.List<java.lang.String> strList5 = notificationTO0.getStaticRecipients();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test098");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        boolean boolean2 = notificationTO0.isActive();
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsProvider();
        java.lang.Class<?> wildcardClass6 = notificationTO0.getClass();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test099");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        boolean boolean3 = notificationTO0.isSelfAsRecipient();
        notificationTO0.setRecipientAttrName("");
        java.util.List<java.lang.String> strList6 = notificationTO0.getStaticRecipients();
        notificationTO0.setRecipientAttrName("");
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(strList6);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test100");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        java.lang.String str2 = notificationTO0.getRecipientAttrName();
        java.lang.String str3 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test101");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        boolean boolean4 = notificationTO0.isActive();
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test102");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        boolean boolean1 = notificationTO0.isSelfAsRecipient();
        java.lang.String str2 = notificationTO0.getKey();
        notificationTO0.setActive(true);
        java.lang.String str5 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test103");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        boolean boolean1 = notificationTO0.isSelfAsRecipient();
        java.lang.String str2 = notificationTO0.getKey();
        notificationTO0.setActive(true);
        notificationTO0.setRecipientAttrName("");
        java.lang.String str7 = notificationTO0.getRecipientsFIQL();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test104");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        java.lang.String str8 = notificationTO0.getSender();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel9 = null;
        notificationTO0.setTraceLevel(traceLevel9);
        java.util.List<java.lang.String> strList11 = notificationTO0.getEvents();
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertNotNull(strList11);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test105");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(true);
        java.lang.String str7 = notificationTO0.getRecipientAttrName();
        notificationTO0.setSender("hi!");
        java.util.List<java.lang.String> strList10 = notificationTO0.getEvents();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNotNull(strList10);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test106");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        boolean boolean7 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel8 = notificationTO0.getTraceLevel();
        notificationTO0.setActive(true);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(traceLevel8);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test107");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        java.lang.String str6 = notificationTO0.getKey();
        notificationTO0.setActive(false);
        java.lang.String str9 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str6);
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test108");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        boolean boolean7 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel8 = notificationTO0.getTraceLevel();
        java.lang.String str9 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(traceLevel8);
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test109");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        notificationTO0.setSubject("hi!");
        java.util.List<java.lang.String> strList8 = notificationTO0.getStaticRecipients();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNotNull(strList8);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test110");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        boolean boolean2 = notificationTO0.isActive();
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsProvider();
        notificationTO0.setActive(false);
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test111");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.lang.String str5 = notificationTO0.getSender();
        notificationTO0.setRecipientsProvider("hi!");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test112");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        java.lang.Class<?> wildcardClass9 = notificationTO0.getClass();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test113");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        boolean boolean4 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(traceLevel5);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test114");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel9 = notificationTO0.getTraceLevel();
        notificationTO0.setSelfAsRecipient(true);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(traceLevel9);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test115");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        notificationTO0.setRecipientsProvider("");
        notificationTO0.setRecipientsProvider("");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel10 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(traceLevel10);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test116");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        boolean boolean2 = notificationTO0.isActive();
        java.lang.String str3 = notificationTO0.getTemplate();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = null;
        notificationTO0.setTraceLevel(traceLevel4);
        java.util.List<java.lang.String> strList6 = notificationTO0.getEvents();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNotNull(strList6);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test117");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        boolean boolean7 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel8 = notificationTO0.getTraceLevel();
        notificationTO0.setRecipientAttrName("");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(traceLevel8);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test118");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSender("");
        java.lang.String str4 = notificationTO0.getRecipientsProvider();
        java.lang.String str5 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test119");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        java.lang.String str8 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str11 = notificationTO0.getKey();
        java.util.List<java.lang.String> strList12 = notificationTO0.getEvents();
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "hi!" + "'", str11, "hi!");
        org.junit.Assert.assertNotNull(strList12);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test120");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        boolean boolean2 = notificationTO0.isActive();
        java.lang.String str3 = notificationTO0.getRecipientAttrName();
        notificationTO0.setKey("");
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test121");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        java.lang.String str9 = notificationTO0.getRecipientAttrName();
        notificationTO0.setRecipientsProvider("");
        boolean boolean12 = notificationTO0.isSelfAsRecipient();
        notificationTO0.setSender("");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test122");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setActive(false);
        java.lang.String str7 = notificationTO0.getKey();
        java.util.List<java.lang.String> strList8 = notificationTO0.getStaticRecipients();
        java.lang.Object obj9 = null;
        boolean boolean10 = notificationTO0.equals(obj9);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNotNull(strList8);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test123");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        notificationTO0.setRecipientsProvider("");
        java.lang.String str14 = notificationTO0.getTemplate();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel15 = null;
        notificationTO0.setTraceLevel(traceLevel15);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "" + "'", str14, "");
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test124");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        boolean boolean2 = notificationTO0.isActive();
        java.lang.String str3 = notificationTO0.getSender();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test125");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        java.util.List<java.lang.String> strList7 = notificationTO0.getEvents();
        boolean boolean8 = notificationTO0.isActive();
        boolean boolean9 = notificationTO0.isSelfAsRecipient();
        notificationTO0.setSubject("");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(strList7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test126");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setRecipientsFIQL("hi!");
        notificationTO0.setActive(false);
        java.lang.String str14 = notificationTO0.getRecipientAttrName();
        java.lang.String str15 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNull(str14);
        org.junit.Assert.assertNull(str15);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test127");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("hi!");
        java.util.List<java.lang.String> strList6 = notificationTO0.getStaticRecipients();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO7 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap8 = notificationTO7.getAbouts();
        boolean boolean9 = notificationTO7.isActive();
        notificationTO7.setRecipientsProvider("hi!");
        boolean boolean12 = notificationTO0.equals((java.lang.Object) notificationTO7);
        java.lang.String str13 = notificationTO0.getKey();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNotNull(strList6);
        org.junit.Assert.assertNotNull(strMap8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNull(str13);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test128");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        java.lang.String str7 = notificationTO0.getRecipientAttrName();
        notificationTO0.setRecipientAttrName("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel10 = null;
        notificationTO0.setTraceLevel(traceLevel10);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test129");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSender("");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO4 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO4.setTemplate("");
        java.lang.String str7 = notificationTO4.getTemplate();
        java.lang.String str8 = notificationTO4.getSender();
        java.util.List<java.lang.String> strList9 = notificationTO4.getEvents();
        boolean boolean10 = notificationTO4.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel11 = null;
        notificationTO4.setTraceLevel(traceLevel11);
        java.lang.String str13 = notificationTO4.getRecipientAttrName();
        notificationTO4.setRecipientsProvider("");
        boolean boolean16 = notificationTO0.equals((java.lang.Object) "");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "" + "'", str7, "");
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertNotNull(strList9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNull(str13);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test130");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        notificationTO0.setTemplate("");
        boolean boolean9 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel10 = null;
        notificationTO0.setTraceLevel(traceLevel10);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test131");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        java.lang.String str4 = notificationTO0.getKey();
        java.lang.String str5 = notificationTO0.getRecipientAttrName();
        notificationTO0.setRecipientAttrName("hi!");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test132");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.lang.String str5 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test133");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        notificationTO0.setTemplate("");
        boolean boolean9 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel10 = notificationTO0.getTraceLevel();
        notificationTO0.setTemplate("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel13 = null;
        notificationTO0.setTraceLevel(traceLevel13);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNull(traceLevel10);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test134");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO2.setTemplate("");
        java.lang.String str5 = notificationTO2.getTemplate();
        java.lang.String str6 = notificationTO2.getSender();
        java.util.List<java.lang.String> strList7 = notificationTO2.getEvents();
        boolean boolean8 = notificationTO2.isActive();
        java.lang.String str9 = notificationTO2.getRecipientAttrName();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO10 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str11 = notificationTO10.getSender();
        java.lang.String str12 = notificationTO10.getRecipientsProvider();
        java.util.List<java.lang.String> strList13 = notificationTO10.getEvents();
        java.lang.String str14 = notificationTO10.getTemplate();
        java.lang.String str15 = notificationTO10.getSubject();
        boolean boolean16 = notificationTO2.equals((java.lang.Object) str15);
        notificationTO2.setTemplate("");
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNull(str6);
        org.junit.Assert.assertNotNull(strList7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str11);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertNotNull(strList13);
        org.junit.Assert.assertNull(str14);
        org.junit.Assert.assertNull(str15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test135");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getKey();
        java.lang.String str4 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test136");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = notificationTO0.getTraceLevel();
        notificationTO0.setSubject("");
        notificationTO0.setRecipientsFIQL("");
        org.junit.Assert.assertNull(traceLevel5);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test137");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setActive(true);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel9 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertNull(traceLevel9);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test138");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setRecipientsFIQL("hi!");
        boolean boolean3 = notificationTO0.isActive();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test139");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setRecipientsFIQL("hi!");
        java.lang.String str12 = notificationTO0.getRecipientsProvider();
        java.lang.String str13 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertNull(str13);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test140");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        notificationTO0.setTemplate("");
        java.lang.String str8 = notificationTO0.getRecipientsFIQL();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test141");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        boolean boolean1 = notificationTO0.isSelfAsRecipient();
        java.util.List<java.lang.String> strList2 = notificationTO0.getStaticRecipients();
        java.lang.String str3 = notificationTO0.getTemplate();
        notificationTO0.setKey("");
        notificationTO0.setTemplate("hi!");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(strList2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test142");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        java.lang.String str4 = notificationTO0.getRecipientAttrName();
        java.util.List<java.lang.String> strList5 = notificationTO0.getStaticRecipients();
        java.lang.String str6 = notificationTO0.getRecipientsFIQL();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test143");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSubject();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(traceLevel2);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test144");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel3 = null;
        notificationTO0.setTraceLevel(traceLevel3);
        boolean boolean5 = notificationTO0.isActive();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test145");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setSubject("");
        java.lang.String str3 = notificationTO0.getSender();
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test146");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(true);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        notificationTO0.setKey("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel11 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(traceLevel11);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test147");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setSubject("");
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test148");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        java.lang.String str8 = notificationTO0.getSender();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel9 = null;
        notificationTO0.setTraceLevel(traceLevel9);
        java.lang.String str11 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test149");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        boolean boolean7 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel8 = notificationTO0.getTraceLevel();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel9 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(traceLevel8);
        org.junit.Assert.assertNull(traceLevel9);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test150");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(true);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        notificationTO0.setSubject("");
        java.lang.String str11 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setRecipientAttrName("");
        java.lang.String str14 = notificationTO0.getRecipientsFIQL();
        java.lang.String str15 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str11);
        org.junit.Assert.assertNull(str14);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "" + "'", str15, "");
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test151");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList2 = notificationTO0.getStaticRecipients();
        java.lang.String str3 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strList2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test152");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setRecipientsProvider("hi!");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test153");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        boolean boolean2 = notificationTO0.isSelfAsRecipient();
        notificationTO0.setSubject("hi!");
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test154");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        java.lang.String str12 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test155");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setActive(true);
        org.apache.syncope.common.lib.to.NotificationTO notificationTO3 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap4 = notificationTO3.getAbouts();
        boolean boolean5 = notificationTO3.isActive();
        notificationTO3.setRecipientsProvider("hi!");
        boolean boolean8 = notificationTO0.equals((java.lang.Object) notificationTO3);
        notificationTO3.setRecipientsProvider("");
        org.junit.Assert.assertNotNull(strMap4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test156");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setRecipientAttrName("");
        notificationTO0.setSubject("");
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test157");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSender("");
        notificationTO0.setKey("");
        java.util.List<java.lang.String> strList6 = notificationTO0.getEvents();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strList6);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test158");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        boolean boolean3 = notificationTO0.isSelfAsRecipient();
        boolean boolean4 = notificationTO0.isSelfAsRecipient();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test159");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getRecipientAttrName();
        notificationTO0.setRecipientsFIQL("");
        java.lang.String str10 = notificationTO0.getTemplate();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test160");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel3 = null;
        notificationTO0.setTraceLevel(traceLevel3);
        notificationTO0.setKey("");
        java.util.List<java.lang.String> strList7 = notificationTO0.getStaticRecipients();
        org.junit.Assert.assertNotNull(strList7);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test161");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        java.util.Map<java.lang.String, java.lang.String> strMap12 = notificationTO0.getAbouts();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO13 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO13.setTemplate("");
        java.lang.String str16 = notificationTO13.getTemplate();
        java.lang.String str17 = notificationTO13.getSender();
        java.util.List<java.lang.String> strList18 = notificationTO13.getEvents();
        boolean boolean19 = notificationTO13.isActive();
        notificationTO13.setTemplate("");
        boolean boolean22 = notificationTO13.isActive();
        boolean boolean23 = notificationTO0.equals((java.lang.Object) boolean22);
        notificationTO0.setActive(true);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNotNull(strMap12);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
        org.junit.Assert.assertNull(str17);
        org.junit.Assert.assertNotNull(strList18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test162");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setRecipientsFIQL("hi!");
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getKey();
        notificationTO0.setTemplate("");
        notificationTO0.setSender("");
        java.lang.String str9 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test163");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setActive(true);
        notificationTO0.setSender("");
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test164");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        boolean boolean4 = notificationTO0.isActive();
        boolean boolean5 = notificationTO0.isActive();
        java.util.List<java.lang.String> strList6 = notificationTO0.getEvents();
        java.util.Map<java.lang.String, java.lang.String> strMap7 = notificationTO0.getAbouts();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(strList6);
        org.junit.Assert.assertNotNull(strMap7);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test165");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setRecipientsFIQL("hi!");
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getKey();
        notificationTO0.setTemplate("");
        notificationTO0.setKey("");
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test166");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setActive(true);
        notificationTO0.setSelfAsRecipient(true);
        notificationTO0.setActive(true);
        java.lang.Object obj13 = null;
        boolean boolean14 = notificationTO0.equals(obj13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test167");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = null;
        notificationTO0.setTraceLevel(traceLevel4);
        notificationTO0.setActive(false);
        java.util.List<java.lang.String> strList8 = notificationTO0.getEvents();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO9 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str10 = notificationTO9.getSender();
        java.lang.String str11 = notificationTO9.getRecipientsProvider();
        java.util.List<java.lang.String> strList12 = notificationTO9.getEvents();
        notificationTO9.setSubject("hi!");
        notificationTO9.setRecipientsProvider("");
        notificationTO9.setRecipientsProvider("");
        java.util.List<java.lang.String> strList19 = notificationTO9.getEvents();
        boolean boolean20 = notificationTO0.equals((java.lang.Object) notificationTO9);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strList8);
        org.junit.Assert.assertNull(str10);
        org.junit.Assert.assertNull(str11);
        org.junit.Assert.assertNotNull(strList12);
        org.junit.Assert.assertNotNull(strList19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test168");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        boolean boolean1 = notificationTO0.isSelfAsRecipient();
        java.util.List<java.lang.String> strList2 = notificationTO0.getStaticRecipients();
        java.lang.String str3 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList4 = notificationTO0.getEvents();
        boolean boolean5 = notificationTO0.isSelfAsRecipient();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(strList2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNotNull(strList4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test169");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(true);
        java.lang.String str7 = notificationTO0.getRecipientAttrName();
        boolean boolean8 = notificationTO0.isSelfAsRecipient();
        java.lang.String str9 = notificationTO0.getRecipientAttrName();
        java.util.List<java.lang.String> strList10 = notificationTO0.getStaticRecipients();
        notificationTO0.setRecipientsFIQL("");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNotNull(strList10);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test170");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        notificationTO0.setTemplate("");
        java.util.List<java.lang.String> strList9 = notificationTO0.getStaticRecipients();
        notificationTO0.setActive(false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(strList9);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test171");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        java.lang.String str8 = notificationTO0.getSender();
        java.lang.String str9 = notificationTO0.getSender();
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test172");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setTemplate("");
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test173");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        boolean boolean1 = notificationTO0.isSelfAsRecipient();
        java.lang.String str2 = notificationTO0.getKey();
        notificationTO0.setActive(true);
        notificationTO0.setRecipientsFIQL("");
        java.lang.String str7 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test174");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        boolean boolean1 = notificationTO0.isSelfAsRecipient();
        java.lang.String str2 = notificationTO0.getKey();
        notificationTO0.setActive(true);
        notificationTO0.setRecipientsFIQL("");
        notificationTO0.setSelfAsRecipient(true);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel9 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNull(traceLevel9);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test175");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        java.lang.String str2 = notificationTO0.getRecipientAttrName();
        boolean boolean3 = notificationTO0.isActive();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test176");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        notificationTO0.setTemplate("");
        boolean boolean9 = notificationTO0.isActive();
        java.lang.String str10 = notificationTO0.getSubject();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNull(str10);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test177");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        java.lang.String str9 = notificationTO0.getRecipientAttrName();
        notificationTO0.setRecipientsProvider("");
        java.lang.String str12 = notificationTO0.getKey();
        java.util.List<java.lang.String> strList13 = notificationTO0.getStaticRecipients();
        java.lang.String str14 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertNotNull(strList13);
        org.junit.Assert.assertNull(str14);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test178");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setRecipientsFIQL("hi!");
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getKey();
        notificationTO0.setTemplate("");
        java.lang.String str7 = notificationTO0.getSender();
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test179");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        notificationTO0.setTemplate("");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test180");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        java.lang.String str8 = notificationTO0.getSender();
        java.lang.String str9 = notificationTO0.getTemplate();
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test181");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        java.util.Map<java.lang.String, java.lang.String> strMap2 = notificationTO0.getAbouts();
        java.lang.String str3 = notificationTO0.getRecipientsFIQL();
        java.lang.String str4 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = null;
        notificationTO0.setTraceLevel(traceLevel5);
        java.util.List<java.lang.String> strList7 = notificationTO0.getEvents();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(strMap2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList7);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test182");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        boolean boolean3 = notificationTO0.isSelfAsRecipient();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNull(traceLevel4);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test183");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel8 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNull(traceLevel8);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test184");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        notificationTO0.setRecipientsProvider("");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO8 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO8.setTemplate("");
        java.lang.String str11 = notificationTO8.getTemplate();
        java.lang.String str12 = notificationTO8.getSender();
        java.util.List<java.lang.String> strList13 = notificationTO8.getEvents();
        boolean boolean14 = notificationTO8.isActive();
        java.util.List<java.lang.String> strList15 = notificationTO8.getEvents();
        boolean boolean16 = notificationTO8.isActive();
        boolean boolean17 = notificationTO8.isActive();
        boolean boolean18 = notificationTO0.equals((java.lang.Object) boolean17);
        java.lang.String str19 = notificationTO0.getRecipientsFIQL();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertNotNull(strList13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(strList15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(str19);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test185");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        notificationTO0.setRecipientsProvider("");
        notificationTO0.setRecipientsProvider("");
        notificationTO0.setRecipientsProvider("hi!");
        java.util.List<java.lang.String> strList12 = notificationTO0.getStaticRecipients();
        java.lang.String str13 = notificationTO0.getRecipientsFIQL();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel14 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNotNull(strList12);
        org.junit.Assert.assertNull(str13);
        org.junit.Assert.assertNull(traceLevel14);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test186");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setRecipientsProvider("hi!");
        notificationTO0.setActive(true);
        java.lang.String str9 = notificationTO0.getKey();
        notificationTO0.setRecipientsFIQL("hi!");
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test187");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        java.util.Map<java.lang.String, java.lang.String> strMap12 = notificationTO0.getAbouts();
        java.lang.String str13 = notificationTO0.getSender();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNotNull(strMap12);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "hi!" + "'", str13, "hi!");
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test188");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        java.lang.String str2 = notificationTO0.getRecipientAttrName();
        java.lang.String str3 = notificationTO0.getSender();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test189");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        notificationTO0.setTemplate("");
        boolean boolean14 = notificationTO0.isActive();
        notificationTO0.setRecipientAttrName("");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test190");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setSubject("hi!");
        notificationTO0.setTemplate("hi!");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO9 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str10 = notificationTO9.getSender();
        java.lang.String str11 = notificationTO9.getRecipientsProvider();
        java.util.List<java.lang.String> strList12 = notificationTO9.getEvents();
        java.lang.String str13 = notificationTO9.getTemplate();
        notificationTO9.setSelfAsRecipient(true);
        java.lang.String str16 = notificationTO9.getRecipientAttrName();
        boolean boolean17 = notificationTO0.equals((java.lang.Object) notificationTO9);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str10);
        org.junit.Assert.assertNull(str11);
        org.junit.Assert.assertNotNull(strList12);
        org.junit.Assert.assertNull(str13);
        org.junit.Assert.assertNull(str16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test191");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(true);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        java.util.List<java.lang.String> strList9 = notificationTO0.getStaticRecipients();
        notificationTO0.setSubject("");
        java.lang.String str12 = notificationTO0.getRecipientsFIQL();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList9);
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test192");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        notificationTO0.setRecipientsProvider("");
        notificationTO0.setRecipientsProvider("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str12 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "hi!" + "'", str12, "hi!");
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test193");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        boolean boolean2 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel3 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNull(traceLevel3);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test194");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str3 = notificationTO2.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = null;
        notificationTO2.setTraceLevel(traceLevel4);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel6 = null;
        notificationTO2.setTraceLevel(traceLevel6);
        notificationTO2.setActive(false);
        java.util.List<java.lang.String> strList10 = notificationTO2.getEvents();
        notificationTO2.setRecipientsProvider("hi!");
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNotNull(strList10);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test195");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        notificationTO0.setSubject("hi!");
        notificationTO0.setRecipientsProvider("");
        notificationTO0.setRecipientsProvider("");
        notificationTO0.setRecipientsProvider("hi!");
        java.util.List<java.lang.String> strList12 = notificationTO0.getStaticRecipients();
        java.lang.String str13 = notificationTO0.getTemplate();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNotNull(strList12);
        org.junit.Assert.assertNull(str13);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test196");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        boolean boolean4 = notificationTO0.isActive();
        java.util.List<java.lang.String> strList5 = notificationTO0.getStaticRecipients();
        java.lang.String str6 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(false);
        notificationTO0.setSelfAsRecipient(false);
        notificationTO0.setTemplate("hi!");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test197");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getSender();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getTemplate();
        notificationTO0.setSelfAsRecipient(true);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        notificationTO0.setSubject("");
        java.lang.String str11 = notificationTO0.getRecipientsProvider();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test198");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str3 = notificationTO2.getSender();
        java.lang.String str4 = notificationTO2.getRecipientsProvider();
        java.util.List<java.lang.String> strList5 = notificationTO2.getEvents();
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test199");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSubject("");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test200");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        java.util.List<java.lang.String> strList7 = notificationTO0.getEvents();
        boolean boolean8 = notificationTO0.isActive();
        boolean boolean9 = notificationTO0.isActive();
        notificationTO0.setRecipientsFIQL("");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(strList7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test201");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setActive(true);
        org.apache.syncope.common.lib.to.NotificationTO notificationTO3 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap4 = notificationTO3.getAbouts();
        boolean boolean5 = notificationTO3.isActive();
        notificationTO3.setRecipientsProvider("hi!");
        boolean boolean8 = notificationTO0.equals((java.lang.Object) notificationTO3);
        notificationTO3.setSender("hi!");
        org.junit.Assert.assertNotNull(strMap4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test202");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsProvider("hi!");
        java.lang.String str5 = notificationTO0.getSender();
        notificationTO0.setRecipientAttrName("hi!");
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test203");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        java.util.List<java.lang.String> strList5 = notificationTO0.getEvents();
        boolean boolean6 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel7 = null;
        notificationTO0.setTraceLevel(traceLevel7);
        java.lang.String str9 = notificationTO0.getRecipientAttrName();
        notificationTO0.setRecipientsProvider("");
        java.lang.String str12 = notificationTO0.getKey();
        java.util.List<java.lang.String> strList13 = notificationTO0.getStaticRecipients();
        java.lang.String str14 = notificationTO0.getSubject();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(strList5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertNotNull(strList13);
        org.junit.Assert.assertNull(str14);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test204");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        java.lang.String str7 = notificationTO0.getSender();
        notificationTO0.setSender("hi!");
        notificationTO0.setKey("hi!");
        java.util.Map<java.lang.String, java.lang.String> strMap12 = notificationTO0.getAbouts();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO13 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO13.setTemplate("");
        java.lang.String str16 = notificationTO13.getTemplate();
        java.lang.String str17 = notificationTO13.getSender();
        java.util.List<java.lang.String> strList18 = notificationTO13.getEvents();
        boolean boolean19 = notificationTO13.isActive();
        notificationTO13.setTemplate("");
        boolean boolean22 = notificationTO13.isActive();
        boolean boolean23 = notificationTO0.equals((java.lang.Object) boolean22);
        java.lang.String str24 = notificationTO0.getTemplate();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str7);
        org.junit.Assert.assertNotNull(strMap12);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
        org.junit.Assert.assertNull(str17);
        org.junit.Assert.assertNotNull(strList18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "" + "'", str24, "");
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test205");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        boolean boolean2 = notificationTO0.isActive();
        java.util.List<java.lang.String> strList3 = notificationTO0.getStaticRecipients();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strList3);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test206");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.lang.String str1 = notificationTO0.getRecipientAttrName();
        boolean boolean2 = notificationTO0.isActive();
        java.lang.String str3 = notificationTO0.getTemplate();
        notificationTO0.setKey("hi!");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test207");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        boolean boolean2 = notificationTO0.isActive();
        java.util.Map<java.lang.String, java.lang.String> strMap3 = notificationTO0.getAbouts();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(strMap3);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test208");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel2 = null;
        notificationTO0.setTraceLevel(traceLevel2);
        java.lang.String str4 = notificationTO0.getTemplate();
        java.lang.String str5 = notificationTO0.getKey();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NotificationDataBinderImplRandoopRaw0.test209");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setTemplate("");
        java.lang.String str3 = notificationTO0.getTemplate();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setKey("hi!");
        boolean boolean7 = notificationTO0.isActive();
        notificationTO0.setActive(true);
        java.util.List<java.lang.String> strList10 = notificationTO0.getStaticRecipients();
        java.util.List<java.lang.String> strList11 = notificationTO0.getStaticRecipients();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(strList10);
        org.junit.Assert.assertNotNull(strList11);
    }
}

