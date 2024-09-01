package com.example.event.controller;

import com.example.event.entity.AdminVenue;
import com.example.event.service.AdminVenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminVenueController {

    @Autowired
    private AdminVenueService adminVenueService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/bookings")
    public List<AdminVenue> getVenueBookingsCount() {
        return adminVenueService.getVenueBookingsCount();
    }
}
