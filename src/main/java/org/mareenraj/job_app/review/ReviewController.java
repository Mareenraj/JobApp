package org.mareenraj.job_app.review;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies/{companyId}/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping()
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable("companyId") Long companyId) {
        return ResponseEntity.ok(reviewService.getAllReviews(companyId));
    }

    @PostMapping()
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review) {
        Boolean isReviewCreated = reviewService.createReview(companyId, review);
        if (isReviewCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Review is successfully created!");
        }
        return ResponseEntity.badRequest().body("Something went wrong, Maybe the company doesn't exist!");
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Review review = reviewService.getReviewById(companyId, reviewId);
        return review != null ? ResponseEntity.ok(review) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review updatedReview) {
        Review newUpdatedReview = reviewService.updateReview(companyId, reviewId, updatedReview);
        return newUpdatedReview != null ? ResponseEntity.ok(newUpdatedReview) :ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Boolean reviewDeleted = reviewService.deleteReview(companyId, reviewId);
        return reviewDeleted ? ResponseEntity.ok("Review is successfully deleted!") : ResponseEntity.noContent().build();
    }
}
