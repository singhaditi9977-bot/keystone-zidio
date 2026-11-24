package com.keystone.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keystone.DTO.NotificationDTO;
import com.keystone.Entity.Notification;
import com.keystone.Repositery.NotificationRepositery;
import com.keystone.Security.EmailService;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepositery notificationRepo;

    @Autowired
    private EmailService emailService;

	
	public void notification(NotificationDTO notifications) {
		

		
		String eventType=notifications.eventType;
		String subjct= notifications.subject;
		Set <String>recepientEmail=notifications.recepientEmail;
		String message= notifications.message;
		
		if(recepientEmail==null) {
			recepientEmail=new HashSet<String>();
		}
		
		Optional<Notification>notification=notificationRepo.findByEventType(notifications.eventType);
		if(notification.isPresent()) {
			Notification note= notification.get();
			
			
		}
		
		if(recepientEmail==null|| recepientEmail.isEmpty()) {
			return;
		}
		
		for(String email:recepientEmail) {
			emailService.notify();
			
			Notification notify=new Notification();
			
			notify.setRecepientEmail(email);
			notify.setSubject(subjct);
			notify.setMessage(message);
			notify.setEventType(eventType);
			notify.setSentAt(LocalDateTime.now());
			notificationRepo.save(notify);
			
		}
		
		
	}
	
	

}



