package com.keystone.Repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keystone.Entity.UserAuth;

@Repository
public interface UserAuthRepositery extends JpaRepository<UserAuth,Long>{
	
	Optional<UserAuth>findByUserEmail(String userEmail);
	Optional<UserAuth>findByResetToken(String resetToken);
}
