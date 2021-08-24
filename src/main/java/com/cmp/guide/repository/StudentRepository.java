package com.cmp.guide.repository;

import com.cmp.guide.model.StudentDomain;

public interface StudentRepository {
     StudentDomain getStudentDetails(Integer id);
     String updateStudent(StudentDomain domain);
}
