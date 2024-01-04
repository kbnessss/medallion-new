package com.group6.Medalion.service;

import com.group6.Medalion.entity.Performance;
import java.util.Optional;
import java.util.List;

public interface PerformanceService {
    Performance addPerformance(Performance performance);
    Optional<Performance> getPerformanceById(Long id); // Missing method
    Performance updatePerformance(Long id, Performance performance);
    void deletePerformance(Long id); // Missing method
    List<Performance> getPerformancesForShow(Long showId);
}
