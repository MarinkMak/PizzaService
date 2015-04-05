package com.epam.repository.interf;

import java.util.Date;
import java.util.List;

import com.epam.domain.Customer;
import com.epam.domain.Order;

public interface OrderRepository {
	Long create(Order order);
	Order read(Long id);
	void update(Order order);
	void delete(Order order);
	List<Order> getAllOrders();
	List<Order> getOrdersByCustomer(Customer customer);
	List<Order> getOrdersByCustomerAndDate(Customer customer, Date fromDate, Date toDate);
}
