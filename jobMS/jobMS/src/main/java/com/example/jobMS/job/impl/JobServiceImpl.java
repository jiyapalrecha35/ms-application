/*
 * package com.example.jobMS.job.impl;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.client.RestClientException;
 * import org.springframework.web.client.RestTemplate;
 * 
 * import com.example.jobMS.job.Job;
 * import com.example.jobMS.job.JobRepository;
 * import com.example.jobMS.job.JobService;
 * import com.example.jobMS.job.dto.JobDTO;
 * import com.example.jobMS.job.external.Company;
 * 
 * @Service
 * public class JobServiceImpl implements JobService {
 * // private List<Job> jobs = new ArrayList<>();
 * 
 * JobRepository jobRepository;
 * 
 * @Autowired
 * RestTemplate restTemplate;
 * 
 * public JobServiceImpl(JobRepository jobRepository) {
 * this.jobRepository = jobRepository;
 * }
 * 
 * // get all the jobs
 * 
 * @Override
 * public List<JobDTO> findAll() {
 * // RestTemplate restTemplate=new RestTemplate();
 * // Company company=
 * //
 * restTemplate.getForObject("http://localhost:8081/companies/1",Company.class);
 * // System.out.println(company.getName());
 * // System.out.println(company.getId());
 * // System.out.println(company.getDescription());
 * 
 * // RestTemplate restTemplate = new RestTemplate();
 * // List<Job> jobs = jobRepository.findAll();
 * // List<jobDTO> jobDTOS = new ArrayList<>();
 * 
 * // //for all jobs return job+company as json
 * // for (Job job : jobs) {
 * // jobDTO jobDTO = new jobDTO();
 * // jobDTO.setJob(job);
 * // Company company =
 * // restTemplate.getForObject("http://localhost:8081/companies/" +
 * // job.getCompanyId(),
 * // Company.class);
 * // jobDTO.setCompany(company);
 * // jobDTOS.add(jobDTO);
 * // }
 * // return jobDTOS;
 * 
 * // using eureka
 * // List<Job> jobs = jobRepository.findAll();
 * // List<jobDTO> jobDTOS = new ArrayList<>();
 * 
 * // // for all jobs return job+company as json
 * // for (Job job : jobs) {
 * // jobDTO jobDTO = new jobDTO();
 * // jobDTO.setJob(job);
 * // Company company =
 * // restTemplate.getForObject("http://COMPANY-MS:8081/companies/" +
 * // job.getCompanyId(),
 * // Company.class);
 * 
 * // jobDTO.setCompany(company);
 * // jobDTOS.add(jobDTO);
 * // }
 * // return jobDTOS;
 * 
 * List<Job> jobs = jobRepository.findAll();
 * List<JobDTO> jobDTOS = new ArrayList<>();
 * 
 * for (Job job : jobs) {
 * JobDTO jobDTO = new JobDTO();
 * jobDTO.setId(job.getId());
 * jobDTO.setTitle(job.getTitle());
 * jobDTO.setDescription(job.getDescription());
 * jobDTO.setMinSalary(job.getMinSalary());
 * jobDTO.setMaxSalary(job.getMaxSalary());
 * jobDTO.setLocation(job.getLocation());
 * jobDTO.setCompanyId(job.getCompanyId());
 * 
 * try {
 * Company company =
 * restTemplate.getForObject("http://COMPANY-MS:8081/companies/" +
 * job.getCompanyId(),
 * Company.class);
 * jobDTO.setCompanyName(company.getName());
 * jobDTO.setCompanyDescription(company.getDescription());
 * } catch (RestClientException e) {
 * System.out.println("Some error occurred while fetching company details...");
 * }
 * 
 * jobDTOS.add(jobDTO);
 * }
 * return jobDTOS;
 * }
 * 
 * // create a job
 * 
 * @Override
 * public void createJob(Job job) {
 * jobRepository.save(job);
 * }
 * 
 * @Override
 * // public jobDTO getJobById(Long id) {
 * // Job job = jobRepository.findById(id).orElse(null);
 * // if (job != null) {
 * // jobDTO jobDTO = new jobDTO();
 * // jobDTO.setJob(job);
 * // try {
 * // Company company =
 * // restTemplate.getForObject("http://COMPANY-MS:8081/companies/" +
 * // job.getCompanyId(),
 * // Company.class);
 * // jobDTO.setCompany(company);
 * // } catch (RestClientException e) {
 * // System.out.println("Some error occured....");
 * // }
 * 
 * // return jobDTO;
 * // }
 * 
 * // return null;
 * // }
 * public JobDTO getJobById(Long id) {
 * Job job = jobRepository.findById(id).orElse(null);
 * 
 * if (job != null) {
 * JobDTO jobDTO = new JobDTO();
 * jobDTO.setId(job.getId());
 * jobDTO.setTitle(job.getTitle());
 * jobDTO.setDescription(job.getDescription());
 * jobDTO.setMinSalary(job.getMinSalary());
 * jobDTO.setMaxSalary(job.getMaxSalary());
 * jobDTO.setLocation(job.getLocation());
 * jobDTO.setCompanyId(job.getCompanyId());
 * 
 * try {
 * Company company =
 * restTemplate.getForObject("http://COMPANY-MS:8081/companies/" +
 * job.getCompanyId(),Company.class);
 * jobDTO.setCompanyName(company.getName());
 * jobDTO.setCompanyDescription(company.getDescription());
 * } catch (RestClientException e) {
 * System.out.println("Some error occurred while fetching company details...");
 * }
 * 
 * return jobDTO;
 * }
 * 
 * return null;
 * }
 * 
 * // delete job by id
 * 
 * @Override
 * public int deleteJobById(Long id) {
 * try {
 * jobRepository.deleteById(id);
 * return 1;
 * } catch (Exception e) {
 * return 0;
 * }
 * }
 * 
 * // update job by id
 * 
 * @Override
 * public int updateJobById(Long id, Job newJob) {
 * Job existingJob = jobRepository.findById(id).orElse(null);
 * 
 * if (existingJob != null) {
 * // Set the id of the new job to be the same as the existing job
 * newJob.setId(existingJob.getId());
 * 
 * // Update the job in the repository
 * jobRepository.save(newJob);
 * 
 * return 1;
 * }
 * return 0;
 * }
 * 
 * }
 */

