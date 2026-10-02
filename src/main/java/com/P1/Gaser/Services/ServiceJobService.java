package com.P1.Gaser.Services;

import com.P1.Gaser.Entity.ServiceCenter;
import com.P1.Gaser.Entity.ServiceJob;
import com.P1.Gaser.Entity.Vehicle;
import com.P1.Gaser.Exception.ResourceNotFoundException;
import com.P1.Gaser.Repositories.ServiceCenterRepository;
import com.P1.Gaser.Repositories.ServiceJobRepository;
import com.P1.Gaser.Repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceJobService {

    private final ServiceJobRepository serviceJobRepository;
    private final VehicleRepository vehicleRepository;
    private final ServiceCenterRepository serviceCenterRepository;

    public ServiceJobService(
            ServiceJobRepository serviceJobRepository,
            VehicleRepository vehicleRepository,
            ServiceCenterRepository serviceCenterRepository) {

        this.serviceJobRepository = serviceJobRepository;
        this.vehicleRepository = vehicleRepository;
        this.serviceCenterRepository = serviceCenterRepository;
    }

    public ServiceJob addServiceJob(
            Long vehicleId,
            Long serviceCenterId,
            ServiceJob serviceJob) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vehicle not found with id: " + vehicleId));

        ServiceCenter serviceCenter = serviceCenterRepository.findById(serviceCenterId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Service center not found with id: " + serviceCenterId));

        serviceJob.setVehicle(vehicle);
        serviceJob.setServiceCenter(serviceCenter);

        return serviceJobRepository.save(serviceJob);
    }

    public List<ServiceJob> getAllServiceJobs() {
        return serviceJobRepository.findAll();
    }

    public ServiceJob getServiceJobById(Long id) {
        return serviceJobRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Service job not found with id: " + id));
    }

    public ServiceJob updateServiceJob(
            Long id,
            ServiceJob serviceJob) {

        ServiceJob existingServiceJob =
                serviceJobRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Service job not found with id: " + id));

        existingServiceJob.setServiceReference(
                serviceJob.getServiceReference());

        existingServiceJob.setReceivedDateTime(
                serviceJob.getReceivedDateTime());

        existingServiceJob.setServiceStartDateTime(
                serviceJob.getServiceStartDateTime());

        existingServiceJob.setServiceCompletedDateTime(
                serviceJob.getServiceCompletedDateTime());

        existingServiceJob.setStatus(
                serviceJob.getStatus());

        return serviceJobRepository.save(existingServiceJob);
    }

    public void deleteServiceJob(Long id) {

        if (!serviceJobRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Service job not found with id: " + id);
        }

        serviceJobRepository.deleteById(id);
    }
}

