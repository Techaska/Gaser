package com.P1.Gaser.Repositories;

import com.P1.Gaser.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByCustomerCustomerId(Long customerId);
}
