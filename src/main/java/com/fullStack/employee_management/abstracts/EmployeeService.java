package com.fullStack.employee_management.abstracts;


import com.fullStack.employee_management.entities.Employee;

import java.util.ArrayList;
import java.util.UUID;

public interface EmployeeService {
    Employee findOne(UUID employeeId);

    ArrayList<Employee> findAll();

    void deleteOne(UUID employeeId);

    Employee updateOne(UUID employeeId, Employee employee);

    Employee createOne(Employee employee);
}
