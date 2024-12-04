package com.springboot.firstapp.controller;

import com.springboot.firstapp.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    // http://localhost:8084/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Puneeth",
                "Kumar"
        );
        return student;
    }
}
