package com.keystone.Repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keystone.Entity.Site;

@Repository
public interface SiteRepositery extends JpaRepository<Site,Long> {
	
	List<Site>findByCustomerId(Long customerId);
	
}
