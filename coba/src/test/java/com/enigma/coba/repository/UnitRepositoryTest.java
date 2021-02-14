package com.enigma.coba.repository;

import com.enigma.coba.entities.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UnitRepositoryTest {

    @Autowired
    private UnitRepository repository;

    @Test
    void shouldsave() {
        Unit unit = new Unit();
        unit.setCode("xyz");
        unit.setDescription("XYZ");
        repository.save(unit);
        Unit savedUnit = repository.findById(unit.getId()).get();
        assertEquals(unit,savedUnit);
    }
}
