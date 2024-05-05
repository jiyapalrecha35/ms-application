package com.example.reviewMS.reviews;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    int createReview(Long companyId,Review review);
    Review getSpecificReview(Long reviewId);
    int updateReviewById(Long reviewId,Review updatedReview);
    int deleteReviewById(Long reviewId);
}
