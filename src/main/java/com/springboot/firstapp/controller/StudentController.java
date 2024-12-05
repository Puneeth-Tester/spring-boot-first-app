package com.springboot.firstapp.controller;

import com.springboot.firstapp.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Spring Boot Rest API with Path Variable
    // {id} - URI template variable
    // http://localhost:8084/students/1
    @GetMapping("students/{id}")
    //public Student studentPathVariable(@PathVariable int id){
    public Student studentPathVariable(@PathVariable("id") int studentId){
        return new Student(studentId, "Puneeth", "Kumar");
    }

    // http://localhost:8084/students/1/Puneeth/Kumar
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(
            @PathVariable("id") int studentId,
            @PathVariable("first-name") String studentFirstName,
            @PathVariable("last-name") String studentLastName){
        return new Student(studentId, studentFirstName, studentLastName);
    }

    // Spring Boot Rest API with Request Param
    // http://localhost:8084/students/query?id=1
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id, "Asha", "Kiran");
    }

    // http://localhost:8084/students/multi-query?id=1&firstName=Asha&lastName=Kiran
    @GetMapping("students/multi-query")
    public Student studentRequestVariable(
            @RequestParam int id,
            @RequestParam String firstName,
            @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    // Spring boot Rest API that handles HTTP Post Request
    // @PostMapping and @RequestBody
    // http://localhost:8084/students/create
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

}
