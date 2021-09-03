package com.test.faniot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.faniot.entity.Sensor;
import com.test.faniot.repository.SensorRepository;

@Service
public class SensorService implements IBaseService<Sensor> {
	
	@Autowired
	private SensorRepository sensorRepository;

	@Override
	public List<Sensor> getAll() {
		// TODO Auto-generated method stub
		return (List<Sensor>) this.sensorRepository.findAll();
	}

	@Override
	public Optional<Sensor> get(Long id) {
		// TODO Auto-generated method stub
		return this.sensorRepository.findById(id);
	}

	@Override
	public void save(Sensor entity) {
		// TODO Auto-generated method stub
		this.sensorRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		this.sensorRepository.deleteById(id);
	}

	@Override
	public void update(Sensor entity, Long id) {
		// TODO Auto-generated method stub
//		this.sensorRepository.save
		Optional<Sensor> sensorById = this.get(id);
		if(sensorById != null) {
			sensorById.get().setSensorId(sensorById.get().getSensorId());
			sensorById.get().setNombre(entity.getNombre());
			sensorById.get().setDescripcion(entity.getDescripcion());
			this.sensorRepository.flush();
		}
	}
	
	
}
