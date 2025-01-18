package com.example.Coding1.Services;

import com.example.Coding1.Controllers.Repositories.EmployeeRepository;
import com.example.Coding1.Controllers.Repositories.DepartmentRepository;
import com.example.Coding1.Entities.Department;
import com.example.Coding1.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeInfoBusinessService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeInfoBusinessService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    // 1. Get all employees in a department sorted by employee number
    public List<Employee> getEmployeesByDepartmentSorted(String departmentName) {
        Department department = departmentRepository.findByDepartmentName(departmentName);
        if (department == null) {
            return Collections.emptyList(); // Return an empty list if department not found
        }
        return employeeRepository.findByDepartmentOrderByEmployeeNumber(department);
    }

    // 2. Get employees in a department whose names start with "A" (case insensitive)
    public List<Employee> getEmployeesByDepartmentAndNamePrefix(String departmentName, String prefix) {
        Department department = departmentRepository.findByDepartmentName(departmentName);
        if (department == null) {
            return Collections.emptyList(); // Return an empty list if department not found
        }
        return employeeRepository.findByDepartmentAndEmployeeNameStartingWithIgnoreCase(department, prefix);
    }

    // 3. Get all employees sorted by department name and employee number
    public List<Employee> getAllEmployeesSorted() {
        return employeeRepository.findAllByOrderByDepartment_DepartmentNameAscEmployeeNumberAsc();
    }

    // 4. Get the department name for a given employee number
    public String getDepartmentNameByEmployeeNumber(Long employeeNumber) {
        Employee employee = employeeRepository.findById(employeeNumber).orElse(null);
        if (employee == null || employee.getDepartment() == null) {
            return "No department found for the given employee number.";
        }
        return employee.getDepartment().getDepartmentName();
    }
}