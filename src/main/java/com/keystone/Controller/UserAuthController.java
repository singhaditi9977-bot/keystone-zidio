package com.keystone.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keystone.DTO.AuthResponse;
import com.keystone.DTO.ForgotPasswordDTO;
import com.keystone.DTO.LoginRequest;
import com.keystone.DTO.RegisterRequest;
import com.keystone.DTO.ResetPasswordDTO;
import com.keystone.Service.UserAuthService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user_auth")
@RequiredArgsConstructor
public class UserAuthController {

	@Autowired
	private UserAuthService userService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse>register(@RequestBody RegisterRequest register) {
		return ResponseEntity.ok(userService.register(register));

	}
	 @PostMapping("login")
	 public ResponseEntity<String>login(@RequestBody LoginRequest login){
		 String token = userService.login(login);
		 return ResponseEntity.ok("Login successful");
	 }
	@PostMapping("/forgot-password")
	public ResponseEntity<String>forgotPassword(@RequestBody ForgotPasswordDTO forgotPassword){
		userService.forgotPassword(forgotPassword);
		return ResponseEntity.ok("Reset password link has sent to your registered email");
	}
	@PostMapping("/reset-password")
	public ResponseEntity<String>resetPassword(@RequestBody ResetPasswordDTO resetPassword){
		userService.resetPassword(resetPassword);
		return ResponseEntity.ok("Password reset sunccessful");
	}

	@PostMapping("/logout")
	public ResponseEntity<String>loogout(HttpServletRequest request){
		return ResponseEntity.ok(userService.logout(request));
	}
}
