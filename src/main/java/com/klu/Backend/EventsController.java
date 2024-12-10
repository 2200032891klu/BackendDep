package com.klu.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:3000")  // Ensure React app can access the backend

public class EventsController {

    @Autowired
    private EventsService eventsService;

    // Add or Update Event
    @PostMapping
    public ResponseEntity<Events> addOrUpdateEvent(
            @RequestParam("eventName") String eventName,
            @RequestParam("venue") String venue,
            @RequestParam("category") String category,
            @RequestParam("date") String date,
            @RequestParam("time") String time,
            @RequestParam(value = "poster", required = false) MultipartFile poster
    ) {
        try {
            Events event = new Events();
            event.setEventName(eventName);
            event.setVenue(venue);
            event.setCategory(category);
            event.setDate(date);
            event.setTime(time);
            if (poster != null) {
                event.setPoster(poster.getBytes());
            }
            Events savedEvent = eventsService.saveEvent(event);
            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all events
    @GetMapping("/")
    public List<Events> getAllEvents() {
        return eventsService.getAllEvents(); // Corrected variable name
    }

    // Fetch a single event by ID, along with the poster image
    @GetMapping("/{id}")
    public ResponseEntity<Events> getEventById(@PathVariable Long id) {
        Events event = eventsService.getEventById(id); // Corrected variable name
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    // Delete Event by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventsService.deleteEventById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
