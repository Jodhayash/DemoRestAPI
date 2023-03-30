package com.itvedant.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.restapp.dto.AddressDTO;
import com.itvedant.restapp.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("")
	public ResponseEntity<String> saveEmployeeAddress(@RequestBody AddressDTO addressDTO) {

		boolean res = addressService.saveEmpAddress(addressDTO);

		if (res == true)
			return new ResponseEntity<>("Address Saved", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Employee with given Id does not exists", HttpStatus.BAD_REQUEST);
	}
}
