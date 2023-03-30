package com.itvedant.restapp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	private Long deptId;
	
	private String deptName;
	
	private Integer buildingNo;
	
//	@OneToMany
//	private List<Employee> employee;
}
