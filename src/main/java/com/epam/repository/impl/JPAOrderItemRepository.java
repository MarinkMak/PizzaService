package com.epam.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.domain.Order;
import com.epam.domain.OrderItem;
import com.epam.repository.interf.OrderItemRepository;

@Repository("orderItemRepository")
public class JPAOrderItemRepository implements OrderItemRepository {
	
	@PersistenceContext(name="pizzaUnit")
	private EntityManager em;

	@Transactional
	public Long create(OrderItem item) {
//		em.merge(item.getOrder());
//		em.merge(item.getPizza());
		em.persist(item);
		return item.getId();
	}

	public OrderItem read(Long id) {
		return em.find(OrderItem.class, id);
	}

	@Transactional
	public void update(OrderItem item) {
		em.merge(item);
	}

	@Transactional
	public void delete(OrderItem item) {
		em.remove(em.merge(item));
	}

	public List<OrderItem> getAllOrderItems() {
		TypedQuery<OrderItem> query = em.createNamedQuery("OrderItem.findAll", OrderItem.class);
		return query.getResultList();
	}

}
