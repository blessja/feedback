package com.jackson.feedbackapp.controllers;

import com.jackson.feedbackapp.models.Feedback;
import com.jackson.feedbackapp.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback createdFeedback = feedbackService.createFeedback(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedback);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback feedbackDetails) {
        Feedback updatedFeedback = feedbackService.updateFeedback(id, feedbackDetails);
        return ResponseEntity.ok(updatedFeedback);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}