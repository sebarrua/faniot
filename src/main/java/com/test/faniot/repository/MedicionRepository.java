package com.test.faniot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.faniot.entity.Medicion;

@Repository
public interface MedicionRepository extends CrudRepository<Medicion, Long>, JpaRepository<Medicion, Long>{

}
