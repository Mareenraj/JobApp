package org.mareenraj.job_app.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    Boolean createReview(Long companyId, Review review);
    Review getReviewById(Long companyId, Long reviewId);
    Review updateReview(Long companyId, Long reviewId, Review updatedReview);
    Boolean deleteReview(Long companyId, Long reviewId);
}
