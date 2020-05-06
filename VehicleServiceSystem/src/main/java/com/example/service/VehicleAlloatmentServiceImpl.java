package com.example.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmloyeeVacationDto;
import com.example.dto.EmployeeVacationReponseDto;
import com.example.dto.VehicleAlloatmentRequestDto;
import com.example.dto.VehicleAlloatmentResponseDto;
import com.example.dto.VehicleExitProcessDto;
import com.example.entity.Employee;
import com.example.entity.ParkingSpot;
import com.example.entity.VehicleAlloatment;
import com.example.exception.EmployeeNotAvalibleException;
import com.example.exception.EmployeeParkingSlotNotAvalibleException;
import com.example.exception.ParkingSpotNotAvalibleException;
import com.example.repository.EmployeeRepository;
import com.example.repository.ParkingSpotRepository;
import com.example.repository.VehicleAlloatmentRepository;

@Service
@Transactional
public class VehicleAlloatmentServiceImpl implements VehicleAlloatmentService{

	@Autowired
	ParkingSpotRepository parkingSpotRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	VehicleAlloatmentRepository vehicleAlloatmentRepository;
	
	@Override
	public VehicleAlloatmentResponseDto vehicleAlloatment(VehicleAlloatmentRequestDto vehileAlloatmentRequestDto) {
	    VehicleAlloatment vehicleAlloatment = new VehicleAlloatment();
		//checking for avaliblity 
		List<ParkingSpot> avalibleParkingList = parkingSpotRepository.findByLocationAndAlloated(vehileAlloatmentRequestDto.getLocation(), false);
		Optional<Employee> findById = employeeRepository.findById(vehileAlloatmentRequestDto.getEmpId());
		findById.orElseThrow(()->new EmployeeNotAvalibleException("employee not avalible"));
		VehicleAlloatmentResponseDto vehicleAlloatmentResponseDto = new VehicleAlloatmentResponseDto();
		if(findById.isPresent() && !avalibleParkingList.isEmpty()) {
			int updateParkingAvalibilityDetails = parkingSpotRepository.updateParkingAvalibilityDetails(true, avalibleParkingList.get(0).getParkingSpotId());
			 
			vehicleAlloatment.setEmployeeId(vehileAlloatmentRequestDto.getEmpId());
			vehicleAlloatment.setParkingAllotId(avalibleParkingList.get(0).getParkingSpotId());
			vehicleAlloatment.setEntryDate(new Date());
			
			vehicleAlloatmentRepository.save(vehicleAlloatment);
			
			vehicleAlloatmentResponseDto.setParkingSpotId(avalibleParkingList.get(0).getParkingSpotId());
			vehicleAlloatmentResponseDto.setAlloatedDate(new Date());
			vehicleAlloatmentResponseDto.setEmpId(vehileAlloatmentRequestDto.getEmpId());
			
		}else {
			
			throw new ParkingSpotNotAvalibleException("Parking slot not avalible");
		}
		return vehicleAlloatmentResponseDto;
	}

	@Override
	public EmployeeVacationReponseDto employeeVaction(EmloyeeVacationDto emloyeeVacationDto) {
      
		EmployeeVacationReponseDto employeeVacationReponseDto  = new EmployeeVacationReponseDto();
		
		Optional<Employee> findById = employeeRepository.findById(emloyeeVacationDto.getEmpId());
		findById.orElseThrow(()->new EmployeeNotAvalibleException("employee not avalible"));
		List<VehicleAlloatment> findByEmployeeId = vehicleAlloatmentRepository.findByEmployeeId(emloyeeVacationDto.getEmpId());
		if(!findByEmployeeId.isEmpty()) {
			int updateEmployeeVactionDetails = parkingSpotRepository.updateEmployeeVactionDetails(emloyeeVacationDto.getNoOfDays()
					, findByEmployeeId.get(0).getParkingAllotId()
					, false);
			
			employeeVacationReponseDto.setEmpId(emloyeeVacationDto.getEmpId());
			employeeVacationReponseDto.setLocation(emloyeeVacationDto.getLocation());
			employeeVacationReponseDto.setParkingslotId(findByEmployeeId.get(0).getParkingAllotId());
		}
		else {
			throw new EmployeeParkingSlotNotAvalibleException("employee parking slot not avalible");
		}
		return employeeVacationReponseDto;
	}

	@Override
	public VehicleExitProcessDto vehicleExitProcess(int empId) {
		VehicleExitProcessDto vehicleExitProcessDto = new VehicleExitProcessDto();
		Optional<Employee> findById = employeeRepository.findById(empId);
		findById.orElseThrow(()->new EmployeeNotAvalibleException("employee not avalible"));
		List<VehicleAlloatment> findByEmployeeId = vehicleAlloatmentRepository.findByEmployeeId(empId);
		
		if(!findByEmployeeId.isEmpty() ) {
			Optional<ParkingSpot> findParkingAllotId = parkingSpotRepository.findById(findByEmployeeId.get(0).getParkingAllotId());
			findParkingAllotId.orElseThrow(()->new ParkingSpotNotAvalibleException("parking spot not avalible"));
			if(findParkingAllotId.isPresent()) {
				parkingSpotRepository.updateParkingAvalibilityDetails(false, findParkingAllotId.get().getParkingSpotId());
				vehicleAlloatmentRepository.updateVehicleExit(new Date(), empId);
			}
			vehicleExitProcessDto.setParkingAllotId(findParkingAllotId.get().getParkingSpotId());
		}
		vehicleExitProcessDto.setEmpId(empId);
		
		return vehicleExitProcessDto;
	}
	

}
