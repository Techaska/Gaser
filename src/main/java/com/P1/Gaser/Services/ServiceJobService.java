package com.P1.Gaser.Services;

import com.P1.Gaser.Entity.ServiceJob;
import com.P1.Gaser.Exception.ResourceNotFoundException;
import com.P1.Gaser.Repositories.ServiceJobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceJobService {

    private final ServiceJobRepository serviceJobRepository;

    public ServiceJobService(ServiceJobRepository serviceJobRepository) {
        this.serviceJobRepository = serviceJobRepository;
    }

    public ServiceJob addServiceJob(ServiceJob serviceJob) {
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
                serviceJobRepository.findById(id).orElse(null);

        if (existingServiceJob != null) {

            existingServiceJob.setServiceReference(
                    serviceJob.getServiceReference());

            existingServiceJob.setCustomerId(
                    serviceJob.getCustomerId());

            existingServiceJob.setVehicleId(
                    serviceJob.getVehicleId());

            existingServiceJob.setServiceCenterId(
                    serviceJob.getServiceCenterId());

            existingServiceJob.setMechanicId(
                    serviceJob.getMechanicId());

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

        return null;
    }

    public void deleteServiceJob(Long id) {
        serviceJobRepository.deleteById(id);
    }
}