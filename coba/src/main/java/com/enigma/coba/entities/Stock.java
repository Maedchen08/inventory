package com.enigma.coba.entities;


import javax.persistence.*;


@Table(name = "stock")
@Entity
public class Stock extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer quantity;

    @Column
    private Long totalPrice;

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public Stock(Integer id, Integer quantity,  Item item) {
        this.id = id;
        this.quantity = quantity;
        this.item = item;
    }

    public Stock() {
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
