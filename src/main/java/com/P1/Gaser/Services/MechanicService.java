package com.P1.Gaser.Services;

import com.P1.Gaser.Entity.Mechanic;
import com.P1.Gaser.Exception.ResourceNotFoundException;
import com.P1.Gaser.Repositories.MechanicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicService {

    private final MechanicRepository mechanicRepository;

    public MechanicService(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    public Mechanic addMechanic(Mechanic mechanic) {
        return mechanicRepository.save(mechanic);
    }

    public List<Mechanic> getAllMechanics() {
        return mechanicRepository.findAll();
    }

    public Mechanic getMechanicById(Long id) {
        return mechanicRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Mechanic not found with id: " + id));
    }

    public Mechanic updateMechanic(Long id, Mechanic mechanic) {

        Mechanic existingMechanic =
                mechanicRepository.findById(id).orElse(null);

        if (existingMechanic != null) {

            existingMechanic.setMechanicName(mechanic.getMechanicName());
            existingMechanic.setSpecialization(mechanic.getSpecialization());
            existingMechanic.setExperienceYears(mechanic.getExperienceYears());

            return mechanicRepository.save(existingMechanic);
        }

        return null;
    }

    public void deleteMechanic(Long id) {
        mechanicRepository.deleteById(id);
    }
}