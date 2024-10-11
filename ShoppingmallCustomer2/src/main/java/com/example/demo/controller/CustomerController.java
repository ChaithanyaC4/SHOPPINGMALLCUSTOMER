package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	
	@Autowired
	private CustomerService s1;
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		
		return s1.saveCustomer(customer);
	}
	
	@GetMapping("/customer")
    public List<Customer> fetchCustomertList() {
        //LOGGER.info("Inside fetchCustomerList of CustomerController");
        return s1.fetchCustomerList();
    }
	
	@GetMapping("/customer/{id}")
    public Customer fetchCustomerById(@PathVariable("id") Long customerId)
            {
        return s1.fetchCustomerById(customerId);
    }
	@DeleteMapping("/customer/{id}")
    public String deleteCustomerById(@PathVariable("id") Long customerId) {
        s1.deleteCustomerById(customerId);
        return "Customer deleted Successfully!!";
    }
	
	@PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable("id") Long customerId,
                                       @RequestBody Customer customer) {
        return s1.updateCustomer(customerId,customer);
    }
}
