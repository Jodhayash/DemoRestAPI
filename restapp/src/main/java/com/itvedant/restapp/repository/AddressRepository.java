package com.itvedant.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.restapp.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
