package com.testing.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

    private DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    @Order(1)
    @DisplayName("Equals and Not Equals")
    void test_equals_and_not_equals() {

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @Order(2)
    @DisplayName("Null and Not Null")
    void test_null_and_not_null() {

        String str1 = null;
        String str2 = "cosik";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @Test
    @Order(3)
    @DisplayName("Same and Not Same")
    void testSameAndNotSame() {
        String str = "Str1";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to the same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects shouldnot refer to the same object");
    }

    @Test
    @Order(4)
    @DisplayName("True and False")
    void testTrueFalse() {
        int gradeOne = 10;
        int graneTwo = 5;
        assertTrue(demoUtils.isGreater(gradeOne, graneTwo), "This should return true");
        assertFalse(demoUtils.isGreater(graneTwo, gradeOne), "This should return false");
    }


    @Test
    @Order(5)
    @DisplayName("Array Equals")
    void testArrayEquals() {

        String[] stringArr = {"A", "B", "C"};
        assertArrayEquals(stringArr, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be equal");
    }

    @Test
    @Order(6)
    @DisplayName("Iterable Equals")
    void testIterableEquals() {

        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
    }

    @Test
    @Order(7)
    @DisplayName("Lines Match")
    void testLinesMatch() {
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }

    @Test
    @Order(8)
    @DisplayName("Throws and Does Not Throw")
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-1), "Should throw exception");
        assertDoesNotThrow(() -> demoUtils.throwException(9), "Should not throw exception");
    }

    @Test
    @Order(9)
    @DisplayName("Timeout")
    void testTimeout() {
        assertTimeout(Duration.ofSeconds(3), () -> demoUtils.checkTimeout(), "Method should execute in 3 seconds");
    }

    /*@AfterEach
    void tearDownAfterEach() {
        System.out.println("Running @AfterEach\n");
    }

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("@BeforeAll executes only once before all test methods");
    }

    @AfterAll
    static void setupAfterAll() {
        System.out.println("@AfterAll executes only once after all test methods");
    }*/
}
