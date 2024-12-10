package com.klu.Backend;
import java.util.Arrays;

import jakarta.persistence.*;

@Entity
@Table(name = "ParticipationList")
public class ParticipationList 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private String venue;

    @Column(nullable = false)
    private String category;

    @Lob
    @Column(name = "poster", nullable = true, columnDefinition = "BLOB")
    private byte[] poster; // Store the image as a byte array

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;
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

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
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

}
