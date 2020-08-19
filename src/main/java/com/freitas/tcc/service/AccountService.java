package com.freitas.tcc.service;

import com.freitas.tcc.entity.Address;
import com.freitas.tcc.entity.User;
import com.freitas.tcc.repository.AddressRepository;
import com.freitas.tcc.repository.UserRepository;
import com.freitas.tcc.rest.resource.convert.UserConvert;
import com.freitas.tcc.rest.resource.dto.LoginDTO;
import com.freitas.tcc.rest.resource.dto.RegisterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class AccountService {
    private final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Optional<User> login(LoginDTO loginDTO) {
        return userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
    }

    public User register(RegisterDTO registerDTO) {
        User user = UserConvert.registerDtoToUser(registerDTO);

        var address = addressRepository.save(user.getAddress());
        user.setAddress(address);

        return userRepository.save(user);
    }
}
