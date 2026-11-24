package com.keystone.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keystone.Entity.EmailLogs;

@Repository
public interface EmailLogRepositery extends JpaRepository<EmailLogs,Long> {

}
