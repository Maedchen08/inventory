package com.enigma.coba.models;
import com.enigma.coba.model.converter.DirectionConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    private final DirectionConverter converter = new DirectionConverter();

    @Test
    void directionConverterShouldReturnUppercase() {
        assertEquals(converter.convert("ASC"), converter.convert("asc"));
    }
}
