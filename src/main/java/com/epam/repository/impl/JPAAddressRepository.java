package com.epam.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.domain.Address;
import com.epam.domain.Order;
import com.epam.repository.interf.AddressRepository;

@Repository("addressRepository")
public class JPAAddressRepository implements AddressRepository {
	
	@PersistenceContext(name="pizzaUnit")
	private EntityManager em;
	
	@Transactional
	public Long create(Address address) {
		em.persist(address);
		return address.getId();
	}

	public Address read(Long id) {
		return em.find(Address.class, id);
	}

	@Transactional
	public void update(Address address) {
		em.merge(address);
	}
	
	@Transactional
	public void delete(Address address) {
		em.remove(em.merge(address));
	}

	public List<Address> getAllAddresses() {
		TypedQuery<Address> query =em.createNamedQuery("Address.findAll", Address.class);
		return query.getResultList();
	}

}
