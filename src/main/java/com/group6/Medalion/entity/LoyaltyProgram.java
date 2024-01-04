package com.group6.Medalion.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "LoyaltyProgram")
public class LoyaltyProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "loyaltyProgram")
    private Customer customer;

    private Integer points;
    private String tier; // e.g., "Gold", "Silver"
    private String benefits; // e.g., "10% off on all bookings"

    // Getters, Setters, Constructors
}
