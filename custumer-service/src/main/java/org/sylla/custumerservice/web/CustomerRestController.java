package org.sylla.custumerservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sylla.custumerservice.entities.Customer;
import org.sylla.custumerservice.repositories.CustomerRepositories;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private final CustomerRepositories customerRepositories;

    public CustomerRestController(CustomerRepositories customerRepositories) {
        this.customerRepositories = customerRepositories;
    }
    @GetMapping("/Customers")
    public List<Customer> customerList(){
        return customerRepositories.findAll();
    }
    @GetMapping("/Customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return customerRepositories.findById(id).get();
    }
}
