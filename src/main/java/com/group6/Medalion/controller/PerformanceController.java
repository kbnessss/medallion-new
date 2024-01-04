package com.group6.Medalion.controller;

import com.group6.Medalion.entity.Performance;
import com.group6.Medalion.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performances")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @PostMapping
    public ResponseEntity<Performance> addPerformance(@RequestBody Performance performance) {
        Performance newPerformance = performanceService.addPerformance(performance);
        return ResponseEntity.ok(newPerformance);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Performance> getPerformanceById(@PathVariable Long id) {
        Performance performance = performanceService.getPerformanceById(id)
                .orElseThrow(() -> new RuntimeException("Performance not found with id " + id));
        return ResponseEntity.ok(performance);
    }

    @GetMapping("/show/{showId}")
    public ResponseEntity<List<Performance>> getPerformancesForShow(@PathVariable Long showId) {
        List<Performance> performances = performanceService.getPerformancesForShow(showId);
        return ResponseEntity.ok(performances);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Performance> updatePerformance(@PathVariable Long id, @RequestBody Performance performance) {
        Performance updatedPerformance = performanceService.updatePerformance(id, performance);
        return ResponseEntity.ok(updatedPerformance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerformance(@PathVariable Long id) {
        performanceService.deletePerformance(id);
        return ResponseEntity.ok().build();
    }
}
