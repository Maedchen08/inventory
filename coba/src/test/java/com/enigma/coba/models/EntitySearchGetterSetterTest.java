package com.enigma.coba.models;

import com.enigma.coba.model.items.ItemSearch;
import com.enigma.coba.model.stocks.StockSearch;
import com.enigma.coba.model.transactions.TransactionSearch;
import com.enigma.coba.model.units.UnitSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EntitySearchGetterSetterTest {
    private UnitSearch unitSearch;
    private ItemSearch itemSearch;
    private StockSearch stockSearch;
    private TransactionSearch transactionSearch;

    @BeforeEach
    void setup(){
        unitSearch = new UnitSearch();
        unitSearch.setCode("x");
        unitSearch.setDescription("X");
        unitSearch.setPage(0);
        unitSearch.setSize(0);
        unitSearch.setSort(Sort.Direction.ASC);

        itemSearch = new ItemSearch();
        itemSearch.setName("x");
        itemSearch.setPage(0);
        itemSearch.setSize(0);
        itemSearch.setSort(Sort.Direction.ASC);

        stockSearch = new StockSearch();
        stockSearch.setQuantity(10);
        stockSearch.setPage(0);
        stockSearch.setSize(0);
        stockSearch.setSort(Sort.Direction.ASC);

        transactionSearch = new TransactionSearch();
        transactionSearch.setItemSearch(itemSearch);
        transactionSearch.setQuantity(1);
        transactionSearch.setTotalPrice(10000000);
        transactionSearch.setUnitSearch(unitSearch);
        transactionSearch.setPage(0);
        transactionSearch.setSize(0);
        transactionSearch.setSort(Sort.Direction.ASC);

    }

    @Test
    void unitSearchSetterShouldEqualsGetter(){
        UnitSearch expected = unitSearch;
        UnitSearch actual = new UnitSearch();
        actual.setCode(unitSearch.getCode());
        actual.setDescription(unitSearch.getDescription());
        actual.setPage(unitSearch.getPage());
        actual.setSize(unitSearch.getSize());
        actual.setSort(unitSearch.getSort());

        assertEquals(expected.getCode(),actual.getCode());
        assertEquals(expected.getDescription(),actual.getDescription());
        assertEquals(expected.getPage(),actual.getPage());
        assertEquals(expected.getSize(),actual.getSize());
        assertEquals(expected.getSort(),actual.getSort());
    }

    @Test
    void itemSearchSetterShouldEqualsGetter(){
        ItemSearch expected = itemSearch;
        ItemSearch actual = new ItemSearch();
        actual.setName(itemSearch.getName());
        actual.setPage(itemSearch.getPage());
        actual.setSize(itemSearch.getSize());
        actual.setSort(itemSearch.getSort());

        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getPage(),actual.getPage());
        assertEquals(expected.getSize(),actual.getSize());
        assertEquals(expected.getSort(),actual.getSort());
    }

    @Test
    void stockSearchSetterShouldEqualsGetter(){
        StockSearch expected = stockSearch;
        StockSearch actual = new StockSearch();
        actual.setQuantity(stockSearch.getQuantity());
        actual.setPage(stockSearch.getPage());
        actual.setSize(stockSearch.getSize());
        actual.setSort(stockSearch.getSort());

        assertEquals(expected.getQuantity(),actual.getQuantity());
        assertEquals(expected.getPage(),actual.getPage());
        assertEquals(expected.getSize(),actual.getSize());
        assertEquals(expected.getSort(),actual.getSize());

    }

    @Test
    void TransactionSearchSetterShouldEqualsGetter(){
        TransactionSearch expected = transactionSearch;
        TransactionSearch actual = new TransactionSearch();
        actual.setItemSearch(transactionSearch.getItemSearch());
        actual.setQuantity(transactionSearch.getQuantity());
        actual.setUnitSearch(transactionSearch.getUnitSearch());
        actual.setPage(transactionSearch.getPage());
        actual.setSize(transactionSearch.getSize());
        actual.setSort(transactionSearch.getSort());
        actual.setTotalPrice(transactionSearch.getTotalPrice());

        assertEquals(expected.getItemSearch(),actual.getItemSearch());
        assertEquals(expected.getUnitSearch(),actual.getUnitSearch());
        assertEquals(expected.getQuantity(),actual.getQuantity());
        assertEquals(expected.getTotalPrice(),actual.getTotalPrice());
        assertEquals(expected.getPage(),actual.getPage());
        assertEquals(expected.getSize(),actual.getSize());
        assertEquals(expected.getSort(),actual.getSort());

    }
}
