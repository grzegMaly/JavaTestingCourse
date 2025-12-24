package com.testing.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

    @Test
    @Order(1)
    @DisplayName("Divisible by Three")
    void testForDivisibleByThree() {

        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    @Test
    @Order(2)
    @DisplayName("Divisible by Five")
    void testForDivisibleByFive() {

        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    @Test
    @Order(3)
    @DisplayName("Divisible by Three And Five")
    void testForDivisibleByThreeAndFive() {

        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    @Test
    @Order(4)
    @DisplayName("Not Divisible")
    void testNotDivisible() {

        String expected = "13";

        assertEquals(expected, FizzBuzz.compute(13), "Should return 13");
    }

    @Order(5)
    @DisplayName("From CSV Source")
    @ParameterizedTest(name = "value = {0}, expected = {1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    void testFromCsvSource(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Should return %s".formatted(expected));
    }

    @Order(6)
    @DisplayName("From CSV Med Source")
    @ParameterizedTest(name = "value = {0}, expected = {1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    void testFromCsvMedSource(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Should return %s".formatted(expected));
    }
}
