package com.miempresa.busesapi.controller;

import com.miempresa.busesapi.model.Marca;
import com.miempresa.busesapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Importaciones necesarias para el controlador de Marca
@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "*") // para permitir llamadas desde el frontend
public class MarcaController {
    // Inyección de dependencias para el repositorio de Marca
    @Autowired
    private MarcaRepository marcaRepository;

    // Obtenemos todas las marcas
    @GetMapping
    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    // Creamos una nueva marca
    @PostMapping
    public ResponseEntity<Marca> createMarca(@RequestBody Marca nuevaMarca) {
        Marca marcaCreada = marcaRepository.save(nuevaMarca);
        return ResponseEntity.ok(marcaCreada);
    }
}
