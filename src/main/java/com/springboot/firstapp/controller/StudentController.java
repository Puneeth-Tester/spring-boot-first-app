package com.springboot.firstapp.controller;

import com.springboot.firstapp.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8084/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Puneeth",
                "Kumar"
        );
        // we are configuring the body for the response as well as the status code
        // return new ResponseEntity<>(student, HttpStatus.OK);
        // return ResponseEntity.ok(student);
        return ResponseEntity.ok()
                .header("custom-header", "puneeth")
                .body(student);
    }

    // http://localhost:8084/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Puneeth", "Kumar"));
        students.add(new Student(2, "Asha", "Kiran"));
        students.add(new Student(3, "Athiran", "Puneeth"));
        return ResponseEntity.ok(students);
    }

    // Spring Boot Rest API with Path Variable
    // {id} - URI template variable
    // http://localhost:8084/students/1
    @GetMapping("students/{id}")
    //public Student studentPathVariable(@PathVariable int id){
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId){
        Student student = new Student(studentId, "Puneeth", "Kumar");
        return ResponseEntity.ok(student);
    }

    // http://localhost:8084/students/1/Puneeth/Kumar
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(
            @PathVariable("id") int studentId,
            @PathVariable("first-name") String studentFirstName,
            @PathVariable("last-name") String studentLastName){
        Student student = new Student(studentId, studentFirstName, studentLastName);
        return ResponseEntity.ok(student);
    }

    // Spring Boot Rest API with Request Param
    // http://localhost:8084/students/query?id=1
    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id){
        Student student = new Student(id, "Asha", "Kiran");
        return ResponseEntity.ok(student);
    }

    // http://localhost:8084/students/multi-query?id=1&firstName=Asha&lastName=Kiran
    @GetMapping("students/multi-query")
    public ResponseEntity<Student> studentRequestVariable(
            @RequestParam int id,
            @RequestParam String firstName,
            @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot Rest API that handles HTTP Post Request - creating new resource
    // @PostMapping and @RequestBody
    // http://localhost:8084/students/create
    @PostMapping("students/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring Boot Rest API that handles HTTP PUT Request - updating existing resource
    // http://localhost:8084/students/3/update
    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId){
        //student.setId(studentId); - 3
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student); // return this student to the client
    }

    // Spring Boot Rest API that handles HTTP DELETE Request - deleting the existing resource
    @DeleteMapping("student/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }

}
