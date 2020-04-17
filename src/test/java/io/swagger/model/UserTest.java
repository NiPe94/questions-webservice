package io.swagger.model;

import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.OffsetDateTime;

import static org.junit.Assert.*;

public class UserTest {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void getUserId() {
        Long idValue = 1L;

        user.setUserId(idValue);

        assertEquals(user.getUserId(), idValue);
    }

    @Test
    public void getCreationDate() {
        OffsetDateTime time = OffsetDateTime.now();

        user.setCreationDate(time);

        assertEquals(user.getCreationDate(), time);
    }

    @Test
    public void getDisplayName() {
        String name = "Hannes";

        user.setDisplayName(name);

        assertEquals(user.getDisplayName(), name);
    }

    @Test
    public void equalUsers(){
        String displayName = "user1";
        Long id = 1L;
        OffsetDateTime time = OffsetDateTime.now();
        user.setDisplayName(displayName);
        user.setCreationDate(time);
        user.setUserId(id);

        User other = new User();
        other.setDisplayName(displayName);
        other.setUserId(id);
        other.setCreationDate(time);

        assertTrue(user.equals(other));
        assertTrue(user.toString().equals(other.toString()));
    }
}