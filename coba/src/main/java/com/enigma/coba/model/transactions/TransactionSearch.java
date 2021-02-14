package com.enigma.coba.model.transactions;

import com.enigma.coba.model.PageSearch;
import com.enigma.coba.model.items.ItemSearch;
import com.enigma.coba.model.units.UnitSearch;

public class TransactionSearch extends PageSearch {
    private Integer totalPrice;
    private UnitSearch unitSearch;
    private ItemSearch itemSearch;
    private Integer quantity;

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public UnitSearch getUnitSearch() {
        return unitSearch;
    }

    public void setUnitSearch(UnitSearch unitSearch) {
        this.unitSearch = unitSearch;
    }

    public ItemSearch getItemSearch() {
        return itemSearch;
    }

    public void setItemSearch(ItemSearch itemSearch) {
        this.itemSearch = itemSearch;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
