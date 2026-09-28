package com.P1.Gaser.Services;

import com.P1.Gaser.Entity.Vehicle;
import com.P1.Gaser.Exception.ResourceNotFoundException;
import com.P1.Gaser.Repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Vehicle not found with id: " + id));
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id).orElse(null);

        if (existingVehicle != null) {
            existingVehicle.setVehicleNumber(vehicle.getVehicleNumber());
            existingVehicle.setVehicleBrand(vehicle.getVehicleBrand());
            existingVehicle.setVehicleModel(vehicle.getVehicleModel());
            existingVehicle.setVehicleType(vehicle.getVehicleType());
            existingVehicle.setVehicleYear(vehicle.getVehicleYear());
            existingVehicle.setKmDriven(vehicle.getKmDriven());

            return vehicleRepository.save(existingVehicle);
        }

        return null;
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}