package com.enigma.coba.controller;

import com.enigma.coba.entities.Item;
import com.enigma.coba.entities.Stock;
import javax.persistence.EntityNotFoundException;

import com.enigma.coba.model.*;
import com.enigma.coba.model.stocks.StockElement;
import com.enigma.coba.model.stocks.StockRequest;
import com.enigma.coba.model.stocks.StockResponse;
import com.enigma.coba.model.stocks.StockSearch;
import com.enigma.coba.service.ItemService;
import com.enigma.coba.service.StockService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/stocks")
@RestController
public class StockController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private StockService stockService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<StockResponse> add(
            @Valid @RequestBody StockRequest model) {
        Stock entity = modelMapper.map(model, Stock.class);

        Item item = itemService.findById(model.getItemId());

        entity.setItem(item);
        entity.setTotalPrice(item.getPrice()* entity.getQuantity());

        entity = stockService.save(entity);

        StockResponse data = modelMapper.map(entity, StockResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<StockResponse> edit(
            @PathVariable Integer id, @RequestBody StockRequest model) {
        Stock entity = stockService.findById(id);
        modelMapper.map(model, entity);

        if (entity == null) {
            throw new EntityNotFoundException();
        }

        Item item = itemService.findById(model.getItemId());
        entity.setItem(item);
        entity.setId(id);
        entity = stockService.save(entity);

        StockResponse data = modelMapper.map(entity, StockResponse.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<StockResponse> removeById(@PathVariable Integer id) {
        Stock entity = stockService.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        StockResponse data = modelMapper.map(entity, StockResponse.class);
        return ResponseMessage.success(data);
    }


    @GetMapping("/{id}")
    public ResponseMessage<StockResponse> findById(
            @PathVariable Integer id) {

        Stock entity = stockService.findById(id);
        if (stockService.findById(id) != null) {
            StockResponse data = modelMapper.map(entity, StockResponse.class);
            return ResponseMessage.success(data);
        }
        throw new EntityNotFoundException();
    }

    @GetMapping
    public ResponseMessage<PagedList<StockElement>> findAll(
            @Valid StockSearch model
    ) {
        Stock search = modelMapper.map(model, Stock.class);

        Page<Stock> entityPage = stockService.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Stock> entities = entityPage.toList();

        List<StockElement> models = entities.stream()
                .map(e -> modelMapper.map(e, StockElement.class))
                .collect(Collectors.toList());

        PagedList<StockElement> data = new PagedList<>(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

//    @GetMapping("/summaries")
//    public ResponseMessage<List<StockSummary>> findAllSummaries() {
//        List<StockSummary> entityPage = stockService.findAllSummaries();
//        return ResponseMessage.success(entityPage);
//    }

}
