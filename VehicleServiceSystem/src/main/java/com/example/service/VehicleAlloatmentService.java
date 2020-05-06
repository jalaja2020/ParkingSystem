package com.example.service;

import com.example.dto.EmloyeeVacationDto;
import com.example.dto.EmployeeVacationReponseDto;
import com.example.dto.VehicleAlloatmentRequestDto;
import com.example.dto.VehicleAlloatmentResponseDto;
import com.example.dto.VehicleExitProcessDto;

public interface VehicleAlloatmentService {

	VehicleAlloatmentResponseDto vehicleAlloatment(VehicleAlloatmentRequestDto vehileAlloatmentRequestDto);
    EmployeeVacationReponseDto employeeVaction(EmloyeeVacationDto emloyeeVacationDto);
    VehicleExitProcessDto vehicleExitProcess(int empId);
	
}
