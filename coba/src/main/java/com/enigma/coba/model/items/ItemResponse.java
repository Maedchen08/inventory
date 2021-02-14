package com.enigma.coba.model.items;

import com.enigma.coba.model.units.UnitModel;

public class ItemResponse {

    private Integer id;
    private String name;
    private UnitModel unit;
    private Long price;

    public ItemResponse(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ItemResponse() {

    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
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

    public UnitModel getUnit() {
        return unit;
    }

    public void setUnit(UnitModel unit) {
        this.unit = unit;
    }
}
