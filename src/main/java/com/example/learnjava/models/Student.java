package com.example.learnjava.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;

    @Transient
    private  Integer age;
    private LocalDate birth;
    private  String email;

    public Student(
            Long id,
            String name,
            LocalDate birth,
            String email
    ) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    public Student(
            String name,
            LocalDate birth,
            String email
    )
    {
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

