package com.miempresa.busesapi.controller;

import com.miempresa.busesapi.model.Bus;
import com.miempresa.busesapi.model.Marca;
import com.miempresa.busesapi.repository.BusRepository;
import com.miempresa.busesapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

// Importaciones necesarias
@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "*")
public class BusController {

    // Inyección de dependencias para el repositorio de Bus y Marca
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    // Métodos para manejar las solicitudes HTTP, paginación y creación de buses
    @GetMapping
    public Page<Bus> getAllBuses(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return busRepository.findAll(pageable);
    }

    // Método para obtener un bus por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        return busRepository.findById(id)
                .map(bus -> ResponseEntity.ok().body(bus))
                .orElse(ResponseEntity.notFound().build());
    }

    // Metodo para registrar un nuevo bus
    @PostMapping
    public ResponseEntity<Bus> crearBus(@RequestBody Bus nuevoBus) {
        if (nuevoBus.getMarca() != null && nuevoBus.getMarca().getId() != null) {
            // Buscamos la marca existente por ID
            Marca marcaExistente = marcaRepository.findById(nuevoBus.getMarca().getId())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con ID: " + nuevoBus.getMarca().getId()));
    
            // Asociamos la marca al objeto Bus
            nuevoBus.setMarca(marcaExistente);
        } else {
            // Si no se seleccionó una marca válida, aseguramos de no pasar nada
            nuevoBus.setMarca(null);
        }
    
        // Se guarda el bus con su relación correctamente definida
        Bus busGuardado = busRepository.save(nuevoBus);
        return ResponseEntity.ok(busGuardado);
    }
    
}
