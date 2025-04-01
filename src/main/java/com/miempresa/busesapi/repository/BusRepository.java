package com.miempresa.busesapi.repository;

import com.miempresa.busesapi.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
