package com.keystone.Repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keystone.Entity.Notification;

@Repository
public interface NotificationRepositery
        extends JpaRepository<Notification, Long> {

    Optional<Notification> findByEventType(String eventType);

}