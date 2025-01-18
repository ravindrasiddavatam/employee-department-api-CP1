package com.example.Coding1.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;



import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"department"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeNumber; // Unique identifier

    @Column(nullable = false)
    private String employeeName; // Full name of the employee
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department; // Many employees belong to one department

    // Getters and Setters
    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
