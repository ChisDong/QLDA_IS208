package com.hctt.is208.Job_post;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class JobPostService {
    @Autowired
    private JobPostRepository jobPostRepository;

     public JobPostService(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    public List<JobPost> searchJobs(String keyword) {
        return jobPostRepository.searchByKeyword(keyword);
    }
}
