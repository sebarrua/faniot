package com.test.faniot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.faniot.entity.Medicion;
import com.test.faniot.entity.Sensor;
import com.test.faniot.repository.MedicionRepository;

@Service
public class MedicionService implements IBaseService<Medicion>{
	
	@Autowired
	private MedicionRepository medicionRepository;
	@Autowired
	private SensorService sensorService;

	@Override
	public List<Medicion> getAll() {
		// TODO Auto-generated method stub
		return this.medicionRepository.findAll();
	}

	@Override
	public Optional<Medicion> get(Long id) {
		// TODO Auto-generated method stub
		return this.medicionRepository.findById(id);
	}

	@Override
	public void save(Medicion entity) {
		// TODO Auto-generated method stub
		System.out.println("MEDICION SERVICE");
		System.out.println(entity);
		System.out.println(entity.getFecha());
		System.out.println(entity.getTemperatura());
		System.out.println(entity.getSensor());
		Optional<Sensor> sensorSelect = this.sensorService.get(entity.getSensor().getSensorId());
		entity.setSensor(sensorSelect.get());
		this.medicionRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		this.medicionRepository.deleteById(id);
	}

	@Override
	public void update(Medicion entity, Long id) {
		// TODO Auto-generated method stub
		Optional<Medicion> medicionById = this.get(id);
		if(medicionById != null) {
			medicionById.get().setFecha(entity.getFecha());
			medicionById.get().setTemperatura(entity.getTemperatura());
			medicionById.get().setSensor(entity.getSensor());
			this.medicionRepository.flush();
		}
	}

}
