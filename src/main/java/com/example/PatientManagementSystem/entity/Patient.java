package com.example.PatientManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 5, max = 20, message = "Name should be between 5 and 20 characters")
    private String name;

    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 150, message = "Age cannot be greater than 150")
    private int age;

    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    @Email(message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "Date of Birth cannot be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of Birth must be in the format yyyy-MM-dd")
    private String dateOfBirth;
}
