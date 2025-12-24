package com.testing.test;

import com.testing.component.MvcTestingExampleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    @Test
    void basicTest() {
        System.out.println("Basic Test");
    }
}
