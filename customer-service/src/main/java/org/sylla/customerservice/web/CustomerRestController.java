package org.sylla.customerservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sylla.customerservice.entities.Customer;
import org.sylla.customerservice.repositories.CustomerRepositories;

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

