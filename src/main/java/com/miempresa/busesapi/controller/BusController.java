package com.miempresa.busesapi.controller;

import com.miempresa.busesapi.model.Bus;
import com.miempresa.busesapi.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "http://localhost:5173") // Habilita CORS para el origen especificado
public class BusController {

    @Autowired
    private BusRepository busRepository;

    // Endpoint para obtener todos los buses
    @GetMapping
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // Endpoint para obtener un bus por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        return busRepository.findById(id)
                .map(bus -> ResponseEntity.ok().body(bus))
                .orElse(ResponseEntity.notFound().build());
    }
}
