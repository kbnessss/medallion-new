package com.group6.Medalion.service;

import com.group6.Medalion.entity.Ticket;
import com.group6.Medalion.exception.ResourceNotFoundException;
import com.group6.Medalion.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket issueTicket(Ticket ticket) {
        // Additional business logic and validations
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + id));
    }

    // Additional methods as necessary, for example, cancelTicket, updateTicket, etc.
}
