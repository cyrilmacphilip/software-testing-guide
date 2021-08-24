package com.cmp.guide.service;

import com.cmp.guide.exception.BadRequestException;
import com.cmp.guide.exception.DataNotFoundException;
import com.cmp.guide.model.StudentDomain;
import com.cmp.guide.repository.StudentRepository;
import com.cmp.guide.view.Student;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DefaultStudentServiceTest {
    @Mock
    private StudentRepository repository;
    private DefaultStudentService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new DefaultStudentService(repository);
    }

    @Test
    public void getStudentDetailsSuccessTest() {
        Mockito.when(repository.getStudentDetails(Mockito.anyInt()))
                .thenReturn(mockValidStudentDomain());
        Student response = service.getStudentDetails(1);
        Assertions.assertEquals(mockValidView(), response);
    }

    @Test
    public void getStudentDetailsDataNotFoundTest() {
        Mockito.when(repository.getStudentDetails(Mockito.anyInt())).thenReturn(null);
        Assertions.assertThrows(DataNotFoundException.class,
                () -> service.getStudentDetails(1));
    }

    @Test
    public void getStudentDetailsIdNotPresentTest() {
        Assertions.assertThrows(BadRequestException.class,
                () -> service.getStudentDetails(null));
    }

    @Test
    public void updateStudentSuccess() {
        Mockito.when(repository.updateStudent(Mockito.any(StudentDomain.class)))
                .thenReturn("updated");
        String response = service.updateStudent(mockValidView());
        Assertions.assertEquals("success", response);
    }

    @Test
    public void updateStudentFail() {
        Mockito.when(repository.updateStudent(Mockito.any(StudentDomain.class)))
                .thenReturn("error");
        String response = service.updateStudent(mockValidView());
        Assertions.assertEquals("fail", response);
    }

    private Student mockValidView() {
        Student student = new Student();
        student.setId(1);
        student.setName("valid-name");
        return student;
    }

    private StudentDomain mockValidStudentDomain() {
        StudentDomain domain = new StudentDomain();
        domain.setName("valid-name");
        domain.setId(1);
        return domain;
    }
}
