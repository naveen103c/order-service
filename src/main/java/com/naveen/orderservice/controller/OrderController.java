package com.naveen.orderservice.controller;

import com.naveen.orderservice.dto.Order;
import com.naveen.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders/add")
    public ResponseEntity<Order> addOrder(@RequestBody @Valid Order order){
        order= orderService.addOrderService(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrder(){
        List<Order> orderList = orderService.getAllOrderService();
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") String id){
        Order order = orderService.getOrderByIdService(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PutMapping("/orders")
    public ResponseEntity<Order> updateOrderById(@RequestBody Order order){
        order = orderService.updateOrderByIdService(order);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Boolean> deleteOrderById(@PathVariable("id") String id){
        boolean isDeleted = orderService.deleteOrderByIdService(id);
        return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
    }
}
