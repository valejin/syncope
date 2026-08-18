package org.apache.syncope.core.logic.c1;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommandLogicC1RandoopTest0 {

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
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test01");
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO0 = null;
        jakarta.validation.Validator validator1 = null;
        org.apache.syncope.core.logic.CommandLogic commandLogic2 = new org.apache.syncope.core.logic.CommandLogic(implementationDAO0, validator1);
        org.apache.syncope.common.lib.command.CommandTO commandTO3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = commandLogic2.run(commandTO3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.common.lib.command.CommandTO.getKey()\" because \"command\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test02");
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO0 = null;
        jakarta.validation.Validator validator1 = null;
        org.apache.syncope.core.logic.CommandLogic commandLogic2 = new org.apache.syncope.core.logic.CommandLogic(implementationDAO0, validator1);
        java.lang.Class<?> wildcardClass3 = commandLogic2.getClass();
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test03");
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO0 = null;
        jakarta.validation.Validator validator1 = null;
        org.apache.syncope.core.logic.CommandLogic commandLogic2 = new org.apache.syncope.core.logic.CommandLogic(implementationDAO0, validator1);
        org.springframework.data.domain.Pageable pageable4 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage5 = commandLogic2.search("", pageable4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.core.persistence.api.dao.ImplementationDAO.findByTypeAndKeyword(String, String)\" because \"this.implementationDAO\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageable4);
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test04");
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO0 = null;
        jakarta.validation.Validator validator1 = null;
        org.apache.syncope.core.logic.CommandLogic commandLogic2 = new org.apache.syncope.core.logic.CommandLogic(implementationDAO0, validator1);
        org.springframework.data.domain.Pageable pageable4 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage5 = commandLogic2.search("hi!", pageable4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.core.persistence.api.dao.ImplementationDAO.findByTypeAndKeyword(String, String)\" because \"this.implementationDAO\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageable4);
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test05");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = commandTO0.getArgs();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass3 = commandArgs2.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"Object.getClass()\" because \"o\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(commandArgs2);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test06");
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO0 = null;
        jakarta.validation.Validator validator1 = null;
        org.apache.syncope.core.logic.CommandLogic commandLogic2 = new org.apache.syncope.core.logic.CommandLogic(implementationDAO0, validator1);
        org.apache.syncope.common.lib.command.CommandTO commandTO3 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO3.setKey("hi!");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str6 = commandLogic2.run(commandTO3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.core.persistence.api.dao.ImplementationDAO.findById(String)\" because \"this.implementationDAO\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test07");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.String str1 = commandTO0.getKey();
        commandTO0.setKey("");
        commandTO0.setKey("");
        java.lang.Class<?> wildcardClass6 = commandTO0.getClass();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test08");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("");
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test09");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        java.lang.String str2 = commandTO0.getKey();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = commandTO0.getArgs();
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(str2);
        org.junit.Assert.assertNull(commandArgs3);
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test10");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("hi!");
        java.lang.String str3 = commandTO0.getKey();
        java.lang.String str4 = commandTO0.getKey();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "hi!" + "'", str4, "hi!");
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test11");
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO0 = null;
        jakarta.validation.Validator validator1 = null;
        org.apache.syncope.core.logic.CommandLogic commandLogic2 = new org.apache.syncope.core.logic.CommandLogic(implementationDAO0, validator1);
        org.apache.syncope.common.lib.command.CommandTO commandTO3 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO3.setKey("hi!");
        commandTO3.setKey("hi!");
        commandTO3.setKey("");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str10 = commandLogic2.run(commandTO3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.core.persistence.api.dao.ImplementationDAO.findById(String)\" because \"this.implementationDAO\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test12");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.String str2 = commandTO1.getKey();
        commandTO1.setKey("");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = commandLogic0.run(commandTO1);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation ");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test13");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("hi!");
        commandTO0.setKey("hi!");
        commandTO0.setKey("");
        java.lang.Class<?> wildcardClass7 = commandTO0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test14");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.String str2 = commandTO1.getKey();
        commandTO1.setKey("");
        commandTO1.setKey("");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str7 = commandLogic0.run(commandTO1);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation ");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test15");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = new org.apache.syncope.common.lib.command.CommandTO();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str2 = commandLogic0.run(commandTO1);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation null");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test16");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.String str2 = commandTO1.getKey();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = commandLogic0.run(commandTO1);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation null");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test17");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
        org.springframework.data.domain.Pageable pageable5 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", pageable5);
        org.apache.syncope.common.lib.command.CommandTO commandTO7 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO7.setKey("hi!");
        java.lang.String str10 = commandTO7.getKey();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str11 = commandLogic0.run(commandTO7);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation hi!");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageable2);
        org.junit.Assert.assertNotNull(commandTOPage3);
        org.junit.Assert.assertNotNull(pageable5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test18");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        java.lang.String str2 = commandTO0.getKey();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = null;
        commandTO0.setArgs(commandArgs3);
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test19");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.String str1 = commandTO0.getKey();
        commandTO0.setKey("");
        java.lang.String str4 = commandTO0.getKey();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test20");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("hi!");
        commandTO0.setKey("hi!");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = commandTO0.getArgs();
        org.junit.Assert.assertNull(commandArgs5);
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test21");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.String str1 = commandTO0.getKey();
        commandTO0.setKey("");
        commandTO0.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = null;
        commandTO0.setArgs(commandArgs6);
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test22");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        commandTO0.setArgs(commandArgs2);
        java.lang.Class<?> wildcardClass4 = commandTO0.getClass();
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test23");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass2 = commandArgs1.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"Object.getClass()\" because \"o\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(commandArgs1);
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test24");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.String str1 = commandTO0.getKey();
        java.lang.String str2 = commandTO0.getKey();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test25");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("hi!");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs4 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder5 = builder3.args(commandArgs4);
        java.lang.Class<?> wildcardClass6 = builder3.getClass();
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test26() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test26");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = commandTO0.getArgs();
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(commandArgs2);
        org.junit.Assert.assertNull(commandArgs3);
    }

    @Test
    public void test27() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test27");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        commandTO0.setArgs(commandArgs2);
        commandTO0.setKey("hi!");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = commandTO0.getArgs();
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(commandArgs6);
    }

    @Test
    public void test28() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test28");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("hi!");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs4 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder5 = builder3.args(commandArgs4);
        org.apache.syncope.common.lib.command.CommandTO commandTO6 = builder5.build();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs7 = null;
        commandTO6.setArgs(commandArgs7);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(commandTO6);
    }

    @Test
    public void test29() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test29");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.String str1 = commandTO0.getKey();
        commandTO0.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs4 = null;
        commandTO0.setArgs(commandArgs4);
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test30() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test30");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("hi!");
        commandTO0.setKey("hi!");
        commandTO0.setKey("");
        commandTO0.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs9 = null;
        commandTO0.setArgs(commandArgs9);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs11 = commandTO0.getArgs();
        org.junit.Assert.assertNull(commandArgs11);
    }

    @Test
    public void test31() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test31");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("hi!");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder3.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO5 = builder3.build();
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(commandTO4);
        org.junit.Assert.assertNotNull(commandTO5);
    }

    @Test
    public void test32() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test32");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
        org.springframework.data.domain.Pageable pageable5 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", pageable5);
        org.apache.syncope.core.logic.CommandLogic commandLogic8 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable10 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic8.search("", pageable10);
        org.springframework.data.domain.Pageable pageable13 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic8.search("", pageable13);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage15 = commandLogic0.search("hi!", pageable13);
        org.apache.syncope.core.logic.CommandLogic commandLogic17 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable19 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage20 = commandLogic17.search("", pageable19);
        org.springframework.data.domain.Pageable pageable22 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage23 = commandLogic17.search("", pageable22);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage24 = commandLogic0.search("hi!", pageable22);
        org.apache.syncope.common.lib.command.CommandTO commandTO25 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO25.setKey("hi!");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str28 = commandLogic0.run(commandTO25);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation hi!");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageable2);
        org.junit.Assert.assertNotNull(commandTOPage3);
        org.junit.Assert.assertNotNull(pageable5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(commandLogic8);
        org.junit.Assert.assertNotNull(pageable10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(pageable13);
        org.junit.Assert.assertNotNull(commandTOPage14);
        org.junit.Assert.assertNotNull(commandTOPage15);
        org.junit.Assert.assertNotNull(commandLogic17);
        org.junit.Assert.assertNotNull(pageable19);
        org.junit.Assert.assertNotNull(commandTOPage20);
        org.junit.Assert.assertNotNull(pageable22);
        org.junit.Assert.assertNotNull(commandTOPage23);
        org.junit.Assert.assertNotNull(commandTOPage24);
    }

    @Test
    public void test33() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test33");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
        org.springframework.data.domain.Pageable pageable5 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", pageable5);
        java.lang.Class<?> wildcardClass7 = commandLogic0.getClass();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageable2);
        org.junit.Assert.assertNotNull(commandTOPage3);
        org.junit.Assert.assertNotNull(pageable5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test34() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test34");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO1.setKey("hi!");
        commandTO1.setKey("hi!");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = null;
        commandTO1.setArgs(commandArgs6);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = commandLogic0.run(commandTO1);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation hi!");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
    }

    @Test
    public void test35() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test35");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
        org.apache.syncope.core.logic.CommandLogic commandLogic5 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable7 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage8 = commandLogic5.search("", pageable7);
        org.springframework.data.domain.Pageable pageable10 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic5.search("", pageable10);
        org.apache.syncope.core.logic.CommandLogic commandLogic13 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable15 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage16 = commandLogic13.search("", pageable15);
        org.springframework.data.domain.Pageable pageable18 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage19 = commandLogic13.search("", pageable18);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage20 = commandLogic5.search("hi!", pageable18);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage21 = commandLogic0.search("hi!", pageable18);
        java.lang.Class<?> wildcardClass22 = pageable18.getClass();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageable2);
        org.junit.Assert.assertNotNull(commandTOPage3);
        org.junit.Assert.assertNotNull(commandLogic5);
        org.junit.Assert.assertNotNull(pageable7);
        org.junit.Assert.assertNotNull(commandTOPage8);
        org.junit.Assert.assertNotNull(pageable10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(commandLogic13);
        org.junit.Assert.assertNotNull(pageable15);
        org.junit.Assert.assertNotNull(commandTOPage16);
        org.junit.Assert.assertNotNull(pageable18);
        org.junit.Assert.assertNotNull(commandTOPage19);
        org.junit.Assert.assertNotNull(commandTOPage20);
        org.junit.Assert.assertNotNull(commandTOPage21);
        org.junit.Assert.assertNotNull(wildcardClass22);
    }

    @Test
    public void test36() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test36");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
        org.springframework.data.domain.Pageable pageable5 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", pageable5);
        org.apache.syncope.core.logic.CommandLogic commandLogic8 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable10 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic8.search("", pageable10);
        org.springframework.data.domain.Pageable pageable13 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic8.search("", pageable13);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage15 = commandLogic0.search("hi!", pageable13);
        org.apache.syncope.core.logic.CommandLogic commandLogic17 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable19 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage20 = commandLogic17.search("", pageable19);
        org.springframework.data.domain.Pageable pageable22 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage23 = commandLogic17.search("", pageable22);
        org.apache.syncope.core.logic.CommandLogic commandLogic25 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable27 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage28 = commandLogic25.search("", pageable27);
        org.springframework.data.domain.Pageable pageable30 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage31 = commandLogic25.search("", pageable30);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage32 = commandLogic17.search("hi!", pageable30);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage33 = commandLogic0.search("hi!", pageable30);
        java.lang.Class<?> wildcardClass34 = commandTOPage33.getClass();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageable2);
        org.junit.Assert.assertNotNull(commandTOPage3);
        org.junit.Assert.assertNotNull(pageable5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(commandLogic8);
        org.junit.Assert.assertNotNull(pageable10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(pageable13);
        org.junit.Assert.assertNotNull(commandTOPage14);
        org.junit.Assert.assertNotNull(commandTOPage15);
        org.junit.Assert.assertNotNull(commandLogic17);
        org.junit.Assert.assertNotNull(pageable19);
        org.junit.Assert.assertNotNull(commandTOPage20);
        org.junit.Assert.assertNotNull(pageable22);
        org.junit.Assert.assertNotNull(commandTOPage23);
        org.junit.Assert.assertNotNull(commandLogic25);
        org.junit.Assert.assertNotNull(pageable27);
        org.junit.Assert.assertNotNull(commandTOPage28);
        org.junit.Assert.assertNotNull(pageable30);
        org.junit.Assert.assertNotNull(commandTOPage31);
        org.junit.Assert.assertNotNull(commandTOPage32);
        org.junit.Assert.assertNotNull(commandTOPage33);
        org.junit.Assert.assertNotNull(wildcardClass34);
    }

    @Test
    public void test37() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test37");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("hi!");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder1.build();
        java.lang.Class<?> wildcardClass5 = builder1.getClass();
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(commandTO4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test38() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test38");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("hi!");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = commandTO0.getArgs();
        org.junit.Assert.assertNull(commandArgs3);
    }

    @Test
    public void test39() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test39");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
        org.springframework.data.domain.Pageable pageable5 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", pageable5);
        org.apache.syncope.core.logic.CommandLogic commandLogic8 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable10 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic8.search("", pageable10);
        org.springframework.data.domain.Pageable pageable13 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic8.search("", pageable13);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage15 = commandLogic0.search("hi!", pageable13);
        org.apache.syncope.common.lib.command.CommandTO commandTO16 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO16.setKey("hi!");
        commandTO16.setKey("hi!");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str21 = commandLogic0.run(commandTO16);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation hi!");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageable2);
        org.junit.Assert.assertNotNull(commandTOPage3);
        org.junit.Assert.assertNotNull(pageable5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(commandLogic8);
        org.junit.Assert.assertNotNull(pageable10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(pageable13);
        org.junit.Assert.assertNotNull(commandTOPage14);
        org.junit.Assert.assertNotNull(commandTOPage15);
    }

    @Test
    public void test40() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test40");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("hi!");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder1.build();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = null;
        commandTO4.setArgs(commandArgs5);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(commandTO4);
    }

    @Test
    public void test41() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test41");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = null;
        commandTO0.setArgs(commandArgs3);
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(commandArgs2);
    }

    @Test
    public void test42() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test42");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        java.lang.Class<?> wildcardClass1 = commandLogic0.getClass();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test43() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test43");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        commandTO0.setArgs(commandArgs2);
        commandTO0.setKey("");
        commandTO0.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs8 = commandTO0.getArgs();
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(commandArgs8);
    }

    @Test
    public void test44() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test44");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = commandTO4.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = null;
        commandTO4.setArgs(commandArgs6);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = commandLogic0.run(commandTO4);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation null");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageable2);
        org.junit.Assert.assertNotNull(commandTOPage3);
        org.junit.Assert.assertNull(commandArgs5);
    }

    @Test
    public void test45() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test45");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        commandTO0.setArgs(commandArgs2);
        commandTO0.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = commandTO0.getArgs();
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(commandArgs6);
    }

    @Test
    public void test46() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test46");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        java.lang.Class<?> wildcardClass2 = commandTO0.getClass();
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test47() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test47");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.Class<?> wildcardClass1 = commandTO0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test48() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test48");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.String str1 = commandTO0.getKey();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        commandTO0.setArgs(commandArgs2);
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test49() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test49");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
        org.springframework.data.domain.Pageable pageable5 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", pageable5);
        org.apache.syncope.core.logic.CommandLogic commandLogic8 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable10 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic8.search("", pageable10);
        org.springframework.data.domain.Pageable pageable13 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic8.search("", pageable13);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage15 = commandLogic0.search("hi!", pageable13);
        org.apache.syncope.core.logic.CommandLogic commandLogic17 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable19 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage20 = commandLogic17.search("", pageable19);
        org.springframework.data.domain.Pageable pageable22 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage23 = commandLogic17.search("", pageable22);
        org.apache.syncope.core.logic.CommandLogic commandLogic25 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable27 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage28 = commandLogic25.search("", pageable27);
        org.springframework.data.domain.Pageable pageable30 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage31 = commandLogic25.search("", pageable30);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage32 = commandLogic17.search("hi!", pageable30);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage33 = commandLogic0.search("hi!", pageable30);
        org.springframework.data.domain.Pageable pageable35 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage36 = commandLogic0.search("", pageable35);
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageable2);
        org.junit.Assert.assertNotNull(commandTOPage3);
        org.junit.Assert.assertNotNull(pageable5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(commandLogic8);
        org.junit.Assert.assertNotNull(pageable10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(pageable13);
        org.junit.Assert.assertNotNull(commandTOPage14);
        org.junit.Assert.assertNotNull(commandTOPage15);
        org.junit.Assert.assertNotNull(commandLogic17);
        org.junit.Assert.assertNotNull(pageable19);
        org.junit.Assert.assertNotNull(commandTOPage20);
        org.junit.Assert.assertNotNull(pageable22);
        org.junit.Assert.assertNotNull(commandTOPage23);
        org.junit.Assert.assertNotNull(commandLogic25);
        org.junit.Assert.assertNotNull(pageable27);
        org.junit.Assert.assertNotNull(commandTOPage28);
        org.junit.Assert.assertNotNull(pageable30);
        org.junit.Assert.assertNotNull(commandTOPage31);
        org.junit.Assert.assertNotNull(commandTOPage32);
        org.junit.Assert.assertNotNull(commandTOPage33);
        org.junit.Assert.assertNotNull(pageable35);
        org.junit.Assert.assertNotNull(commandTOPage36);
    }

    @Test
    public void test50() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test50");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
        org.springframework.data.domain.Pageable pageable5 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", pageable5);
        org.apache.syncope.core.logic.CommandLogic commandLogic8 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable10 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic8.search("", pageable10);
        org.springframework.data.domain.Pageable pageable13 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic8.search("", pageable13);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage15 = commandLogic0.search("hi!", pageable13);
        org.apache.syncope.common.lib.command.CommandTO commandTO16 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO16.setKey("hi!");
        commandTO16.setKey("hi!");
        commandTO16.setKey("");
        commandTO16.setKey("");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str25 = commandLogic0.run(commandTO16);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation ");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageable2);
        org.junit.Assert.assertNotNull(commandTOPage3);
        org.junit.Assert.assertNotNull(pageable5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(commandLogic8);
        org.junit.Assert.assertNotNull(pageable10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(pageable13);
        org.junit.Assert.assertNotNull(commandTOPage14);
        org.junit.Assert.assertNotNull(commandTOPage15);
    }

    @Test
    public void test51() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest0.test51");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = commandTO0.getArgs();
        commandTO0.setKey("hi!");
        commandTO0.setKey("");
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(commandArgs2);
    }
}

