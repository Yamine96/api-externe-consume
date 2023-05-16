package com.servicesweb.apiexterneconsume.controller;
import com.servicesweb.apiexterneconsume.SoapClient;
import com.servicesweb.apiexterneconsume.entity.Employee;
import com.servicesweb.apiexterneconsume.entity.Product;
import com.servicesweb.apiexterneconsume.stub.DetailsType;
import com.servicesweb.apiexterneconsume.stub.GetBankResponseType;
import com.servicesweb.apiexterneconsume.stub.GetBankType;
import com.servicesweb.apiexterneconsume.stub.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private SoapClient soapClient;
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    String endpoint = "https://reqres.in/api/product";

    private static List employeesList = new ArrayList();

    static {
        Employee employee1 = new Employee(1L, "yamine", "123123", 2000L);
        Employee employee2 = new Employee(2L, "ahmed", "111222", 1000L);
        employeesList.add(employee1);
        employeesList.add(employee2);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeesList;
    }

    @PostMapping("/addemployees")
    public String addEmployees() {
        return "test api ajout employer";
    }

    @DeleteMapping("/deleteemployees")
    public String deleteEmployees() {
        return "test api suppression employer";
    }

    @PutMapping("/updateemployees")
    public String ipdateEmployees() {
        return "test api modification employer";
    }

    @GetMapping("/getProducts")
    public Product getProductDetails() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        Product productFound = restTemplate.exchange(endpoint, HttpMethod.GET, entity, Product.class).getBody();
        return productFound;
    }

    @GetMapping("/testSoap")
    public DetailsType sum(@RequestParam String code) {
        ObjectFactory objectFactory = new ObjectFactory();
        GetBankType type = new GetBankType();
        type.setBlz(code);

        GetBankResponseType response = soapClient.getBank("http://www.thomas-bayer.com/axis2/services/BLZService",
                objectFactory.createGetBank(type));
        return response.getDetails();
    }
}
