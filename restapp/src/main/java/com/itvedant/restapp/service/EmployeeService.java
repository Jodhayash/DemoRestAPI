package com.itvedant.restapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.restapp.dto.EmployeeDTO;
import com.itvedant.restapp.dto.EmployeeName;
import com.itvedant.restapp.entity.Employee;
import com.itvedant.restapp.exceptions.EmployeeNotFoundException;
import com.itvedant.restapp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<EmployeeDTO> getAllEmployees() {

		List<Employee> empList = employeeRepository.findAll();

		List<EmployeeDTO> empDTOList = new ArrayList<>();

		empList.forEach(e -> {
			EmployeeDTO empDTO = new EmployeeDTO();

			BeanUtils.copyProperties(e, empDTO);
			empDTOList.add(empDTO);
		});

		return empDTOList;
	}

	public Boolean addEmployee(EmployeeDTO empDTO) {
		// Logic to save the data
		Employee emp = new Employee();
		BeanUtils.copyProperties(empDTO, emp);
		employeeRepository.save(emp);
		return Boolean.TRUE;
	}

	public EmployeeDTO findEmployeeById(Long empId) {

		// Logic to read the object
		Employee emp = employeeRepository.findById(empId).orElse(null);

		if (emp == null) {
			throw new EmployeeNotFoundException("EmployeeNotFound");
		}

		EmployeeDTO empDto = new EmployeeDTO();
		BeanUtils.copyProperties(emp, empDto);

		return empDto;
	}

	public List<Employee> getEmployeeByDepartment(String dept) {

		return employeeRepository.findByDept(dept);
	}

	public EmployeeDTO updateEmployeeDetails(EmployeeDTO empDTO) {

		boolean res = employeeRepository.existsById(empDTO.getEmpId());

		if (res == false)
			return null;

		Employee emp = new Employee();
		BeanUtils.copyProperties(empDTO, emp);

		Employee e = employeeRepository.save(emp);

		EmployeeDTO updatedEmp = new EmployeeDTO();
		BeanUtils.copyProperties(e, updatedEmp);

		return updatedEmp;
	}
	
	public EmployeeName findEmployeeNameById(Long empId) {

		
		EmployeeName emp = employeeRepository.findByEmpId(empId);

		return emp;
	}
}
