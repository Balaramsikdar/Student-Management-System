package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.dao.StudentDAO;
import com.luv2code.springboot.cruddemo.entity.Student;
import com.luv2code.springboot.cruddemo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService theStudentService){
        studentService=theStudentService;
    }

    @GetMapping("/students")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        Student theStudent=studentService.findById(studentId);
        if(theStudent==null){
            throw new RuntimeException("Student id not found - " + studentId);
        }
        return theStudent;
    }

    //add employee
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent){
        theStudent.setId(0);
        Student dbStudent=studentService.save(theStudent);
        return dbStudent;
    }

    //update id
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent){
        Student dbStudent=studentService.save(theStudent);
        return dbStudent;
    }

    //delete student
    @DeleteMapping("/students/{studentId}")
    public String deleteEmployee(@PathVariable int studentId){
        Student tempStudent=studentService.findById(studentId);

        if(tempStudent==null){
            throw new RuntimeException("Student id not found - " + studentId);
        }
        studentService.deleteById(studentId);
        return "Deleted student id - " + studentId;
    }

}
