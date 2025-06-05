package com.hctt.is208.controller;

import com.hctt.is208.entity.JobPost;
import com.hctt.is208.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/jobposts")
public class JobPostController {

    @Autowired
    private JobPostRepository jobPostRepository;

    @PostMapping
    public JobPost createJobPost(@RequestBody JobPost jobPost) {
        jobPost.setCreatedAt(LocalDateTime.now());
        return jobPostRepository.save(jobPost);
    }
}