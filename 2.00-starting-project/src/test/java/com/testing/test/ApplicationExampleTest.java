package com.testing.test;

import com.testing.component.MvcTestingExampleApplication;
import com.testing.component.models.CollegeStudent;
import com.testing.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    private static int count = 0;

    @Value("${info.app.name}")
    private String appInfo;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    private CollegeStudent student;

    @Autowired
    private StudentGrades studentGrades;

    @BeforeEach
    public void beforeEach() {
        count += 1;
        System.out.println("Testing: " + appInfo + " which is " +
                appDescription + " Version: " + appVersion + ". Execution o test method " + count);

        student.setFirstname("Eric");
        student.setLastname("Roby");
        student.setEmailAddress("eric.roby@testing.com");
        studentGrades.setMathGradeResults(new ArrayList<>(List.of(100.0, 85.0, 76.5, 91.75)));
        student.setStudentGrades(studentGrades);
    }

    @Test
    void basicTest() {
        System.out.println("Basic Test");
    }

    @Test
    @DisplayName("Add grade results for student grades")
    void addGradeResultForStudentGrade() {
        assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(
                student.getStudentGrades().getMathGradeResults()
        ));
    }

    @Test
    @DisplayName("Add grade results for student grades not equal")
    void addGradeResultForStudentGradeNotEqual() {
        assertNotEquals(21.37, studentGrades.addGradeResultsForSingleClass(
                student.getStudentGrades().getMathGradeResults()
        ));
    }

    @Test
    @DisplayName("Is grade greater")
    void isGradeGreaterStudentGrades() {
        assertTrue(studentGrades.isGradeGreater(90, 75), "failure - should be true");
    }

    @Test
    @DisplayName("Is grade greater false")
    void isGradeGreaterStudentGradesFalse() {
        assertFalse(studentGrades.isGradeGreater(50, 87), "failure - should be false");
    }

    @Test
    @DisplayName("Check Null for Student")
    void checkNullForStudentTest() {
        assertNotNull(studentGrades.checkNull(student.getStudentGrades().getMathGradeResults()),
                "failure - should not be null");
    }
}
