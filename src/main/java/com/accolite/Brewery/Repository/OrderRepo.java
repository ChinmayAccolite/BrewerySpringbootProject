package com.accolite.Brewery.Repository;

import com.accolite.Brewery.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
