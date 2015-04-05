package com.epam.run;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.domain.Address;
import com.epam.domain.Customer;
import com.epam.domain.Order;
import com.epam.domain.Pizza;
import com.epam.domain.enums.OrderStatus;
import com.epam.service.interf.CustomerService;
import com.epam.service.interf.OrderService;
import com.epam.service.interf.PizzaService;

public class AppJPARunner {
	public static String DATE_FORNAT = "yyyy-MM-dd";
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORNAT);
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(
				"springConfig.xml");
		PizzaService pizzaService = appContext.getBean("pizzaService",
				PizzaService.class);
		OrderService orderService = appContext.getBean("orderService",
				OrderService.class);
		CustomerService customerService = appContext.getBean("customerService",
				CustomerService.class);

		Address newAddress = new Address("city","street","house","flat");
		Customer newCustomer = new Customer("NewName","488-48-48", newAddress);
		customerService.addNewCustomer(newCustomer);
		
		Pizza pizza = pizzaService.findPizzaById((long) 3);
		Order newOrder = new Order();
		newOrder.setCustomer(newCustomer);
		orderService.createNewOrder(newOrder);
		
		orderService.addPizzaToOrder(pizza, 5, newOrder);
		
		orderService.changeOrderStatus(newOrder, OrderStatus.IN_PROGRSS);
		
		ArrayList<Order> orders = (ArrayList<Order>) orderService.getOrdersByCustomer(newCustomer);
		for (Order order : orders) {
			System.out.println(order);
		}
		
		
		
		
		
/*		Pizza pizza = new Pizza();
		pizza.setName("Oliva");
		pizza.setType(PizzaType.Sea);
		pizza.setPrice(123.1);
		System.out.println("Before: " + pizza);
		pizzaService.addNewPizza(pizza);
		System.out.println("After: " + pizza);*/

/*		Pizza pizza = pizzaService.findPizzaById((long) 3);
		System.out.println(pizza);
		pizza.setName("MmmmMMMmm");
		pizzaService.updatePizza(pizza);*/
		
//		ArrayList<Pizza> pizzas = (ArrayList<Pizza>) pizzaService.getPizzasByType(PizzaType.Sea);
//		for(Pizza pizza : pizzas){
//			System.out.println(pizza);
//		}
		
//		Order order = orderService.getOrderById((long) 1);
//		System.out.println(order);
//		
		appContext.close();
		
		
		
	}

}
