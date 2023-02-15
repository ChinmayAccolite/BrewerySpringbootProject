package com.accolite.Brewery.Impl;

import com.accolite.Brewery.Model.Beer;
import com.accolite.Brewery.Repository.BeerRepo;
import com.accolite.Brewery.Service.BeerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BeerServiceImpl implements BeerService {

    @Autowired
    private BeerRepo BR;

    @Override
    public Beer createBeer(Beer B) {
        return BR.save(B);
    }

    @Override
    public Beer updateBeer(Beer B) {
        Optional<Beer> BeerObj = this.BR.findById(B.getId());
        if (BeerObj.isPresent()){
            Beer BRU = BeerObj.get();
            BRU.setBeerName(B.getBeerName());
            BRU.setAlcoholPercent(B.getAlcoholPercent());
            return this.BR.save(BRU);
        }else {
            throw new RuntimeException("Beer Not Found");
        }
    }

    @Override
    public List<Beer> getBeerDetails() {
        return this.BR.findAll();
    }

    @Override
      public void deleteBeer(Long id) {
        Optional<Beer> BeerObj = this.BR.findById(id);
        if (BeerObj.isPresent()){
            this.BR.delete(BeerObj.get());
        }else {
            throw new RuntimeException("Beer Not Found");
        }
    }
}
