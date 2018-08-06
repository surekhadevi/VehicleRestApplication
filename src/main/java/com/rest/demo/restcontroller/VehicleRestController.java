package com.rest.demo.restcontroller;

import com.rest.demo.model.Vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.model.VehicleType;
import com.rest.demo.model.VehicleTypeConvertor;
import com.rest.demo.repository.VehicleRepository;

import javassist.NotFoundException;
@RestController
@RequestMapping("/vehicles")
public class VehicleRestController {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@GetMapping("/all")
	public List<Vehicle> getVehicles() {
		
		return vehicleRepository.findAll();
	}
	
	@PostMapping
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		
		return vehicleRepository.save(vehicle);
	}
	
	@PutMapping("/{vehicleType}")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle,@PathVariable("vehicleType") VehicleType vehicleType) {
		return vehicleRepository.save(vehicle);
	}
	
	@GetMapping("/{vehicleType}")
	public Vehicle getVehicleByVehicleType(@PathVariable("vehicleType") VehicleType vehicleType) {
		return vehicleRepository.findById(vehicleType).get();
	}
	
	@DeleteMapping("/{vehicleType}")
	public HttpStatus deleteVehicle(@PathVariable("vehicleType")VehicleType vehicleType) throws Exception{
		Vehicle vehicle = vehicleRepository.findById(vehicleType).get();
		if(vehicle==null) {
			throw new NotFoundException("Vehicle with the type"+vehicleType+"is not found");
		}
		vehicleRepository.deleteById(vehicleType);
		return HttpStatus.OK;
	}
	
	@InitBinder
	public void initBinder(final WebDataBinder webdataBinder) {
		webdataBinder.registerCustomEditor(VehicleType.class, new VehicleTypeConvertor());
	}
}
