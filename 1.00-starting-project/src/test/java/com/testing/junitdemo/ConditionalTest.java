package com.testing.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.*;

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

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMAC() {
        System.out.println("Enabled on MAC");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinux() {
        System.out.println("Enabled on Linux");
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    void testForLinuxAndWindows() {
        System.out.println("Enabled on Linux And Windows");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testEnabledOnJre17() {
        System.out.println("Enabled on JRE-17");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_21)
    void testEnabledOnJre21() {
        System.out.println("Enabled on JRE-21");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_19)
    void testEnabledOnJreRange() {
        System.out.println("Enabled for range {17, 19}");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_18)
    void testEnabledForJreRangeMin18() {
        System.out.println("Enabled for range min 18");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "prof", matches = "DEV")
    void testDevEnv() {
        System.out.println("Enabled for dev env");
    }

    @Test
    @EnabledIfSystemProperty(named = "sys_prop", matches = "test")
    void testSysProps() {
        System.out.println("Enabled for system property");
    }
}
