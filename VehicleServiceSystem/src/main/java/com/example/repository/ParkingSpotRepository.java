package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.ParkingSpot;
@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer>{

	List<ParkingSpot> findByLocationAndAlloated(String location, boolean notalloated);
	
	@Modifying
	@Query("UPDATE ParkingSpot a SET a.alloated = :alloated WHERE a.parkingSpotId = :parkingSpotId") 
	int updateParkingAvalibilityDetails(@Param("alloated") boolean alloated, @Param("parkingSpotId") int parkingSpotId);

	 
	@Modifying
	@Query("UPDATE ParkingSpot a SET a.noOfDays = :noOfDays , a.alloated = :alloated WHERE a.parkingSpotId = :parkingSpotId") 
	int updateEmployeeVactionDetails(@Param("noOfDays") int noOfDays, @Param("parkingSpotId") int parkingSpotId,
			@Param("alloated") boolean alloated );

	
}
