package com.testing.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConditionalTest {

    @Test
    @Disabled("Don't run this test")
    void basicTest() {
        //Execute something
    }
}
