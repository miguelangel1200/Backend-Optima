package com.example.optimacrud.controller;

import com.example.optimacrud.entity.Customer;
import com.example.optimacrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/customers")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getCustomers();
    }
    @GetMapping("/{customerId}")
    public Optional<Customer> getById(@PathVariable("customerId") Long customerId){
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public Customer saveUpdate(@RequestBody Customer customer){
        customerService.saveOrUpdate(customer);
        return customer;
    }
    @DeleteMapping("/{customerId}")
    public void saveUpdate(@PathVariable("customerId") Long customerId){
        customerService.delete(customerId);
    }
}
