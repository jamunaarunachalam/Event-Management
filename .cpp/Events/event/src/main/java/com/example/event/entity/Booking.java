package com.example.event.entity;


import com.example.event.entity.enumerate.Addon;
import com.example.event.entity.enumerate.Catering;
import com.example.event.entity.enumerate.Decoration;
import com.example.event.entity.enumerate.Event;
import com.example.event.entity.enumerate.venue;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String number;
    private String email;
    @Enumerated(EnumType.STRING)
    private Event event;
    private String date;
    private String peopleCount;
    @Enumerated(EnumType.STRING)
    private venue venue;
    private String colorTheme;
    @Enumerated(EnumType.STRING)
    private Catering catering;
    @Enumerated(EnumType.STRING)
    private Decoration decoration;
    @Enumerated(EnumType.STRING)
    private Addon addon;
       
}

