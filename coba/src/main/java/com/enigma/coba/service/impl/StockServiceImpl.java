package com.enigma.coba.service.impl;

import com.enigma.coba.entities.Stock;
import com.enigma.coba.repository.StockRepository;
import com.enigma.coba.service.StockService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl extends CommonServiceImpl<Stock, Integer> implements StockService {

    protected StockServiceImpl(StockRepository repository) {
        super(repository);
    }
}
