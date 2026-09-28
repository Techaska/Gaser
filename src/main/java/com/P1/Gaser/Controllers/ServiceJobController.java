package com.P1.Gaser.Controllers;

import com.P1.Gaser.Entity.ServiceJob;
import com.P1.Gaser.Services.ServiceJobService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-jobs")
public class ServiceJobController {

    private final ServiceJobService serviceJobService;

    public ServiceJobController(ServiceJobService serviceJobService) {
        this.serviceJobService = serviceJobService;
    }

    @PostMapping
    public ServiceJob addServiceJob(
            @Valid @RequestBody ServiceJob serviceJob) {

        return serviceJobService.addServiceJob(serviceJob);
    }

    @GetMapping
    public List<ServiceJob> getAllServiceJobs() {
        return serviceJobService.getAllServiceJobs();
    }

    @GetMapping("/{id}")
    public ServiceJob getServiceJobById(
            @PathVariable Long id) {

        return serviceJobService.getServiceJobById(id);
    }

    @PutMapping("/{id}")
    public ServiceJob updateServiceJob(
            @PathVariable Long id,
            @Valid @RequestBody ServiceJob serviceJob) {

        return serviceJobService.updateServiceJob(
                id, serviceJob);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceJob(
            @PathVariable Long id) {

        serviceJobService.deleteServiceJob(id);
    }
}