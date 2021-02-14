package com.enigma.coba.models;

import com.enigma.coba.model.items.ItemElement;
import com.enigma.coba.model.items.ItemRequest;
import com.enigma.coba.model.items.ItemResponse;
import com.enigma.coba.model.stocks.StockElement;
import com.enigma.coba.model.stocks.StockRequest;
import com.enigma.coba.model.stocks.StockResponse;
import com.enigma.coba.model.transactions.TransactionModel;
import com.enigma.coba.model.transactions.TransactionResponse;
import com.enigma.coba.model.units.UnitModel;
import com.enigma.coba.model.units.UnitResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EntityModelGetterSetterTest {

    private UnitModel unitModel;

    private ItemResponse itemResponse;
    private ItemRequest itemRequest;
    private ItemElement itemElement;

    private StockRequest stockRequest;
    private StockResponse stockResponse;
    private StockElement stockElement;

    private TransactionModel transactionModel;
    private TransactionResponse transactionResponse;

    @BeforeEach
    void setup() {
        unitModel = new UnitModel();
        unitModel.setId(1);
        unitModel.setCode("x");
        unitModel.setDescription("x");

        itemElement = new ItemElement();
        itemElement.setId(1);
        itemElement.setName("shampoo");
        itemElement.setUnit(unitModel);
        itemElement.setPrice(3000);

        itemRequest = new ItemRequest();
        itemRequest.setName("s");
        itemRequest.setPrice(1000);
        itemRequest.setUnitId(3);

        itemResponse = new ItemResponse();
        itemResponse.setId(1);
        itemResponse.setName("s");
        itemResponse.setPrice(2000L);
        itemResponse.setUnit(unitModel);

        stockElement = new StockElement();
        stockElement.setId(1);
        stockElement.setItem(itemElement);
        stockElement.setQuantity(3);

        stockRequest = new StockRequest();
        stockRequest.setItemId(1);
        stockRequest.setQuantity(4);

        stockResponse = new StockResponse();
        stockResponse.setId(1);
        stockResponse.setItem(itemResponse);
        stockResponse.setQuantity(4);

        transactionModel = new TransactionModel();
        transactionModel.setItemId(1);
        transactionModel.setStockId(1);
        transactionModel.setQuantity(3);

        transactionResponse = new TransactionResponse();
        transactionResponse.setId(3);
        transactionResponse.setItemResponse(itemResponse);
        transactionResponse.setTotalPrice(3000);

    }

    @Test
    void unitModelSetterShouldEqualsGetter() {
        UnitModel expected = unitModel;

        UnitModel actual = new UnitModel();
        actual.setId(unitModel.getId());
        actual.setCode(unitModel.getCode());
        actual.setDescription(unitModel.getDescription());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getCode(),actual.getCode());
        assertEquals(expected.getDescription(),actual.getDescription());
    }

    @Test
    void itemElementSetterShouldEqualsGetter(){
        ItemElement expected = itemElement;

        ItemElement actual = new ItemElement();
        actual.setId(itemElement.getId());
        actual.setName(itemElement.getName());
        actual.setPrice(itemElement.getPrice());
        actual.setUnit(itemElement.getUnit());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getPrice(),actual.getPrice());
        assertEquals(expected.getUnit(),actual.getUnit());
    }

    @Test
    void itemRequestSetterShouldEqualsGetter(){
        ItemRequest expected = itemRequest;
        ItemRequest actual = new ItemRequest();
        actual.setUnitId(itemRequest.getUnitId());
        actual.setPrice(itemRequest.getPrice());
        actual.setName(itemRequest.getName());

        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getPrice(),actual.getPrice());
        assertEquals(expected.getUnitId(),actual.getUnitId());
    }

    @Test
    void itemResponseSetterShouldEqualsGetter(){
        ItemResponse expected = itemResponse;
        ItemResponse actual = new ItemResponse();
        actual.setId(itemResponse.getId());
        actual.setUnit(itemResponse.getUnit());
        actual.setPrice(itemResponse.getPrice());
        actual.setName(itemResponse.getName());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getPrice(),actual.getPrice());
        assertEquals(expected.getUnit(),actual.getUnit());
    }

    @Test
    void stockElementSetterShouldEqualsGetter(){
        StockElement expected = stockElement;
        StockElement actual = new StockElement();
        actual.setId(stockElement.getId());
        actual.setItem(stockElement.getItem());
        actual.setQuantity(stockElement.getQuantity());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getItem(),actual.getItem());
        assertEquals(expected.getQuantity(),actual.getQuantity());
    }

    @Test
    void stockRequestSetterShouldEqualsGetter() {
        StockRequest expected = stockRequest;
        StockRequest actual = new StockRequest();
        actual.setItemId(stockRequest.getItemId());
        actual.setQuantity(stockRequest.getQuantity());

        assertEquals(expected.getItemId(),actual.getItemId());
        assertEquals(expected.getQuantity(),actual.getQuantity());

    }

    @Test
    void stockResponseSetterShouldEqualsGetter(){
        StockResponse expected = stockResponse;
        StockResponse actual = new StockResponse();
        actual.setId(stockResponse.getId());
        actual.setQuantity(stockResponse.getQuantity());
        actual.setItem(stockResponse.getItem());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getItem(),actual.getItem());
        assertEquals(expected.getQuantity(),actual.getQuantity());

    }

    @Test
    void transactionModelSetterShouldEqualsGetter() {
        TransactionModel expected = transactionModel;
        TransactionModel actual = new TransactionModel();
        actual.setQuantity(transactionModel.getQuantity());
        actual.setStockId(transactionModel.getStockId());
        actual.setItemId(transactionModel.getItemId());

        assertEquals(expected.getItemId(),actual.getItemId());
        assertEquals(expected.getQuantity(),actual.getQuantity());
        assertEquals(expected.getStockId(),actual.getStockId());

    }

    @Test
    void transactionResponseSetterShouldEqualsGetter(){
        TransactionResponse expected = transactionResponse;
        TransactionResponse actual = new TransactionResponse();
        actual.setId(transactionResponse.getId());
        actual.setTotalPrice(transactionResponse.getTotalPrice());
        actual.setItemResponse(transactionResponse.getItemResponse());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getItemResponse(),actual.getItemResponse());
        assertEquals(expected.getTotalPrice(),actual.getTotalPrice());

    }



}

