package com.klu.Backend;

import com.klu.Backend.Participants;
import com.klu.Backend.ParticipantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantsService {

    @Autowired
    private ParticipantsRepository repository;

    public void saveParticipant(Participants participant) {
        repository.save(participant);
    }
    
    public List<Participants> getAllParticipants() {
        List<Participants> participants = repository.findAll();
        System.out.println(participants); // Log the participants
        return participants;
    }


}

