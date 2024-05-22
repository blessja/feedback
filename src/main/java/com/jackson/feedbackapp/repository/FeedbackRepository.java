package com.jackson.feedbackapp.repository;

import com.jackson.feedbackapp.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}