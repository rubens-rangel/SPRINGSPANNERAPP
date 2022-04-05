package com.test.cloud.SpringSpannerApp.controller;

import com.test.cloud.SpringSpannerApp.entities.Order;
import com.test.cloud.SpringSpannerApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private final OrderRepository orderRepository;

    OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/api/orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " not found"));
    }

    @PostMapping("/api/orders")
    public String createOrder(@RequestBody Order order) {
        // Spanner currently does not auto generate IDs
        // Generate UUID on new orders
        order.setId(UUID.randomUUID().toString());
        order.setTimestamp(LocalDateTime.now());
        order.setIdtest1("1");



        order.getItems().forEach(item -> {
            // Assign parent ID, and also generate child ID
            item.setOrderId(order.getId());
            order.setIdtest2(order.getIdtest2());
            order.setIdtest3(order.getIdtest3());
            item.setOrderItemId(UUID.randomUUID().toString());
        });

        Order saved = orderRepository.save(order);
        return saved.getId();
    }
}