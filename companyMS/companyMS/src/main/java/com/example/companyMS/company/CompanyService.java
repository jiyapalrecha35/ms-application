package com.example.companyMS.company;
import java.util.List;

import com.example.companyMS.company.dto.ReviewMessage;

public interface CompanyService {
    List<Company> getAllCompanies();
    int updateCompany(Company uCompany,Long id);
    void createCompany(Company company);
    int deleteCompany(Long id);
    Company getCompanyById(Long id);
    public void updateCompanyRating(ReviewMessage reviewMessage);

    
} 
