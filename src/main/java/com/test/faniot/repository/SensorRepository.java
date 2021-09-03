package com.test.faniot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.faniot.entity.Sensor;

@Repository
public interface SensorRepository extends CrudRepository<Sensor, Long>, JpaRepository<Sensor, Long> {

}
