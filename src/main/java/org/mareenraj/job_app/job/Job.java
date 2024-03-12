package org.mareenraj.job_app.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mareenraj.job_app.company.Company;

@Entity
@Table(name = "job_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double minSalary;
    private double maxSalary;
    private String location;
    @ManyToOne
    @JsonIgnore
    private Company company;
}
