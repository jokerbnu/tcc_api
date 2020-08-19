package com.freitas.tcc.repository;

import com.freitas.tcc.entity.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BeaconRepository extends JpaRepository<Beacon, UUID> {
    Optional<Beacon> findOneByIdentity(String identity);
}
