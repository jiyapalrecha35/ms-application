package com.example.jobMS.job;

import java.util.List;

import com.example.jobMS.job.dto.JobDTO;

public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);
    JobDTO getJobById(Long id);
    int deleteJobById(Long id);
    int updateJobById(Long id,Job job);
}
