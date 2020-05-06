package com.example.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="vehicleallotment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleAlloatment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vehicleAllotId;
	private Integer  employeeId;
	
	private Integer  parkingAllotId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date entryDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date exitDate;
}
