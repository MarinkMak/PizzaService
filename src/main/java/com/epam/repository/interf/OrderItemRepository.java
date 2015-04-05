package com.epam.repository.interf;

import java.util.List;

import com.epam.domain.OrderItem;

public interface OrderItemRepository {
	Long create(OrderItem item);
	OrderItem read(Long id);
	void update(OrderItem item);
	void delete(OrderItem item);
	List<OrderItem> getAllOrderItems();
}
