package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmloyeeVacationDto {
	private int noOfDays;
	private int empId;
	private String location;
}
