
package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepository r1;

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return r1.save(customer);
	}

	@Override
	public List<Customer> fetchCustomerList() {
		// TODO Auto-generated method stub
		return r1.findAll();
	}

	@Override
	public Customer fetchCustomerById(Long customerId) {
		// TODO Auto-generated method stub
		return r1.findById(customerId).get();
	}

	@Override
	public void deleteCustomerById(Long customerId) {
		// TODO Auto-generated method stub
		 r1.deleteById(customerId);
	}

	@Override
	public Customer updateCustomer(Long customerId, Customer customer) {
		// TODO Auto-generated method stub
		Customer custDB = r1.findById(customerId).get();

	       if(Objects.nonNull(customer.getName()) &&
	       !"".equalsIgnoreCase(customer.getName())) {
	           custDB.setName(customer.getName());
	       }

	       if (Objects.nonNull(customer.getPhone()) && customer.getPhone() != 0L) {
	    	    custDB.setPhone(customer.getPhone());
	    	}


	       if(Objects.nonNull(customer.getEmail()) &&
	               !"".equalsIgnoreCase(customer.getEmail())) {
	           custDB.setEmail(null);
	       }

	       return r1.save(custDB);
	}
	
	
}

