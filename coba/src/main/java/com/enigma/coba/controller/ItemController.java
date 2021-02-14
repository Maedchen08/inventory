package com.enigma.coba.controller;

import com.enigma.coba.entities.Item;
import com.enigma.coba.entities.Unit;
import com.enigma.coba.model.PagedList;
import com.enigma.coba.model.ResponseMessage;
import com.enigma.coba.model.items.ItemElement;
import com.enigma.coba.model.items.ItemRequest;
import com.enigma.coba.model.items.ItemResponse;
import com.enigma.coba.model.items.ItemSearch;
import com.enigma.coba.service.ItemService;
import com.enigma.coba.service.UnitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<ItemResponse> add(@RequestBody @Valid ItemRequest model) {
        Item entity = modelMapper.map(model, Item.class);

        Unit unit = unitService.findById(model.getUnitId());
        entity.setUnit(unit);

        entity = itemService.save(entity);

        ItemResponse data = modelMapper.map(entity, ItemResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ItemResponse> edit(
            @PathVariable Integer id, @RequestBody ItemRequest model) {
        Item entity = itemService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        Unit unit = unitService.findById(model.getUnitId());
        entity.setUnit(unit);
        modelMapper.map(model, entity);

        entity = itemService.save(entity);

        ItemResponse data = modelMapper.map(entity, ItemResponse.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("{id}")
    public ResponseMessage<ItemResponse> removeById(@PathVariable Integer id) {
        Item entity = itemService.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        ItemResponse data = modelMapper.map(entity, ItemResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ItemResponse> findById(
            @PathVariable("id") Integer id) {
        Item entity = itemService.findById(id);
        if (itemService.findById(id) != null) {
            ItemResponse data = modelMapper.map(entity, ItemResponse.class);
            return ResponseMessage.success(data);
        }
        throw new EntityNotFoundException();

    }
    @GetMapping
    public ResponseMessage<PagedList<ItemElement>> findAll(
            @Valid ItemSearch model
    ) {
        Item search = modelMapper.map(model, Item.class);

        Page<Item> entityPage = itemService.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Item> entities = entityPage.toList();

        List<ItemElement> models = entities.stream()
                .map(e -> modelMapper.map(e, ItemElement.class))
                .collect(Collectors.toList());

        PagedList<ItemElement> data = new PagedList<>(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

//    @PostMapping(value = "/{id}/image", consumes = "multipart/form-data")
//    public ResponseMessage<Object> upload (@PathVariable Integer id, @Valid ImageUploadRequest model) throws IOException {
//
//        Item entity = itemService.findById(id);
//        if(entity == null) {
//            throw new EntityNotFoundException();
//        }
//        fileService.upload(entity,model.getFile().getInputStream());
//        return  ResponseMessage.success(true);
//
//    }
//    @GetMapping("/{id}/imagedownload")
//    public void  download (@PathVariable Integer id, HttpServletResponse response)throws IOException {
//        Item entity = itemService.findById(id);
//        if(entity == null) {
//            throw new EntityNotFoundException();
//        }
//        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" +entity.getId() + "\"");
//        fileService.download(entity,response.getOutputStream());
//    }
}
