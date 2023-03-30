package com.itvedant.restapp.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity(name="emp_address")
@EntityListeners(AuditingEntityListener.class)
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public String city;
	public String state;
	public Integer pin;
	
	@CreatedDate
	private Instant createdAt;
	
	@LastModifiedDate
	private Instant modifiedAt;
	
//	@OneToOne(mappedBy= "address")
//	private Employee employee;
}
