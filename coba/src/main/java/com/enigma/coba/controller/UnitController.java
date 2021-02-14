package com.enigma.coba.controller;

import com.enigma.coba.entities.Unit;
import com.enigma.coba.model.PagedList;
import com.enigma.coba.model.ResponseMessage;
import com.enigma.coba.model.units.UnitModel;
import com.enigma.coba.model.units.UnitSearch;
import com.enigma.coba.service.UnitService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/units")
@RestController
public class UnitController {

    @Autowired
    private UnitService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<UnitModel> add(@RequestBody @Valid UnitModel model) {
        Unit entity = modelMapper.map(model, Unit.class);
        entity = service.save(entity);

        UnitModel data = modelMapper.map(entity, UnitModel.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<UnitModel> edit(@PathVariable Integer id, @RequestBody UnitModel model) {
        Unit entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        modelMapper.map(model, entity);
        entity = service.save(entity);

        UnitModel data = modelMapper.map(entity, UnitModel.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("{id}")
    public ResponseMessage<UnitModel> removeById(@PathVariable Integer id) {
        Unit entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        UnitModel data = modelMapper.map(entity, UnitModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<UnitModel> findById(@PathVariable("id") Integer id) {
        Unit entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        UnitModel data = modelMapper.map(entity, UnitModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<Object> findAll(
            @Valid UnitSearch model
    ) {
        Unit search = modelMapper.map(model, Unit.class);

        Page<Unit> entityPage = service.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Unit> entities = entityPage.toList();

        List<UnitModel> models = entities.stream()
                .map(e -> modelMapper.map(e, UnitModel.class))
                .collect(Collectors.toList());

        PagedList<UnitModel> data = new PagedList<>(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }


}


    

