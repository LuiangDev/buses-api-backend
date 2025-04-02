package com.miempresa.busesapi.controller;

import com.miempresa.busesapi.model.Bus;
import com.miempresa.busesapi.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "*") // para permitir llamadas desde el frontend
public class BusController {

    @Autowired
    private BusRepository busRepository;

    // Endpoint para obtener todos los buses
    @GetMapping
    public Page<Bus> getAllBuses(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return busRepository.findAll(pageable);
    }
    

    // Endpoint para obtener un bus por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        return busRepository.findById(id)
                .map(bus -> ResponseEntity.ok().body(bus))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
public ResponseEntity<Bus> crearBus(@RequestBody Bus nuevoBus) {
    Bus busGuardado = busRepository.save(nuevoBus);
    return ResponseEntity.ok(busGuardado);
}

}
