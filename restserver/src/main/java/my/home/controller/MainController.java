package my.home.controller;

import my.home.entity.Company;
import my.home.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public String index(Model model) {
        List<Company> companies = (List<Company>) companyService.getAllCompany();
        model.addAttribute("companies", companies);
        return "index";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(
            @RequestParam("name") String name,
            @RequestParam("address") String address
    ) {

        Company company = new Company();
        company.setName(name);
        company.setAddress(address);

        companyService.saveCompany(company);

        return "redirect:/";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return "redirect:/";
    }
}
