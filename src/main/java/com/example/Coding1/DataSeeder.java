package com.example.Coding1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Coding1.Controllers.Repositories.DepartmentRepository;
import com.example.Coding1.Controllers.Repositories.EmployeeRepository;
import com.example.Coding1.Entities.Department;
import com.example.Coding1.Entities.Employee;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) {
        Department itDept = new Department();
        itDept.setDepartmentName("IT");
        departmentRepository.save(itDept);

        Department hrDept = new Department();
        hrDept.setDepartmentName("HR");
        departmentRepository.save(hrDept);

        Employee emp1 = new Employee();
        emp1.setEmployeeName("Alice");
        emp1.setDepartment(itDept);
        employeeRepository.save(emp1);

        Employee emp2 = new Employee();
        emp2.setEmployeeName("Adam");
        emp2.setDepartment(itDept);
        employeeRepository.save(emp2);

        Employee emp3 = new Employee();
        emp3.setEmployeeName("Bob");
        emp3.setDepartment(hrDept);
        employeeRepository.save(emp3);
    }
}
