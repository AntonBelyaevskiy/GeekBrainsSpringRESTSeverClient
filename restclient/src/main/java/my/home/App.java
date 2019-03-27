package my.home;

import my.home.api.ICompanyResource;
import my.home.entity.Company;

public class App {

    public static void main(String[] args) {
        final String baseUrl = "http://localhost:8080";
        final ICompanyResource companyResource = ICompanyResource.client(baseUrl);
        System.out.println(companyResource.get(1L));
        System.out.println(companyResource.get(2L));


        final ICompanyResource companyResource1 = ICompanyResource.client(baseUrl);
        final Company company = new Company();
        company.setName("TEST2");
        company.setAddress("Test address 200");
        companyResource1.post(company);

    }

}
