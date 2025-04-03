package com.miempresa.busesapi.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Clase que representa una Marca de bus en el sistema.
 * Contiene información sobre la marca y su relación con los buses.
 */
@Entity
@Table(name = "marca")
public class Marca {

    // Atributos de la clase Marca
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación con la entidad Bus
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    // Se ignora la serialización de la lista de buses para evitar bucles infinitos
    @JsonIgnore
    private List<Bus> buses;

    // Constructor por defecto
    public Marca() {
    }

    // Constructores con parámetros
    public Marca(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}
