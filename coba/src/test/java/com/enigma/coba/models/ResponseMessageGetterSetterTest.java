package com.enigma.coba.models;
import com.enigma.coba.model.PagedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseMessageGetterSetterTest {

    private List<String> stringList;
    private PagedList<String> stringPagedList;

    @BeforeEach
    void setup() {
        stringList = new ArrayList<>();
        stringPagedList = new PagedList<>(
                stringList,
                0,
                0,
                0L
        );
    }

    @Test
    void paginationSetterShouldEqualsGetter() {
        PagedList<String> expected =  stringPagedList;
        expected.setList(stringList);
        expected.setPage(0);
        expected.setSize(0);
        expected.setTotal(0L);

        PagedList<String> actual = new PagedList<>(
                stringList,
                0,
                0,
                0L
        );
        actual.setList(stringList);
        actual.setPage(0);
        actual.setSize(0);
        actual.setTotal(0L);

        assertEquals(expected.getList(), actual.getList());
        assertEquals(expected.getPage(), actual.getPage());
        assertEquals(expected.getSize(), actual.getSize());
        assertEquals(expected.getTotal(), actual.getTotal());
    }
}

