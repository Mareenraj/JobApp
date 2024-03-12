package org.mareenraj.job_app.review.impl;

import lombok.RequiredArgsConstructor;
import org.mareenraj.job_app.company.Company;
import org.mareenraj.job_app.company.CompanyRepository;
import org.mareenraj.job_app.company.CompanyService;
import org.mareenraj.job_app.review.Review;
import org.mareenraj.job_app.review.ReviewRepository;
import org.mareenraj.job_app.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    private final CompanyService companyService;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Boolean createReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = getAllReviews(companyId);
        return reviews.stream().filter((review -> review.getId().equals(reviewId))).findFirst().orElse(null);
    }

    @Override
    public Review updateReview(Long companyId, Long reviewId, Review updatedReview) {
        Optional<Review> optionalReview = reviewRepository.findByIdAndCompanyId(reviewId, companyId);
        if (optionalReview.isPresent()) {
            Review existingReview = optionalReview.get();
            existingReview.setTitle(updatedReview.getTitle());
            existingReview.setDescription(updatedReview.getDescription());
            existingReview.setRating(updatedReview.getRating());
            existingReview.setCompany(updatedReview.getCompany());
            return reviewRepository.save(existingReview);
        }
        return null;
    }

    @Override
    public Boolean deleteReview(Long companyId, Long reviewId) {
        Optional<Review> optionalReview = reviewRepository.findByIdAndCompanyId(reviewId, companyId);
        if (optionalReview.isPresent()) {
            reviewRepository.delete(optionalReview.get());
            return true;
        }
        return false;
    }

}
