package com.fullStack.employee_management.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private UUID id;
    @NotNull(message = "First name is required")
    @Size(min = 2, max = 50, message = "Min is 2 characters and max is 50")
    private String firstName;
    @NotNull(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Min is 2 characters and max is 50")
    private String lastName;
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "Phone is required")
    @Pattern(regexp = "^\\+?[0-9]{10}$", message = "Invalid phone number format")
    private String phoneNumber;


    @NotNull(message = "Hire Date is required")
    @PastOrPresent(message = "Hire date cannot be in the future")
//    @Size(min = 2, max = 50, message = "Min is 2 characters and max is 50")
    private LocalDate hireDate;

    @NotNull(message = "Hire Date is required")
    @Size(min = 2, max = 50, message = "Min is 2 characters and max is 50")
    private String position;

    private UUID departmentId;
}
