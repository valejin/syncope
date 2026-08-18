import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommandLogicRandoopRaw0 {

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
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test001");
        org.springframework.data.domain.Sort sort2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.of((-1), (int) (short) -1, sort2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page index must not be less than zero");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test002");
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page size must not be less than one");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test003");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        java.lang.Class<?> wildcardClass1 = commandLogic0.getClass();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test004");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray3 = new java.lang.String[] {};
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of((int) (byte) 0, (int) (short) 1, direction2, strArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertArrayEquals(strArray3, new java.lang.String[] {});
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test005");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("hi!", pageable2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.springframework.data.domain.Pageable.getPageSize()\" because \"pageable\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test006");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.Pageable pageable2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage3 = commandLogic0.search("", pageable2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.springframework.data.domain.Pageable.getPageSize()\" because \"pageable\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test007");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str2 = commandLogic0.run(commandTO1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.syncope.common.lib.command.CommandTO.getKey()\" because \"command\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test008");
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
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test009");
        org.springframework.data.domain.Sort sort2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.of((int) '#', (int) (byte) 0, sort2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page size must not be less than one");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test010");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        org.springframework.data.domain.Sort.Direction direction3 = null;
        java.lang.String[] strArray9 = new java.lang.String[] { "hi!", "", "hi!", "", "hi!" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest10 = pageRequest1.withSort(direction3, strArray9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new java.lang.String[] { "hi!", "", "hi!", "", "hi!" });
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test011");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.withPage((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page index must not be less than zero");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest2);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test012");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        boolean boolean3 = pageRequest2.hasPrevious();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test013");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = commandTO1.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = null;
        commandTO1.setArgs(commandArgs3);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = commandLogic0.run(commandTO1);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation null");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNull(commandArgs2);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test014");
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) 'a', (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page size must not be less than one");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test015");
        org.springframework.data.domain.Sort sort2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.of((-1), (int) 'a', sort2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page index must not be less than zero");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test016");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        boolean boolean2 = pageRequest1.isUnpaged();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test017");
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (short) 1, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page size must not be less than one");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test018");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean3 = pageRequest2.isUnpaged();
        org.springframework.data.domain.Sort sort4 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.withSort(sort4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Sort must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test019");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        org.springframework.data.domain.Sort.Direction direction4 = null;
        java.lang.String[] strArray9 = new java.lang.String[] { "hi!", "", "hi!", "hi!" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest10 = pageRequest1.withSort(direction4, strArray9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new java.lang.String[] { "hi!", "", "hi!", "hi!" });
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test020");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest2.toScrollPosition();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test021");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray8 = new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "hi!", "", "Page request [number: 100, size 10, sort: UNSORTED]", "hi!" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest9 = org.springframework.data.domain.PageRequest.of(0, (int) (short) 100, direction2, strArray8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertArrayEquals(strArray8, new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "hi!", "", "Page request [number: 100, size 10, sort: UNSORTED]", "hi!" });
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test022");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean5 = pageRequest4.isUnpaged();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest4);
        org.apache.syncope.common.lib.command.CommandTO commandTO7 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO7.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs10 = null;
        commandTO7.setArgs(commandArgs10);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs12 = null;
        commandTO7.setArgs(commandArgs12);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str14 = commandLogic0.run(commandTO7);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation ");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(commandTOPage6);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test023");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        java.lang.Class<?> wildcardClass3 = pageRequest2.getClass();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test024");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray4 = new java.lang.String[] { "hi!" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest5 = org.springframework.data.domain.PageRequest.of(10, (int) (short) 100, direction2, strArray4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertArrayEquals(strArray4, new java.lang.String[] { "hi!" });
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test025");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest2.previous();
        int int4 = pageRequest3.getPageNumber();
        boolean boolean5 = pageRequest3.hasPrevious();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 99 + "'", int4 == 99);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test026");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional4 = pageRequest2.toOptional();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest2.toScrollPosition();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertNotNull(pageableOptional4);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test027");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest4.toScrollPosition();
        org.springframework.data.domain.Sort.Direction direction6 = null;
        java.lang.String[] strArray11 = new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "hi!", "hi!", "" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest12 = pageRequest4.withSort(direction6, strArray11);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertArrayEquals(strArray11, new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "hi!", "hi!", "" });
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test028");
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Sort sort6 = pageRequest3.getSort();
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest7 = org.springframework.data.domain.PageRequest.of((int) (byte) 10, (int) (short) 0, sort6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page size must not be less than one");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(sort6);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test029");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest2.toScrollPosition();
        java.lang.Class<?> wildcardClass4 = pageRequest2.getClass();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test030");
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Sort sort6 = pageRequest3.getSort();
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest7 = org.springframework.data.domain.PageRequest.of((int) (short) 100, 0, sort6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page size must not be less than one");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(sort6);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test031");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest2 = pageRequest1.previous();
        java.lang.String str3 = pageRequest2.toString();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str3, "Page request [number: 0, size 10, sort: UNSORTED]");
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test032");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean5 = pageRequest4.isUnpaged();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest4);
        org.apache.syncope.common.lib.command.CommandTO commandTO7 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO7.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs10 = null;
        commandTO7.setArgs(commandArgs10);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs12 = null;
        commandTO7.setArgs(commandArgs12);
        commandTO7.setKey("");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str16 = commandLogic0.run(commandTO7);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation ");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(commandTOPage6);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test033");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        java.lang.String str4 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest1.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest1.first();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest7);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test034");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest2.previous();
        long long4 = pageRequest2.getOffset();
        int int5 = pageRequest2.getPageNumber();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 1000L + "'", long4 == 1000L);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test035");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        int int4 = pageRequest2.getPageSize();
        int int5 = pageRequest2.getPageNumber();
        boolean boolean6 = pageRequest2.isUnpaged();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test036");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("");
        org.apache.syncope.common.lib.command.CommandTO commandTO2 = builder1.build();
        java.lang.Class<?> wildcardClass3 = commandTO2.getClass();
        org.junit.Assert.assertNotNull(commandTO2);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test037");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.Limit limit4 = pageRequest2.toLimit();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.first();
        org.springframework.data.domain.Sort.Direction direction6 = null;
        java.lang.String[] strArray11 = new java.lang.String[] { "Page request [number: 0, size 10, sort: UNSORTED]", "hi!", "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest12 = pageRequest5.withSort(direction6, strArray11);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(limit4);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertArrayEquals(strArray11, new java.lang.String[] { "Page request [number: 0, size 10, sort: UNSORTED]", "hi!", "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]" });
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test038");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        org.springframework.data.domain.Pageable pageable3 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        boolean boolean4 = pageRequest2.equals((java.lang.Object) pageable3);
        org.springframework.data.domain.Sort sort5 = pageRequest2.getSort();
        org.springframework.data.domain.PageRequest pageRequest7 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long8 = pageRequest7.getOffset();
        int int9 = pageRequest7.getPageNumber();
        boolean boolean10 = pageRequest2.equals((java.lang.Object) int9);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageable3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(sort5);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test039");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest2 = pageRequest1.previous();
        java.lang.String str3 = pageRequest1.toString();
        java.lang.String str4 = pageRequest1.toString();
        boolean boolean5 = pageRequest1.isUnpaged();
        org.springframework.data.domain.Sort.Direction direction6 = null;
        java.lang.String[] strArray10 = new java.lang.String[] { "hi!", "", "" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest11 = pageRequest1.withSort(direction6, strArray10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str3, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertArrayEquals(strArray10, new java.lang.String[] { "hi!", "", "" });
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test040");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        int int5 = pageRequest4.getPageNumber();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 101 + "'", int5 == 101);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test041");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest2.previous();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test042");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        boolean boolean5 = pageRequest1.equals((java.lang.Object) 100.0f);
        boolean boolean6 = pageRequest1.isPaged();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test043");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("Page request [number: 0, size 10, sort: UNSORTED]");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder1.build();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = commandTO4.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = null;
        commandTO4.setArgs(commandArgs6);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(commandTO4);
        org.junit.Assert.assertNull(commandArgs5);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test044");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray5 = new java.lang.String[] { "", "" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest6 = org.springframework.data.domain.PageRequest.of((int) (short) 100, (int) ' ', direction2, strArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new java.lang.String[] { "", "" });
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test045");
        org.springframework.data.domain.PageRequest pageRequest6 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        org.springframework.data.domain.Pageable pageable7 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        boolean boolean8 = pageRequest6.equals((java.lang.Object) pageable7);
        org.springframework.data.domain.Sort sort9 = pageRequest6.getSort();
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of((int) '#', (int) (short) 100, sort9);
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest11 = org.springframework.data.domain.PageRequest.of((int) (short) -1, 1, sort9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page index must not be less than zero");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageable7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(sort9);
        org.junit.Assert.assertNotNull(pageRequest10);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test046");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest3);
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest3.previous();
        org.springframework.data.domain.Pageable pageable8 = pageRequest3.previousOrFirst();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional9 = pageable8.toOptional();
        java.lang.Class<?> wildcardClass10 = pageable8.getClass();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertNotNull(pageable8);
        org.junit.Assert.assertNotNull(pageableOptional9);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test047");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray3 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of((int) (short) 100, (-1), direction2, strArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test048");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.Sort.Direction direction3 = null;
        java.lang.String[] strArray10 = new java.lang.String[] { "", "hi!", "Page request [number: 0, size 10, sort: UNSORTED]", "", "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest11 = pageRequest2.withSort(direction3, strArray10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertArrayEquals(strArray10, new java.lang.String[] { "", "hi!", "Page request [number: 0, size 10, sort: UNSORTED]", "", "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]" });
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test049");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        int int4 = pageRequest2.getPageSize();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest2.toScrollPosition();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.next();
        int int7 = pageRequest6.getPageSize();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 10 + "'", int7 == 10);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test050");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest2.previous();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition4 = pageRequest3.toScrollPosition();
        org.springframework.data.domain.Limit limit5 = pageRequest3.toLimit();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(offsetScrollPosition4);
        org.junit.Assert.assertNotNull(limit5);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test051");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest3);
        int int7 = pageRequest3.getPageSize();
        boolean boolean8 = pageRequest3.isPaged();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 10 + "'", int7 == 10);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test052");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray9 = new java.lang.String[] { "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]", "", "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]", "hi!" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of(1, (int) ' ', direction2, strArray9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new java.lang.String[] { "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]", "", "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]", "hi!" });
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test053");
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) -1, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page index must not be less than zero");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test054");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray6 = new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]", "hi!" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest7 = org.springframework.data.domain.PageRequest.of((int) (short) 1, 0, direction2, strArray6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray6);
        org.junit.Assert.assertArrayEquals(strArray6, new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]", "hi!" });
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test055");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean3 = pageRequest2.isUnpaged();
        int int4 = pageRequest2.getPageNumber();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 100 + "'", int4 == 100);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test056");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        int int2 = pageRequest1.getPageSize();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest1.toOptional();
        org.springframework.data.domain.Limit limit4 = pageRequest1.toLimit();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 10 + "'", int2 == 10);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(limit4);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test057");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.lang.String str3 = pageRequest2.toString();
        org.springframework.data.domain.Pageable pageable4 = pageRequest2.previousOrFirst();
        boolean boolean5 = pageable4.isUnpaged();
        boolean boolean6 = pageable4.isPaged();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Page request [number: 100, size 10, sort: UNSORTED]" + "'", str3, "Page request [number: 100, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageable4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test058");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.Limit limit4 = pageRequest2.toLimit();
        org.springframework.data.domain.Sort.Direction direction5 = null;
        java.lang.String[] strArray9 = new java.lang.String[] { "", "hi!", "Page request [number: 0, size 10, sort: UNSORTED]" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest10 = pageRequest2.withSort(direction5, strArray9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(limit4);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new java.lang.String[] { "", "hi!", "Page request [number: 0, size 10, sort: UNSORTED]" });
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test059");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest2 = pageRequest1.previous();
        java.lang.String str3 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        org.springframework.data.domain.Pageable pageable7 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        boolean boolean8 = pageRequest6.equals((java.lang.Object) pageable7);
        org.springframework.data.domain.Sort sort9 = pageRequest6.getSort();
        org.springframework.data.domain.PageRequest pageRequest10 = pageRequest1.withSort(sort9);
        org.springframework.data.domain.Sort sort11 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest12 = pageRequest1.withSort(sort11);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Sort must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str3, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageable7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(sort9);
        org.junit.Assert.assertNotNull(pageRequest10);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test060");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        boolean boolean4 = pageRequest2.hasPrevious();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test061");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = null;
        commandTO0.setArgs(commandArgs3);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = null;
        commandTO0.setArgs(commandArgs5);
        java.lang.String str7 = commandTO0.getKey();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs8 = null;
        commandTO0.setArgs(commandArgs8);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs10 = null;
        commandTO0.setArgs(commandArgs10);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "" + "'", str7, "");
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test062");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("Page request [number: 100, size 10, sort: UNSORTED]");
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test063");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.first();
        org.springframework.data.domain.Sort sort6 = pageRequest5.getSort();
        org.springframework.data.domain.PageRequest pageRequest8 = pageRequest5.withPage((int) (short) 0);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(sort6);
        org.junit.Assert.assertNotNull(pageRequest8);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test064");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        int int2 = pageRequest1.getPageSize();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest1.toOptional();
        org.springframework.data.domain.Sort.Direction direction4 = null;
        java.lang.String[] strArray9 = new java.lang.String[] { "hi!", "hi!", "", "" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest10 = pageRequest1.withSort(direction4, strArray9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 10 + "'", int2 == 10);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new java.lang.String[] { "hi!", "hi!", "", "" });
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test065");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.Pageable pageable3 = pageRequest2.previousOrFirst();
        org.springframework.data.domain.Sort.Direction direction4 = null;
        java.lang.String[] strArray5 = new java.lang.String[] {};
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.withSort(direction4, strArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageable3);
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new java.lang.String[] {});
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test066");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 1);
        org.junit.Assert.assertNotNull(pageRequest1);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test067");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest3);
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest3.previous();
        org.springframework.data.domain.Pageable pageable8 = pageRequest3.previousOrFirst();
        org.springframework.data.domain.PageRequest pageRequest11 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional12 = pageRequest11.toOptional();
        org.springframework.data.domain.Limit limit13 = pageRequest11.toLimit();
        boolean boolean14 = pageRequest11.isUnpaged();
        org.springframework.data.domain.PageRequest pageRequest16 = pageRequest11.withPage((int) '#');
        boolean boolean17 = pageRequest3.equals((java.lang.Object) pageRequest16);
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertNotNull(pageable8);
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertNotNull(pageableOptional12);
        org.junit.Assert.assertNotNull(limit13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(pageRequest16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test068");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean3 = pageRequest2.isUnpaged();
        boolean boolean4 = pageRequest2.hasPrevious();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test069");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        commandTO0.setArgs(commandArgs2);
        java.lang.String str4 = commandTO0.getKey();
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(str4);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test070");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest2 = pageRequest1.previous();
        java.lang.String str3 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        org.springframework.data.domain.Pageable pageable7 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        boolean boolean8 = pageRequest6.equals((java.lang.Object) pageable7);
        org.springframework.data.domain.Sort sort9 = pageRequest6.getSort();
        org.springframework.data.domain.PageRequest pageRequest10 = pageRequest1.withSort(sort9);
        long long11 = pageRequest1.getOffset();
        org.springframework.data.domain.Sort.Direction direction12 = null;
        java.lang.String[] strArray19 = new java.lang.String[] { "Page request [number: 0, size 10, sort: UNSORTED]", "hi!", "Page request [number: 0, size 10, sort: UNSORTED]", "hi!", "hi!", "" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest20 = pageRequest1.withSort(direction12, strArray19);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str3, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageable7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(sort9);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertTrue("'" + long11 + "' != '" + 0L + "'", long11 == 0L);
        org.junit.Assert.assertNotNull(strArray19);
        org.junit.Assert.assertArrayEquals(strArray19, new java.lang.String[] { "Page request [number: 0, size 10, sort: UNSORTED]", "hi!", "Page request [number: 0, size 10, sort: UNSORTED]", "hi!", "hi!", "" });
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test071");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        org.springframework.data.domain.Pageable pageable4 = pageRequest2.previousOrFirst();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertNotNull(pageable4);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test072");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("");
        org.apache.syncope.common.lib.command.CommandTO commandTO2 = builder1.build();
        java.lang.String str3 = commandTO2.getKey();
        org.junit.Assert.assertNotNull(commandTO2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test073");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        java.lang.String str4 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest1.previous();
        boolean boolean6 = pageRequest1.isPaged();
        boolean boolean7 = pageRequest1.hasPrevious();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test074");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        boolean boolean5 = pageRequest1.equals((java.lang.Object) 100.0f);
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest1.previous();
        int int7 = pageRequest1.getPageSize();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 10 + "'", int7 == 10);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test075");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray5 = new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest6 = org.springframework.data.domain.PageRequest.of(0, (int) (short) 10, direction2, strArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]" });
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test076");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest3);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition11 = pageRequest10.toScrollPosition();
        boolean boolean12 = pageRequest10.isUnpaged();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional13 = pageRequest10.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.apache.syncope.common.lib.command.CommandTO commandTO15 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO15.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs18 = null;
        commandTO15.setArgs(commandArgs18);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs20 = null;
        commandTO15.setArgs(commandArgs20);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str22 = commandLogic0.run(commandTO15);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation ");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(offsetScrollPosition11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(pageableOptional13);
        org.junit.Assert.assertNotNull(commandTOPage14);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test077");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.first();
        int int6 = pageRequest5.getPageSize();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test078");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional7 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest9 = pageRequest2.withPage((int) (short) 0);
        boolean boolean10 = pageRequest2.isUnpaged();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageableOptional7);
        org.junit.Assert.assertNotNull(pageRequest9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test079");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("Page request [number: 100, size 10, sort: UNSORTED]");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.junit.Assert.assertNotNull(builder3);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test080");
        org.springframework.data.domain.PageRequest pageRequest6 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional7 = pageRequest6.toOptional();
        org.springframework.data.domain.PageRequest pageRequest8 = pageRequest6.next();
        org.springframework.data.domain.PageRequest pageRequest10 = pageRequest6.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional11 = pageRequest6.toOptional();
        org.springframework.data.domain.PageRequest pageRequest13 = pageRequest6.withPage((int) (short) 0);
        org.springframework.data.domain.Sort sort14 = pageRequest13.getSort();
        org.springframework.data.domain.PageRequest pageRequest15 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100, sort14);
        org.springframework.data.domain.PageRequest pageRequest16 = org.springframework.data.domain.PageRequest.of(10, 99, sort14);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageableOptional7);
        org.junit.Assert.assertNotNull(pageRequest8);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(pageableOptional11);
        org.junit.Assert.assertNotNull(pageRequest13);
        org.junit.Assert.assertNotNull(sort14);
        org.junit.Assert.assertNotNull(pageRequest15);
        org.junit.Assert.assertNotNull(pageRequest16);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test081");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) 'a', (int) (byte) 100);
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit5 = pageRequest4.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition6 = pageRequest4.toScrollPosition();
        java.lang.String str7 = pageRequest4.toString();
        org.springframework.data.domain.PageRequest pageRequest9 = pageRequest4.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest12 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional13 = pageRequest12.toOptional();
        org.springframework.data.domain.PageRequest pageRequest14 = pageRequest12.next();
        org.springframework.data.domain.PageRequest pageRequest15 = pageRequest12.first();
        org.springframework.data.domain.Sort sort16 = pageRequest15.getSort();
        org.springframework.data.domain.Sort sort17 = pageRequest9.getSortOr(sort16);
        org.springframework.data.domain.PageRequest pageRequest18 = pageRequest2.withSort(sort16);
        boolean boolean19 = pageRequest2.isPaged();
        boolean boolean20 = pageRequest2.hasPrevious();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(limit5);
        org.junit.Assert.assertNotNull(offsetScrollPosition6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str7, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest9);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(pageableOptional13);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertNotNull(pageRequest15);
        org.junit.Assert.assertNotNull(sort16);
        org.junit.Assert.assertNotNull(sort17);
        org.junit.Assert.assertNotNull(pageRequest18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test082");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest2 = pageRequest1.previous();
        java.lang.String str3 = pageRequest1.toString();
        org.springframework.data.domain.Sort sort4 = pageRequest1.getSort();
        int int5 = pageRequest1.getPageSize();
        org.springframework.data.domain.Pageable pageable6 = pageRequest1.previousOrFirst();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str3, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(sort4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 10 + "'", int5 == 10);
        org.junit.Assert.assertNotNull(pageable6);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test083");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional4 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest2.withPage(1);
        int int8 = pageRequest2.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest9 = pageRequest2.first();
        org.springframework.data.domain.PageRequest pageRequest12 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        org.springframework.data.domain.Pageable pageable13 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        boolean boolean14 = pageRequest12.equals((java.lang.Object) pageable13);
        org.springframework.data.domain.Sort sort15 = pageRequest12.getSort();
        org.springframework.data.domain.Sort sort16 = pageRequest2.getSortOr(sort15);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertNotNull(pageableOptional4);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
        org.junit.Assert.assertNotNull(pageRequest9);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(pageable13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(sort15);
        org.junit.Assert.assertNotNull(sort16);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test084");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.withPage((int) (short) 1);
        int int7 = pageRequest6.getPageNumber();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test085");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional4 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest2.withPage(1);
        org.springframework.data.domain.Limit limit8 = pageRequest2.toLimit();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertNotNull(pageableOptional4);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertNotNull(limit8);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test086");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("Page request [number: 0, size 10, sort: UNSORTED]");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder1.build();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = commandTO4.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = commandTO4.getArgs();
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(commandTO4);
        org.junit.Assert.assertNull(commandArgs5);
        org.junit.Assert.assertNull(commandArgs6);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test087");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest4.toScrollPosition();
        boolean boolean6 = pageRequest4.isPaged();
        org.springframework.data.domain.Limit limit7 = pageRequest4.toLimit();
        org.springframework.data.domain.PageRequest pageRequest8 = pageRequest4.first();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(limit7);
        org.junit.Assert.assertNotNull(pageRequest8);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test088");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest2 = pageRequest1.previous();
        java.lang.String str3 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest1.withPage((int) (byte) 100);
        org.springframework.data.domain.Sort sort6 = pageRequest1.getSort();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str3, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(sort6);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test089");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder3.build();
        java.lang.Class<?> wildcardClass5 = builder3.getClass();
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(commandTO4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test090");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional5 = pageRequest4.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest4);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.PageRequest pageRequest14 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long15 = pageRequest14.getOffset();
        int int16 = pageRequest14.getPageNumber();
        int int17 = pageRequest14.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest18 = pageRequest14.first();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage19 = commandLogic0.search("Page request [number: 100, size 10, sort: UNSORTED]", (org.springframework.data.domain.Pageable) pageRequest18);
        org.apache.syncope.common.lib.command.CommandTO commandTO20 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs21 = commandTO20.getArgs();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str22 = commandLogic0.run(commandTO20);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation null");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageableOptional5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertTrue("'" + long15 + "' != '" + 0L + "'", long15 == 0L);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertNotNull(pageRequest18);
        org.junit.Assert.assertNotNull(commandTOPage19);
        org.junit.Assert.assertNull(commandArgs21);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test091");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 100);
        org.springframework.data.domain.Sort sort2 = pageRequest1.getSort();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(sort2);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test092");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        int int4 = pageRequest2.getPageSize();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest2.toScrollPosition();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.next();
        long long7 = pageRequest6.getOffset();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 1010L + "'", long7 == 1010L);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test093");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        int int4 = pageRequest2.getPageSize();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest2.toScrollPosition();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.next();
        java.lang.String str7 = pageRequest6.toString();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Page request [number: 101, size 10, sort: UNSORTED]" + "'", str7, "Page request [number: 101, size 10, sort: UNSORTED]");
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test094");
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional5 = pageRequest4.toOptional();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest4.next();
        org.springframework.data.domain.PageRequest pageRequest8 = pageRequest4.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional9 = pageRequest4.toOptional();
        org.springframework.data.domain.PageRequest pageRequest11 = pageRequest4.withPage((int) (short) 0);
        org.springframework.data.domain.Sort sort12 = pageRequest11.getSort();
        org.springframework.data.domain.PageRequest pageRequest13 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100, sort12);
        org.springframework.data.domain.PageRequest pageRequest14 = pageRequest13.next();
        boolean boolean16 = pageRequest14.equals((java.lang.Object) (short) 100);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageableOptional5);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest8);
        org.junit.Assert.assertNotNull(pageableOptional9);
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertNotNull(sort12);
        org.junit.Assert.assertNotNull(pageRequest13);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test095");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("Page request [number: 0, size 10, sort: UNSORTED]");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder3.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO5 = builder3.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO6 = builder3.build();
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(commandTO4);
        org.junit.Assert.assertNotNull(commandTO5);
        org.junit.Assert.assertNotNull(commandTO6);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test096");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.withPage((int) (short) 1);
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest6.previous();
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest9 = pageRequest7.withPage((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page index must not be less than zero");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest7);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test097");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        int int4 = pageRequest2.getPageSize();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest2.toScrollPosition();
        org.springframework.data.domain.Pageable pageable6 = pageRequest2.previousOrFirst();
        org.springframework.data.domain.PageRequest pageRequest8 = pageRequest2.withPage((int) '#');
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertNotNull(pageable6);
        org.junit.Assert.assertNotNull(pageRequest8);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test098");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        boolean boolean4 = pageRequest1.hasPrevious();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test099");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest4.toScrollPosition();
        boolean boolean6 = pageRequest4.isPaged();
        org.springframework.data.domain.Limit limit7 = pageRequest4.toLimit();
        org.springframework.data.domain.Pageable pageable8 = pageRequest4.previousOrFirst();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(limit7);
        org.junit.Assert.assertNotNull(pageable8);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test100");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("Page request [number: 0, size 10, sort: UNSORTED]");
        org.apache.syncope.common.lib.command.CommandTO commandTO2 = builder1.build();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = commandTO2.getArgs();
        org.junit.Assert.assertNotNull(commandTO2);
        org.junit.Assert.assertNull(commandArgs3);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test101");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest2.previous();
        long long4 = pageRequest2.getOffset();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.previous();
        int int6 = pageRequest2.getPageNumber();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 1000L + "'", long4 == 1000L);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test102");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs1 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = null;
        commandTO0.setArgs(commandArgs3);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = null;
        commandTO0.setArgs(commandArgs5);
        org.junit.Assert.assertNull(commandArgs1);
        org.junit.Assert.assertNull(commandArgs2);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test103");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest1.previous();
        org.springframework.data.domain.PageRequest pageRequest5 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit6 = pageRequest5.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition7 = pageRequest5.toScrollPosition();
        java.lang.String str8 = pageRequest5.toString();
        org.springframework.data.domain.PageRequest pageRequest10 = pageRequest5.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest12 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long13 = pageRequest12.getOffset();
        boolean boolean14 = pageRequest10.equals((java.lang.Object) pageRequest12);
        org.springframework.data.domain.PageRequest pageRequest17 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        org.springframework.data.domain.Pageable pageable18 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        boolean boolean19 = pageRequest17.equals((java.lang.Object) pageable18);
        org.springframework.data.domain.Sort sort20 = pageRequest17.getSort();
        org.springframework.data.domain.PageRequest pageRequest21 = pageRequest10.withSort(sort20);
        org.springframework.data.domain.Sort sort22 = pageRequest3.getSortOr(sort20);
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(limit6);
        org.junit.Assert.assertNotNull(offsetScrollPosition7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str8, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertTrue("'" + long13 + "' != '" + 0L + "'", long13 == 0L);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(pageable18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(sort20);
        org.junit.Assert.assertNotNull(pageRequest21);
        org.junit.Assert.assertNotNull(sort22);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test104");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        boolean boolean5 = pageRequest1.equals((java.lang.Object) 100.0f);
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest1.previous();
        boolean boolean7 = pageRequest6.isPaged();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test105");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional5 = pageRequest4.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest4);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.PageRequest pageRequest14 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long15 = pageRequest14.getOffset();
        int int16 = pageRequest14.getPageNumber();
        int int17 = pageRequest14.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest18 = pageRequest14.first();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage19 = commandLogic0.search("Page request [number: 100, size 10, sort: UNSORTED]", (org.springframework.data.domain.Pageable) pageRequest18);
        org.springframework.data.domain.PageRequest pageRequest22 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean23 = pageRequest22.isUnpaged();
        boolean boolean24 = pageRequest18.equals((java.lang.Object) boolean23);
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageableOptional5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertTrue("'" + long15 + "' != '" + 0L + "'", long15 == 0L);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertNotNull(pageRequest18);
        org.junit.Assert.assertNotNull(commandTOPage19);
        org.junit.Assert.assertNotNull(pageRequest22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test106");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.Limit limit4 = pageRequest2.toLimit();
        int int5 = pageRequest2.getPageNumber();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(limit4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test107");
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) -1, (int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page index must not be less than zero");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test108");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO1 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO1.setKey("");
        java.lang.String str4 = commandTO1.getKey();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = null;
        commandTO1.setArgs(commandArgs5);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs7 = null;
        commandTO1.setArgs(commandArgs7);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str9 = commandLogic0.run(commandTO1);
            org.junit.Assert.fail("Expected exception of type org.apache.syncope.core.persistence.api.dao.NotFoundException; message: Implementation ");
        } catch (org.apache.syncope.core.persistence.api.dao.NotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test109");
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of((int) 'a', (int) (byte) 100);
        org.springframework.data.domain.PageRequest pageRequest6 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit7 = pageRequest6.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition8 = pageRequest6.toScrollPosition();
        java.lang.String str9 = pageRequest6.toString();
        org.springframework.data.domain.PageRequest pageRequest11 = pageRequest6.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest14 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional15 = pageRequest14.toOptional();
        org.springframework.data.domain.PageRequest pageRequest16 = pageRequest14.next();
        org.springframework.data.domain.PageRequest pageRequest17 = pageRequest14.first();
        org.springframework.data.domain.Sort sort18 = pageRequest17.getSort();
        org.springframework.data.domain.Sort sort19 = pageRequest11.getSortOr(sort18);
        org.springframework.data.domain.PageRequest pageRequest20 = pageRequest4.withSort(sort18);
        org.springframework.data.domain.PageRequest pageRequest21 = org.springframework.data.domain.PageRequest.of(99, (int) '#', sort18);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(limit7);
        org.junit.Assert.assertNotNull(offsetScrollPosition8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str9, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertNotNull(pageableOptional15);
        org.junit.Assert.assertNotNull(pageRequest16);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(sort18);
        org.junit.Assert.assertNotNull(sort19);
        org.junit.Assert.assertNotNull(pageRequest20);
        org.junit.Assert.assertNotNull(pageRequest21);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test110");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        java.lang.String str4 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest1.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest9 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional10 = pageRequest9.toOptional();
        org.springframework.data.domain.PageRequest pageRequest11 = pageRequest9.next();
        org.springframework.data.domain.PageRequest pageRequest12 = pageRequest9.first();
        org.springframework.data.domain.Sort sort13 = pageRequest12.getSort();
        org.springframework.data.domain.Sort sort14 = pageRequest6.getSortOr(sort13);
        org.springframework.data.domain.Sort sort15 = pageRequest6.getSort();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest9);
        org.junit.Assert.assertNotNull(pageableOptional10);
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(sort13);
        org.junit.Assert.assertNotNull(sort14);
        org.junit.Assert.assertNotNull(sort15);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test111");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest2.toScrollPosition();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition4 = pageRequest2.toScrollPosition();
        org.springframework.data.domain.Pageable pageable5 = pageRequest2.previousOrFirst();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional6 = pageable5.toOptional();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertNotNull(offsetScrollPosition4);
        org.junit.Assert.assertNotNull(pageable5);
        org.junit.Assert.assertNotNull(pageableOptional6);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test112");
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional5 = pageRequest4.toOptional();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest4.next();
        org.springframework.data.domain.PageRequest pageRequest8 = pageRequest4.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional9 = pageRequest4.toOptional();
        org.springframework.data.domain.PageRequest pageRequest11 = pageRequest4.withPage((int) (short) 0);
        org.springframework.data.domain.Sort sort12 = pageRequest11.getSort();
        org.springframework.data.domain.PageRequest pageRequest13 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100, sort12);
        org.springframework.data.domain.Sort.Direction direction14 = null;
        java.lang.String[] strArray15 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest16 = pageRequest13.withSort(direction14, strArray15);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageableOptional5);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest8);
        org.junit.Assert.assertNotNull(pageableOptional9);
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertNotNull(sort12);
        org.junit.Assert.assertNotNull(pageRequest13);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test113");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("");
        org.apache.syncope.common.lib.command.CommandTO commandTO2 = builder1.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO3 = builder1.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder1.build();
        org.junit.Assert.assertNotNull(commandTO2);
        org.junit.Assert.assertNotNull(commandTO3);
        org.junit.Assert.assertNotNull(commandTO4);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test114");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("Page request [number: 0, size 10, sort: UNSORTED]");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs4 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder5 = builder3.args(commandArgs4);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(builder5);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test115");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = null;
        commandTO0.setArgs(commandArgs3);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = null;
        commandTO0.setArgs(commandArgs5);
        java.lang.String str7 = commandTO0.getKey();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs8 = null;
        commandTO0.setArgs(commandArgs8);
        java.lang.Class<?> wildcardClass10 = commandTO0.getClass();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "" + "'", str7, "");
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test116");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest3);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition11 = pageRequest10.toScrollPosition();
        boolean boolean12 = pageRequest10.isUnpaged();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional13 = pageRequest10.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.PageRequest pageRequest17 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit18 = pageRequest17.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition19 = pageRequest17.toScrollPosition();
        org.springframework.data.domain.Pageable pageable20 = pageRequest17.previousOrFirst();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage21 = commandLogic0.search("hi!", pageable20);
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(offsetScrollPosition11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(pageableOptional13);
        org.junit.Assert.assertNotNull(commandTOPage14);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(limit18);
        org.junit.Assert.assertNotNull(offsetScrollPosition19);
        org.junit.Assert.assertNotNull(pageable20);
        org.junit.Assert.assertNotNull(commandTOPage21);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test117");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest2.previous();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition4 = pageRequest3.toScrollPosition();
        long long5 = pageRequest3.getOffset();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(offsetScrollPosition4);
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 990L + "'", long5 == 990L);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test118");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest2 = pageRequest1.previous();
        java.lang.String str3 = pageRequest1.toString();
        int int4 = pageRequest1.getPageSize();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str3, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test119");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional4 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest2.withPage(1);
        int int8 = pageRequest2.getPageNumber();
        boolean boolean9 = pageRequest2.isUnpaged();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertNotNull(pageableOptional4);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test120");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest2.toScrollPosition();
        boolean boolean4 = pageRequest2.isUnpaged();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional5 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.previous();
        boolean boolean7 = pageRequest6.isUnpaged();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(pageableOptional5);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test121");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest3);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition11 = pageRequest10.toScrollPosition();
        boolean boolean12 = pageRequest10.isUnpaged();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional13 = pageRequest10.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.PageRequest pageRequest17 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit18 = pageRequest17.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition19 = pageRequest17.toScrollPosition();
        java.lang.String str20 = pageRequest17.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage21 = commandLogic0.search("Page request [number: 0, size 10, sort: UNSORTED]", (org.springframework.data.domain.Pageable) pageRequest17);
        org.springframework.data.domain.Pageable pageable22 = pageRequest17.previousOrFirst();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(offsetScrollPosition11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(pageableOptional13);
        org.junit.Assert.assertNotNull(commandTOPage14);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(limit18);
        org.junit.Assert.assertNotNull(offsetScrollPosition19);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str20, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage21);
        org.junit.Assert.assertNotNull(pageable22);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test122");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("Page request [number: 0, size 10, sort: UNSORTED]");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder3.build();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = null;
        commandTO4.setArgs(commandArgs5);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(commandTO4);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test123");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        java.lang.String str4 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest1.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest9 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional10 = pageRequest9.toOptional();
        org.springframework.data.domain.PageRequest pageRequest11 = pageRequest9.next();
        org.springframework.data.domain.PageRequest pageRequest12 = pageRequest9.first();
        org.springframework.data.domain.Sort sort13 = pageRequest12.getSort();
        org.springframework.data.domain.Sort sort14 = pageRequest6.getSortOr(sort13);
        java.lang.Class<?> wildcardClass15 = pageRequest6.getClass();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest9);
        org.junit.Assert.assertNotNull(pageableOptional10);
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(sort13);
        org.junit.Assert.assertNotNull(sort14);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test124");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        int int4 = pageRequest2.getPageSize();
        org.springframework.data.domain.Limit limit5 = pageRequest2.toLimit();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
        org.junit.Assert.assertNotNull(limit5);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test125");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        java.lang.String str4 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest1.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest6.previous();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest7);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test126");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest3);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition11 = pageRequest10.toScrollPosition();
        boolean boolean12 = pageRequest10.isUnpaged();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional13 = pageRequest10.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.PageRequest pageRequest17 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit18 = pageRequest17.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition19 = pageRequest17.toScrollPosition();
        java.lang.String str20 = pageRequest17.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage21 = commandLogic0.search("Page request [number: 0, size 10, sort: UNSORTED]", (org.springframework.data.domain.Pageable) pageRequest17);
        org.springframework.data.domain.PageRequest pageRequest22 = pageRequest17.next();
        org.springframework.data.domain.Sort.Direction direction23 = null;
        java.lang.String[] strArray28 = new java.lang.String[] { "Page request [number: 99, size 99, sort: UNSORTED]", "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 99, size 99, sort: UNSORTED]" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest29 = pageRequest17.withSort(direction23, strArray28);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(offsetScrollPosition11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(pageableOptional13);
        org.junit.Assert.assertNotNull(commandTOPage14);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(limit18);
        org.junit.Assert.assertNotNull(offsetScrollPosition19);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str20, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage21);
        org.junit.Assert.assertNotNull(pageRequest22);
        org.junit.Assert.assertNotNull(strArray28);
        org.junit.Assert.assertArrayEquals(strArray28, new java.lang.String[] { "Page request [number: 99, size 99, sort: UNSORTED]", "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 99, size 99, sort: UNSORTED]" });
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test127");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        int int2 = pageRequest1.getPageSize();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest1.toOptional();
        boolean boolean4 = pageRequest1.hasPrevious();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest1.previous();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 10 + "'", int2 == 10);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(pageRequest5);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test128");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) 'a', (int) (byte) 100);
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit5 = pageRequest4.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition6 = pageRequest4.toScrollPosition();
        java.lang.String str7 = pageRequest4.toString();
        org.springframework.data.domain.PageRequest pageRequest9 = pageRequest4.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest12 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional13 = pageRequest12.toOptional();
        org.springframework.data.domain.PageRequest pageRequest14 = pageRequest12.next();
        org.springframework.data.domain.PageRequest pageRequest15 = pageRequest12.first();
        org.springframework.data.domain.Sort sort16 = pageRequest15.getSort();
        org.springframework.data.domain.Sort sort17 = pageRequest9.getSortOr(sort16);
        org.springframework.data.domain.PageRequest pageRequest18 = pageRequest2.withSort(sort16);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional19 = pageRequest18.toOptional();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(limit5);
        org.junit.Assert.assertNotNull(offsetScrollPosition6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str7, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest9);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(pageableOptional13);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertNotNull(pageRequest15);
        org.junit.Assert.assertNotNull(sort16);
        org.junit.Assert.assertNotNull(sort17);
        org.junit.Assert.assertNotNull(pageRequest18);
        org.junit.Assert.assertNotNull(pageableOptional19);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test129");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (short) 10);
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest1.withPage(99);
        org.springframework.data.domain.Sort.Direction direction4 = null;
        java.lang.String[] strArray11 = new java.lang.String[] { "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 101, size 10, sort: UNSORTED]", "Page request [number: 101, size 10, sort: UNSORTED]", "Page request [number: 99, size 99, sort: UNSORTED]", "" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest12 = pageRequest3.withSort(direction4, strArray11);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertArrayEquals(strArray11, new java.lang.String[] { "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 101, size 10, sort: UNSORTED]", "Page request [number: 101, size 10, sort: UNSORTED]", "Page request [number: 99, size 99, sort: UNSORTED]", "" });
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test130");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional4 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.next();
        org.springframework.data.domain.Pageable pageable6 = pageRequest2.previousOrFirst();
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest2.first();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertNotNull(pageableOptional4);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(pageable6);
        org.junit.Assert.assertNotNull(pageRequest7);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test131");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional5 = pageRequest4.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest4);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.Pageable pageable12 = pageRequest10.previousOrFirst();
        org.springframework.data.domain.PageRequest pageRequest13 = pageRequest10.first();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageableOptional5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(pageable12);
        org.junit.Assert.assertNotNull(pageRequest13);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test132");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (short) 1, 99);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.withPage(99);
        java.lang.String str5 = pageRequest4.toString();
        org.apache.syncope.core.logic.CommandLogic commandLogic6 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest9 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest10 = pageRequest9.previous();
        java.lang.String str11 = pageRequest9.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage12 = commandLogic6.search("", (org.springframework.data.domain.Pageable) pageRequest9);
        org.springframework.data.domain.PageRequest pageRequest13 = pageRequest9.previous();
        boolean boolean14 = pageRequest4.equals((java.lang.Object) pageRequest9);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 99, size 99, sort: UNSORTED]" + "'", str5, "Page request [number: 99, size 99, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandLogic6);
        org.junit.Assert.assertNotNull(pageRequest9);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str11, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage12);
        org.junit.Assert.assertNotNull(pageRequest13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test133");
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page size must not be less than one");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test134");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (short) 1, 99);
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit5 = pageRequest4.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition6 = pageRequest4.toScrollPosition();
        java.lang.String str7 = pageRequest4.toString();
        org.springframework.data.domain.PageRequest pageRequest9 = pageRequest4.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest12 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional13 = pageRequest12.toOptional();
        org.springframework.data.domain.PageRequest pageRequest14 = pageRequest12.next();
        org.springframework.data.domain.PageRequest pageRequest15 = pageRequest12.first();
        org.springframework.data.domain.Sort sort16 = pageRequest15.getSort();
        org.springframework.data.domain.Sort sort17 = pageRequest9.getSortOr(sort16);
        org.springframework.data.domain.PageRequest pageRequest18 = pageRequest2.withSort(sort16);
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition19 = pageRequest2.toScrollPosition();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(limit5);
        org.junit.Assert.assertNotNull(offsetScrollPosition6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str7, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest9);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(pageableOptional13);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertNotNull(pageRequest15);
        org.junit.Assert.assertNotNull(sort16);
        org.junit.Assert.assertNotNull(sort17);
        org.junit.Assert.assertNotNull(pageRequest18);
        org.junit.Assert.assertNotNull(offsetScrollPosition19);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test135");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("");
        org.apache.syncope.common.lib.command.CommandTO commandTO2 = builder1.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO3 = builder1.build();
        java.lang.Class<?> wildcardClass4 = commandTO3.getClass();
        org.junit.Assert.assertNotNull(commandTO2);
        org.junit.Assert.assertNotNull(commandTO3);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test136");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        int int4 = pageRequest2.getPageSize();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest2.toScrollPosition();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.next();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional7 = pageRequest2.toOptional();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageableOptional7);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test137");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray8 = new java.lang.String[] { "hi!", "Page request [number: 0, size 10, sort: UNSORTED]", "hi!", "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 0, size 10, sort: UNSORTED]" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest9 = org.springframework.data.domain.PageRequest.of((int) ' ', 0, direction2, strArray8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertArrayEquals(strArray8, new java.lang.String[] { "hi!", "Page request [number: 0, size 10, sort: UNSORTED]", "hi!", "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 0, size 10, sort: UNSORTED]" });
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test138");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("");
        java.lang.String str3 = commandTO0.getKey();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs4 = null;
        commandTO0.setArgs(commandArgs4);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = null;
        commandTO0.setArgs(commandArgs6);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs8 = null;
        commandTO0.setArgs(commandArgs8);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test139");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        java.lang.String str4 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest1.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest8 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long9 = pageRequest8.getOffset();
        boolean boolean10 = pageRequest6.equals((java.lang.Object) pageRequest8);
        boolean boolean11 = pageRequest8.hasPrevious();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest8);
        org.junit.Assert.assertTrue("'" + long9 + "' != '" + 0L + "'", long9 == 0L);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test140");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest3);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition11 = pageRequest10.toScrollPosition();
        boolean boolean12 = pageRequest10.isUnpaged();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional13 = pageRequest10.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.Pageable pageable15 = pageRequest10.previousOrFirst();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(offsetScrollPosition11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(pageableOptional13);
        org.junit.Assert.assertNotNull(commandTOPage14);
        org.junit.Assert.assertNotNull(pageable15);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test141");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(1, (int) (byte) 10);
        org.junit.Assert.assertNotNull(pageRequest2);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test142");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        boolean boolean2 = pageRequest1.isPaged();
        boolean boolean3 = pageRequest1.isUnpaged();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test143");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        java.lang.String str4 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest1.previous();
        java.lang.String str6 = pageRequest5.toString();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str6, "Page request [number: 0, size 10, sort: UNSORTED]");
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test144");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean3 = pageRequest2.isUnpaged();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.first();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.withPage(10);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageRequest6);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test145");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest2.previous();
        org.springframework.data.domain.Sort sort4 = pageRequest3.getSort();
        java.lang.Class<?> wildcardClass5 = sort4.getClass();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(sort4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test146");
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (short) 1, (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page size must not be less than one");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test147");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        java.lang.String str4 = pageRequest1.toString();
        long long5 = pageRequest1.getOffset();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 0L + "'", long5 == 0L);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test148");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (short) 1, 99);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.withPage(99);
        java.lang.String str5 = pageRequest4.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest4.previous();
        org.apache.syncope.core.logic.CommandLogic commandLogic7 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest11 = pageRequest10.previous();
        java.lang.String str12 = pageRequest10.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage13 = commandLogic7.search("", (org.springframework.data.domain.Pageable) pageRequest10);
        int int14 = pageRequest10.getPageSize();
        boolean boolean15 = pageRequest6.equals((java.lang.Object) int14);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 99, size 99, sort: UNSORTED]" + "'", str5, "Page request [number: 99, size 99, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(commandLogic7);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str12, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 10 + "'", int14 == 10);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test149");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional4 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest2.withPage(1);
        int int8 = pageRequest2.getPageNumber();
        int int9 = pageRequest2.getPageSize();
        org.springframework.data.domain.PageRequest pageRequest11 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit12 = pageRequest11.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition13 = pageRequest11.toScrollPosition();
        java.lang.String str14 = pageRequest11.toString();
        org.springframework.data.domain.PageRequest pageRequest16 = pageRequest11.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest19 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional20 = pageRequest19.toOptional();
        org.springframework.data.domain.PageRequest pageRequest21 = pageRequest19.next();
        org.springframework.data.domain.PageRequest pageRequest22 = pageRequest19.first();
        org.springframework.data.domain.Sort sort23 = pageRequest22.getSort();
        org.springframework.data.domain.Sort sort24 = pageRequest16.getSortOr(sort23);
        org.springframework.data.domain.Sort sort25 = pageRequest2.getSortOr(sort23);
        org.springframework.data.domain.PageRequest pageRequest27 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest28 = pageRequest27.previous();
        java.lang.String str29 = pageRequest27.toString();
        org.springframework.data.domain.Sort sort30 = pageRequest27.getSort();
        int int31 = pageRequest27.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest34 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional35 = pageRequest34.toOptional();
        org.springframework.data.domain.PageRequest pageRequest36 = pageRequest34.next();
        org.springframework.data.domain.PageRequest pageRequest37 = pageRequest34.first();
        org.springframework.data.domain.Sort sort38 = pageRequest37.getSort();
        org.springframework.data.domain.Sort sort39 = pageRequest27.getSortOr(sort38);
        org.springframework.data.domain.PageRequest pageRequest40 = pageRequest2.withSort(sort39);
        int int41 = pageRequest40.getPageNumber();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertNotNull(pageableOptional4);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 10 + "'", int9 == 10);
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertNotNull(limit12);
        org.junit.Assert.assertNotNull(offsetScrollPosition13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str14, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest16);
        org.junit.Assert.assertNotNull(pageRequest19);
        org.junit.Assert.assertNotNull(pageableOptional20);
        org.junit.Assert.assertNotNull(pageRequest21);
        org.junit.Assert.assertNotNull(pageRequest22);
        org.junit.Assert.assertNotNull(sort23);
        org.junit.Assert.assertNotNull(sort24);
        org.junit.Assert.assertNotNull(sort25);
        org.junit.Assert.assertNotNull(pageRequest27);
        org.junit.Assert.assertNotNull(pageRequest28);
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str29, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(sort30);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 0 + "'", int31 == 0);
        org.junit.Assert.assertNotNull(pageRequest34);
        org.junit.Assert.assertNotNull(pageableOptional35);
        org.junit.Assert.assertNotNull(pageRequest36);
        org.junit.Assert.assertNotNull(pageRequest37);
        org.junit.Assert.assertNotNull(sort38);
        org.junit.Assert.assertNotNull(sort39);
        org.junit.Assert.assertNotNull(pageRequest40);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 100 + "'", int41 == 100);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test150");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.Limit limit4 = pageRequest2.toLimit();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.first();
        boolean boolean6 = pageRequest2.isUnpaged();
        org.springframework.data.domain.Pageable pageable7 = pageRequest2.previousOrFirst();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(limit4);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(pageable7);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test151");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        int int4 = pageRequest1.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest1.first();
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional11 = pageRequest10.toOptional();
        org.springframework.data.domain.PageRequest pageRequest12 = pageRequest10.next();
        org.springframework.data.domain.PageRequest pageRequest14 = pageRequest10.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional15 = pageRequest10.toOptional();
        org.springframework.data.domain.PageRequest pageRequest17 = pageRequest10.withPage((int) (short) 0);
        org.springframework.data.domain.Sort sort18 = pageRequest17.getSort();
        org.springframework.data.domain.PageRequest pageRequest19 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100, sort18);
        org.springframework.data.domain.PageRequest pageRequest20 = pageRequest19.next();
        boolean boolean21 = pageRequest1.equals((java.lang.Object) pageRequest20);
        long long22 = pageRequest20.getOffset();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(pageableOptional11);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertNotNull(pageableOptional15);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(sort18);
        org.junit.Assert.assertNotNull(pageRequest19);
        org.junit.Assert.assertNotNull(pageRequest20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + long22 + "' != '" + 10100L + "'", long22 == 10100L);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test152");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray8 = new java.lang.String[] { "Page request [number: 101, size 10, sort: UNSORTED]", "Page request [number: 99, size 99, sort: UNSORTED]", "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 99, size 99, sort: UNSORTED]", "" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest9 = org.springframework.data.domain.PageRequest.of((int) 'a', (int) (short) 10, direction2, strArray8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertArrayEquals(strArray8, new java.lang.String[] { "Page request [number: 101, size 10, sort: UNSORTED]", "Page request [number: 99, size 99, sort: UNSORTED]", "Page request [number: 0, size 10, sort: UNSORTED]", "Page request [number: 99, size 99, sort: UNSORTED]", "" });
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test153");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest3.withPage((int) (byte) 100);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage8 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest7);
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertNotNull(commandTOPage8);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test154");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional5 = pageRequest4.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest4);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.PageRequest pageRequest14 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest15 = pageRequest14.previous();
        java.lang.String str16 = pageRequest14.toString();
        java.lang.String str17 = pageRequest14.toString();
        boolean boolean18 = pageRequest14.isUnpaged();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage19 = commandLogic0.search("Page request [number: 0, size 10, sort: UNSORTED]", (org.springframework.data.domain.Pageable) pageRequest14);
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageableOptional5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertNotNull(pageRequest15);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str16, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str17, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(commandTOPage19);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test155");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest1.previous();
        org.springframework.data.domain.Sort.Direction direction5 = null;
        java.lang.String[] strArray7 = new java.lang.String[] { "" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest8 = pageRequest4.withSort(direction5, strArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(strArray7);
        org.junit.Assert.assertArrayEquals(strArray7, new java.lang.String[] { "" });
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test156");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = null;
        commandTO0.setArgs(commandArgs3);
        commandTO0.setKey("hi!");
        java.lang.String str7 = commandTO0.getKey();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test157");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest2 = pageRequest1.previous();
        java.lang.String str3 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        org.springframework.data.domain.Pageable pageable7 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        boolean boolean8 = pageRequest6.equals((java.lang.Object) pageable7);
        org.springframework.data.domain.Sort sort9 = pageRequest6.getSort();
        org.springframework.data.domain.PageRequest pageRequest10 = pageRequest1.withSort(sort9);
        org.springframework.data.domain.PageRequest pageRequest11 = pageRequest10.first();
        org.springframework.data.domain.PageRequest pageRequest14 = org.springframework.data.domain.PageRequest.of((int) 'a', (int) (byte) 100);
        org.springframework.data.domain.PageRequest pageRequest16 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit17 = pageRequest16.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition18 = pageRequest16.toScrollPosition();
        java.lang.String str19 = pageRequest16.toString();
        org.springframework.data.domain.PageRequest pageRequest21 = pageRequest16.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest24 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional25 = pageRequest24.toOptional();
        org.springframework.data.domain.PageRequest pageRequest26 = pageRequest24.next();
        org.springframework.data.domain.PageRequest pageRequest27 = pageRequest24.first();
        org.springframework.data.domain.Sort sort28 = pageRequest27.getSort();
        org.springframework.data.domain.Sort sort29 = pageRequest21.getSortOr(sort28);
        org.springframework.data.domain.PageRequest pageRequest30 = pageRequest14.withSort(sort28);
        org.springframework.data.domain.PageRequest pageRequest31 = pageRequest11.withSort(sort28);
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str3, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageable7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(sort9);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertNotNull(pageRequest16);
        org.junit.Assert.assertNotNull(limit17);
        org.junit.Assert.assertNotNull(offsetScrollPosition18);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str19, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest21);
        org.junit.Assert.assertNotNull(pageRequest24);
        org.junit.Assert.assertNotNull(pageableOptional25);
        org.junit.Assert.assertNotNull(pageRequest26);
        org.junit.Assert.assertNotNull(pageRequest27);
        org.junit.Assert.assertNotNull(sort28);
        org.junit.Assert.assertNotNull(sort29);
        org.junit.Assert.assertNotNull(pageRequest30);
        org.junit.Assert.assertNotNull(pageRequest31);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test158");
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional5 = pageRequest4.toOptional();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest4.next();
        org.springframework.data.domain.PageRequest pageRequest8 = pageRequest4.withPage((int) (short) 1);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest11 = pageRequest10.previous();
        java.lang.String str12 = pageRequest10.toString();
        org.springframework.data.domain.Sort sort13 = pageRequest10.getSort();
        int int14 = pageRequest10.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest17 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional18 = pageRequest17.toOptional();
        org.springframework.data.domain.PageRequest pageRequest19 = pageRequest17.next();
        org.springframework.data.domain.PageRequest pageRequest20 = pageRequest17.first();
        org.springframework.data.domain.Sort sort21 = pageRequest20.getSort();
        org.springframework.data.domain.Sort sort22 = pageRequest10.getSortOr(sort21);
        org.springframework.data.domain.Sort sort23 = pageRequest4.getSortOr(sort21);
        org.springframework.data.domain.PageRequest pageRequest24 = org.springframework.data.domain.PageRequest.of(100, 101, sort23);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageableOptional5);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest8);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str12, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(sort13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(pageableOptional18);
        org.junit.Assert.assertNotNull(pageRequest19);
        org.junit.Assert.assertNotNull(pageRequest20);
        org.junit.Assert.assertNotNull(sort21);
        org.junit.Assert.assertNotNull(sort22);
        org.junit.Assert.assertNotNull(sort23);
        org.junit.Assert.assertNotNull(pageRequest24);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test159");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest3);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition11 = pageRequest10.toScrollPosition();
        boolean boolean12 = pageRequest10.isUnpaged();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional13 = pageRequest10.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage14 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.PageRequest pageRequest17 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit18 = pageRequest17.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition19 = pageRequest17.toScrollPosition();
        java.lang.String str20 = pageRequest17.toString();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage21 = commandLogic0.search("Page request [number: 0, size 10, sort: UNSORTED]", (org.springframework.data.domain.Pageable) pageRequest17);
        org.springframework.data.domain.PageRequest pageRequest25 = org.springframework.data.domain.PageRequest.of((int) (short) 1, 99);
        org.springframework.data.domain.PageRequest pageRequest27 = pageRequest25.withPage(99);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage28 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest25);
        org.springframework.data.domain.PageRequest pageRequest32 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional33 = pageRequest32.toOptional();
        org.springframework.data.domain.PageRequest pageRequest34 = pageRequest32.next();
        org.springframework.data.domain.PageRequest pageRequest36 = pageRequest32.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional37 = pageRequest32.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage38 = commandLogic0.search("Page request [number: 99, size 99, sort: UNSORTED]", (org.springframework.data.domain.Pageable) pageRequest32);
        org.springframework.data.domain.PageRequest pageRequest40 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest41 = pageRequest40.previous();
        java.lang.String str42 = pageRequest40.toString();
        java.lang.String str43 = pageRequest40.toString();
        boolean boolean44 = pageRequest40.isUnpaged();
        org.springframework.data.domain.Sort sort45 = pageRequest40.getSort();
        org.springframework.data.domain.PageRequest pageRequest46 = pageRequest32.withSort(sort45);
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(offsetScrollPosition11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(pageableOptional13);
        org.junit.Assert.assertNotNull(commandTOPage14);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(limit18);
        org.junit.Assert.assertNotNull(offsetScrollPosition19);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str20, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(commandTOPage21);
        org.junit.Assert.assertNotNull(pageRequest25);
        org.junit.Assert.assertNotNull(pageRequest27);
        org.junit.Assert.assertNotNull(commandTOPage28);
        org.junit.Assert.assertNotNull(pageRequest32);
        org.junit.Assert.assertNotNull(pageableOptional33);
        org.junit.Assert.assertNotNull(pageRequest34);
        org.junit.Assert.assertNotNull(pageRequest36);
        org.junit.Assert.assertNotNull(pageableOptional37);
        org.junit.Assert.assertNotNull(commandTOPage38);
        org.junit.Assert.assertNotNull(pageRequest40);
        org.junit.Assert.assertNotNull(pageRequest41);
        org.junit.Assert.assertEquals("'" + str42 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str42, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertEquals("'" + str43 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str43, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNotNull(sort45);
        org.junit.Assert.assertNotNull(pageRequest46);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test160");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest1.withPage(101);
        org.springframework.data.domain.PageRequest pageRequest7 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit8 = pageRequest7.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition9 = pageRequest7.toScrollPosition();
        java.lang.String str10 = pageRequest7.toString();
        org.springframework.data.domain.PageRequest pageRequest12 = pageRequest7.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest15 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional16 = pageRequest15.toOptional();
        org.springframework.data.domain.PageRequest pageRequest17 = pageRequest15.next();
        org.springframework.data.domain.PageRequest pageRequest19 = pageRequest15.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional20 = pageRequest15.toOptional();
        org.springframework.data.domain.PageRequest pageRequest22 = pageRequest15.withPage((int) (short) 0);
        org.springframework.data.domain.Sort sort23 = pageRequest22.getSort();
        boolean boolean24 = pageRequest7.equals((java.lang.Object) sort23);
        boolean boolean25 = pageRequest5.equals((java.lang.Object) sort23);
        org.springframework.data.domain.PageRequest pageRequest26 = pageRequest5.next();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertNotNull(limit8);
        org.junit.Assert.assertNotNull(offsetScrollPosition9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str10, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(pageRequest15);
        org.junit.Assert.assertNotNull(pageableOptional16);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(pageRequest19);
        org.junit.Assert.assertNotNull(pageableOptional20);
        org.junit.Assert.assertNotNull(pageRequest22);
        org.junit.Assert.assertNotNull(sort23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(pageRequest26);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test161");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("hi!");
        org.apache.syncope.common.lib.command.CommandTO commandTO2 = builder1.build();
        org.junit.Assert.assertNotNull(commandTO2);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test162");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("Page request [number: 0, size 10, sort: UNSORTED]");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder3.build();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = commandTO4.getArgs();
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(commandTO4);
        org.junit.Assert.assertNull(commandArgs5);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test163");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        boolean boolean5 = pageRequest1.equals((java.lang.Object) 100.0f);
        boolean boolean6 = pageRequest1.isUnpaged();
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest1.first();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(pageRequest7);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test164");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional4 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest8 = org.springframework.data.domain.PageRequest.of((int) (short) 1, 99);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit11 = pageRequest10.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition12 = pageRequest10.toScrollPosition();
        java.lang.String str13 = pageRequest10.toString();
        org.springframework.data.domain.PageRequest pageRequest15 = pageRequest10.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest18 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional19 = pageRequest18.toOptional();
        org.springframework.data.domain.PageRequest pageRequest20 = pageRequest18.next();
        org.springframework.data.domain.PageRequest pageRequest21 = pageRequest18.first();
        org.springframework.data.domain.Sort sort22 = pageRequest21.getSort();
        org.springframework.data.domain.Sort sort23 = pageRequest15.getSortOr(sort22);
        org.springframework.data.domain.PageRequest pageRequest24 = pageRequest8.withSort(sort22);
        org.springframework.data.domain.PageRequest pageRequest25 = pageRequest2.withSort(sort22);
        org.springframework.data.domain.Limit limit26 = pageRequest25.toLimit();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertNotNull(pageableOptional4);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(pageRequest8);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(limit11);
        org.junit.Assert.assertNotNull(offsetScrollPosition12);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str13, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest15);
        org.junit.Assert.assertNotNull(pageRequest18);
        org.junit.Assert.assertNotNull(pageableOptional19);
        org.junit.Assert.assertNotNull(pageRequest20);
        org.junit.Assert.assertNotNull(pageRequest21);
        org.junit.Assert.assertNotNull(sort22);
        org.junit.Assert.assertNotNull(sort23);
        org.junit.Assert.assertNotNull(pageRequest24);
        org.junit.Assert.assertNotNull(pageRequest25);
        org.junit.Assert.assertNotNull(limit26);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test165");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest1.withPage(101);
        org.springframework.data.domain.PageRequest pageRequest7 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit8 = pageRequest7.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition9 = pageRequest7.toScrollPosition();
        java.lang.String str10 = pageRequest7.toString();
        org.springframework.data.domain.PageRequest pageRequest12 = pageRequest7.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest15 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional16 = pageRequest15.toOptional();
        org.springframework.data.domain.PageRequest pageRequest17 = pageRequest15.next();
        org.springframework.data.domain.PageRequest pageRequest19 = pageRequest15.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional20 = pageRequest15.toOptional();
        org.springframework.data.domain.PageRequest pageRequest22 = pageRequest15.withPage((int) (short) 0);
        org.springframework.data.domain.Sort sort23 = pageRequest22.getSort();
        boolean boolean24 = pageRequest7.equals((java.lang.Object) sort23);
        boolean boolean25 = pageRequest5.equals((java.lang.Object) sort23);
        java.lang.Class<?> wildcardClass26 = sort23.getClass();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertNotNull(limit8);
        org.junit.Assert.assertNotNull(offsetScrollPosition9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str10, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(pageRequest15);
        org.junit.Assert.assertNotNull(pageableOptional16);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(pageRequest19);
        org.junit.Assert.assertNotNull(pageableOptional20);
        org.junit.Assert.assertNotNull(pageRequest22);
        org.junit.Assert.assertNotNull(sort23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(wildcardClass26);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test166");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean3 = pageRequest2.isUnpaged();
        int int4 = pageRequest2.getPageSize();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.withPage((int) (byte) 10);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 100 + "'", int4 == 100);
        org.junit.Assert.assertNotNull(pageRequest6);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test167");
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit4 = pageRequest3.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest3.toScrollPosition();
        java.lang.String str6 = pageRequest3.toString();
        org.springframework.data.domain.PageRequest pageRequest8 = pageRequest3.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest11 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional12 = pageRequest11.toOptional();
        org.springframework.data.domain.PageRequest pageRequest13 = pageRequest11.next();
        org.springframework.data.domain.PageRequest pageRequest15 = pageRequest11.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional16 = pageRequest11.toOptional();
        org.springframework.data.domain.PageRequest pageRequest18 = pageRequest11.withPage((int) (short) 0);
        org.springframework.data.domain.Sort sort19 = pageRequest18.getSort();
        boolean boolean20 = pageRequest3.equals((java.lang.Object) sort19);
        org.springframework.data.domain.PageRequest pageRequest21 = org.springframework.data.domain.PageRequest.of(101, (int) 'a', sort19);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(limit4);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str6, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest8);
        org.junit.Assert.assertNotNull(pageRequest11);
        org.junit.Assert.assertNotNull(pageableOptional12);
        org.junit.Assert.assertNotNull(pageRequest13);
        org.junit.Assert.assertNotNull(pageRequest15);
        org.junit.Assert.assertNotNull(pageableOptional16);
        org.junit.Assert.assertNotNull(pageRequest18);
        org.junit.Assert.assertNotNull(sort19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(pageRequest21);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test168");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        boolean boolean4 = pageRequest1.hasPrevious();
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest6 = pageRequest1.withPage((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page index must not be less than zero");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test169");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest1.previous();
        boolean boolean5 = pageRequest4.isUnpaged();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test170");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest2.previous();
        long long4 = pageRequest2.getOffset();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest2.previous();
        org.springframework.data.domain.Sort sort6 = pageRequest5.getSort();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 1000L + "'", long4 == 1000L);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(sort6);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test171");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest1.previous();
        java.lang.String str4 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest1.withPage((int) '4');
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test172");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray3 = new java.lang.String[] {};
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of(101, 101, direction2, strArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertArrayEquals(strArray3, new java.lang.String[] {});
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test173");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize(99);
        org.junit.Assert.assertNotNull(pageRequest1);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test174");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.Limit limit4 = pageRequest2.toLimit();
        java.lang.Class<?> wildcardClass5 = limit4.getClass();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(limit4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test175");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        int int2 = pageRequest1.getPageSize();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest1.toOptional();
        long long4 = pageRequest1.getOffset();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 10 + "'", int2 == 10);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 0L + "'", long4 == 0L);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test176");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        int int4 = pageRequest1.getPageSize();
        long long5 = pageRequest1.getOffset();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 0L + "'", long5 == 0L);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test177");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional5 = pageRequest4.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest4);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage11 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.Pageable pageable12 = pageRequest10.previousOrFirst();
        long long13 = pageRequest10.getOffset();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageableOptional5);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(commandTOPage11);
        org.junit.Assert.assertNotNull(pageable12);
        org.junit.Assert.assertTrue("'" + long13 + "' != '" + 10000L + "'", long13 == 10000L);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test178");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean5 = pageRequest4.isUnpaged();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest4);
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean11 = pageRequest10.isUnpaged();
        int int12 = pageRequest10.getPageSize();
        boolean boolean13 = pageRequest10.hasPrevious();
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional14 = pageRequest10.toOptional();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage15 = commandLogic0.search("Page request [number: 100, size 10, sort: UNSORTED]", (org.springframework.data.domain.Pageable) pageRequest10);
        org.springframework.data.domain.PageRequest pageRequest18 = org.springframework.data.domain.PageRequest.ofSize((int) '4');
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage19 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest18);
        org.springframework.data.domain.PageRequest pageRequest22 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest23 = pageRequest22.previous();
        java.lang.String str24 = pageRequest22.toString();
        org.springframework.data.domain.Sort sort25 = pageRequest22.getSort();
        int int26 = pageRequest22.getPageSize();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage27 = commandLogic0.search("", (org.springframework.data.domain.Pageable) pageRequest22);
        org.springframework.data.domain.PageRequest pageRequest30 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest31 = pageRequest30.previous();
        java.lang.String str32 = pageRequest30.toString();
        org.springframework.data.domain.Sort sort33 = pageRequest30.getSort();
        int int34 = pageRequest30.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest37 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional38 = pageRequest37.toOptional();
        org.springframework.data.domain.PageRequest pageRequest39 = pageRequest37.next();
        org.springframework.data.domain.PageRequest pageRequest40 = pageRequest37.first();
        org.springframework.data.domain.Sort sort41 = pageRequest40.getSort();
        org.springframework.data.domain.Sort sort42 = pageRequest30.getSortOr(sort41);
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage43 = commandLogic0.search("Page request [number: 101, size 10, sort: UNSORTED]", (org.springframework.data.domain.Pageable) pageRequest30);
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 100 + "'", int12 == 100);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNotNull(pageableOptional14);
        org.junit.Assert.assertNotNull(commandTOPage15);
        org.junit.Assert.assertNotNull(pageRequest18);
        org.junit.Assert.assertNotNull(commandTOPage19);
        org.junit.Assert.assertNotNull(pageRequest22);
        org.junit.Assert.assertNotNull(pageRequest23);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str24, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(sort25);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 10 + "'", int26 == 10);
        org.junit.Assert.assertNotNull(commandTOPage27);
        org.junit.Assert.assertNotNull(pageRequest30);
        org.junit.Assert.assertNotNull(pageRequest31);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str32, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(sort33);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertNotNull(pageRequest37);
        org.junit.Assert.assertNotNull(pageableOptional38);
        org.junit.Assert.assertNotNull(pageRequest39);
        org.junit.Assert.assertNotNull(pageRequest40);
        org.junit.Assert.assertNotNull(sort41);
        org.junit.Assert.assertNotNull(sort42);
        org.junit.Assert.assertNotNull(commandTOPage43);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test179");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("Page request [number: 99, size 99, sort: UNSORTED]");
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test180");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray5 = new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest6 = org.springframework.data.domain.PageRequest.of((int) (byte) 0, (int) (short) 100, direction2, strArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertArrayEquals(strArray5, new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "" });
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test181");
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        org.springframework.data.domain.Pageable pageable5 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.pageable();
        boolean boolean6 = pageRequest4.equals((java.lang.Object) pageable5);
        org.springframework.data.domain.Sort sort7 = pageRequest4.getSort();
        org.springframework.data.domain.PageRequest pageRequest8 = org.springframework.data.domain.PageRequest.of((int) '#', (int) (short) 100, sort7);
        org.springframework.data.domain.PageRequest pageRequest9 = pageRequest8.next();
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageable5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(sort7);
        org.junit.Assert.assertNotNull(pageRequest8);
        org.junit.Assert.assertNotNull(pageRequest9);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test182");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        org.springframework.data.domain.Sort.Direction direction4 = null;
        java.lang.String[] strArray9 = new java.lang.String[] { "Page request [number: 101, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 101, size 10, sort: UNSORTED]", "hi!" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest10 = pageRequest1.withSort(direction4, strArray9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new java.lang.String[] { "Page request [number: 101, size 10, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]", "Page request [number: 101, size 10, sort: UNSORTED]", "hi!" });
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test183");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) ' ');
        int int3 = pageRequest2.getPageNumber();
        org.springframework.data.domain.Limit limit4 = pageRequest2.toLimit();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.withPage(1);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertNotNull(limit4);
        org.junit.Assert.assertNotNull(pageRequest6);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test184");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional7 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest9 = pageRequest2.withPage((int) (short) 0);
        org.springframework.data.domain.Sort sort10 = pageRequest9.getSort();
        org.springframework.data.domain.Sort sort11 = pageRequest9.getSort();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageableOptional7);
        org.junit.Assert.assertNotNull(pageRequest9);
        org.junit.Assert.assertNotNull(sort10);
        org.junit.Assert.assertNotNull(sort11);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test185");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest2.next();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest4.toScrollPosition();
        boolean boolean6 = pageRequest4.isPaged();
        org.springframework.data.domain.Limit limit7 = pageRequest4.toLimit();
        java.lang.String str8 = pageRequest4.toString();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(limit7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Page request [number: 101, size 10, sort: UNSORTED]" + "'", str8, "Page request [number: 101, size 10, sort: UNSORTED]");
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test186");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest2 = pageRequest1.previous();
        java.lang.String str3 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest1.withPage((int) (byte) 100);
        boolean boolean6 = pageRequest5.isPaged();
        org.springframework.data.domain.Sort.Direction direction7 = null;
        java.lang.String[] strArray12 = new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "hi!", "Page request [number: 99, size 99, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]" };
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest13 = pageRequest5.withSort(direction7, strArray12);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str3, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(strArray12);
        org.junit.Assert.assertArrayEquals(strArray12, new java.lang.String[] { "Page request [number: 100, size 10, sort: UNSORTED]", "hi!", "Page request [number: 99, size 99, sort: UNSORTED]", "Page request [number: 100, size 10, sort: UNSORTED]" });
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test187");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.Limit limit4 = pageRequest2.toLimit();
        boolean boolean5 = pageRequest2.isUnpaged();
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest2.withPage((int) '#');
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional11 = pageRequest10.toOptional();
        org.springframework.data.domain.PageRequest pageRequest12 = pageRequest10.next();
        org.springframework.data.domain.PageRequest pageRequest14 = pageRequest10.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional15 = pageRequest10.toOptional();
        org.springframework.data.domain.PageRequest pageRequest17 = pageRequest10.withPage((int) (short) 0);
        org.springframework.data.domain.PageRequest pageRequest19 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest20 = pageRequest19.previous();
        java.lang.String str21 = pageRequest19.toString();
        org.springframework.data.domain.Sort sort22 = pageRequest19.getSort();
        int int23 = pageRequest19.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest26 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional27 = pageRequest26.toOptional();
        org.springframework.data.domain.PageRequest pageRequest28 = pageRequest26.next();
        org.springframework.data.domain.PageRequest pageRequest29 = pageRequest26.first();
        org.springframework.data.domain.Sort sort30 = pageRequest29.getSort();
        org.springframework.data.domain.Sort sort31 = pageRequest19.getSortOr(sort30);
        org.springframework.data.domain.Sort sort32 = pageRequest10.getSortOr(sort31);
        org.springframework.data.domain.PageRequest pageRequest33 = pageRequest7.withSort(sort32);
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(limit4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(pageableOptional11);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertNotNull(pageableOptional15);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(pageRequest19);
        org.junit.Assert.assertNotNull(pageRequest20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str21, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(sort22);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertNotNull(pageRequest26);
        org.junit.Assert.assertNotNull(pageableOptional27);
        org.junit.Assert.assertNotNull(pageRequest28);
        org.junit.Assert.assertNotNull(pageRequest29);
        org.junit.Assert.assertNotNull(sort30);
        org.junit.Assert.assertNotNull(sort31);
        org.junit.Assert.assertNotNull(sort32);
        org.junit.Assert.assertNotNull(pageRequest33);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test188");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (short) 10);
        org.springframework.data.domain.PageRequest pageRequest3 = pageRequest1.withPage(99);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional4 = pageRequest3.toOptional();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageableOptional4);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test189");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long2 = pageRequest1.getOffset();
        int int3 = pageRequest1.getPageNumber();
        int int4 = pageRequest1.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest1.first();
        org.springframework.data.domain.PageRequest pageRequest10 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional11 = pageRequest10.toOptional();
        org.springframework.data.domain.PageRequest pageRequest12 = pageRequest10.next();
        org.springframework.data.domain.PageRequest pageRequest14 = pageRequest10.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional15 = pageRequest10.toOptional();
        org.springframework.data.domain.PageRequest pageRequest17 = pageRequest10.withPage((int) (short) 0);
        org.springframework.data.domain.Sort sort18 = pageRequest17.getSort();
        org.springframework.data.domain.PageRequest pageRequest19 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100, sort18);
        org.springframework.data.domain.PageRequest pageRequest20 = pageRequest19.next();
        boolean boolean21 = pageRequest1.equals((java.lang.Object) pageRequest20);
        org.springframework.data.domain.Limit limit22 = pageRequest1.toLimit();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertNotNull(pageRequest10);
        org.junit.Assert.assertNotNull(pageableOptional11);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertNotNull(pageRequest14);
        org.junit.Assert.assertNotNull(pageableOptional15);
        org.junit.Assert.assertNotNull(pageRequest17);
        org.junit.Assert.assertNotNull(sort18);
        org.junit.Assert.assertNotNull(pageRequest19);
        org.junit.Assert.assertNotNull(pageRequest20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(limit22);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test190");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional3 = pageRequest2.toOptional();
        org.springframework.data.domain.Limit limit4 = pageRequest2.toLimit();
        boolean boolean5 = pageRequest2.isUnpaged();
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest2.withPage((int) '#');
        boolean boolean8 = pageRequest2.isPaged();
        org.springframework.data.domain.PageRequest pageRequest9 = pageRequest2.first();
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertNotNull(pageableOptional3);
        org.junit.Assert.assertNotNull(limit4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(pageRequest7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(pageRequest9);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test191");
        org.apache.syncope.common.lib.command.CommandTO.Builder builder1 = new org.apache.syncope.common.lib.command.CommandTO.Builder("Page request [number: 0, size 10, sort: UNSORTED]");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs2 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder3 = builder1.args(commandArgs2);
        org.apache.syncope.common.lib.command.CommandTO commandTO4 = builder3.build();
        org.apache.syncope.common.lib.command.CommandTO commandTO5 = builder3.build();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder7 = builder3.args(commandArgs6);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs8 = null;
        org.apache.syncope.common.lib.command.CommandTO.Builder builder9 = builder3.args(commandArgs8);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(commandTO4);
        org.junit.Assert.assertNotNull(commandTO5);
        org.junit.Assert.assertNotNull(builder7);
        org.junit.Assert.assertNotNull(builder9);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test192");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        java.lang.String str4 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest5 = pageRequest1.previous();
        boolean boolean6 = pageRequest1.isPaged();
        java.lang.String str7 = pageRequest1.toString();
        org.springframework.data.domain.Pageable pageable8 = pageRequest1.previousOrFirst();
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str7, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageable8);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test193");
        org.apache.syncope.core.logic.CommandLogic commandLogic0 = org.apache.syncope.core.logic.randoop.CommandLogicRandoopSeeds.build();
        org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of((int) (byte) 100, (int) (byte) 100);
        boolean boolean5 = pageRequest4.isUnpaged();
        org.springframework.data.domain.Page<org.apache.syncope.common.lib.command.CommandTO> commandTOPage6 = commandLogic0.search("hi!", (org.springframework.data.domain.Pageable) pageRequest4);
        org.springframework.data.domain.PageRequest pageRequest7 = pageRequest4.first();
        org.junit.Assert.assertNotNull(commandLogic0);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(commandTOPage6);
        org.junit.Assert.assertNotNull(pageRequest7);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test194");
        org.springframework.data.domain.PageRequest pageRequest3 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.PageRequest pageRequest4 = pageRequest3.previous();
        java.lang.String str5 = pageRequest3.toString();
        org.springframework.data.domain.Sort sort6 = pageRequest3.getSort();
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest7 = org.springframework.data.domain.PageRequest.of((-1), (int) (byte) 1, sort6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Page index must not be less than zero");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pageRequest3);
        org.junit.Assert.assertNotNull(pageRequest4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str5, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(sort6);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test195");
        org.springframework.data.domain.Sort.Direction direction2 = null;
        java.lang.String[] strArray3 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.springframework.data.domain.PageRequest pageRequest4 = org.springframework.data.domain.PageRequest.of(100, (int) (short) 10, direction2, strArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Direction must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test196");
        org.springframework.data.domain.PageRequest pageRequest2 = org.springframework.data.domain.PageRequest.of(100, 10);
        int int3 = pageRequest2.getPageNumber();
        int int4 = pageRequest2.getPageSize();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition5 = pageRequest2.toScrollPosition();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest2.next();
        org.springframework.data.domain.PageRequest pageRequest8 = pageRequest6.withPage(1);
        org.springframework.data.domain.PageRequest pageRequest9 = pageRequest8.previous();
        boolean boolean11 = pageRequest9.equals((java.lang.Object) "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
        org.junit.Assert.assertNotNull(offsetScrollPosition5);
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest8);
        org.junit.Assert.assertNotNull(pageRequest9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test197");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit2 = pageRequest1.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition3 = pageRequest1.toScrollPosition();
        java.lang.String str4 = pageRequest1.toString();
        org.springframework.data.domain.PageRequest pageRequest6 = pageRequest1.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest8 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long9 = pageRequest8.getOffset();
        boolean boolean10 = pageRequest6.equals((java.lang.Object) pageRequest8);
        org.springframework.data.domain.PageRequest pageRequest12 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        long long13 = pageRequest12.getOffset();
        int int14 = pageRequest12.getPageNumber();
        org.springframework.data.domain.PageRequest pageRequest16 = pageRequest12.withPage(101);
        org.springframework.data.domain.PageRequest pageRequest18 = org.springframework.data.domain.PageRequest.ofSize((int) (byte) 10);
        org.springframework.data.domain.Limit limit19 = pageRequest18.toLimit();
        org.springframework.data.domain.OffsetScrollPosition offsetScrollPosition20 = pageRequest18.toScrollPosition();
        java.lang.String str21 = pageRequest18.toString();
        org.springframework.data.domain.PageRequest pageRequest23 = pageRequest18.withPage((int) (short) 100);
        org.springframework.data.domain.PageRequest pageRequest26 = org.springframework.data.domain.PageRequest.of(100, 10);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional27 = pageRequest26.toOptional();
        org.springframework.data.domain.PageRequest pageRequest28 = pageRequest26.next();
        org.springframework.data.domain.PageRequest pageRequest30 = pageRequest26.withPage((int) (short) 1);
        java.util.Optional<org.springframework.data.domain.Pageable> pageableOptional31 = pageRequest26.toOptional();
        org.springframework.data.domain.PageRequest pageRequest33 = pageRequest26.withPage((int) (short) 0);
        org.springframework.data.domain.Sort sort34 = pageRequest33.getSort();
        boolean boolean35 = pageRequest18.equals((java.lang.Object) sort34);
        boolean boolean36 = pageRequest16.equals((java.lang.Object) sort34);
        org.springframework.data.domain.PageRequest pageRequest37 = pageRequest6.withSort(sort34);
        org.junit.Assert.assertNotNull(pageRequest1);
        org.junit.Assert.assertNotNull(limit2);
        org.junit.Assert.assertNotNull(offsetScrollPosition3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str4, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest6);
        org.junit.Assert.assertNotNull(pageRequest8);
        org.junit.Assert.assertTrue("'" + long9 + "' != '" + 0L + "'", long9 == 0L);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(pageRequest12);
        org.junit.Assert.assertTrue("'" + long13 + "' != '" + 0L + "'", long13 == 0L);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertNotNull(pageRequest16);
        org.junit.Assert.assertNotNull(pageRequest18);
        org.junit.Assert.assertNotNull(limit19);
        org.junit.Assert.assertNotNull(offsetScrollPosition20);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "Page request [number: 0, size 10, sort: UNSORTED]" + "'", str21, "Page request [number: 0, size 10, sort: UNSORTED]");
        org.junit.Assert.assertNotNull(pageRequest23);
        org.junit.Assert.assertNotNull(pageRequest26);
        org.junit.Assert.assertNotNull(pageableOptional27);
        org.junit.Assert.assertNotNull(pageRequest28);
        org.junit.Assert.assertNotNull(pageRequest30);
        org.junit.Assert.assertNotNull(pageableOptional31);
        org.junit.Assert.assertNotNull(pageRequest33);
        org.junit.Assert.assertNotNull(sort34);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(pageRequest37);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test198");
        org.springframework.data.domain.PageRequest pageRequest1 = org.springframework.data.domain.PageRequest.ofSize((int) (short) 1);
        org.junit.Assert.assertNotNull(pageRequest1);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "CommandLogicRandoopRaw0.test199");
        org.apache.syncope.common.lib.command.CommandTO commandTO0 = new org.apache.syncope.common.lib.command.CommandTO();
        commandTO0.setKey("");
        org.apache.syncope.common.lib.command.CommandArgs commandArgs3 = null;
        commandTO0.setArgs(commandArgs3);
        org.apache.syncope.common.lib.command.CommandArgs commandArgs5 = commandTO0.getArgs();
        org.apache.syncope.common.lib.command.CommandArgs commandArgs6 = commandTO0.getArgs();
        org.junit.Assert.assertNull(commandArgs5);
        org.junit.Assert.assertNull(commandArgs6);
    }
}

