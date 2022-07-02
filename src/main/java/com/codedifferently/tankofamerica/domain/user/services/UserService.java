package com.codedifferently.tankofamerica.domain.user.services;

import com.codedifferently.tankofamerica.domain.user.Exceptions.UserNotFoundException;
import com.codedifferently.tankofamerica.domain.user.models.User;

public interface UserService {
    User create(User user);
    String getAllUsers();

    User getById(Long userId) throws UserNotFoundException;
}
