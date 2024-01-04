package com.group6.Medalion.repository;

import com.group6.Medalion.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    // Additional custom query methods as required
}
