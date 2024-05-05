// package com.example.jobMS.job.dto;

// import com.example.jobMS.job.Job;
// import com.example.jobMS.job.external.Company;

// public class JobWithCompany {
//     private Job job;
//     private Company company;

//     // Constructors (if needed)

//     public Job getJob() {
//         return job;
//     }

//     public void setJob(Job job) {
//         this.job = job;
//     }

//     public Company getCompany() {
//         return company;
//     }

//     public void setCompany(Company company) {
//         this.company = company;
//     }
// }

package com.example.jobMS.job.dto;

import java.util.List;

import com.example.jobMS.job.external.Review;

// import com.example.jobMS.job.Job;
// import com.example.jobMS.job.external.Company;

public class JobDTO {
    private long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private long companyId;
    private String companyName;
    private String companyDescription;
    private List<Review> reviews;

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
