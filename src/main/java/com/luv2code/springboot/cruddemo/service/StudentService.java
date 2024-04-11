package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int theId);

    Student save(Student theStudent);

    void deleteById(int theId);
}
