package com.example.event.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.event.entity.enumerate.venue;
import com.example.event.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Booking b WHERE b.venue = :venue AND b.date = :date")
    boolean existsByVenueAndDate(@Param("venue") venue venue, @Param("date") String date);
}

