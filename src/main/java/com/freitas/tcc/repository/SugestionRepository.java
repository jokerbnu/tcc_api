package com.freitas.tcc.repository;

import com.freitas.tcc.entity.Sugestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SugestionRepository extends JpaRepository<Sugestion, UUID> {
}
