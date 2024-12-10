package com.klu.Backend;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Achievements{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String title;
    private String date;
    private String place;
    @Column(name = "category")
    private String category;
    private String achievementType;
    private String level;
    private String participants;
    
    @Column(name = "email")
    private String email;
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAchievementType() {
        return achievementType;
    }

    public void setAchievementType(String achievementType) {
        this.achievementType = achievementType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

	@Override
	public String toString() {
		return "Achievements [id=" + id + ", title=" + title + ", date=" + date + ", place=" + place + ", category="
				+ category + ", achievementType=" + achievementType + ", level=" + level + ", participants="
				+ participants + ", email=" + email + "]";
	}

	
    
    
}
