package com.example.reviewMS.reviews;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return ResponseEntity.ok(reviewService.getAllReviews(companyId));
    }

    @PostMapping
    public ResponseEntity<String> giveReview(@RequestParam Long companyId, @RequestBody Review review) {
        int value = reviewService.createReview(companyId, review);
        if (value == 1)
            return new ResponseEntity<>("Review added to the company succesfully!", HttpStatus.OK);
        else
            return new ResponseEntity<>("Company with given id not found", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getSpecificReview(@PathVariable Long reviewId) {
        Review review = reviewService.getSpecificReview(reviewId);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long reviewId,
            @RequestBody Review updatedReview) {
        int value = reviewService.updateReviewById(reviewId, updatedReview);
        if (value == 1)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review with given id not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteSpecificReview(@PathVariable Long reviewId) {
        int value = reviewService.deleteReviewById(reviewId);
        if (value == 1)
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review with given id not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/averageRating")
    public double getAverageReview(@RequestParam Long companyId) {
        List<Review> reviews = reviewService.getAllReviews(companyId);
        return reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0); 
    }

}
