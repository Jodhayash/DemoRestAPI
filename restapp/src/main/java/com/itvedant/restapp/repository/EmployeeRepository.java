package com.itvedant.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.restapp.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
