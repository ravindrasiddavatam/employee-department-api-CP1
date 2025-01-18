package com.example.Coding1.Controllers;

import com.example.Coding1.Controllers.Repositories.EmployeeRepository;
import com.example.Coding1.Entities.Employee;
import com.example.Coding1.Services.EmployeeInfoBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeInfoBusinessService businessService;

    @Autowired
    public EmployeeController(EmployeeInfoBusinessService businessService) {
        this.businessService = businessService;
    }

    // 1. Retrieve all employees for a given department name and sorted by employee name
    @GetMapping("/department/{departmentName}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(
            @PathVariable String departmentName) {
        List<Employee> employees = businessService.getEmployeesByDepartmentSorted(departmentName);
        return ResponseEntity.ok(employees);
    }

    // 2. Retrieve employees whose names start with "A" (case insensitive) in a department
    @GetMapping("/department/{departmentName}/starts-with/{prefix}")
    public ResponseEntity<List<Employee>> getEmployeesByPrefix(
            @PathVariable String departmentName,
            @PathVariable String prefix) {
        List<Employee> employees = businessService.getEmployeesByDepartmentAndNamePrefix(departmentName, prefix);
        return ResponseEntity.ok(employees);
    }

    // 3. Retrieve all employees sorted by department name and employee number
    @GetMapping("/sorted")
    public ResponseEntity<List<Employee>> getAllEmployeesSorted() {
        List<Employee> employees = businessService.getAllEmployeesSorted();
        return ResponseEntity.ok(employees);
    }

    // 4. Retrieve the department name for a given employee number
    @GetMapping("/{employeeNumber}/department")
    public ResponseEntity<String> getDepartmentName(
            @PathVariable Long employeeNumber) {
        String departmentName = businessService.getDepartmentNameByEmployeeNumber(employeeNumber);
        return ResponseEntity.ok(departmentName);
    }

    // 5. Add a new employee
    @PostMapping
    public ResponseEntity<String> addEmployee(
            @RequestBody Employee employee) {
        // Normally, this would go through a service method to save the employee
        // Example: `businessService.saveEmployee(employee)`
        return ResponseEntity.ok("Employee added successfully!");
    }
}