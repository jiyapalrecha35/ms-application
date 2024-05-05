package com.example.reviewMS.reviews.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.reviewMS.reviews.Review;
import com.example.reviewMS.reviews.ReviewRepository;
import com.example.reviewMS.reviews.ReviewService;
import com.example.reviewMS.reviews.messaging.ReviewMessageProducer;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private ReviewMessageProducer reviewMessageProducer;

    public ReviewServiceImpl(ReviewRepository reviewRepository,ReviewMessageProducer reviewMessageProducer) {
        this.reviewRepository = reviewRepository;
        // this.companyService = companyService;
        this.reviewMessageProducer=reviewMessageProducer;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public int createReview(Long companyId, Review review) {
        if (companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            reviewMessageProducer.sendMessage(review);   //trigger 
            //whenever review created the message is pushed onto MQ
            return 1;
        }
        return 0;
    }

    @Override
    public Review getSpecificReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        return review;
    }

    @Override
    public int updateReviewById(Long reviewId, Review updatedReview) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setCompanyId(updatedReview.getCompany());
            reviewRepository.save(review);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteReviewById(Long reviewId) {

        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            reviewRepository.deleteById(reviewId);
            return 1;
        }
        return 0;

    }

}
