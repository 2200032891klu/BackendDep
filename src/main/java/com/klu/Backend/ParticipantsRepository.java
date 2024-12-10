package com.klu.Backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.klu.Backend.Participants;

@Repository
public interface ParticipantsRepository extends JpaRepository<Participants, Long> {
    // Custom query methods (if needed) can be added here
}
