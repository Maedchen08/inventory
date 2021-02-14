package com.enigma.coba.models;
import com.enigma.coba.model.ResponseMessage;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ResponseMessageTest {

    @Test
    void responseMessageSetterShouldEqualsGetter() {
        ResponseMessage<String> expected = new ResponseMessage<String>(
                0,
                "message",
                "data"
        );
        expected.setCode(0);
        expected.setMessage("message");
        expected.setData("data");
        expected.setTimestamp(LocalDateTime.MIN);

        ResponseMessage<String> actual = new ResponseMessage<String>(
                expected.getCode(),
                expected.getMessage(),
                expected.getData()
        );
        actual.setTimestamp(LocalDateTime.MIN);

        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getMessage(), actual.getMessage());
        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getTimestamp(), actual.getTimestamp());
    }
}
