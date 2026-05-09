package com.fullStack.employee_management.services;

import com.fullStack.employee_management.abstracts.EmployeeService;
import com.fullStack.employee_management.entities.Employee;
import com.fullStack.employee_management.shared.CustomResponseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    ArrayList<Employee> employees = new ArrayList<>();


    public Employee findOne(UUID employeeId) {
        Employee employee = employees.stream()
                .filter(emp -> emp.getId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + employeeId + " Not found"
                ));

        return employee;
    }


    public ArrayList<Employee> findAll() {
        return employees;
    }

    public void deleteOne(UUID employeeId) {

        Optional<Employee> employee = employees.stream()
                .filter(emp -> emp.getId().equals(employeeId))
                .findFirst();

        employee.ifPresent(value -> employees.remove(value));
    }

    public Employee updateOne(UUID employeeId, Employee employee) {
        Employee existingEmployee = employees.stream()
                .filter(emp -> emp.getId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with ID: " + employeeId + " not found"
                ));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setHireDate(employee.getHireDate());
        existingEmployee.setDepartmentId(employee.getDepartmentId());

        return existingEmployee;
    }


    public Employee createOne(Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employees.add(employee);

        return employee;
    }
}
