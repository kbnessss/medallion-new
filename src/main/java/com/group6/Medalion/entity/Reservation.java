package com.group6.Medalion.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "reservation_time", nullable = false)
    private LocalDateTime reservationTime;

    private String seats; // Format: "A1,A2,B1,B2"
    private String status; // Example: "CONFIRMED", "CANCELLED"
    private Set<Seat> reservedSeats;

    // Default Constructor
    public Reservation() {
    }

    // Parameterized Constructor
    public Reservation(Customer customer, LocalDateTime reservationTime, String seats, String status) {
        this.customer = customer;
        this.reservationTime = reservationTime;
        this.seats = seats;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
