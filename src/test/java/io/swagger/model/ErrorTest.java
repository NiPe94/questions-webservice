package io.swagger.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorTest {

    Error error;

    @BeforeEach
    void setUp() {
        error = new Error();
    }

    @Test
    void getCode() {
        Integer code = 404;
        error.setCode(code);
        assertEquals(error.getCode(), code);
    }

    @Test
    void getMessage() {
        String message = "Not Found";
        error.setMessage(message);
        assertEquals(error.getMessage(),message);
    }
}