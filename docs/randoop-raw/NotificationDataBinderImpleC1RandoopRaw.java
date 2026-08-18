package org.apache.syncope.core.provisioning.java.data.c1;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

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
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
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
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        org.apache.syncope.core.persistence.api.entity.Notification notification0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        java.lang.Class<?> wildcardClass1 = notification0.getClass();
        org.junit.Assert.assertNotNull(notification0);
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel3 = null;
        notificationTO2.setTraceLevel(traceLevel3);
        boolean boolean6 = notificationTO2.equals((java.lang.Object) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.lang.String str3 = notificationTO0.getSubject();
        notificationTO0.setRecipientsProvider("hi!");
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl0 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.build();
        org.apache.syncope.core.persistence.api.entity.Notification notification1 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO2 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel3 = null;
        notificationTO2.setTraceLevel(traceLevel3);
        boolean boolean6 = notificationTO2.equals((java.lang.Object) (short) 0);
        java.lang.String str7 = notificationTO2.getRecipientsFIQL();
        notificationTO2.setSelfAsRecipient(false);
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl0.update(notification1, notificationTO2);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.common.lib.SyncopeClientException; message: RequiredValuesMissing [template, events]");
        } catch (org.apache.syncope.common.lib.SyncopeClientException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notificationDataBinderImpl0);
        org.junit.Assert.assertNotNull(notification1);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.lang.String str3 = notificationTO0.getSubject();
        notificationTO0.setRecipientsFIQL("hi!");
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        org.apache.syncope.core.persistence.api.dao.MailTemplateDAO mailTemplateDAO0 = null;
        org.apache.syncope.core.persistence.api.dao.AnyTypeDAO anyTypeDAO1 = null;
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO2 = null;
        org.apache.syncope.core.persistence.api.entity.EntityFactory entityFactory3 = null;
        org.apache.syncope.core.provisioning.api.IntAttrNameParser intAttrNameParser4 = null;
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl5 = new org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl(mailTemplateDAO0, anyTypeDAO1, implementationDAO2, entityFactory3, intAttrNameParser4);
        org.apache.syncope.core.persistence.api.entity.Notification notification6 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.syncope.common.lib.to.NotificationTO notificationTO7 = notificationDataBinderImpl5.getNotificationTO(notification6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.core.persistence.api.entity.MailTemplate.getKey()\" because the return value of \"org.apache.syncope.core.persistence.api.entity.Notification.getTemplate()\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notification6);
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO4 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = null;
        notificationTO4.setTraceLevel(traceLevel5);
        boolean boolean8 = notificationTO4.equals((java.lang.Object) (short) 0);
        java.lang.String str9 = notificationTO4.getRecipientsFIQL();
        notificationTO4.setSelfAsRecipient(false);
        java.lang.String str12 = notificationTO4.getKey();
        boolean boolean13 = notificationTO0.equals((java.lang.Object) notificationTO4);
        java.lang.String str14 = notificationTO0.getTemplate();
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNull(str14);
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        java.lang.String str2 = notificationTO0.getRecipientsFIQL();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test11");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        notificationTO0.setTemplate("");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel4 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNull(traceLevel4);
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test12");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO4 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = null;
        notificationTO4.setTraceLevel(traceLevel5);
        boolean boolean8 = notificationTO4.equals((java.lang.Object) (short) 0);
        java.lang.String str9 = notificationTO4.getRecipientsFIQL();
        notificationTO4.setSelfAsRecipient(false);
        java.lang.String str12 = notificationTO4.getKey();
        boolean boolean13 = notificationTO0.equals((java.lang.Object) notificationTO4);
        java.lang.String str14 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNull(str14);
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test13");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO4 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = null;
        notificationTO4.setTraceLevel(traceLevel5);
        boolean boolean8 = notificationTO4.equals((java.lang.Object) (short) 0);
        java.lang.String str9 = notificationTO4.getRecipientsFIQL();
        notificationTO4.setSelfAsRecipient(false);
        java.lang.String str12 = notificationTO4.getKey();
        boolean boolean13 = notificationTO0.equals((java.lang.Object) notificationTO4);
        notificationTO0.setSelfAsRecipient(true);
        boolean boolean16 = notificationTO0.isActive();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel17 = null;
        notificationTO0.setTraceLevel(traceLevel17);
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test14");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        boolean boolean4 = notificationTO0.equals((java.lang.Object) (short) 0);
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSelfAsRecipient(false);
        java.lang.String str8 = notificationTO0.getKey();
        java.lang.String str9 = notificationTO0.getSender();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test15");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = notificationTO0.getTraceLevel();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        java.lang.String str3 = notificationTO0.getKey();
        java.lang.String str4 = notificationTO0.getSubject();
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        org.junit.Assert.assertNull(traceLevel1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test16");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = notificationTO0.getTraceLevel();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        notificationTO0.setRecipientAttrName("hi!");
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = notificationTO0.getTraceLevel();
        org.junit.Assert.assertNull(traceLevel1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNull(traceLevel5);
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test17");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        boolean boolean4 = notificationTO0.equals((java.lang.Object) (short) 0);
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = null;
        notificationTO0.setTraceLevel(traceLevel5);
        boolean boolean7 = notificationTO0.isSelfAsRecipient();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test18");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.lang.String str3 = notificationTO0.getSubject();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setActive(false);
        notificationTO0.setSubject("");
        java.lang.Class<?> wildcardClass9 = notificationTO0.getClass();
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test19");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        boolean boolean4 = notificationTO0.equals((java.lang.Object) (short) 0);
        java.lang.String str5 = notificationTO0.getKey();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test20");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        notificationTO0.setSender("");
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test21");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        boolean boolean1 = notificationTO0.isSelfAsRecipient();
        notificationTO0.setKey("hi!");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test22");
        org.apache.syncope.core.persistence.api.dao.MailTemplateDAO mailTemplateDAO0 = null;
        org.apache.syncope.core.persistence.api.dao.AnyTypeDAO anyTypeDAO1 = null;
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO2 = null;
        org.apache.syncope.core.persistence.api.entity.EntityFactory entityFactory3 = null;
        org.apache.syncope.core.provisioning.api.IntAttrNameParser intAttrNameParser4 = null;
        org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl notificationDataBinderImpl5 = new org.apache.syncope.core.provisioning.java.data.NotificationDataBinderImpl(mailTemplateDAO0, anyTypeDAO1, implementationDAO2, entityFactory3, intAttrNameParser4);
        org.apache.syncope.core.persistence.api.entity.Notification notification6 = org.apache.syncope.core.provisioning.java.data.randoop.NotificationDataBinderImplRandoopSeeds.notification();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO7 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel8 = null;
        notificationTO7.setTraceLevel(traceLevel8);
        java.lang.String str10 = notificationTO7.getSubject();
        java.lang.String str11 = notificationTO7.getSender();
        notificationTO7.setActive(false);
        // The following exception was thrown during execution in test generation
        try {
            notificationDataBinderImpl5.update(notification6, notificationTO7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.core.persistence.api.dao.MailTemplateDAO.findById(String)\" because \"this.mailTemplateDAO\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(notification6);
        org.junit.Assert.assertNull(str10);
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test23");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        java.lang.String str4 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSubject("");
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test24");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = notificationTO0.getTraceLevel();
        java.util.List<java.lang.String> strList2 = notificationTO0.getStaticRecipients();
        notificationTO0.setKey("hi!");
        org.junit.Assert.assertNull(traceLevel1);
        org.junit.Assert.assertNotNull(strList2);
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test25");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO4 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = null;
        notificationTO4.setTraceLevel(traceLevel5);
        boolean boolean8 = notificationTO4.equals((java.lang.Object) (short) 0);
        java.lang.String str9 = notificationTO4.getRecipientsFIQL();
        notificationTO4.setSelfAsRecipient(false);
        java.lang.String str12 = notificationTO4.getKey();
        boolean boolean13 = notificationTO0.equals((java.lang.Object) notificationTO4);
        notificationTO0.setSelfAsRecipient(true);
        notificationTO0.setSender("");
        notificationTO0.setKey("hi!");
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test26() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test26");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        notificationTO0.setSubject("hi!");
    }

    @Test
    public void test27() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test27");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.lang.String str3 = notificationTO0.getSubject();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setActive(false);
        notificationTO0.setRecipientsFIQL("hi!");
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test28() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test28");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        boolean boolean4 = notificationTO0.equals((java.lang.Object) (short) 0);
        java.lang.String str5 = notificationTO0.getRecipientsFIQL();
        notificationTO0.setSelfAsRecipient(false);
        notificationTO0.setSender("");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test29() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test29");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO4 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = null;
        notificationTO4.setTraceLevel(traceLevel5);
        boolean boolean8 = notificationTO4.equals((java.lang.Object) (short) 0);
        java.lang.String str9 = notificationTO4.getRecipientsFIQL();
        notificationTO4.setSelfAsRecipient(false);
        java.lang.String str12 = notificationTO4.getKey();
        boolean boolean13 = notificationTO0.equals((java.lang.Object) notificationTO4);
        notificationTO0.setSelfAsRecipient(true);
        boolean boolean16 = notificationTO0.isActive();
        java.util.Map<java.lang.String, java.lang.String> strMap17 = notificationTO0.getAbouts();
        java.util.Map<java.lang.String, java.lang.String> strMap18 = notificationTO0.getAbouts();
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(strMap17);
        org.junit.Assert.assertNotNull(strMap18);
    }

    @Test
    public void test30() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test30");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = notificationTO0.getTraceLevel();
        java.lang.String str2 = notificationTO0.getRecipientsProvider();
        notificationTO0.setTemplate("hi!");
        org.junit.Assert.assertNull(traceLevel1);
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test31() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test31");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        java.lang.Class<?> wildcardClass2 = strMap1.getClass();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test32() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test32");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.util.List<java.lang.String> strList3 = notificationTO0.getEvents();
        org.apache.syncope.common.lib.to.NotificationTO notificationTO4 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel5 = null;
        notificationTO4.setTraceLevel(traceLevel5);
        boolean boolean8 = notificationTO4.equals((java.lang.Object) (short) 0);
        java.lang.String str9 = notificationTO4.getRecipientsFIQL();
        notificationTO4.setSelfAsRecipient(false);
        java.lang.String str12 = notificationTO4.getKey();
        boolean boolean13 = notificationTO0.equals((java.lang.Object) notificationTO4);
        notificationTO0.setSelfAsRecipient(true);
        notificationTO0.setSender("");
        notificationTO0.setSubject("");
        notificationTO0.setRecipientsProvider("");
        org.junit.Assert.assertNotNull(strList3);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNull(str9);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test33() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test33");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        java.lang.String str3 = notificationTO0.getSubject();
        java.lang.String str4 = notificationTO0.getSender();
        notificationTO0.setActive(false);
        notificationTO0.setSubject("");
        java.lang.String str9 = notificationTO0.getRecipientAttrName();
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test34() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test34");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        org.apache.syncope.common.lib.types.TraceLevel traceLevel1 = null;
        notificationTO0.setTraceLevel(traceLevel1);
        boolean boolean4 = notificationTO0.equals((java.lang.Object) (short) 0);
        java.util.Map<java.lang.String, java.lang.String> strMap5 = notificationTO0.getAbouts();
        java.lang.String str6 = notificationTO0.getRecipientsProvider();
        notificationTO0.setSelfAsRecipient(true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(strMap5);
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test35() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test35");
        org.apache.syncope.common.lib.to.NotificationTO notificationTO0 = new org.apache.syncope.common.lib.to.NotificationTO();
        java.util.Map<java.lang.String, java.lang.String> strMap1 = notificationTO0.getAbouts();
        notificationTO0.setTemplate("");
        notificationTO0.setRecipientsFIQL("");
        org.junit.Assert.assertNotNull(strMap1);
    }
}

