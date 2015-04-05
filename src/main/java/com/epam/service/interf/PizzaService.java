package com.epam.service.interf;

import java.util.List;

import com.epam.domain.Pizza;
import com.epam.domain.enums.PizzaType;

public interface PizzaService {
	List<Pizza> getAllPizzas();
	List<Pizza> getPizzasByType(PizzaType type);
	Long addNewPizza(Pizza pizza);
	void deletePizza(Pizza pizza);
	void updatePizza(Pizza pizza);
	Pizza findPizzaById(Long id);
	
	
}
