package com.demojpa.demojpa.controller;

import com.demojpa.demojpa.entity.Order;
import com.demojpa.demojpa.entity.OrderDetail;
import com.demojpa.demojpa.repository.OrderRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/")
    public Object basePath(@RequestParam Long id){
        Order order = orderRepository.findById(id).get();
        System.out.println("coba ah");
        Hibernate.initialize(order.getOrderDetails());
        return order;
    }

    @RequestMapping(path = "/insert")
    public Long insert(@RequestParam String orderId){

        Order order = new Order();
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetail("itemName", 100L, order));
        order.setOrderId(orderId);
        order.setOrderDate(new Date());
        order.setOrderDetails(orderDetails);
        Order save = orderRepository.save(order);
        return save.getId();
    }

    @RequestMapping(path = "/delete")
    public String deleteOrder(@RequestParam Long id){
        orderRepository.deleteById(id);
        return "Delete success";
    }


}
