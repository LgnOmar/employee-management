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

    @PutMapping("{employeeId}")
    public Employee updateOne(@PathVariable UUID employeeId,
                              @RequestBody Employee employee) {

        Optional<Employee> existingEmployee = employees.stream()
                .filter(emp -> emp.getId().equals(employeeId))
                .findFirst();

        if (existingEmployee.isPresent()) {
            existingEmployee.get().setFirstName(employee.getFirstName());
            existingEmployee.get().setLastName(employee.getLastName());
            existingEmployee.get().setEmail(employee.getEmail());
            existingEmployee.get().setPhoneNumber(employee.getPhoneNumber());
            existingEmployee.get().setPosition(employee.getPosition());
            existingEmployee.get().setHireDate(employee.getHireDate());
            existingEmployee.get().setDepartmentId(employee.getDepartmentId());
        }
        return employee;
    }


    @PostMapping
    public Employee createOne(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employees.add(employee);

        return employee;

    }

}
