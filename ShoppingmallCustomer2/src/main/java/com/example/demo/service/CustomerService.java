package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> fetchCustomerList();

	Customer fetchCustomerById(Long customerId);

	void deleteCustomerById(Long customerId);

	Customer updateCustomer(Long customerId, Customer customer);

}
