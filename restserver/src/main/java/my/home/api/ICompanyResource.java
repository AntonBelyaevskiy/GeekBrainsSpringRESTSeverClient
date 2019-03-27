package my.home.api;

import my.home.entity.Company;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/company")
public interface ICompanyResource {
    @GetMapping(value = "/ping", produces = "application/json")
    String ping();

    @GetMapping(value = "/{id}", produces = "application/json")
    Company get(@PathVariable("id") Long id);

    @PostMapping(consumes = "application/json")
    void post(@RequestBody Company company);

    @PutMapping(consumes = "application/json")
    void put(@RequestBody Company company);

    @DeleteMapping(consumes = "application/json")
    void delete(@RequestBody Company company);
}
