package com.miempresa.busesapi.repository;

import com.miempresa.busesapi.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}