package com.miempresa.busesapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Clase que representa un Bus en el sistema.
 * Contiene información sobre el bus, incluyendo su número, placa, fecha de creación,
 * características y estado de actividad.
 */
@Entity
@Table(name = "bus")
public class Bus {
    // Atributos de la clase Bus
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroBus;
    private String placa;
    
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    private String caracteristicas;
    private Boolean activo;

    // Relación con la entidad Marca
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    // Constructor por defecto
    public Bus() {
    }

    // Constructores con parámetros
    public Long getId() {
        return id;
    }
    //// Getters y Setters
    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(String numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    // Método que se ejecuta antes de persistir el objeto
    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
