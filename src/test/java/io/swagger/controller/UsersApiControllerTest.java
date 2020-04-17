package io.swagger.controller;

import io.swagger.model.User;
import io.swagger.service.UserService;
import io.swagger.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class UsersApiControllerTest {

    @InjectMocks
    UsersApiController controller;

    @Mock
    UserService service;

    @Mock
    HttpServletRequest request;

    @Test
    public void findUserById() {
        User user = new User();
        user.setUserId(1L);

        Mockito.when(service.findById(1L)).thenReturn(user);
        Mockito.when(request.getHeader("Accept")).thenReturn("application/json");

        ResponseEntity<User> result = controller.findUserById(1L);

        assertEquals(result.getStatusCode(), HttpStatus.OK);
        Mockito.verify(service,Mockito.times(1)).findById(any());
    }

    @Test
    public void findNoUser()
    {
        Mockito.when(service.findById(1L)).thenReturn(null);
        Mockito.when(request.getHeader("Accept")).thenReturn("application/json");

        ResponseEntity<User> result = controller.findUserById(1L);

        assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
        Mockito.verify(service,Mockito.times(1)).findById(any());
    }
}