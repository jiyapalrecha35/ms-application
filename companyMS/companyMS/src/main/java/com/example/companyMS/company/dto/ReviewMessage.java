package com.example.companyMS.company.dto;

public class ReviewMessage {
    private Long id;
    private String title;
    private double rating;
    private String description;
    private Long companyId;
    
    // Getter methods
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public Long getCompanyId() {
        return companyId;
    }

    // Setter methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
