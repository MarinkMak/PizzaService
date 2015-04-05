package com.epam.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.domain.Customer;
import com.epam.domain.Order;
import com.epam.repository.interf.OrderRepository;

@Repository("orderRepository")
public class JPAOrderRepository implements OrderRepository{
	
	@PersistenceContext(name="pizzaUnit")
	private EntityManager em;
	
	public JPAOrderRepository(){
	}
	
	public List<Order> getAllOrders() {
		TypedQuery<Order> query =em.createNamedQuery("Order.findAll", Order.class);
		return query.getResultList();
	}
	
	@Transactional
	public Long create(Order order) {
		em.persist(order);
		return order.getId();
	}
	
	@Transactional
	public void update(Order order) {
		em.merge(order);
	}
	
	@Transactional
	public void delete(Order order) {
		em.remove(em.merge(order));
	}

	public Order read(Long id) {
		return em.find(Order.class, id);
	}

	public List<Order> getOrdersByCustomer(Customer customer) {
		TypedQuery<Order> query = em.createNamedQuery("Order.findByCustomer", Order.class);
		query.setParameter("customer", customer);
		return query.getResultList();
	}

	public List<Order> getOrdersByCustomerAndDate(Customer customer, Date fromDate, Date toDate) {
		TypedQuery<Order> query = em.createNamedQuery("Order.findByCustomerAndDate", Order.class);
		query.setParameter("customer", customer);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		return query.getResultList();
	}

	

}
