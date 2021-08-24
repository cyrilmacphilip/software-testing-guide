package com.cmp.guide.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Student {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("name")
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Student() {
        //default
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
