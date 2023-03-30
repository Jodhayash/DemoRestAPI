package com.itvedant.restapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.restapp.dto.EmployeeName;
import com.itvedant.restapp.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findByDept(String dept);
	
	EmployeeName findByEmpId(Long empId);
		
}
