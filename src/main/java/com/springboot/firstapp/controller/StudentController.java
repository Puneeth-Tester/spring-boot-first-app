package com.springboot.firstapp.controller;

import com.springboot.firstapp.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    // http://localhost:8084/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Puneeth", "Kumar"));
        students.add(new Student(2, "Asha", "Kiran"));
        students.add(new Student(3, "Athiran", "Puneeth"));
        return students;
    }
}
