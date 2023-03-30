package com.itvedant.restapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.restapp.dto.EmployeeDTO;
import com.itvedant.restapp.dto.EmployeeName;
import com.itvedant.restapp.entity.Employee;
import com.itvedant.restapp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeDTO> empDTOList = employeeService.getAllEmployees();
		return new ResponseEntity<>(empDTOList, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<String> saveEmployeeInfo(@RequestBody @Valid EmployeeDTO emplyeeDTO) {
		Boolean res = employeeService.addEmployee(emplyeeDTO);

		if (res == Boolean.TRUE)
			return new ResponseEntity<>("Data Saved", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Unable to save", HttpStatus.BAD_REQUEST);
	}

	// localhost:8080/employee/4
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Long empId) {

		EmployeeDTO employee = employeeService.findEmployeeById(empId);

		if (employee == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
		
		EmployeeDTO emp = employeeService.updateEmployeeDetails(employeeDTO);
		
		if(emp==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(emp,HttpStatus.OK);		
	}
	
	//localhost:8080/employee?dept=HR
	@GetMapping("")
	public ResponseEntity<List<Employee>> getEmployeeByDept(@RequestParam String dept){
		
//		List<Employee> empList = employeeService.getEmployeeByDepartment(dept);
//		return new ResponseEntity<>(empList,HttpStatus.OK);

		return new ResponseEntity<>(employeeService.getEmployeeByDepartment(dept),HttpStatus.OK);
	}
	
	@GetMapping("/name/{id}")
	public ResponseEntity<EmployeeName> getEmployeeName(@PathVariable("id") Long empId) {

		EmployeeName employee = employeeService.findEmployeeNameById(empId);

		if (employee == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
