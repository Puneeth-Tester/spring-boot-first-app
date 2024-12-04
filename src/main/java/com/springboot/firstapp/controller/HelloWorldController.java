package com.springboot.firstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {

    // HTTP Get Request
    // http://localhost:8084/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }
}
