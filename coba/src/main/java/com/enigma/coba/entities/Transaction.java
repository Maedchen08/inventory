package com.enigma.coba.entities;


import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction extends AbstractEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Column
    private Long totalPrice;

    @Column
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity1) {
        this.quantity = quantity;
    }

    public Transaction(Integer id, Item item, Stock stock, Long totalPrice) {
        this.id = id;
        this.item = item;
        this.stock = stock;
        this.totalPrice = totalPrice;
    }

    public Transaction() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
