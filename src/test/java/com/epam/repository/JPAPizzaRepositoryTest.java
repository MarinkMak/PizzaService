package com.epam.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.domain.Pizza;
import com.epam.domain.enums.PizzaType;
import com.epam.repository.interf.PizzaRepository;
import com.epam.repository.template.UTRepositoryTestsTemplate;

public class JPAPizzaRepositoryTest extends UTRepositoryTestsTemplate {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Test
    public void testSomeMethod() {
        Pizza pizza = new Pizza();
        pizza.setName("Meet");
        pizza.setType(PizzaType.Meat);
        pizza.setPrice(123.1);        
        
        Long id = pizzaRepository.create(pizza);
        System.out.println(id);
        
        assertNotNull(id);
        fail("The test case is a prototype.");
    }

}
