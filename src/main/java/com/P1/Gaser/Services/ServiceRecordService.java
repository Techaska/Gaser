package com.P1.Gaser.Services;

import com.P1.Gaser.Entity.ServiceRecord;
import com.P1.Gaser.Exception.ResourceNotFoundException;
import com.P1.Gaser.Repositories.ServiceRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRecordService {

    private final ServiceRecordRepository serviceRecordRepository;

    public ServiceRecordService(ServiceRecordRepository serviceRecordRepository) {
        this.serviceRecordRepository = serviceRecordRepository;
    }

    public ServiceRecord addServiceRecord(ServiceRecord serviceRecord) {
        return serviceRecordRepository.save(serviceRecord);
    }

    public List<ServiceRecord> getAllServiceRecords() {
        return serviceRecordRepository.findAll();
    }

    public ServiceRecord getServiceRecordById(Long id) {
        return serviceRecordRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Service record not found with id: " + id));
    }

    public ServiceRecord updateServiceRecord(
            Long id,
            ServiceRecord serviceRecord) {

        ServiceRecord existingServiceRecord =
                serviceRecordRepository.findById(id).orElse(null);

        if (existingServiceRecord != null) {

            existingServiceRecord.setServiceJobId(
                    serviceRecord.getServiceJobId());

            existingServiceRecord.setServicePerformed(
                    serviceRecord.getServicePerformed());

            existingServiceRecord.setDescription(
                    serviceRecord.getDescription());

            existingServiceRecord.setCost(
                    serviceRecord.getCost());

            return serviceRecordRepository.save(existingServiceRecord);
        }

        return null;
    }

    public void deleteServiceRecord(Long id) {
        serviceRecordRepository.deleteById(id);
    }
}