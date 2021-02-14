package com.enigma.coba.model.units;

import com.enigma.coba.model.PageSearch;
import com.enigma.coba.model.validations.Alphabetic;

public class UnitSearch extends PageSearch {

    @Alphabetic
    private String code;

    private String description;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
