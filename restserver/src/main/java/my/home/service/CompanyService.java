package my.home.service;

import my.home.entity.Company;

public interface CompanyService {

    void saveCompany(Company company);
    Company getCompanyById(Long id);
    Iterable<Company> getAllCompany();
    void deleteCompany(Company company);
    void deleteCompanyById(Long id);

}
