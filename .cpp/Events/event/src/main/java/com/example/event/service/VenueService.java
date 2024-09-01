package com.example.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event.entity.VenueList;

import com.example.event.repository.VenueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

        @Autowired
    private VenueRepository venueRepository;

    public List<VenueList> getAllVenue() {
        return venueRepository.findAll();
    }

    public Optional<VenueList> getVenueById(int id) {
        return venueRepository.findById(id);
    }

    public VenueList saveVenue(VenueList venue) {
        return venueRepository.save(venue);
    }

    public VenueList updateVenue(VenueList venue) {
        return venueRepository.save(venue);
    }

    public void deleteVenue(int id) {
        venueRepository.deleteById(id);
    }
}