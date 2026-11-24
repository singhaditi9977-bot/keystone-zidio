package com.keystone.DTO;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDTO {

	public String eventType;
	public String subject;
	public Set<String >recepientEmail;
	public String message;
	

}
