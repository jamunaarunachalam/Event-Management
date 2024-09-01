package com.example.event.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.event.entity.AdminVenue;

import java.util.List;

public interface AdminVenueRepository extends JpaRepository<AdminVenue, Integer> {

    @Query("SELECT new com.example.event.entity.AdminVenue(b.venue, COUNT(b)) FROM Booking b WHERE b.venue IN ('luminary', 'Grandeur', 'Magnate') GROUP BY b.venue")
    List<AdminVenue> findVenueBookingsCount();
}

    
    