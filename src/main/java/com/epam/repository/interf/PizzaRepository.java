package com.epam.repository.interf;

import java.util.List;

import com.epam.domain.Pizza;
import com.epam.domain.enums.PizzaType;

public interface PizzaRepository {
	Long create(Pizza pizza);
	Pizza read(Long id);
	void update(Pizza pizza);
	void delete(Pizza pizza);
	List<Pizza> getAllPizzas();
	List<Pizza> getPizzaByType(PizzaType type);
	
}
