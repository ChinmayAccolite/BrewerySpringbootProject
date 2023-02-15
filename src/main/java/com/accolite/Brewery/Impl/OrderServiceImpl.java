package com.accolite.Brewery.Impl;


import com.accolite.Brewery.Model.Beer;
import com.accolite.Brewery.Model.Order;
import com.accolite.Brewery.Repository.BeerRepo;
import com.accolite.Brewery.Repository.OrderRepo;
import com.accolite.Brewery.Service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepo OR;

    @Autowired
    private BeerRepo BR;

    @Override
    public Order createOrder(Order O,Long Bid) {
        Optional<Beer> BeerObj = this.BR.findById(Bid);
        if (BeerObj.isPresent())
            return this.OR.save(O);
        else
            throw new RuntimeException("Beer Not Found");
    }

    @Override
    public List<Order> getOrders() {
        return this.OR.findAll();
    }

    @Override
    public Order updateOrder(Order O) {
        Optional<Order> OrderObj = this.OR.findById(O.getId());
        if (OrderObj.isPresent()){
            Order OBJNew = OrderObj.get();
            OBJNew.setBeerType(O.getBeerType());
            OBJNew.setPrice(O.getPrice());
            return this.OR.save(OBJNew);
        }else {
            throw new RuntimeException("Order Not Found");
        }
    }

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> OrderObj = this.OR.findById(id);
        this.OR.delete(OrderObj.get());
    }
}
