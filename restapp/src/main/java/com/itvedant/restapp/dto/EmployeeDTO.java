package com.itvedant.restapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.itvedant.restapp.validators.PhoneNumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	
	private Long empId;
	
	@Size(min=3, message="Name should have atleast 3 chars")
	private String fname;
	
	private String lname;
	
	@NotNull(message = "Dept can not be null")
	private String Dept;
	
	@Email(message ="Not an valid email")
	private String email;
	
	//@PhoneNumber
	private String mobileNo;
	
	private Integer age;
	
}
