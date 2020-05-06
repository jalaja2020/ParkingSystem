package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.VehicleAlloatment;
import java.lang.Integer;
import java.util.Date;
import java.util.List;
@Repository
public interface VehicleAlloatmentRepository extends JpaRepository<VehicleAlloatment, Integer> {

	List<VehicleAlloatment> findByEmployeeId(Integer employeeid);
	
	@Modifying
	@Query("UPDATE VehicleAlloatment a SET a.exitDate = :exitDate WHERE a.employeeId = :employeeId") 
	int updateVehicleExit(@Param("exitDate") Date exitDate, @Param("employeeId") int employeeId);

}
