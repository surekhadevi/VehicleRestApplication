package com.rest.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Vehicle{

	@Id
	@Enumerated(EnumType.ORDINAL)
	private VehicleType id;

	private VehicleType vehicleType;

	public void setId(VehicleType id) {
		this.id = id;
	}

	public VehicleType getId() {
		return id;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
}
