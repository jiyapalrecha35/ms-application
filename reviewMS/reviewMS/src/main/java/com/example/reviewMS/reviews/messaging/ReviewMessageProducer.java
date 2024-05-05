package com.example.reviewMS.reviews.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.reviewMS.reviews.Review;
import com.example.reviewMS.reviews.dto.ReviewMessage;


@Service
public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review) {
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setId(review.getId());
        reviewMessage.setTitle(review.getTitle());
        reviewMessage.setDescription(review.getDescription());
        reviewMessage.setRating(review.getRating());
        reviewMessage.setCompanyId(review.getCompany());
        rabbitTemplate.convertAndSend("companyRatingQueue", reviewMessage);

    }

}
