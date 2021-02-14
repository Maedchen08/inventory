package com.enigma.coba.model.transactions;

import com.enigma.coba.model.items.ItemResponse;

public class TransactionResponse  {
    private Integer id;
    private ItemResponse itemResponse;
    private Integer totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemResponse getItemResponse() {
        return itemResponse;
    }

    public void setItemResponse(ItemResponse itemResponse) {
        this.itemResponse = itemResponse;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice1) {
        this.totalPrice = totalPrice;
    }
}
