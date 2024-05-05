package com.example.jobMS.job.external;


public class Company {
    private Long id;
    private String name;
    private String description;
    

    
    // private List<Review> reviews;

    // Default constructor
    public Company() {
    }

    // Parameterized constructor
    public Company(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
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
}
