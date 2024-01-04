package com.group6.Medalion.service;

import com.group6.Medalion.entity.Sales;
import com.group6.Medalion.exception.ResourceNotFoundException;
import com.group6.Medalion.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    public Sales recordSale(Sales sale) {
        // Additional business logic and validations
        return salesRepository.save(sale);
    }

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales processPayment(Sales sale) {
        // Logic to handle payment processing
        sale.setPaymentStatus("PAID"); // Example update
        return salesRepository.save(sale);
    }

    public Sales getSaleById(Long id) {
        return salesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found with id " + id));
    }
}
