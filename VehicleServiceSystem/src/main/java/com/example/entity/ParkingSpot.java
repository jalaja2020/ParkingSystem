package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="parkingspot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parkingSpotId;
	private String spotNumber;
	private String block;
	private String wing;
	private String location;
	private boolean alloated;
	private Integer noOfDays;
	
}
