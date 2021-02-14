package com.enigma.coba.service;
import com.enigma.coba.entities.Unit;
import com.enigma.coba.repository.UnitRepository;
import com.enigma.coba.service.impl.UnitServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static java.util.Optional.ofNullable;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.Sort.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class UnitServiceTest {

    @InjectMocks
    private UnitServiceImpl service;

    @Mock
    private UnitRepository repository;

    private Unit input;
    private Unit output;

    @BeforeEach
    void setup() {
        input = new Unit();
        input.setCode("x");
        input.setDescription("X");

        output = new Unit();
        output.setId(1);
        output.setCode(input.getCode());
        output.setDescription(input.getDescription());
    }

    @Test
    void saveShouldSuccess() {
        when(repository.save(any()))
                .thenReturn(output);
        Unit result = service.save(input);

        assertEquals(output, result);
    }

    @Test
    void removeShouldSuccess() {
        when(repository.findById(1))
                .thenReturn(ofNullable(input));
        Unit result = service.removeById(1);

        assertNotNull(result);
    }

    @Test
    void removeShouldFail() {
        Unit result = service.removeById(1);
        assertNull(result);
    }

    @Test
    void findAllShouldSuccess() {
        List<Unit> result = service.findAll();
        assertNotNull(result);
    }

    @Test
    void findAllPageShouldSuccess() {
        Unit search = new Unit();
        int page = 0;
        int size = 1;
        Direction sort = Direction.ASC;

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);


        Page<Unit> result = service.findAll(search, page, size, sort);

        assertNull(result);
    }

}
