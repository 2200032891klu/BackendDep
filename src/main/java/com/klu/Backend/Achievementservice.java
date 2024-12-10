package com.klu.Backend;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Achievementservice {

    @Autowired
    private Repo achievementRepository;

    public Achievements addAchievement(Achievements achievement) {
        return achievementRepository.save(achievement);
    }

	public List<Achievements> getAllAchievements() {
		// TODO Auto-generated method stub
        return achievementRepository.findAll();
	}
	public Achievements updateAchievement(Long id, Achievements achievementDetails) {
        Achievements existingAchievement = achievementRepository.findById(id).orElseThrow(() -> new RuntimeException("Achievement not found"));
        existingAchievement.setTitle(achievementDetails.getTitle());
        existingAchievement.setDate(achievementDetails.getDate());
        existingAchievement.setPlace(achievementDetails.getPlace());
        existingAchievement.setCategory(achievementDetails.getCategory());
        existingAchievement.setAchievementType(achievementDetails.getAchievementType());
        existingAchievement.setLevel(achievementDetails.getLevel());
        existingAchievement.setParticipants(achievementDetails.getParticipants());
        return achievementRepository.save(existingAchievement);
    }

	
	
    // Delete achievement by ID
    public void deleteAchievement(Long id) {
        achievementRepository.deleteById(id);
    }
    public Optional<Achievements> getAchievementById(Long id) {
        return achievementRepository.findById(id);
    }

    public List<Achievements> findByEmail(String email) {
        return achievementRepository.findByEmail(email);
    }
    
    public List<Achievements> retrieveAchievementsByEmail(String email) {
        return achievementRepository.findByEmail(email);
    }

    public List<Object[]> getAchievementsGroupedByLevel() {
        return achievementRepository.getAchievementsGroupedByLevel();
    }
}
