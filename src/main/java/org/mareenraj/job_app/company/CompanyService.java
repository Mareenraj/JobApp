package org.mareenraj.job_app.company;

import org.mareenraj.job_app.job.Job;

import java.util.List;

public interface CompanyService {
    List<Company> findAllCompanies();

    String createCompany(Company company);

    Company getCompanyById(Long id);

    Boolean deleteCompanyById(Long id);

    Boolean updateCompanyById(Long id, Company updatedCompany);
}
