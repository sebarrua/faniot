package com.test.faniot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Medicion {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "medicion_id",nullable = false)
    private Long medicionId;
    
    @Column(name="fecha")
    private Date fecha;

    @Column(name="temperatura")
    private Double temperatura;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor")
    private Sensor sensor;
    
    public Medicion() {
    	
    }

	public Long getMedicionId() {
		return medicionId;
	}

	public void setMedicionId(Long medicionId) {
		this.medicionId = medicionId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
    

}
