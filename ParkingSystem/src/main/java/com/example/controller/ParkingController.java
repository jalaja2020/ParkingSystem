package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.VehicleAlloatmentRequestDto;
import com.example.dto.VehicleAlloatmentResponseDto;
import com.example.feign.VehicleServiceClient;

@RestController
public class ParkingController {

	@Autowired
	VehicleServiceClient vehicleServiceClient;
	
	@PostMapping("/alloatment")
	public ResponseEntity<VehicleAlloatmentResponseDto> vehicleAlloatment(@RequestBody VehicleAlloatmentRequestDto vehicleAlloatmentRequestDtoDto){
		return vehicleServiceClient.vehicleAlloatment(vehicleAlloatmentRequestDtoDto);
	}

}
