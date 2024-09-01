package com.example.event.entity;

import com.example.event.entity.enumerate.venue;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminVenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private venue venue;
    private int bookings;

    
    public AdminVenue(venue venue, long bookings) {
        this.venue = venue;
        this.bookings = (int) bookings; // Convert long to int
    }
}
