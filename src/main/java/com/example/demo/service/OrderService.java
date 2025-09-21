package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) { this.repository = repository; }

    public List<Order> getAllOrders() { return repository.findAll(); }

    public Optional<Order> getOrderById(Long id) { return repository.findById(id); }

    public Order createOrder(Order order) { return repository.save(order); }

    public void deleteOrder(Long id) { repository.delete(id); }

    public List<Order> getOrdersByUser(Long userId) { return repository.findByUserId(userId); }
}
