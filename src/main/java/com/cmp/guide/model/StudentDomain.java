package com.cmp.guide.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "student")
@Entity
@Data
public class StudentDomain {
    @Id
    @GeneratedValue
    private int id;
    private String name;
}
