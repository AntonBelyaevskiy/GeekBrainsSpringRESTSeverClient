package my.home.resource;

import my.home.api.ICompanyResource;
import my.home.entity.Company;
import my.home.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyResource implements ICompanyResource {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "/ping", produces = "application/json")
    public String ping(){
        return "OK";
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Company get(@PathVariable("id") final Long id){
        return companyService.getCompanyById(id);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Company> getAll(){
        return (List<Company>) companyService.getAllCompany();
    }

    @PostMapping(consumes = "application/json")
    public void post(@RequestBody final Company company){
        companyService.saveCompany(company);
    }

    @PutMapping(consumes = "application/json")
    public void put(@RequestBody final Company company){
        companyService.saveCompany(company);
    }

    @DeleteMapping(consumes = "application/json")
    public void delete(@RequestBody Company company){
        companyService.deleteCompany(company);
    }


}
