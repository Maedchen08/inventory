package com.enigma.coba.model.stocks;

import com.enigma.coba.model.items.ItemResponse;

public class StockResponse {
    private Integer id;
    private Integer quantity;
    private ItemResponse item;

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

    public ItemResponse getItem() {
        return item;
    }

    public void setItem(ItemResponse item) {
        this.item = item;
    }
}
