package com.cmp.guide.repository;

import com.cmp.guide.model.StudentDomain;
import org.springframework.stereotype.Repository;

@Repository
public class DemoStudentRepository implements StudentRepository{
    @Override
    public StudentDomain getStudentDetails(Integer id) {
        return null;
    }

    @Override
    public String updateStudent(StudentDomain domain) {
        return null;
    }
}
