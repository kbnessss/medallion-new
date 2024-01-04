package com.group6.Medalion.service;

import com.group6.Medalion.entity.Discount;
import com.group6.Medalion.entity.Sales;
import com.group6.Medalion.exception.DiscountCodeExistsException;
import com.group6.Medalion.exception.DiscountExpiredException;
import com.group6.Medalion.exception.DiscountNotFoundException;
import com.group6.Medalion.exception.SaleNotFoundException;
import com.group6.Medalion.repository.DiscountRepository;
import com.group6.Medalion.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private SalesRepository salesRepository; // Injecting SalesRepository

    public Discount createDiscount(Discount discount) {
        discountRepository.findByCode(discount.getCode())
                .ifPresent(d -> {
                    throw new DiscountCodeExistsException("Discount code already exists");
                });
        return discountRepository.save(discount);
    }

    public Sales applyDiscount(Long saleId, String discountCode) {
        Discount discount = discountRepository.findByCode(discountCode)
                .orElseThrow(() -> new DiscountNotFoundException("Discount not found"));

        Sales sale = salesRepository.findById(saleId)
                .orElseThrow(() -> new SaleNotFoundException("Sale not found"));

        if (discount.getValidUntil().isBefore(LocalDateTime.now())) {
            throw new DiscountExpiredException("Discount code is expired");
        }

        // Calculate the discounted amount
        double discountedAmount = calculateDiscountedAmount(sale.getAmount(), discount.getPercentage());

        // Update the sales entity
        sale.setAmount(discountedAmount);
        return salesRepository.save(sale);
    }

    private double calculateDiscountedAmount(double originalAmount, double discountPercentage) {
        return originalAmount - (originalAmount * discountPercentage / 100);
    }

    // Additional methods for update, delete, etc.
}
