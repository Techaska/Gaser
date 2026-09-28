package com.P1.Gaser.Controllers;

import com.P1.Gaser.Entity.ServiceRecord;
import com.P1.Gaser.Services.ServiceRecordService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-records")
public class ServiceRecordController {

    private final ServiceRecordService serviceRecordService;

    public ServiceRecordController(ServiceRecordService serviceRecordService) {
        this.serviceRecordService = serviceRecordService;
    }

    @PostMapping
    public ServiceRecord addServiceRecord(
            @Valid @RequestBody ServiceRecord serviceRecord) {

        return serviceRecordService.addServiceRecord(serviceRecord);
    }

    @GetMapping
    public List<ServiceRecord> getAllServiceRecords() {
        return serviceRecordService.getAllServiceRecords();
    }

    @GetMapping("/{id}")
    public ServiceRecord getServiceRecordById(
            @PathVariable Long id) {

        return serviceRecordService.getServiceRecordById(id);
    }

    @PutMapping("/{id}")
    public ServiceRecord updateServiceRecord(
            @PathVariable Long id,
            @Valid @RequestBody ServiceRecord serviceRecord) {

        return serviceRecordService.updateServiceRecord(
                id, serviceRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceRecord(
            @PathVariable Long id) {

        serviceRecordService.deleteServiceRecord(id);
    }
}