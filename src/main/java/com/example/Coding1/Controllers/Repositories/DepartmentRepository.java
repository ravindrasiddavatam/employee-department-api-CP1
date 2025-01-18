package com.example.Coding1.Controllers.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Coding1.Entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	 Department findByDepartmentName(String departmentName);
}
