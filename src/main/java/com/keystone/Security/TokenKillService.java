package com.keystone.Security;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component

public class TokenKillService {
	
	private final Set<String>blockToken= Collections.newSetFromMap(new ConcurrentHashMap<String,Boolean>());
	public void blockListToken(String token) {
		blockToken.add(token);
	}
	public boolean isBlockToken(String token) {
		return blockToken.contains(token);
		
	}
	
	public String extractToken(String header) {
		if(header!=null && header.startsWith("Bearer")) {
			return header.substring(7);
		}
		return null;
	}
}
