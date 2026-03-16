package com.example.apiescolar.repository;

import com.example.apiescolar.model.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MaestroRepository extends JpaRepository<Maestro, Long> {
    Optional<Maestro> findByEmail(String email);
}

