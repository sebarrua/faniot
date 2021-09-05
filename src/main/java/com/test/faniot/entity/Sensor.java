package com.test.faniot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sensor {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sensor_id",nullable = false)
    private Long sensorId;
    
    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;
    
    public Sensor() {
    
    }

	public Long getSensorId() {
		return sensorId;
	}

	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
