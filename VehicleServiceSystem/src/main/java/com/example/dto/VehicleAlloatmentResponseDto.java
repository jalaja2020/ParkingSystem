package com.example.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleAlloatmentResponseDto {
	private Integer empId;
	private Integer parkingSpotId;
	private Date alloatedDate;
}