package com.example.jobMS.job.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.ParameterizedTypeReference;
// import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.jobMS.job.Job;
import com.example.jobMS.job.JobRepository;
import com.example.jobMS.job.JobService;
import com.example.jobMS.job.clients.CompanyClient;
import com.example.jobMS.job.clients.ReviewClient;
import com.example.jobMS.job.dto.JobDTO;
import com.example.jobMS.job.external.Company;
import com.example.jobMS.job.external.Review;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;
    private CompanyClient companyClient;
    private ReviewClient reviewClient;
    int attempt = 0;

    @Autowired
    RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    // get all the jobs
    // @CircuitBreaker(name = "companyBreaker",fallbackMethod =
    // "companyBreakerFallBack")
    // @Retry(name = "companyBreaker", fallbackMethod = "companyBreakerFallBack")
    @RateLimiter(name = "companyBreaker", fallbackMethod = "companyBreakerFallBack")
    @Override
    public List<JobDTO> findAll() {
        System.out.println("Attempts : " + ++attempt);
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();

        for (Job job : jobs) {
            JobDTO jobDTO = createJobDTO(job);
            jobDTOS.add(jobDTO);
        }
        return jobDTOS;
    }

    // fallback method
    public List<String> companyBreakerFallBack(Exception e) {
        List<String> list = new ArrayList<>();
        list.add("Dummy info..fallback!");
        return list;
    }

    // create a job
    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);

        if (job != null) {
            JobDTO jobDTO = createJobDTO(job);
            return jobDTO;
        }

        return null;
    }

    // delete job by id
    @Override
    public int deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    // update job by id
    @Override
    public int updateJobById(Long id, Job newJob) {
        Job existingJob = jobRepository.findById(id).orElse(null);

        if (existingJob != null) {
            // Set the id of the new job to be the same as the existing job
            newJob.setId(existingJob.getId());
            jobRepository.save(newJob);
            return 1;
        }
        return 0;
    }

    private JobDTO createJobDTO(Job job) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setCompanyId(job.getCompanyId());

        try {
            // for single object

            // using RestTemplate
            // Company company =
            // restTemplate.getForObject("http://COMPANY-MS:8081/companies/" +
            // job.getCompanyId(),Company.class);

            // using openfeign
            Company company = companyClient.getCompany(job.getCompanyId());

            // for generic colletions
            // List<Review> reviews =
            // restTemplate.exchange("http://REVIEW-MS:8080/reviews?companyId=" +
            // company.getId(),
            // HttpMethod.GET,
            // null, new ParameterizedTypeReference<List<Review>>() {
            // }).getBody();

            // using openfeign
            List<Review> reviews = reviewClient.getReviews(job.getCompanyId());

            jobDTO.setCompanyName(company.getName());
            jobDTO.setCompanyDescription(company.getDescription());
            jobDTO.setReviews(reviews);
        } catch (RestClientException e) {
            System.out.println("Some error occurred while fetching company details...");
        }
        return jobDTO;
    }
};
