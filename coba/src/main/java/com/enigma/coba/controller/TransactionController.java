package com.enigma.coba.controller;

import com.enigma.coba.entities.Item;
import com.enigma.coba.entities.Stock;
import com.enigma.coba.entities.Transaction;
import com.enigma.coba.model.ResponseMessage;
import com.enigma.coba.model.items.ItemResponse;
import com.enigma.coba.model.transactions.TransactionModel;
import com.enigma.coba.model.transactions.TransactionResponse;
import com.enigma.coba.service.ItemService;
import com.enigma.coba.service.StockService;
import com.enigma.coba.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@RequestMapping("/transactions")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @Transactional
    public ResponseMessage<TransactionResponse> add(@RequestBody TransactionModel model) {
        Item item = itemService.findById(model.getItemId());
        ItemResponse itemResponse = modelMapper.map(item, ItemResponse.class);

        if (item == null) {
            throw new EntityNotFoundException();
        }

        Stock addStock = new Stock();
        addStock.setTotalPrice(-(item.getPrice())*model.getQuantity());
        addStock.setQuantity(-(model.getQuantity()));
        addStock.setItem(item);
        addStock = stockService.save(addStock);

        Transaction entity = modelMapper.map(model, Transaction.class);
        entity.setItem(item);
        entity.setTotalPrice(model.getQuantity()* item.getPrice());
        entity.setStock(addStock);
        entity = transactionService.save(entity);

        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        data.setItemResponse(itemResponse);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<TransactionResponse> findById(
            @PathVariable Integer id) {
        Transaction entity = transactionService.findById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        ItemResponse item = modelMapper.map(entity.getItem(), ItemResponse.class);

        TransactionResponse data  = modelMapper.map(entity, TransactionResponse.class);
        data.setItemResponse(item);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<TransactionResponse> removeById(
            @PathVariable Integer id) {
        Transaction entity = transactionService.removeById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        TransactionResponse data = modelMapper.map(entity,TransactionResponse.class);
        return  ResponseMessage.success(data);
    }



}
