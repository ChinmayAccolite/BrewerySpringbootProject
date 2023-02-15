package com.accolite.Brewery.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Beer")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String BeerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Integer AlcoholPercent;

    public String getBeerName() {
        return BeerName;
    }

    public Integer getAlcoholPercent() {
        return AlcoholPercent;
    }

    public void setAlcoholPercent(Integer alcoholPercent) {
        AlcoholPercent = alcoholPercent;
    }

    public void setBeerName(String beerName) {
        BeerName = beerName;
    }
}
