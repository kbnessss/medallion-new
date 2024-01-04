package com.group6.Medalion.controller;

import com.group6.Medalion.entity.Discount;
import com.group6.Medalion.entity.Sales;
import com.group6.Medalion.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discounts")
public class DiscountController {
    @Autowired
    private DiscountService discountService;


        @PostMapping
        public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount) {
            return new ResponseEntity<>(discountService.createDiscount(discount), HttpStatus.CREATED);
        }

        @PostMapping("/{discountCode}/apply")
        public ResponseEntity<Sales> applyDiscount(@PathVariable String discountCode, @RequestBody Long saleId) {
            return new ResponseEntity<>(discountService.applyDiscount(saleId, discountCode), HttpStatus.OK);
        }
    }

