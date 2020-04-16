package io.swagger.service;

import io.swagger.model.User;

public interface UserService {
    User findById(Long id);
}
