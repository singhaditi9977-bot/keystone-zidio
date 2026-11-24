package com.keystone.DTO;

import javax.management.relation.Role;

import org.jspecify.annotations.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
	
	public String username;
	public String userEmail;
	public String password;
	public String phone;
	public Role role;
	public String firstName;
	public String lastName;
	}