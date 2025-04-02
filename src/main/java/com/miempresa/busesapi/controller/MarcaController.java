package com.miempresa.busesapi.controller;

import com.miempresa.busesapi.model.Marca;
import com.miempresa.busesapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "*") // para permitir llamadas desde el frontend
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    // Obtener todas las marcas
    @GetMapping
    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    // Crear una nueva marca
    @PostMapping
    public ResponseEntity<Marca> createMarca(@RequestBody Marca nuevaMarca) {
        Marca marcaCreada = marcaRepository.save(nuevaMarca);
        return ResponseEntity.ok(marcaCreada);
    }
}
