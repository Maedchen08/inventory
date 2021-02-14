package com.enigma.coba.model.items;

import com.enigma.coba.model.units.UnitModel;

public class ItemElement {


    private Integer id;
    private String name;
    private Integer price;
    private UnitModel unit;

    public UnitModel getUnit() {
        return unit;
    }

    public void setUnit(UnitModel unit) {
        this.unit = unit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}

