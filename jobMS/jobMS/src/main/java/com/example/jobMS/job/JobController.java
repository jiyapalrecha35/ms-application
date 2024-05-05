package com.example.jobMS.job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobMS.job.dto.JobDTO;

@RestController
@RequestMapping("/jobs") // at class level
public class JobController {
    private JobService jobService;

    // springboot will take care of the thing
    // loosely coupled
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping // get all jobs
    public ResponseEntity<List<JobDTO>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    // @RequestMapping(value = "/jobs",method=RequestMethod.POST) at method level
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added succesfully!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
        JobDTO jobDTO = jobService.getJobById(id);
        if (jobDTO != null) {
            return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {

        int value = jobService.deleteJobById(id);
        if (value == 1)
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Job with given id not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@RequestBody Job job, @PathVariable Long id) {
        int value = jobService.updateJobById(id, job);
        if (value == 1)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Job with given id not found", HttpStatus.NOT_FOUND);

    }

}
