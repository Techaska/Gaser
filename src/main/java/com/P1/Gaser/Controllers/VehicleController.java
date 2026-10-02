package com.P1.Gaser.Controllers;

import com.P1.Gaser.Entity.Vehicle;
import com.P1.Gaser.Services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/customer/{customerId}")
    public Vehicle addVehicle(
            @PathVariable Long customerId,
            @Valid @RequestBody Vehicle vehicle) {

        return vehicleService.addVehicle(customerId, vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(
            @PathVariable Long id,
            @Valid @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Vehicle> getVehiclesByCustomerId(
            @PathVariable Long customerId) {

        return vehicleService.getVehiclesByCustomerId(customerId);
    }
}