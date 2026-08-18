package org.apache.syncope.core.logic.c1;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Randoop C1-CommandLogic, seconda run (con --testclass=CommandTO aggiunto per
 * costruire un CommandTO reale, invece che sempre null, così da raggiungere
 * NotFoundException reale in run().
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class CommandLogicC1RandoopTest {

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
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test01");
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO0 = null;
        jakarta.validation.Validator validator1 = null;
        org.apache.syncope.core.logic.CommandLogic commandLogic2 = new org.apache.syncope.core.logic.CommandLogic(implementationDAO0, validator1);
        org.apache.syncope.common.lib.command.CommandTO commandTO3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = commandLogic2.run(commandTO3);
            org.junit.jupiter.api.Assertions.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.common.lib.command.CommandTO.getKey()\" because \"command\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test02");
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO0 = null;
        jakarta.validation.Validator validator1 = null;
        org.apache.syncope.core.logic.CommandLogic commandLogic2 = new org.apache.syncope.core.logic.CommandLogic(implementationDAO0, validator1);
        java.lang.Class<?> wildcardClass3 = commandLogic2.getClass();
        org.junit.jupiter.api.Assertions.assertNotNull(wildcardClass3);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test03");
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO0 = null;
        jakarta.validation.Validator validator1 = null;
        org.apache.syncope.core.logic.CommandLogic commandLogic2 = new org.apache.syncope.core.logic.CommandLogic(implementationDAO0, validator1);
        org.springframework.data.domain.Pageable pageable4 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage5 = commandLogic2.search("", pageable4);
            org.junit.jupiter.api.Assertions.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.core.persistence.api.dao.ImplementationDAO.findByTypeAndKeyword(String, String)\" because \"this.implementationDAO\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.jupiter.api.Assertions.assertNotNull(pageable4);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test06");
        org.apache.syncope.core.persistence.api.dao.ImplementationDAO implementationDAO0 = null;
        jakarta.validation.Validator validator1 = null;
        org.apache.syncope.core.logic.CommandLogic commandLogic2 = new org.apache.syncope.core.logic.CommandLogic(implementationDAO0, validator1);
        org.apache.syncope.common.lib.command.CommandTO commandTO3 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO3.setKey("hi!");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str6 = commandLogic2.run(commandTO3);
            org.junit.jupiter.api.Assertions.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.core.persistence.api.dao.ImplementationDAO.findById(String)\" because \"this.implementationDAO\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test12");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = new org.apache.syncope.common.lib.command.CommandTO();
        java.lang.String str2 = commandTO1.getKey();
        commandTO1.setKey("");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = commandLogic0.run(commandTO1);
            org.junit.jupiter.api.Assertions.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation ");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic0);
        org.junit.jupiter.api.Assertions.assertNull(str2);
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test15");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = new org.apache.syncope.common.lib.command.CommandTO();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str2 = commandLogic0.run(commandTO1);
            org.junit.jupiter.api.Assertions.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation null");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic0);
    }

    @Test
    public void test33() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test33");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
        org.springframework.data.domain.Pageable pageable5 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", pageable5);
        java.lang.Class<?> wildcardClass7 = commandLogic0.getClass();
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic0);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable2);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage3);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable5);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage6);
        org.junit.jupiter.api.Assertions.assertNotNull(wildcardClass7);
    }

    @Test
    public void test34() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test34");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO1.setKey("hi!");
        commandTO1.setKey("hi!");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = null;
        commandTO1.setArgs(commandArgs6);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = commandLogic0.run(commandTO1);
            org.junit.jupiter.api.Assertions.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation hi!");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic0);
    }

    @Test
    public void test35() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test35");
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
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic0);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable2);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage3);
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic5);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable7);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage8);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable10);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage11);
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic13);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable15);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage16);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable18);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage19);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage20);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage21);
        org.junit.jupiter.api.Assertions.assertNotNull(wildcardClass22);
    }

    @Test
    public void test36() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test36");
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
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic0);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable2);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage3);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable5);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage6);
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic8);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable10);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage11);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable13);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage14);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage15);
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic17);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable19);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage20);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable22);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage23);
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic25);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable27);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage28);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable30);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage31);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage32);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage33);
        org.junit.jupiter.api.Assertions.assertNotNull(wildcardClass34);
    }

    @Test
    public void test42() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test42");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        java.lang.Class<?> wildcardClass1 = commandLogic0.getClass();
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic0);
        org.junit.jupiter.api.Assertions.assertNotNull(wildcardClass1);
    }

    @Test
    public void test49() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicC1RandoopTest.test49");
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
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic0);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable2);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage3);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable5);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage6);
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic8);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable10);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage11);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable13);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage14);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage15);
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic17);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable19);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage20);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable22);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage23);
        org.junit.jupiter.api.Assertions.assertNotNull(commandLogic25);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable27);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage28);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable30);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage31);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage32);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage33);
        org.junit.jupiter.api.Assertions.assertNotNull(pageable35);
        org.junit.jupiter.api.Assertions.assertNotNull(commandTOPage36);
    }

}