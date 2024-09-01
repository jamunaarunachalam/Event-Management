package com.example.event.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.event.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
    

}