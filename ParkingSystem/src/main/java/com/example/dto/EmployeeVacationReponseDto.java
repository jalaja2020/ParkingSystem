package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVacationReponseDto {

	private int empId;
	private String location;
    private int parkingslotId;
}
