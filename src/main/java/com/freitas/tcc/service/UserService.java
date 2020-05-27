package com.freitas.tcc.service;

import com.freitas.tcc.entity.User;
import com.freitas.tcc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> get(UUID id) {
        return userRepository.findById(id);
    }

    public User insert(User user) {
        if (user.getAddress() != null && user.getAddress().getId() == null) {
            var newAddress = addressService.insert(user.getAddress());

            user.setAddress(newAddress);
        }

        return userRepository.save(user);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public void update(User user) {
        addressService.update(user.getAddress());

        userRepository.save(user);
    }
}
