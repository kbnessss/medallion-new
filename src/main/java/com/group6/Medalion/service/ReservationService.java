package com.group6.Medalion.service;

import com.group6.Medalion.entity.Reservation;
import com.group6.Medalion.exception.ResourceNotFoundException;
import com.group6.Medalion.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        // Additional business logic and validations
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id " + id));
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = getReservationById(id);

        // Update logic
        existingReservation.setCustomer(updatedReservation.getCustomer());
        existingReservation.setReservationTime(updatedReservation.getReservationTime());
        existingReservation.setSeats(updatedReservation.getSeats());
        existingReservation.setStatus(updatedReservation.getStatus());

        return reservationRepository.save(existingReservation);
    }

    public void deleteReservation(Long id) {
        Reservation existingReservation = getReservationById(id);
        reservationRepository.delete(existingReservation);
    }
}
