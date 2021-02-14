package com.enigma.coba.entities;

import javax.persistence.*;

@Entity
@Table(name="unit")
public class Unit extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String code;
    @Column
    private String description;

    public Unit(Integer id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Unit() {

    }

    @Override
    public Integer getId() {
        // TODO Auto-generated method stub
        return id;
    }

    @Override
    public void setId(Integer id) {
       this.id = id;

    }

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

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    
}
