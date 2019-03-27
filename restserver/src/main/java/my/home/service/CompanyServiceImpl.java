package my.home.service;

import my.home.entity.Company;
import my.home.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    public Company getCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
    }

    public Iterable<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    public void deleteCompany(Company company) {
        companyRepository.delete(company);
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

}


