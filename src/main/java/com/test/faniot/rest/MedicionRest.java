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

import com.test.faniot.entity.Medicion;
import com.test.faniot.service.MedicionService;

@RestController
@RequestMapping(value="/medicion", consumes = "application/json", produces = "application/json")
public class MedicionRest {

	@Autowired
	private MedicionService medicionService;
	
	@GetMapping(value="")
	public List<Medicion> ListMedicion(){
		System.out.println("GET LIST");
		List<Medicion> listMediciones = this.medicionService.getAll();
		return listMediciones;
	}
	
	@GetMapping(value="/{medicionId}")
	public Optional<Medicion> GetMedicionById (@PathVariable ("medicionId") Long medicionId){
		System.out.println("GET BY ID");
		Optional<Medicion> sensorById = this.medicionService.get(medicionId);
		return sensorById;
	}
	
	@PostMapping(value="")
	public Optional<Medicion> AddMedicion (@RequestBody Medicion newMedicion ) {
		System.out.println("ADD MEDICION");
		this.medicionService.save(newMedicion);
		Optional<Medicion> thisMedicion = this.medicionService.get(newMedicion.getMedicionId());
		return thisMedicion;
	}
	
	@PatchMapping(value="/{medicionId}")
	public void UpdateMedicion (@RequestBody Medicion newMedicion, @PathVariable ("medicionId") Long medicionId){
		System.out.println("UPDATE MEDICION");
		this.medicionService.update(newMedicion, medicionId);
	}
	
	@DeleteMapping(value="/{medicionId}")
	public void DeleteMedicion(@PathVariable ("medicionId") Long medicionId){
		System.out.println("DELETE MEDICION");
		this.medicionService.delete(medicionId);
	}
}
