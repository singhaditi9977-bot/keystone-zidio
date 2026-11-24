package com.keystone.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.keystone.DTO.EmailLogsDTO;
import com.keystone.Entity.EmailLogs;
import com.keystone.Repositery.EmailLogRepositery;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMail;
	@Autowired
	private EmailLogRepositery emailLogsRepo;
	
	
	public void sentResetPasswordLink(String toEmail,String token) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("Reset Your Password");
		String resetLink= "http://localhost:7979/auth/reset-password?token="+token;
		message.setText("Click the below link to reset your password:\n\n"
				+resetLink+"\n\nThis link will be expirein 10minutes");
		
		
		javaMail.send(message);
		
	}
	
	public String notify(EmailLogsDTO email){
		boolean sentStatus=false;
		
		try {
			MimeMessage message = javaMail.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper(message,true);
			
			helper.setTo(email.recipientEmail);
			helper.setSubject(email.subject);
			helper.setText(email.body,true);
			
			javaMail.send(message);
			sentStatus=false;
		
		}catch (Exception e) {
			sentStatus=true;
		}
		EmailLogs logs=new EmailLogs(email.recipientEmail,email.subject,email.body,email.sentStatus);
		emailLogsRepo.save(logs);
		
		return sentStatus ? "Email sent Successfully":"Email sending failed";
	}

	public void sendResetPasswordLink(String to, String token) {
		
	}
	
	}

