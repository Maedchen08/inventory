package com.enigma.coba.model.stocks;

import javax.validation.constraints.NotNull;

public class StockRequest {


    @NotNull
    private Integer itemId;


    private Integer quantity;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

