package com.itvedant.restapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.restapp.dto.EmployeeDTO;
import com.itvedant.restapp.entity.Employee;
import com.itvedant.restapp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<EmployeeDTO> getAllEmployees() {

		List<EmployeeDTO> empList = new ArrayList<>();

		return empList;
	}

	public Boolean addEmployee(EmployeeDTO empDTO) {
		// Logic to save the data
		Employee emp = new Employee();
		BeanUtils.copyProperties(empDTO, emp);
		employeeRepository.save(emp);
		return Boolean.TRUE;
	}
}
