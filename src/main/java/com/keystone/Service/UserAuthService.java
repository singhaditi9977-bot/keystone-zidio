package com.keystone.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.keystone.DTO.AuthResponse;
import com.keystone.DTO.ForgotPasswordDTO;
import com.keystone.DTO.LoginRequest;
import com.keystone.DTO.RegisterRequest;
import com.keystone.DTO.ResetPasswordDTO;
import com.keystone.Entity.UserAuth;
import com.keystone.Repositery.UserAuthRepositery;
import com.keystone.Security.EmailService;
import com.keystone.Security.JwtTokenUtil;
import com.keystone.Security.TokenKillService;

import jakarta.servlet.http.HttpServletRequest;

@Service 
public class UserAuthService {

	
	
	@Autowired
	private UserAuthRepositery userRepo;
	@Autowired
	private JwtTokenUtil jwtUtil;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private EmailService emailService;
	@Autowired
	private TokenKillService tokenKillService;
	
	
	public AuthResponse register(RegisterRequest register) {

		Optional<UserAuth> existingUser =
		        userRepo.findByUserEmail(register.userEmail);

		if (existingUser.isPresent()) {
		    throw new RuntimeException("User already exists");
		}

		UserAuth user = new UserAuth();

		
		user.setUserName(register.username);
		user.setUserEmail(register.userEmail);
		user.setPassword(passwordEncoder.encode(register.password));
		user.setPhone(register.phone);
		user.setFirstName(register.firstName);
		user.setLastName(register.lastName);
		userRepo.save(user);

	    String token = jwtUtil.generateToken(user);

	    return new AuthResponse(token, "User registered successfully");
	}
	
	public String login(LoginRequest login) {
	
		UserAuth user=userRepo.findByUserEmail(login.userEmail)
				.orElseThrow(()-> new RuntimeException("User not found"));
		if(!passwordEncoder.matches(login.password, user.getPassword())) {
			
		}
		
		return jwtUtil.generateToken(user);
		
	}
public void forgotPassword(ForgotPasswordDTO forgotPassword) {
		
		UserAuth user = userRepo.findByUserEmail(forgotPassword.userEmail)
				.orElseThrow(()-> new RuntimeException("User not found"));
		
		String token = UUID.randomUUID().toString();
		
		user.setResetToken(token);
		user.setResetTokenExpire(new Date(System.currentTimeMillis()+10*60*1000));
		
		userRepo.save(user);
		System.out.println("Reset password;"+token);
		
		String resetPasswordLink =
		        "http://localhost:7979/auth/reset-password?token=" + token;
}
public void resetPassword(ResetPasswordDTO resetpassword) {
	
	UserAuth user = userRepo.findByResetToken(resetpassword.token).orElseThrow(()-> new RuntimeException("Inavlid password"));
	
	if(user.getResetTokenExpire().before(new Date())) {
		
	}
	
	user.setPassword(passwordEncoder.encode(resetpassword.newPassword));
	user.setResetTokenExpire(null);
	user.setResetTokenExpire(null);
	
	userRepo.save(user);
}

public String logout(HttpServletRequest request) {
	
	String header = request.getHeader("Authorization");
	String token = jwtUtil.extractToken(header);
	
	if(token != null) {
		tokenKillService.blockListToken(token);
	}
	return "Logged out successully"; 
}
}
