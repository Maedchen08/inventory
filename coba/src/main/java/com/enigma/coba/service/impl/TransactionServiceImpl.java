package com.enigma.coba.service.impl;


import com.enigma.coba.entities.Transaction;
import com.enigma.coba.repository.TransactionRepository;
import com.enigma.coba.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends CommonServiceImpl<Transaction,Integer> implements TransactionService {

    @Autowired
    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }
}
