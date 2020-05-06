package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleAlloatmentRequestDto {
	
	private Integer empId;
	private Integer noOfYearsExp;
	private String location;

}
