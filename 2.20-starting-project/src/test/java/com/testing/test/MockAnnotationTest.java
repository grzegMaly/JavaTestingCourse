package com.testing.test;

import com.testing.component.MvcTestingExampleApplication;
import com.testing.component.dao.ApplicationDao;
import com.testing.component.models.CollegeStudent;
import com.testing.component.models.StudentGrades;
import com.testing.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    //    @Mock
    @MockitoBean
    private ApplicationDao applicationDao;

    //    @InjectMocks
    @Autowired
    private ApplicationService applicationService;

    @BeforeEach
    void beforeEach() {
        studentOne.setFirstname("Bob");
        studentOne.setLastname("Dark");
        studentOne.setEmailAddress("bob.dark@testing.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @Test
    @DisplayName("When & Verify")
    void assertEqualsAddGradesTest() {
        when(applicationDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults())).thenReturn(100.00);
        assertEquals(100, applicationService.addGradeResultsForSingleClass(studentGrades.getMathGradeResults()));

        verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
        verify(applicationDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }

    @Test
    @DisplayName("Find Gpa")
    void assertEqualsTestFindGpa() {
        when(applicationDao.findGradePointAverage(studentGrades.getMathGradeResults()))
                .thenReturn(88.31);
        assertEquals(88.31, applicationService.findGradePointAverage(
                studentOne.getStudentGrades().getMathGradeResults()
        ));
    }

    @Test
    @DisplayName("Not null")
    void assertNotNullTest() {
        when(applicationDao.checkNull(studentGrades.getMathGradeResults()))
                .thenReturn(List.of(75.0, 100.0, 54.0));
        assertNotNull(
                applicationService.checkNull(studentOne.getStudentGrades().getMathGradeResults()),
                "Object should not be null"
        );
    }

    @Test
    @DisplayName("Throw Runtime Exception")
    void throwRuntimeExceptionTest() {
        CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");
        doThrow(new RuntimeException()).when(applicationDao).checkNull(nullStudent);

        assertThrows(RuntimeException.class, () -> applicationService.checkNull(nullStudent));

        verify(applicationDao, times(1)).checkNull(nullStudent);
    }
}
