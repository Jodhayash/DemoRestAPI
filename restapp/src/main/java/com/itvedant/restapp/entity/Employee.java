package com.itvedant.restapp.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.AuditingBeanDefinitionParser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="employee_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long empId;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="department")
	private String dept;
	
	@Column(name="email")
	private String email;
	
	private Integer age;
	
	@CreatedDate
	private Instant createdAt;
	
	@LastModifiedDate
	private Instant modifiedAt;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name= "dept_id")
	private Department department;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="emp_project", 
	joinColumns= @JoinColumn(name="employee_id", referencedColumnName="empId"),
	inverseJoinColumns= @JoinColumn(name="projectId"))
	private List<Project> projects;
}
