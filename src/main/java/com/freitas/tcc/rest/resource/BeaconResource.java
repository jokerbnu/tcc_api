package com.freitas.tcc.rest.resource;

import com.freitas.tcc.entity.Beacon;
import com.freitas.tcc.service.BeaconService;
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
@RequestMapping("/v1/beacon")
public class BeaconResource {
    @Autowired
    private BeaconService beaconService;

    @GetMapping
    public ResponseEntity<List<Beacon>> get() {
        return ResponseEntity.ok(beaconService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beacon> get(@PathVariable UUID id) {
        var beacon = beaconService.get(id);

        if(beacon.isPresent())
            return ResponseEntity.ok(beacon.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Beacon> create(@Valid @RequestBody Beacon beacon) {
        return ResponseEntity.ok(beaconService.insert(beacon));
    }

    @PutMapping
    public ResponseEntity<Beacon> update(@Valid @RequestBody Beacon beacon) {
        if(beacon.getId() == null || !beaconService.get(beacon.getId()).isPresent())
            return ResponseEntity.notFound().build();

        beaconService.update(beacon);

        return ResponseEntity.ok(beacon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        var beacon = beaconService.get(id);

        if(beacon.isPresent()) {
            beaconService.delete(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
