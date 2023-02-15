package com.accolite.Brewery.Service;

import com.accolite.Brewery.Model.Beer;

import java.util.List;

public interface BeerService {

    Beer createBeer(Beer B);
    Beer updateBeer(Beer B);
    List<Beer> getBeerDetails();
    void deleteBeer(Long id);

}
