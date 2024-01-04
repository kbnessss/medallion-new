package com.group6.Medalion.repository;

import com.group6.Medalion.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Custom query methods if needed
    // Example: List<Ticket> findByReservationId(Long reservationId);
}
