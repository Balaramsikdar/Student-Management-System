package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDAOJpaImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOJpaImpl(EntityManager theEntityManger){
        entityManager=theEntityManger;
    }
    @Override
    public List<Student> findAll() {

        TypedQuery<Student>theQuery=entityManager.createQuery("from Student", Student.class);

        List<Student>students=theQuery.getResultList();

        return students;
    }

    @Override
    public Student findById(int theId) {

        //get student
        Student theStudent=entityManager.find(Student.class,theId);

        //return student
        return theStudent;
    }

    @Override
    public Student save(Student theStudent) {

        //save student

        Student dbStudent=entityManager.merge(theStudent);

        //return the dbStudent
        return dbStudent;
    }

    @Override
    public void deleteById(int theId) {

        //find student by id
        Student theStudent=entityManager.find(Student.class,theId);

        //remove employee
        entityManager.remove(theStudent);

    }


}
