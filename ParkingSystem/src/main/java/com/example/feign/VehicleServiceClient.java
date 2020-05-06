package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.EmloyeeVacationDto;
import com.example.dto.EmployeeVacationReponseDto;
import com.example.dto.VehicleAlloatmentRequestDto;
import com.example.dto.VehicleAlloatmentResponseDto;
import com.example.dto.VehicleExitProcessDto;
@FeignClient(value="vehicle-service",url="http://localhost:9090/demo/vehicle")
//@FeignClient(name="http://VEHICLE_SERVICE/demo/vehicle")
public interface VehicleServiceClient {
	
	@PostMapping("/alloatment")
	public ResponseEntity<VehicleAlloatmentResponseDto> vehicleAlloatment(@RequestBody VehicleAlloatmentRequestDto vehicleAlloatmentRequestDtoDto);

	@PostMapping("/employeeVacation")
	public ResponseEntity<EmployeeVacationReponseDto> employeeVacation(@RequestBody EmloyeeVacationDto emloyeeVacationDto);

	@GetMapping("/vehicleExit/{empId}")
	public ResponseEntity<VehicleExitProcessDto> vehicleExit(@PathVariable("empId") int empId);

}
