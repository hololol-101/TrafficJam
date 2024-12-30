package com.lotte.lottExit.controller;

import com.lotte.lottExit.model.Member;
import com.lotte.lottExit.model.Order;
import com.lotte.lottExit.service.MemberService;
import com.lotte.lottExit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {
    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public HashMap<String, String> makeOrder(Order order) {
        HashMap<String, String> hm = orderService.makeOrder(order);

        return hm;
    }
}
