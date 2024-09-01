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

import com.example.event.entity.Event;
import com.example.event.service.EventService;


@RequestMapping("/events")
@RestController
public class EventController {

    @Autowired
    private EventService eventService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/allevents")
    public List<Event> getAllEvents() {
        return eventService.getAllevents();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable int id) {
        return eventService.getEventById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addevents")
    public Event saveEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/updateevents")
    public Event updateEvents(@RequestBody Event event) {
        return eventService.updateEvents(event);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/deleteevents/{id}")
    public String deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
        return "Event deleted successfully with id: " + id;
    }
 
}


