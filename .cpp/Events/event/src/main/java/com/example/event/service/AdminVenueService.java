package com.example.event.service;

import com.example.event.entity.AdminVenue;
import com.example.event.repository.AdminVenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminVenueService {

    @Autowired
    private AdminVenueRepository adminVenueRepository;

    public List<AdminVenue> getVenueBookingsCount() {
        return adminVenueRepository.findVenueBookingsCount();
    }
}