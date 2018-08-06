package com.rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.demo.model.Vehicle;
import com.rest.demo.model.VehicleType;

public interface VehicleRepository extends JpaRepository<Vehicle, VehicleType>{

	
}
