package com.rest.demo.model;

import java.util.Arrays;

public enum VehicleType {
	
	CAR("car"), TRUCK("truck"), AIRPLANE("airplane"), AMPHIBIAN("amphibian"), BOAT("boat");
	
	private String value;

	private VehicleType(String value) {
		this.value = value;
	}

	public static VehicleType fromValue(String value) {
		for (VehicleType category : values()) {
			if (category.value.equalsIgnoreCase(value)) {
				return category;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}

}
