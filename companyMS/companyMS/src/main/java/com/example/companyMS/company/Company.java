package com.example.companyMS.company;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double rating;
    

    // // Map company to jobs
    // @JsonIgnore
    // @OneToMany(mappedBy = "company")
    // private List<Job> jobs;

    // @OneToMany(mappedBy = "company")
    // private List<Review> reviews;

    // Default constructor
    public Company() {
    }

    // Parameterized constructor
    public Company(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        // this.jobs = jobs;
        // this.reviews = reviews;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public double getRating(){
        return rating;
    }

    public void setRating(double rating){
        this.rating=rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // public List<Job> getJobs() {
    //     return jobs;
    // }

    // public void setJobs(List<Job> jobs) {
    //     this.jobs = jobs;
    // }

    // public List<Review> getReviews() {
    //     return reviews;
    // }

    // public void setReviews(List<Review> reviews) {
    //     this.reviews = reviews;
    // }
}
