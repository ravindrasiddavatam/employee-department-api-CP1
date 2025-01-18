package com.example.Coding1.Controllers.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Coding1.Entities.Department;
import com.example.Coding1.Entities.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find all employees in a specific department sorted by employee number
    List<Employee> findByDepartmentOrderByEmployeeNumber(Department department);

    // Find all employees in a department whose names start with "A" (case insensitive)
    List<Employee> findByDepartmentAndEmployeeNameStartingWithIgnoreCase(Department department, String namePrefix);

    // Find all employees sorted by department name and then by employee number
    List<Employee> findAllByOrderByDepartment_DepartmentNameAscEmployeeNumberAsc();
}