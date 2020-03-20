package com.freitas.tcc.repository;

import com.freitas.tcc.entity.UF;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UFRepository extends JpaRepository<UF, UUID> {
}
