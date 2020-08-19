package com.freitas.tcc.service;

import com.freitas.tcc.entity.Beacon;
import com.freitas.tcc.repository.BeaconRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BeaconService {
    private final Logger logger = LoggerFactory.getLogger(BeaconService.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private BeaconRepository beaconRepository;

    public List<Beacon> getAll() {
        return beaconRepository.findAll();
    }

    public Optional<Beacon> get(UUID id) {
        return beaconRepository.findById(id);
    }

    public Optional<Beacon> get(String identity) {
        return beaconRepository.findOneByIdentity(identity);
    }

    public Beacon insert(Beacon beacon) {
        if (beacon.getAddress() != null && beacon.getAddress().getId() == null) {
            var newAddress = addressService.insert(beacon.getAddress());

            beacon.setAddress(newAddress);
        }

        return beaconRepository.save(beacon);
    }

    public void delete(UUID id) {
        beaconRepository.deleteById(id);
    }

    public void update(Beacon beacon) {
        addressService.update(beacon.getAddress());

        beaconRepository.save(beacon);
    }
}
