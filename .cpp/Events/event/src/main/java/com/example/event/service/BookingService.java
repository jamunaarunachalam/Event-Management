package com.example.event.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event.entity.Booking;
import com.example.event.entity.enumerate.venue;
import com.example.event.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }

    public Booking saveBooking(Booking booking) {
        venue venueEnum = booking.getVenue();
        
        if (!bookingRepository.existsByVenueAndDate(venueEnum, booking.getDate())) {
            return bookingRepository.save(booking);
        } else {
            return null; 
        }
    }

    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }
   
  
}

