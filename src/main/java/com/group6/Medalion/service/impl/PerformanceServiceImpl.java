package com.group6.Medalion.service.impl;

import com.group6.Medalion.entity.Performance;
import com.group6.Medalion.repository.PerformanceRepository;
import com.group6.Medalion.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Override
    public Performance addPerformance(Performance performance) {
        if (performance.getDateTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Performance date and time must be in the future");
        }
        return performanceRepository.save(performance);
    }

    @Override
    public Optional<Performance> getPerformanceById(Long id) {
        return performanceRepository.findById(id);
    }

    @Override
    public Performance updatePerformance(Long id, Performance updatedPerformance) {
        return performanceRepository.findById(id)
                .map(performance -> {
                    performance.setDateTime(updatedPerformance.getDateTime());
                    // Ensure that the Show is not null before setting it
                    if (updatedPerformance.getShow() != null) {
                        performance.setShow(updatedPerformance.getShow());
                    }
                    return performanceRepository.save(performance);
                })
                .orElseThrow(() -> new RuntimeException("Performance not found with id " + id));
    }

    public void deletePerformance(Long id) {
        if (!performanceRepository.existsById(id)) {
            throw new RuntimeException("Performance not found with id " + id);
        }
        performanceRepository.deleteById(id);
    }

    @Override
    public List<Performance> getPerformancesForShow(Long showId) {
        // Implement logic to retrieve performances for a specific show
        // This method should be updated to filter performances by the given showId
        return performanceRepository.findByShow_ShowId(showId); // Assuming such a method exists in the repository
    }
}
