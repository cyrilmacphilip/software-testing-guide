package com.cmp.guide.controller;

import com.cmp.guide.service.StudentService;
import com.cmp.guide.view.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public @ResponseBody Student getStudentDetails(@PathVariable("id") Integer id) {
        return service.getStudentDetails(id);
    }
}
