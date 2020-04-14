package com.freitas.tcc.service;

import com.freitas.tcc.entity.Address;
import com.freitas.tcc.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {
    private final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> get(UUID id) {
        return addressRepository.findById(id);
    }

    public Address insert(Address address) {
        return addressRepository.save(address);
    }

    public void delete(UUID id) {
        addressRepository.deleteById(id);
    }

    public void update(Address address) {
        addressRepository.save(address);
    }
}
