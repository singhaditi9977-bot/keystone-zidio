package com.keystone.Repositery;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keystone.Entity.Technician;
import com.keystone.Enum.AvialableStatus;

@Repository
public interface TechnicianRepositery extends JpaRepository<Technician, Long> {

    Optional<Technician> findByEmpCode(String empCode);

    Optional<Technician> findByEmail(String email);

    List<Technician> findByActiveTrue();

    List<Technician> findByAvialable(AvialableStatus avialable);

    boolean existsByEmpCode(String empCode);

    boolean existsByEmail(String email);
}