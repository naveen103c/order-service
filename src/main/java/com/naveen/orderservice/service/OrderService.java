package com.naveen.orderservice.service;

import com.naveen.orderservice.dto.Order;
import com.naveen.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepo;
    
    public Order addOrderService(Order order) {
        return orderRepo.save(order);
    }

    public List<Order> getAllOrderService() {
        return orderRepo.findAll();
    }

    public Order getOrderByIdService(String id) {
        Order order = orderRepo.findById(id).get();
        return order;
    }

    public Order updateOrderByIdService(Order order) {
        return orderRepo.save(order);
    }

    public boolean deleteOrderByIdService(String id) {
        orderRepo.deleteById(id);
        return true;
    }
}
