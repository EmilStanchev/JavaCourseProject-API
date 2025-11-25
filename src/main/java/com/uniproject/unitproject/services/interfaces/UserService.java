package com.uniproject.unitproject.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.uniproject.unitproject.entities.User;

public interface UserService {
    User create(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    User update(Long id, User user);

    void delete(Long id);
}
