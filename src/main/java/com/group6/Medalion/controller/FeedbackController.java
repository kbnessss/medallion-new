package com.group6.Medalion.controller;

import com.group6.Medalion.entity.Feedback;
import com.group6.Medalion.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@RequestBody Feedback feedback) {
        Feedback submittedFeedback = feedbackService.submitFeedback(feedback);
        return new ResponseEntity<>(submittedFeedback, HttpStatus.CREATED);
    }

    // Endpoint to get all feedback
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> feedbacks = feedbackService.getAllFeedback();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    // Endpoint to update feedback status
    @PutMapping("/{id}/status")
    public ResponseEntity<Feedback> updateFeedbackStatus(@PathVariable Long id, @RequestParam String status) {
        Feedback updatedFeedback = feedbackService.updateFeedbackStatus(id, status);
        return ResponseEntity.ok(updatedFeedback);
    }
}

