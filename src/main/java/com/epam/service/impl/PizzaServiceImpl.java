package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.domain.Pizza;
import com.epam.domain.enums.PizzaType;
import com.epam.repository.interf.PizzaRepository;
import com.epam.service.interf.PizzaService;

@Service("pizzaService")
public class PizzaServiceImpl implements PizzaService{
	
	private PizzaRepository pizzaRepository;

	public PizzaServiceImpl(){
	}
	
	@Autowired
	public PizzaServiceImpl(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}

	public List<Pizza> getAllPizzas() {
		return this.pizzaRepository.getAllPizzas();
	}

	public List<Pizza> getPizzasByType(PizzaType type) {
		return this.pizzaRepository.getPizzaByType(type);
	}
	
	public Long addNewPizza(Pizza pizza) {
		return this.pizzaRepository.create(pizza);
	}
	
	public void deletePizza(Pizza pizza) {
		this.pizzaRepository.delete(pizza);
	}

	public Pizza findPizzaById(Long id) {
		return this.pizzaRepository.read(id);
	}

	public void updatePizza(Pizza pizza) {
		this.pizzaRepository.update(pizza);
	}

//	public PizzaRepository getPizzaRepository() {
//		return pizzaRepository;
//	}
//
//	public void setPizzaRepository(PizzaRepository pizzaRepository) {
//		this.pizzaRepository = pizzaRepository;
//	}


}
