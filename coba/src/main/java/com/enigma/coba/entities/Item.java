package com.enigma.coba.entities;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Long price;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Item(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


}
