package com.example.event.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event.entity.VenueList;


public interface VenueRepository extends JpaRepository<VenueList, Integer> {
}
