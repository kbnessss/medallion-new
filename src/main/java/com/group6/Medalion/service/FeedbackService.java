package com.group6.Medalion.service;

import com.group6.Medalion.entity.Feedback;
import com.group6.Medalion.exception.FeedbackNotFoundException;
import com.group6.Medalion.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    // Method to submit feedback
    public Feedback submitFeedback(Feedback feedback) {
        feedback.setSubmissionDate(LocalDateTime.now());
        feedback.setStatus("PENDING");
        return feedbackRepository.save(feedback);
    }

    // Method to get all feedback
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // Method to update feedback status
    public Feedback updateFeedbackStatus(Long feedbackId, String newStatus) {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback not found with id: " + feedbackId));

        feedback.setStatus(newStatus);
        return feedbackRepository.save(feedback);
    }

    // Any other additional methods...
}
