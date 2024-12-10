package com.klu.Backend;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/achievements")
@CrossOrigin(origins = "http://localhost:3000")  
public class AchievementController {

    @Autowired
    private Achievementservice achievementService;

    @PostMapping("/add")
    public ResponseEntity<String> addAchievement(@RequestBody Achievements achievement) {
        try {
            achievementService.addAchievement(achievement);
            return ResponseEntity.ok("Achievement added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding achievement");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Achievements>> getAllAchievements() {
        List<Achievements> achievements = achievementService.getAllAchievements();
        return ResponseEntity.ok(achievements);
    }

    // Updated method to match the frontend URL format
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Achievements>> getAchievementsByEmail(@PathVariable String email) {
        // Fetch the list of achievements for the given email
        List<Achievements> achievements = achievementService.findByEmail(email);

        // If no achievements are found, return 204 No Content
        if (achievements.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // Return the achievements with 200 OK status
        return new ResponseEntity<>(achievements, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Achievements> getAchievementById(@PathVariable Long id) {
        Optional<Achievements> achievement = achievementService.getAchievementById(id);
        if (achievement.isPresent()) {
            return ResponseEntity.ok(achievement.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Achievements> updateAchievement(@PathVariable Long id, @RequestBody Achievements achievementDetails) {
        try {
            Achievements updatedAchievement = achievementService.updateAchievement(id, achievementDetails);
            return ResponseEntity.ok(updatedAchievement);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an achievement by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable Long id) {
        try {
            achievementService.deleteAchievement(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/user/{email}")
    public ResponseEntity<List<Achievements>> fetchAchievementsByUserEmail(@PathVariable String email) {
        List<Achievements> achievements = achievementService.retrieveAchievementsByEmail(email);
        return achievements.isEmpty() 
            ? ResponseEntity.noContent().build() 
            : ResponseEntity.ok(achievements);
    }

    @GetMapping("/levels")
    public ResponseEntity<List<Object[]>> getAchievementsGroupedByLevel() {
        List<Object[]> result = achievementService.getAchievementsGroupedByLevel();
        return ResponseEntity.ok(result);
    }
}
