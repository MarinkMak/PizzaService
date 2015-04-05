package com.epam.repository.interf;

import java.util.List;

import com.epam.domain.Customer;

public interface CustomerRepository {
	Long create(Customer customer);
	Customer read(Long id);
	void update(Customer customer);
	void delete(Customer customer);
	List<Customer> getAllCustomers();
}
