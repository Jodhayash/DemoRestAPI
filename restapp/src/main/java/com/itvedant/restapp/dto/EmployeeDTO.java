package com.itvedant.restapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	private Long empId;
	private String fname;
	private String lname;
	private String Dept;
	private String email;
}
