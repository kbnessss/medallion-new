package com.group6.Medalion.repository;

import com.group6.Medalion.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Find a customer by email
    Optional<Customer> findByEmail(String email);

    Boolean existsByEmail(String email);

    // Find a customer by name (if needed)
    Optional<Customer> findByName(String name);

}
