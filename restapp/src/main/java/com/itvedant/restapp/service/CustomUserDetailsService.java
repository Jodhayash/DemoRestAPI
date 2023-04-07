package com.itvedant.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itvedant.restapp.dto.CustomUserDetails;
import com.itvedant.restapp.entity.User;
import com.itvedant.restapp.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("Username does not exists");
		
		CustomUserDetails variable1 = new CustomUserDetails(user);
		
		return variable1;
	}

}
