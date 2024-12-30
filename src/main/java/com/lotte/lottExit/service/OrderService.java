package com.lotte.lottExit.service;

import com.lotte.lottExit.mapper.MemberMapper;
import com.lotte.lottExit.mapper.OrderMapper;
import com.lotte.lottExit.model.Member;
import com.lotte.lottExit.model.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class OrderService {
    OrderMapper orderMapper;
    public HashMap makeOrder(Order order){
        HashMap<String, String> returnMap = new HashMap<>();
        orderMapper.makeOrder(order);

        returnMap.put("status", order.getStatus());

        return returnMap;
    }

}
