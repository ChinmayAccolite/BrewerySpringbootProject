package com.accolite.Brewery.Controller;

import com.accolite.Brewery.Model.Beer;
import com.accolite.Brewery.Model.Order;
import com.accolite.Brewery.Service.BeerService;
import com.accolite.Brewery.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerMachineController {

    @Autowired
    private BeerService BS;
    @Autowired
    private OrderService OS;

    @GetMapping("/listAllBeers")
    private ResponseEntity<List<Beer>> getAllBeers(){
        return ResponseEntity.ok().body(this.BS.getBeerDetails());
    }
    @GetMapping("/listAllOrders")
    private ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok().body(this.OS.getOrders());
    }

    @PostMapping("/addBeer")
    private ResponseEntity addBeer(@RequestBody Beer B){
        return ResponseEntity.ok().body(this.BS.createBeer(B));
    }

    @PostMapping("/Order/{id}")
    private ResponseEntity createOrder(@PathVariable Long id,@RequestBody Order O){
        return ResponseEntity.ok().body(this.OS.createOrder(O,id));
    }

    @PutMapping("/updateOrder/{id}")
    private ResponseEntity updateOrder(@PathVariable Long id,@RequestBody Order O){
        O.setId(id);
        return ResponseEntity.ok().body(this.OS.updateOrder(O));
    }

    @PutMapping("/updateBeer/{id}")
    private ResponseEntity updateBeer(@PathVariable Long id,@RequestBody Beer B){
        B.setId(id);
        return ResponseEntity.ok().body(this.BS.updateBeer(B));
    }

    @DeleteMapping("/deleteBeer/{id}")
    private HttpStatus deleteBeer(@PathVariable Long id){
        this.BS.deleteBeer(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/deleteOrder/{id}")
    private HttpStatus deleteOrder(@PathVariable Long id){
        this.OS.deleteOrder(id);
        return HttpStatus.OK;
    }


}
