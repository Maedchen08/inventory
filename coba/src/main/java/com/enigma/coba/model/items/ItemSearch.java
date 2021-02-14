package com.enigma.coba.model.items;


import com.enigma.coba.model.PageSearch;

public class ItemSearch extends PageSearch {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}