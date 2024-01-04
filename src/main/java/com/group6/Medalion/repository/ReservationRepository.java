package com.group6.Medalion.repository;

import com.group6.Medalion.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Custom query methods if needed
    // Example: List<Reservation> findByCustomerId(Long customerId);
}

