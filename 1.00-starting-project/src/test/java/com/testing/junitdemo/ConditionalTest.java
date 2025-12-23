package com.testing.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConditionalTest {

    @Test
    @Disabled("Don't run this test")
    void basicTest() {
        //Execute something
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindows() {
        System.out.println("Enabled on Windows");
    }
}
