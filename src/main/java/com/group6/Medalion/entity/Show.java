package com.group6.Medalion.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    private String title;
    private String description;
    private String genre;
    private Double ratings;
    private String imageUrl;
    private Set<SocialMediaInteraction> socialMediaInteractions;
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Performance> performances;

    // Default Constructor
    public Show() {
    }

    // Parameterized Constructor
    public Show(String title, String description, String genre, Double ratings, String imageUrl, Set<Performance> performances) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.ratings = ratings;
        this.imageUrl = imageUrl;
        this.performances = performances;
    }

    // Getters and Setters
    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }
}
