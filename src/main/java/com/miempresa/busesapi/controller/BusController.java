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

@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "*")
public class BusController {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public Page<Bus> getAllBuses(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return busRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        return busRepository.findById(id)
                .map(bus -> ResponseEntity.ok().body(bus))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bus> crearBus(@RequestBody Bus nuevoBus) {
        if (nuevoBus.getMarca() != null && nuevoBus.getMarca().getId() != null) {
            // Buscar la marca existente por ID
            Marca marcaExistente = marcaRepository.findById(nuevoBus.getMarca().getId())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con ID: " + nuevoBus.getMarca().getId()));
    
            // Asociar la marca al objeto Bus
            nuevoBus.setMarca(marcaExistente);
        } else {
            // Si no se seleccionó una marca válida, asegurarse de no pasar nada
            nuevoBus.setMarca(null);
        }
    
        // Guardar el bus con su relación correctamente definida
        Bus busGuardado = busRepository.save(nuevoBus);
        return ResponseEntity.ok(busGuardado);
    }
    
}
