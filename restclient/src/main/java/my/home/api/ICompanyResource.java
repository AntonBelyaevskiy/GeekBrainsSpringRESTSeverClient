package my.home.api;

import feign.Feign;
import my.home.entity.Company;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.bind.annotation.*;

@FeignClient("rest-server")
@RequestMapping("/api/company")
public interface ICompanyResource {

    static ICompanyResource client(final String baseUrl) {
        final FormHttpMessageConverter converter = new FormHttpMessageConverter();
        final HttpMessageConverters converters = new HttpMessageConverters(converter);
        final ObjectFactory<HttpMessageConverters> objectFactory = () -> converters;
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new SpringEncoder(objectFactory))
                .decoder(new SpringDecoder(objectFactory))
                .target(ICompanyResource.class, baseUrl);
    }


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
