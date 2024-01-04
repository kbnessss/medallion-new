package com.group6.Medalion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "SocialMediaInteraction")
public class SocialMediaInteraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String platform; // e.g., "Facebook", "Twitter"
    private int shareCount;
    private LocalDateTime interactionDate;

    // Getters, Setters, Constructors
}
