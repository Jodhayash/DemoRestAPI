package com.itvedant.restapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

	private Long id;
	public String city;
	public String state;
	public Integer pin;
	private Long empId;
}
