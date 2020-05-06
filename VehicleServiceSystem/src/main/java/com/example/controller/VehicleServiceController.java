package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmloyeeVacationDto;
import com.example.dto.EmployeeVacationReponseDto;
import com.example.dto.VehicleAlloatmentRequestDto;
import com.example.dto.VehicleAlloatmentResponseDto;
import com.example.dto.VehicleExitProcessDto;
import com.example.service.VehicleAlloatmentService;

@RestController
@RequestMapping("vehicle")
public class VehicleServiceController {
	
	@Autowired
	VehicleAlloatmentService vehicleAlloatmentService;
	
	@PostMapping("/alloatment")
	public ResponseEntity<VehicleAlloatmentResponseDto> vehicleAlloatment(@RequestBody VehicleAlloatmentRequestDto vehicleAlloatmentRequestDtoDto){
		VehicleAlloatmentResponseDto vehicleAlloatment = vehicleAlloatmentService.vehicleAlloatment(vehicleAlloatmentRequestDtoDto);
		return new ResponseEntity<VehicleAlloatmentResponseDto>(vehicleAlloatment, HttpStatus.OK);
	}
	
	@PostMapping("/employeeVacation")
	public ResponseEntity<EmployeeVacationReponseDto> employeeVacation(@RequestBody EmloyeeVacationDto emloyeeVacationDto){
		EmployeeVacationReponseDto employeeVaction = vehicleAlloatmentService.employeeVaction(emloyeeVacationDto);
		return new ResponseEntity<EmployeeVacationReponseDto>(employeeVaction, HttpStatus.OK);
	}
	
	@GetMapping("/vehicleExit/{empId}")
	public ResponseEntity<VehicleExitProcessDto> vehicleExit(@PathVariable("empId") int empId){
		 VehicleExitProcessDto vehicleExitProcess = vehicleAlloatmentService.vehicleExitProcess(empId);
		return new ResponseEntity<VehicleExitProcessDto>(vehicleExitProcess, HttpStatus.OK);
	}
	
	

}
