package com.epam.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.domain.Customer;
import com.epam.domain.Order;
import com.epam.domain.OrderItem;
import com.epam.domain.Pizza;
import com.epam.domain.enums.OrderStatus;
import com.epam.repository.interf.OrderItemRepository;
import com.epam.repository.interf.OrderRepository;
import com.epam.repository.interf.PizzaRepository;
import com.epam.service.interf.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	private OrderRepository orderRepository;
	private OrderItemRepository orderItemRepository;
	private PizzaRepository pizzaRepository;
		
	public OrderServiceImpl() {
	}
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository,
			PizzaRepository pizzaRepository) {
		this.orderRepository = orderRepository;
		this.orderItemRepository = orderItemRepository;
		this.pizzaRepository = pizzaRepository;
	}

	public List<Order> getAllOrders(){
		return orderRepository.getAllOrders();
	}
	
	public void placeOrder(Order order){
		orderRepository.getAllOrders().add(order);
	}
	
	public Order getOrderById(Long id){
		return this.orderRepository.read(id);
	} 

	public Long createNewOrder(Order order){
		return orderRepository.create(order);
	}

	public boolean changeOrderStatus(Order order, OrderStatus newStatus) {
		switch (newStatus) {
		case NEW:{
			return false;
		}
		case IN_PROGRSS:{
			if (order.getStatus().equals(OrderStatus.NEW)) {
				order.setStatus(newStatus);
				orderRepository.update(order);
				return true;
			}else return false;
		}
		case CANCELED:{
			if (order.getStatus().equals(OrderStatus.NEW)||order.getStatus().equals(OrderStatus.IN_PROGRSS)) {
				order.setStatus(newStatus);
				orderRepository.update(order);
				return true;
			}else return false;
		}
		case DONE:{
			if (order.getStatus().equals(OrderStatus.IN_PROGRSS)) {
				order.setStatus(newStatus);
				orderRepository.update(order);
				return true;
			}else return false;
		}
		default:
			return false;
		}
	}
	
	public void addPizzaToOrder(Pizza pizza, Integer amount, Order order) {
		orderItemRepository.create(new OrderItem(pizza, amount, order));
	}
	public List<Order> getOrdersByCustomer(Customer customer) {
		return orderRepository.getOrdersByCustomer(customer);
	}
	public List<Order> getOrdersByCustomerAndDate(Customer customer, Date fromDate, Date toDate) {
		return orderRepository.getOrdersByCustomerAndDate(customer, fromDate, toDate);
	}

	
	
	
	
}
