package com.lotte.lottExit.mapper;

import com.lotte.lottExit.model.Order;
import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;

@Mapper
public interface OrderMapper {
    HashMap<String, String> makeOrder(Order order);
}
