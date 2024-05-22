package com.jackson.feedbackapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback")
@EqualsAndHashCode(callSuper = false)
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotEmpty(message = "Name cannot be blank")
    @Column(unique = true)
    private String name;

    private String email;
    private String message;
}