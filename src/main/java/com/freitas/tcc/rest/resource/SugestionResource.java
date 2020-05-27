package com.freitas.tcc.rest.resource;

import com.freitas.tcc.entity.Sugestion;
import com.freitas.tcc.service.SugestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/sugestion")
public class SugestionResource {
    @Autowired
    private SugestionService sugestionService;

    @GetMapping
    public ResponseEntity<List<Sugestion>> get() {
        return ResponseEntity.ok(sugestionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sugestion> get(@PathVariable UUID id) {
        var sugestion = sugestionService.get(id);

        if (sugestion.isPresent())
            return ResponseEntity.ok(sugestion.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Sugestion> create(@Valid @RequestBody Sugestion sugestion) {
        return ResponseEntity.ok(sugestionService.insert(sugestion));
    }

    @PutMapping
    public ResponseEntity<Sugestion> update(@Valid @RequestBody Sugestion sugestion) {
        if(sugestion.getId() == null || !sugestionService.get(sugestion.getId()).isPresent())
            return ResponseEntity.notFound().build();

        sugestionService.update(sugestion);

        return ResponseEntity.ok(sugestion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        var sugestion = sugestionService.get(id);

        if(sugestion.isPresent()) {
            sugestionService.delete(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
