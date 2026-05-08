package com.fullStack.employee_management.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/hello")
    public String helloWorld(){

        return "Hello World!";
    }
}
