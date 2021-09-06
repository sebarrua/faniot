package com.test.faniot.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.faniot.entity.Sensor;
import com.test.faniot.service.SensorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/sensor")
public class SensorRest {
	
	@Autowired
	private SensorService sensorService;

	@GetMapping(value="")
	public @ResponseBody List<Sensor> ListSensor (){
		List<Sensor> listSensor = this.sensorService.getAll();
		return listSensor;
	}
	
	@GetMapping(value="/{sensorId}")
	public Optional<Sensor> GetSensorById (@PathVariable ("sensorId") Long sensorId){
		Optional<Sensor> sensorById = this.sensorService.get(sensorId);
		return sensorById;
	}
	
	@PostMapping(value="")
	public Optional<Sensor> AddSensor (@RequestBody Sensor newSensor) {
		this.sensorService.save(newSensor);
		Optional<Sensor> thisSensor = this.sensorService.get(newSensor.getSensorId());
		return thisSensor;
	}
	
	@PatchMapping(value="/{sensorId}")
	public void UpdateSensor (@RequestBody Sensor newSensor, @PathVariable ("sensorId") Long sensorId){
		this.sensorService.update(newSensor, sensorId);
	}
	
	@DeleteMapping(value="/{sensorId}")
	public void DeleteSensor(@PathVariable ("sensorId") Long sensorId){
		this.sensorService.delete(sensorId);
	}
}
