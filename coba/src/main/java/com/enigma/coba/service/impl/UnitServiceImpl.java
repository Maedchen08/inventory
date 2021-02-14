package com.enigma.coba.service.impl;


import com.enigma.coba.entities.Unit;
import com.enigma.coba.repository.UnitRepository;
import com.enigma.coba.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UnitServiceImpl extends CommonServiceImpl<Unit, Integer> implements UnitService {

    @Autowired
    public UnitServiceImpl(UnitRepository repository) {
        super(repository);
    }
}

