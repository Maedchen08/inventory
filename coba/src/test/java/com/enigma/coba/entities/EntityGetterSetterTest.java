package com.enigma.coba.entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EntityGetterSetterTest {
    private Unit unit;
    private Item item;
    private Stock stock;
    private UserInfo userInfo;
    private Transaction transaction;


    @BeforeEach
    void setup(){
        unit = new Unit();
        unit.setId(1);
        unit.setCode("x");
        unit.setDescription("X");
        unit.setCreatedDate(LocalDateTime.MIN);
        unit.setModifiedDate(LocalDateTime.MIN);

        item = new Item();
        item.setId(1);
        item.setName("name");
        item.setUnit(unit);
        item.setPrice(3000l);
        item.setCreatedDate(LocalDateTime.MIN);
        item.setModifiedDate(LocalDateTime.MIN);


        stock = new Stock();
        stock.setQuantity(10);
        stock.setItem(item);
        stock.setCreatedDate(LocalDateTime.MIN);
        stock.setModifiedDate(LocalDateTime.MIN);


        userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("eka@gmail.com");
        userInfo.setPassword("aaa");
        userInfo.setFullname("eka nur r");

        transaction = new Transaction();
        transaction.setId(1);
        transaction.setStock(stock);
        transaction.setTotalPrice(1000l);
        transaction.setItem(item);
        transaction.setQuantity(4);
        transaction.setCreatedDate(LocalDateTime.MIN);
        transaction.setModifiedDate(LocalDateTime.MIN);


    }
    @Test
    void unitSetterShouldEqualsGetter() {
        Unit expected = unit;

        Unit actual = new Unit();
        actual.setId(expected.getId());
        actual.setCode(expected.getCode());
        actual.setDescription(expected.getDescription());
        actual.setModifiedDate(expected.getModifiedDate());
        actual.setCreatedDate(expected.getCreatedDate());

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getModifiedDate(), actual.getModifiedDate());
        assertEquals(expected.getCreatedDate(),actual.getCreatedDate());
    }

    @Test
    void itemSetterShouldEqualsGetter(){
        Item expected = item;
        Item actual = new Item();
        actual.setId(expected.getId());
        actual.setName(expected.getName());
        actual.setUnit(expected.getUnit());
        actual.setPrice(expected.getPrice());
        actual.setModifiedDate(expected.getModifiedDate());
        actual.setCreatedDate(expected.getCreatedDate());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getUnit(),actual.getUnit());
        assertEquals(expected.getPrice(),actual.getPrice());
        assertEquals(expected.getCreatedDate(),actual.getCreatedDate());
        assertEquals(expected.getModifiedDate(),actual.getModifiedDate());
    }

    @Test
    void stockSetterShouldEqualsGetter(){
        Stock expected = stock;

        Stock actual = new Stock();
        actual.setId(expected.getId());
        actual.setQuantity(expected.getQuantity());
        actual.setItem(expected.getItem());
        actual.setTotalPrice(expected.getTotalPrice());
        actual.setCreatedDate(expected.getCreatedDate());
        actual.setModifiedDate(expected.getModifiedDate());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getItem(),actual.getItem());
        assertEquals(expected.getQuantity(),actual.getQuantity());
        assertEquals(expected.getTotalPrice(),actual.getTotalPrice());
        assertEquals(expected.getCreatedDate(),actual.getCreatedDate());
        assertEquals(expected.getModifiedDate(),actual.getModifiedDate());
    }

    @Test
    void userSetterShouldEqualGetter(){
        UserInfo expected = userInfo;

        UserInfo actual  = new UserInfo();
        actual.setId(expected.getId());
        actual.setUsername(expected.getUsername());
        actual.setPassword(expected.getPassword());
        actual.setFullname(expected.getFullname());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getUsername(),actual.getUsername());
        assertEquals(expected.getPassword(),actual.getPassword());
        assertEquals(expected.getFullname(),actual.getFullname());
    }

    @Test
    void transactionSetterShouldEqualGetter(){
        Transaction expected = transaction;
        Transaction actual = new Transaction();

        actual.setId(expected.getId());
        actual.setQuantity(expected.getQuantity());
        actual.setItem(expected.getItem());
        actual.setStock(expected.getStock());
        actual.setTotalPrice(expected.getTotalPrice());
        actual.setModifiedDate(expected.getModifiedDate());
        actual.setCreatedDate(expected.getCreatedDate());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getItem(),actual.getItem());
        assertEquals(expected.getQuantity(),actual.getQuantity());
        assertEquals(expected.getStock(),actual.getStock());
        assertEquals(expected.getCreatedDate(),actual.getCreatedDate());
        assertEquals(expected.getModifiedDate(),actual.getModifiedDate());
    }



}
