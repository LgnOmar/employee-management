package com.fullStack.employee_management.controllers;


import com.fullStack.employee_management.entities.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    ArrayList<Employee> employees = new ArrayList<>();


    @GetMapping
    public ArrayList<Employee> findAll() {
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> findOne(@PathVariable UUID employeeId) {

        Optional<Employee> employee = employees.stream()
                .filter(emp -> emp.getId().equals(employeeId))
                .findFirst();
        return employee;
    }

    @DeleteMapping("/{employeeId}")
    public void deleteOne(@PathVariable UUID employeeId) {
        Optional<Employee> employee = employees.stream()
                .filter(emp -> emp.getId().equals(employeeId))
                .findFirst();
        if (employee.isPresent()) {
            employees.remove(employee.get());
        }
    }


    @PostMapping
    public Employee createOne(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employees.add(employee);

        return employee;

    }

}
