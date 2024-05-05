package com.example.companyMS.company.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.companyMS.company.Company;
import com.example.companyMS.company.CompanyRepository;
import com.example.companyMS.company.CompanyService;
import com.example.companyMS.company.clients.ReviewClient;
import com.example.companyMS.company.dto.ReviewMessage;

import jakarta.ws.rs.NotFoundException;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private ReviewClient reviewClient;

    public CompanyServiceImpl(CompanyRepository companyRepository, ReviewClient reviewClient) {
        this.companyRepository = companyRepository;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public int updateCompany(Company updatedCompany, Long id) {
        Company existingCompany = companyRepository.findById(id).orElse(null);

        if (existingCompany != null) {
            // Set the id of the new company to be the same as the existing company
            updatedCompany.setId(existingCompany.getId());

            // Update the company in the repository
            companyRepository.save(updatedCompany);

            return 1;
        }
        return 0;
    }

    @Override
    public int deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        System.out.println(reviewMessage.getDescription());
        Company company = companyRepository.findById(reviewMessage.getCompanyId())
                .orElseThrow(() -> new NotFoundException("Comapny not found " + reviewMessage.getCompanyId()));

        double averageRating = reviewClient.getAverageRatingForCompany(reviewMessage.getCompanyId());

        company.setRating(averageRating);
        companyRepository.save(company);

    }
}
