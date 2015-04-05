package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.domain.Address;
import com.epam.domain.Customer;
import com.epam.repository.interf.AddressRepository;
import com.epam.repository.interf.CustomerRepository;
import com.epam.service.interf.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	private AddressRepository addressRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
		this.customerRepository = customerRepository;
		this.addressRepository = addressRepository;
	}

	public CustomerServiceImpl() {
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	public Long addNewCustomer(Customer customer) {
		return customerRepository.create(customer);
		
	}

	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

	public void updateCustomer(Customer customer) {
		customerRepository.update(customer);
	}

	public Customer getCustomerById(Long id) {
		return customerRepository.read(id);
	}

}
