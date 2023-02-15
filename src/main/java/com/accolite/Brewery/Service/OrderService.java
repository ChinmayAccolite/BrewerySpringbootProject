package com.accolite.Brewery.Service;

import com.accolite.Brewery.Model.Beer;
import com.accolite.Brewery.Model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {

    Order createOrder(Order O,Long Bid);
    List<Order> getOrders();
    Order updateOrder(Order O);
    void deleteOrder(Long id);

}
