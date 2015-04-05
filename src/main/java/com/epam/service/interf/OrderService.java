package com.epam.service.interf;

import java.util.Date;
import java.util.List;

import com.epam.domain.Customer;
import com.epam.domain.Order;
import com.epam.domain.Pizza;
import com.epam.domain.enums.OrderStatus;

public interface OrderService {
	List<Order> getAllOrders();
	List<Order> getOrdersByCustomer(Customer customer);
	List<Order> getOrdersByCustomerAndDate(Customer customer, Date fromDate, Date toDate);
	Order getOrderById(Long id);
	public Long createNewOrder(Order order);
	boolean changeOrderStatus(Order order, OrderStatus newStatus);
	void addPizzaToOrder(Pizza pizza, Integer amount, Order order);
}
