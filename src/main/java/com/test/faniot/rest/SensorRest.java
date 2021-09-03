package com.test.faniot.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.faniot.entity.Sensor;
import com.test.faniot.service.SensorService;

@RestController
@RequestMapping(value="/sensor")
public class SensorRest {
	
	@Autowired
	private SensorService sensorService;

	@GetMapping(value="")
	public List<Sensor> ListSensor (){
		System.out.println("GET ALL");
		List<Sensor> listSensor = this.sensorService.getAll();
		return listSensor;
	}
	
	@GetMapping(value="/{sensorId}")
	public Optional<Sensor> GetSensorById (@PathVariable ("sensorId") Long sensorId){
		System.out.println("GET BY ID");
		Optional<Sensor> sensorById = this.sensorService.get(sensorId);
		return sensorById;
	}
	
	@PostMapping(value="")
	public Optional<Sensor> AddSensor (@RequestBody Sensor newSensor) {
		System.out.println("ADD SENSOR");
		this.sensorService.save(newSensor);
		Optional<Sensor> thisSensor = this.sensorService.get(newSensor.getSensorId());
		return thisSensor;
	}
	
	@PatchMapping(value="/{sensorId}")
	public Optional<Sensor> UpdateSensor (@RequestBody Sensor newSensor, @PathVariable ("sensorId") Long sensorId){
		System.out.println("UPDATE SENSOR");
		this.sensorService.update(newSensor, sensorId);
		Optional<Sensor> thisSensor = this.sensorService.get(newSensor.getSensorId());
		return thisSensor;
	}
	
	@DeleteMapping(value="/{sensorId}")
	public void DeleteSensor(@PathVariable ("sensorId") Long sensorId){
		System.out.println("DELETE SENSOR");
		this.sensorService.delete(sensorId);
	}
}
