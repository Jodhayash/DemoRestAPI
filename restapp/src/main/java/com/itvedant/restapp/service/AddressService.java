package com.itvedant.restapp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.restapp.dto.AddressDTO;
import com.itvedant.restapp.entity.Address;
import com.itvedant.restapp.entity.Employee;
import com.itvedant.restapp.repository.AddressRepository;
import com.itvedant.restapp.repository.EmployeeRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public boolean saveEmpAddress(AddressDTO addressDTO) {
		
		Address address = new Address();
		BeanUtils.copyProperties(addressDTO, address);
		
		Employee emp = employeeRepository.findById(addressDTO.getEmpId()).orElse(null);
		if(emp == null)
			return false;
		
		//address.setEmployee(emp);
		emp.setAddress(address);
		
		employeeRepository.save(emp);
		return true;
	}
}
