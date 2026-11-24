package com.keystone.Repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keystone.Entity.Customer;

@Repository
public interface CustomerRespositery extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUserEmail(String userEmail);

    boolean existsByUserEmail(String userEmail);
    
    Optional<Customer> findByPhone(String phone);

}