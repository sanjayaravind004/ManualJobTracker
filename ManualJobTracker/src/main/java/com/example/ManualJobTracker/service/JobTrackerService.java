package com.example.ManualJobTracker.service;

import com.example.ManualJobTracker.model.JobTracker;
import com.example.ManualJobTracker.repository.JobTrackerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobTrackerService {
    @Autowired
    JobTrackerRepo jobTrackerRepo;


    public List<JobTracker> getAllJobs() {
        return jobTrackerRepo.findAll();
    }

    public void addNewJob(JobTracker jobTracker) {
         jobTrackerRepo.save(jobTracker);
    }

    public JobTracker updateJobById(JobTracker jobTracker) {
        jobTrackerRepo.save(jobTracker);
        return jobTracker;
    }
    @Transactional
    public void  clearByStatus(String status) {
        jobTrackerRepo.deleteByStatus(status);
    }
}
