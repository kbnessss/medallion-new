package com.group6.Medalion.repository;

import com.group6.Medalion.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    // Custom query methods if needed
}