package com.example.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.event.entity.Event;

import com.example.event.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

        @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllevents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(int id) {
        return eventRepository.findById(id);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvents(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }
}

