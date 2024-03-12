package org.mareenraj.job_app.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mareenraj.job_app.company.Company;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review_table")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double rating;
    @ManyToOne
    @JsonIgnore
    private Company company;
}
