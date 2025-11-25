package com.uniproject.unitproject.services.implementation;


import com.uniproject.unitproject.entities.Trip;
import com.uniproject.unitproject.entities.User;
import com.uniproject.unitproject.repositories.TripRepository;
import com.uniproject.unitproject.repositories.UserRepository;
import com.uniproject.unitproject.services.interfaces.TripService;
import com.uniproject.unitproject.services.interfaces.UserService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User updatedUser) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id " + id));

        return userRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Trip not found with id " + id);
        }
        userRepository.deleteById(id);
    }
}
