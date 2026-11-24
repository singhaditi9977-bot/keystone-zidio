package com.keystone.Security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.keystone.Entity.UserAuth;
import com.keystone.Enum.Permissions;
import com.keystone.Repositery.UserAuthRepositery;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserAuthRepositery userRepo;

	
	@Override
	public UserDetails loadUserByUsername(String userEmail) {

	    UserAuth user = userRepo.findByUserEmail(userEmail)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    return new org.springframework.security.core.userdetails.User(
	            user.getUserEmail(),
	            user.getPassword(),
	            new java.util.ArrayList<>()
	    );
	}
}