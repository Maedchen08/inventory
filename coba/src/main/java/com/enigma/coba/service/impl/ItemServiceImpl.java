package com.enigma.coba.service.impl;
import com.enigma.coba.entities.Item;
import com.enigma.coba.repository.ItemRepository;
import com.enigma.coba.service.ItemService;
import com.enigma.coba.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl extends CommonServiceImpl<Item, Integer> implements ItemService {

    @Autowired
    private UnitService unitService;

    @Autowired
    public ItemServiceImpl(ItemRepository repository) {
        super(repository);
    }

}
