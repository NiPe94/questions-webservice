package io.swagger.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ErrorTest {

    Error error;

    @Before
    public void setUp() throws Exception {
        error = new Error();
    }

    @Test
    public void getCode() {
        Integer code = 404;
        error.setCode(code);
        assertEquals(error.getCode(), code);
    }

    @Test
    public void getMessage() {
        String message = "Not Found";
        error.setMessage(message);
        assertEquals(error.getMessage(),message);
    }

    @Test
    public void equalErrors(){
        Integer code = 200;
        String msg = "OK";

        error.setMessage(msg);
        error.setCode(code);

        Error other = new Error();
        other.setCode(code);
        other.setMessage(msg);

        assertTrue(error.equals(other));
        assertTrue(error.toString().equals(other.toString()));
    }
}