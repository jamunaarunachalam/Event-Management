package com.example.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event.entity.registerentity;


public interface UserRepository extends JpaRepository<registerentity, Long> {
}
