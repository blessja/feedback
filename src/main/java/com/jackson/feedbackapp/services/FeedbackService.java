package com.jackson.feedbackapp.services;

import com.jackson.feedbackapp.models.Feedback;
import com.jackson.feedbackapp.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Feedback not found"));
    }

    public Feedback updateFeedback(Long id, Feedback feedbackDetail) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Feedback not found"));

        feedback.setName(feedbackDetail.getName());
        feedback.setEmail(feedbackDetail.getEmail());
        feedback.setMessage(feedbackDetail.getMessage());

        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}