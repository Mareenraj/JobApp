package org.mareenraj.job_app.job;

import java.util.List;

public interface JobService {
    List<Job> findAllJobs();

    String createJob(Job job);

    Job getJobById(Long id);

    Boolean deleteJobById(Long id);

    Boolean updateJobById(Long id, Job updatedJob);
}
