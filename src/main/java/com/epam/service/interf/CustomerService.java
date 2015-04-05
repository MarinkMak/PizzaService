package com.epam.service.interf;

import java.util.List;

import com.epam.domain.Address;
import com.epam.domain.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Long addNewCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	void updateCustomer(Customer customer);
	Customer getCustomerById(Long id);
}
