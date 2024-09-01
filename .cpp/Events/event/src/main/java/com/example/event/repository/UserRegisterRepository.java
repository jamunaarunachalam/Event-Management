package com.example.event.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event.entity.registerentity;


public interface UserRegisterRepository extends JpaRepository<registerentity,Long>{
	Optional<registerentity>findByUsername(String username);
}
