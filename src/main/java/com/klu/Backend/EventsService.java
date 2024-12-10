package com.klu.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository; // Corrected variable name

    // Create or Update an Event
    public Events saveEvent(Events event) {
        return eventsRepository.save(event);
    }

    // Get all events
    public List<Events> getAllEvents() {
        return eventsRepository.findAll(); // Corrected variable name
    }

    // Get event by ID
    public Events getEventById(Long id) {
        Optional<Events> event = eventsRepository.findById(id); // Corrected variable name
        return event.orElse(null);
    }

    // Delete event by ID
    public void deleteEventById(Long id) {
        eventsRepository.deleteById(id);
    }
}
