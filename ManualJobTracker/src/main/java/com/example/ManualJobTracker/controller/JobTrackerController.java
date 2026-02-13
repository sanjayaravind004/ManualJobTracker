package com.example.ManualJobTracker.controller;

import com.example.ManualJobTracker.model.JobTracker;
import com.example.ManualJobTracker.service.JobTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobTrackerController {
    @Autowired
    JobTrackerService jobTrackerService;

    @GetMapping("/job/all")
    public List<JobTracker> getAllJobs(){
        return jobTrackerService.getAllJobs();
    }

    @PostMapping("/job/add")
    public String addNewJob(@RequestBody JobTracker jobTracker){
         jobTrackerService.addNewJob(jobTracker);
         return "Added Succesfully";
    }

    @PutMapping("/update/{id}")
    public JobTracker updateJob(@PathVariable("id") int id , @RequestBody JobTracker jobTracker) {
        jobTracker.setId(id);
        return jobTrackerService.updateJobById(jobTracker);
    }

    @PutMapping("/update")
    public JobTracker updateJobs(@RequestBody JobTracker jobTracker){
        return jobTrackerService.updateJobs(jobTracker);
    }

    @DeleteMapping("/clear/{status}")
    public String clearByStatus(@PathVariable("status") String status){
        //jobTracker.setStatus(status);
         jobTrackerService.clearByStatus(status);
         return "Data Cleared Succesfully";
        }



}
