package com.epam.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.domain.Customer;
import com.epam.domain.Order;
import com.epam.repository.interf.CustomerRepository;

@Repository("customerRepository")
public class JPACustomerRepository implements CustomerRepository {
	
	@PersistenceContext(name="pizzaUnit")
	private EntityManager em;
	
	@Transactional
	public Long create(Customer customer) {
		em.persist(customer);
		return customer.getId();
	}

	public Customer read(Long id) {
		return em.find(Customer.class, id);
	}

	@Transactional
	public void update(Customer customer) {
		em.merge(customer);
	}

	@Transactional
	public void delete(Customer customer) {
		em.remove(em.merge(customer));
	}

	public List<Customer> getAllCustomers() {
		TypedQuery<Customer> query =em.createNamedQuery("Customer.findAll", Customer.class);
		return query.getResultList();
	}

}
