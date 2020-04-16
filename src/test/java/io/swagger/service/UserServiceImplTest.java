package io.swagger.service;

import io.swagger.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void findById() {
        // given
        Long id = 828896L;

        // then
        User resultUser = userService.findById(id);
        assertNotNull(resultUser);
    }

    @Test
    public void findNothingById(){
        // given
        Long id = -2L;

        // then
        User resultUser = userService.findById(id);
        assertNull(resultUser);
    }
}