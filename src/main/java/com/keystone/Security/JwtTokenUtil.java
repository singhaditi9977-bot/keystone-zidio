package com.keystone.Security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.keystone.Entity.UserAuth;
import com.keystone.Enum.Permissions;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {
	private final SecretKey key;
	private final long expiration = 12*60*60*1000L;
	
	public JwtTokenUtil() {
		
		String secret = System.getenv("JWT_SECRET");
		if(secret == null || secret.isEmpty()){
			secret = "MySecretKeyForJwtAuthentication123456789123456789";
			}
		
		key=Keys.hmacShaKeyFor(secret.getBytes());
	}

public String generateToken(UserAuth user) {
    Map<String, Object> claim = new HashMap<>();
    claim.put("role", user.getRole().name());

    Set<Permissions> perm =
            RoleBasedPermissions.getRoleBasedPermissions()
                    .get(user.getRole());

    claim.put("permissions", perm);

    Date now = new Date();
    Date expire = new Date(now.getTime() + expiration);

    return Jwts.builder()
            .claims(claim)
            .subject(user.getUserEmail())
            .issuedAt(now)
            .expiration(expire)
            .signWith(key)
            .compact();
}	public boolean validateToken(String token) {
	    try {
	        Jwts.parser()
	                .verifyWith(key)
	                .build()
	                .parseSignedClaims(token);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}	

	public Claims getClaims(String token) {
	    return Jwts.parser()
	            .verifyWith(key)
	            .build()
	            .parseSignedClaims(token)
	            .getPayload();
	}
	public String getUserEmail(String toekn) {
		return getClaims(toekn).getSubject();
		}

	public String extractToken(String header) {
		// TODO Auto-generated method stub
		return null;
	}
}
