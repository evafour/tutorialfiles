package com.demojpa.demojpa.controller;

import com.demojpa.demojpa.entity.Order;
import com.demojpa.demojpa.entity.OrderDetail;
import com.demojpa.demojpa.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @RequestMapping(path = "/detail")
    public String basePath(@RequestParam Long id){
        return orderDetailRepository.findById(id).toString();
    }

    @RequestMapping(path = "/detail/insert")
    public Long insert(
                        @RequestParam String itemName,
                        @RequestParam Long itemPrice
//                        @RequestParam Long orderFk
                        ){
        OrderDetail orderDetail = new OrderDetail(itemName, itemPrice, null);
        orderDetail.setItemName(itemName);
        orderDetail.setItemPrice(itemPrice);
//        orderDetail.setOrderFk(orderFk);
        OrderDetail save = orderDetailRepository.save(orderDetail);
        return save.getId();
    }


}
