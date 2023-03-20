package com.itvedant.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.restapp.dto.EmployeeDTO;
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
	public ResponseEntity<String> saveEmployeeInfo(@RequestBody EmployeeDTO emplyeeDTO) {
		Boolean res = employeeService.addEmployee(emplyeeDTO);

		if (res == Boolean.TRUE)
			return new ResponseEntity<>("Data Saved", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Unable to save", HttpStatus.BAD_REQUEST);
	}

}
