package com.cmp.guide.service;

import com.cmp.guide.exception.BadRequestException;
import com.cmp.guide.exception.DataNotFoundException;
import com.cmp.guide.model.StudentDomain;
import com.cmp.guide.repository.StudentRepository;
import com.cmp.guide.view.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultStudentService implements StudentService {

    public StudentRepository repository;

    @Autowired
    public DefaultStudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student getStudentDetails(Integer id) {
        if (id == null)
            throw new BadRequestException("Check your id");
        StudentDomain domain = repository.getStudentDetails(id);
        if (domain == null)
            throw new DataNotFoundException("No data for provided id");
        return mapToView(domain);
    }

    @Override
    public String updateStudent(Student detailsToUpdate) {
        String response = repository.updateStudent(mapToDomain(detailsToUpdate));
        if ("updated".equalsIgnoreCase(response))
            return "success";
        else if ("error".equalsIgnoreCase(response))
            return "fail";
        return null;
    }


    private Student mapToView(StudentDomain domain) {
        Student view = new Student();
        view.setId(domain.getId());
        view.setName(domain.getName());
        return view;
    }

    private StudentDomain mapToDomain(Student student) {
        StudentDomain domain = new StudentDomain();
        domain.setName(student.getName());
        return domain;
    }
}
