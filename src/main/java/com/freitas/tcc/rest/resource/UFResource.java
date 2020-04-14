package com.freitas.tcc.rest.resource;

import com.freitas.tcc.entity.UF;
import com.freitas.tcc.service.UFService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/uf")
public class UFResource {
    private final Logger log = LoggerFactory.getLogger(UFResource.class);

    @Autowired
    private UFService ufService;

    @GetMapping
    public ResponseEntity<List<UF>> getAll() {
        return ResponseEntity.ok(ufService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UF> get(@PathVariable Integer id) {
        var uf = ufService.get(id);

        if(uf.isPresent())
            return ResponseEntity.ok(uf.get());

        return ResponseEntity.notFound().build();
    }
}