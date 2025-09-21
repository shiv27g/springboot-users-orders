package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) { this.service = service; }

    @GetMapping
    public List<Order> getAllOrders() { return service.getAllOrders(); }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) { return service.getOrderById(id); }

    @PostMapping
    public Order createOrder(@RequestBody Order order) { return service.createOrder(order); }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) { service.deleteOrder(id); }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) { return service.getOrdersByUser(userId); }
}
