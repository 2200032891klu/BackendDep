package com.klu.Backend;

import jakarta.persistence.*;

@Entity
@Table(name = "participants")
public class Participants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;
    private String venue;
    private String category;
    private String date;
    private String time;
    private String email;

    @Lob
    private byte[] poster; // For storing event poster images

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    // toString method
    @Override
    public String toString() {
        return "Participants{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", venue='" + venue + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
