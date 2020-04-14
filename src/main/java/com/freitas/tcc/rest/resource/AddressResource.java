package com.freitas.tcc.rest.resource;


import com.freitas.tcc.entity.Address;
import com.freitas.tcc.service.AddressService;
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
@RequestMapping("/v1/address")
public class AddressResource {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> get() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> get(@PathVariable UUID id) {
        var address = addressService.get(id);

        if(address.isPresent())
            return ResponseEntity.ok(address.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Address> create(@Valid @RequestBody Address address) {
        return ResponseEntity.ok(addressService.insert(address));
    }

    @PutMapping
    public ResponseEntity<Address> update(@Valid @RequestBody Address address) {
        addressService.update(address);

        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        var address = addressService.get(id);

        if(address.isPresent()) {
            addressService.delete(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }


}
