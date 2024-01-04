package com.group6.Medalion.controller;

import com.group6.Medalion.entity.Sales;
import com.group6.Medalion.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @PostMapping
    public ResponseEntity<Sales> createSale(@RequestBody Sales sale) {
        Sales newSale = salesService.recordSale(sale);
        return new ResponseEntity<>(newSale, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> sales = salesService.getAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSale(@PathVariable Long id) {
        Sales sale = salesService.getSaleById(id);
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<Sales> processPayment(@PathVariable Long id) {
        Sales sale = salesService.getSaleById(id);
        Sales updatedSale = salesService.processPayment(sale);
        return new ResponseEntity<>(updatedSale, HttpStatus.OK);
    }
}
