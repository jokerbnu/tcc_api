package com.freitas.tcc.service;

import com.freitas.tcc.entity.Address;
import com.freitas.tcc.entity.Sugestion;
import com.freitas.tcc.repository.SugestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SugestionService {
    private final Logger logger = LoggerFactory.getLogger(SugestionService.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private SugestionRepository sugestionRepository;

    public List<Sugestion> getAll() {
        return sugestionRepository.findAll();
    }

    public Optional<Sugestion> get(UUID id) {
        return sugestionRepository.findById(id);
    }

    public Sugestion insert(Sugestion sugestion) {
        if (sugestion.getAddress() != null && sugestion.getAddress().getId() == null) {
            var newAddress = addressService.insert(sugestion.getAddress());

            sugestion.setAddress(newAddress);
        }

        return sugestionRepository.save(sugestion);
    }

    public void delete(UUID id) {
        sugestionRepository.deleteById(id);
    }

    public void update(Sugestion sugestion) {
        sugestionRepository.save(sugestion);
    }
}
