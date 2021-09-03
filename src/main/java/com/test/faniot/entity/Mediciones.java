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

@Entity
public class Mediciones {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "MedicionId",nullable = false)
    private Long medicionId;
    
    @Column(name="Fecha")
    private Date fecha;

    @Column(name="Temperatura")
    private Double temperatura;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "Sensor")
    private Sensor sensor;

}
