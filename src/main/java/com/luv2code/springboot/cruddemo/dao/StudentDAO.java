package com.luv2code.springboot.cruddemo.dao;


import com.luv2code.springboot.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> findAll();

    Student findById(int theId);

    Student save(Student theStudent);

    void deleteById(int theId);
}
