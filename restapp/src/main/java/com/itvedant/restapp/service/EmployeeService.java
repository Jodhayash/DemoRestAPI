package com.itvedant.restapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public EmployeeDTO findEmployeeById(Long empId) {
		
		//Logic to read the object
		Employee emp = employeeRepository.findById(empId).orElse(null);
		
		if(emp==null) {
			return null;
		}
		
		EmployeeDTO empDto = new EmployeeDTO();
		BeanUtils.copyProperties(emp, empDto);
		
		return empDto;
	}
}
