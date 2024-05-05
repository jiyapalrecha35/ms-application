package com.example.jobMS.job.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.jobMS.job.external.Company;

@FeignClient(name = "COMPANY-MS", url = "${company-service.url}")
public interface CompanyClient {

    @GetMapping("/companies/{companyId}")
    Company getCompany(@PathVariable Long companyId);
}
