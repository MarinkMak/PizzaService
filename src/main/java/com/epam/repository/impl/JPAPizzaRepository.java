package com.epam.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.domain.Pizza;
import com.epam.domain.enums.PizzaType;
import com.epam.repository.interf.PizzaRepository;



@Repository("pizzaRepository")
public class JPAPizzaRepository implements PizzaRepository{
	
	@PersistenceContext(name="pizzaUnit")
	private EntityManager em;
	
	public JPAPizzaRepository() {
		super();
	}
	
	@Transactional
	public Long create(Pizza pizza) {
		em.persist(pizza);           
	    return pizza.getId();
	}
	
	public Pizza read(Long id) {
		return em.find(Pizza.class, id);
	}
	
	@Transactional
	public void update(Pizza pizza) {
		em.merge(pizza);
	}
	
	@Transactional
	public void delete(Pizza pizza) {
		Pizza delPizza = em.merge(pizza);
		em.remove(delPizza);
		// change to "not available"
	}

	public List<Pizza> getAllPizzas() {
		TypedQuery<Pizza> query =em.createNamedQuery("Pizza.findAll", Pizza.class);
		return query.getResultList();
	}

	public List<Pizza> getPizzaByType(PizzaType type) {
		TypedQuery<Pizza> query =em.createNamedQuery("Pizza.findByType", Pizza.class);
		query.setParameter("type", type);
		return query.getResultList();
	}

}
