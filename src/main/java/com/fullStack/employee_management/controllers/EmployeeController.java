package com.fullStack.employee_management.controllers;


import com.fullStack.employee_management.entities.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    ArrayList<Employee> employees = new ArrayList<>(
            List.of(
                    new Employee(
                            UUID.randomUUID(),
                            "Ahmed",
                            "LAGGOUNE",
                            "laggouneahmedomar@gmail.com",
                            "0657599501",
                            LocalDate.of(2024, 2, 24),
                            "Software Engineer",
                            UUID.randomUUID()
                    ),
                    new Employee(
                            UUID.randomUUID(),
                            "Omar",
                            "LAARBI",
                            "omarlaarbi@gmail.com",
                            "0542834640",
                            LocalDate.of(2024, 2, 24),
                            "DevOps Engineer",
                            UUID.randomUUID()
                    )

            )
    );


    @GetMapping
    public ArrayList<Employee> findAll(){
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> findOne(@PathVariable UUID employeeId){

        Optional<Employee> employee = employees.stream()
                .filter(emp -> emp.getId().equals(employeeId))
                .findFirst();

        return employee;
    }

}
