package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orders = new HashMap<>();

    public OrderRepository() {
        orders.put(1L, new Order(1L, 1L, "Laptop", 1200.0));
        orders.put(2L, new Order(2L, 2L, "Headphones", 200.0));
    }

    public List<Order> findAll() { return new ArrayList<>(orders.values()); }

    public Optional<Order> findById(Long id) { return Optional.ofNullable(orders.get(id)); }

    public Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public void delete(Long id) { orders.remove(id); }

    public List<Order> findByUserId(Long userId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getUserId().equals(userId)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
}
