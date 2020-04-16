package io.swagger.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.threeten.bp.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void getUserId() {
        Long idValue = 1L;

        user.setUserId(idValue);

        assertEquals(user.getUserId(), idValue);
    }

    @Test
    void getCreationDate() {
        OffsetDateTime time = OffsetDateTime.now();

        user.setCreationDate(time);

        assertEquals(user.getCreationDate(), time);
    }

    @Test
    void getDisplayName() {
        String name = "Hannes";

        user.setDisplayName(name);

        assertEquals(user.getDisplayName(), name);
    }
}