package com.example.event.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.entity.VenueList;
import com.example.event.service.VenueService;




@RequestMapping("/venue")
@RestController
public class VenueController {

    @Autowired
    private VenueService venueService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/allvenue")
    public List<VenueList> getAllEvents() {
        return venueService.getAllVenue();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public VenueList getVenueById(@PathVariable int id) {
        return venueService.getVenueById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id: " + id));
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addvenue")
    public VenueList saveVenue(@RequestBody VenueList venue) {
        return venueService.saveVenue(venue);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/updatevenue")
    public VenueList updateEvents(@RequestBody VenueList venue) {
        return venueService.updateVenue(venue);
    }

    @DeleteMapping("/deletevenue/{id}")
    public String deleteVenue(@PathVariable int id) {
        venueService.deleteVenue(id);
        return "Venue deleted successfully with id: " + id;
    }
}



