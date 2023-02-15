package com.accolite.Brewery.Repository;

import com.accolite.Brewery.Model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepo extends JpaRepository<Beer,Long> {
}
