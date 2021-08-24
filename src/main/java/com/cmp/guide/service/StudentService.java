package com.cmp.guide.service;

import com.cmp.guide.view.Student;

public interface StudentService {
    Student getStudentDetails(Integer id);
    String updateStudent(Student detailsToUpdate);
}
