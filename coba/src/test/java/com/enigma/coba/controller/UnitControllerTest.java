package com.enigma.coba.controller;


import com.enigma.coba.entities.Unit;
import com.enigma.coba.model.units.UnitModel;
import com.enigma.coba.service.UnitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UnitController.class)
public class UnitControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UnitService service;

    @MockBean
    private ModelMapper modelMapper;

    private Unit entity;

    @BeforeEach
    void setup(){
        entity = new Unit();
        entity.setId(1);
        entity.setCode("x");
        entity.setDescription("X");

    }

    @Test
    void addShouldSuccess() throws Exception {
        when(service.save(any())).thenReturn(entity);

        UnitModel unitModel = new UnitModel();
        unitModel.setId(entity.getId());
        unitModel.setCode(entity.getCode());
        unitModel.setDescription(entity.getDescription());
        when(modelMapper.map(any(Unit.class),any(Class.class))).thenReturn(unitModel);

        RequestBuilder request = post("/units")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"code\": \"x\", \"description\": \"X\"}");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.code", is(entity.getCode())));

    }

    @Test
    void getShouldReturnEntity() throws Exception{
        when(service.findById(1)).thenReturn(entity);

        UnitModel model = new UnitModel();
        model.setId(entity.getId());
        model.setCode(entity.getCode());
        model.setDescription(entity.getDescription());

        when(modelMapper.map(any(Unit.class),any(Class.class))).thenReturn(model);

        RequestBuilder request = get("/units/1")
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code",is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.code",is(entity.getCode())))
                .andExpect(jsonPath("$.data.description", is(entity.getDescription())));
    }

    @Test
    void findAllCompleteShouldReturnEmptyArray() throws Exception {
        List<Unit> entityList = new ArrayList<>();
        when(service.findAll()).thenReturn(entityList);

        RequestBuilder requestBuilder = get("/units/all")
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code",is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data",empty()));
    }




}
