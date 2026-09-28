package com.P1.Gaser.Controllers;

import com.P1.Gaser.Entity.ServiceCenter;
import com.P1.Gaser.Services.ServiceCenterService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-centers")
public class ServiceCenterController {

    private final ServiceCenterService serviceCenterService;

    public ServiceCenterController(ServiceCenterService serviceCenterService) {
        this.serviceCenterService = serviceCenterService;
    }

    @PostMapping
    public ServiceCenter addServiceCenter(
            @Valid @RequestBody ServiceCenter serviceCenter) {

        return serviceCenterService.addServiceCenter(serviceCenter);
    }

    @GetMapping
    public List<ServiceCenter> getAllServiceCenters() {
        return serviceCenterService.getAllServiceCenters();
    }

    @GetMapping("/{id}")
    public ServiceCenter getServiceCenterById(
            @PathVariable Long id) {

        return serviceCenterService.getServiceCenterById(id);
    }

    @PutMapping("/{id}")
    public ServiceCenter updateServiceCenter(
            @PathVariable Long id,
            @Valid @RequestBody ServiceCenter serviceCenter) {

        return serviceCenterService.updateServiceCenter(
                id, serviceCenter);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceCenter(@PathVariable Long id) {
        serviceCenterService.deleteServiceCenter(id);
    }
}