package com.freitas.tcc.web.rest.resources;

import com.freitas.tcc.entity.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/address")
public class AddressResource {

    @GetMapping
    public List<Address> getAllAddress() {
        return null;
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable UUID id) {
        return null;
    }

}
