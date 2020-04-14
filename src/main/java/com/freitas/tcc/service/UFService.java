package com.freitas.tcc.service;

import com.freitas.tcc.entity.UF;
import com.freitas.tcc.repository.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UFService {
    @Autowired
    private UFRepository ufRepository;

    public List<UF> getAll() {
        return ufRepository.findAll();
    }

    public Optional<UF> get(Integer id) {
        return ufRepository.findById(id);
    }
}
