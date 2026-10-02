package com.P1.Gaser.Services;

import com.P1.Gaser.Entity.Customer;
import com.P1.Gaser.Entity.Vehicle;
import com.P1.Gaser.Exception.ResourceNotFoundException;
import com.P1.Gaser.Repositories.CustomerRepository;
import com.P1.Gaser.Repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;

    public VehicleService(
            VehicleRepository vehicleRepository,
            CustomerRepository customerRepository) {

        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
    }

    public Vehicle addVehicle(Long customerId, Vehicle vehicle) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with id: " + customerId));

        vehicle.setCustomer(customer);

        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vehicle not found with id: " + id));
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

    public List<Vehicle> getVehiclesByCustomerId(Long customerId) {

        if (!customerRepository.existsById(customerId)) {   
            throw new ResourceNotFoundException(
                    "Customer not found with id: " + customerId);
        }

        return vehicleRepository.findByCustomerCustomerId(customerId);
    }
}