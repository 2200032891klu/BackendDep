package com.klu.Backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.Backend.Participants;

@RestController
@RequestMapping("/api/participants")
@CrossOrigin(origins = "http://localhost:3000")
public class ParticipantsController {

    @Autowired
    private ParticipantsService service;

    @PostMapping
    public ResponseEntity<String> registerParticipant(@RequestBody Participants participant) {
        try {
            service.saveParticipant(participant);
            return new ResponseEntity<>("Successfully registered!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register participant.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<Participants> getAllParticipants() {
        System.out.println("Fetching all participants");
        return service.getAllParticipants();
    }


}
