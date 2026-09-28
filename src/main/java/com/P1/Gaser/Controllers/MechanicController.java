package com.P1.Gaser.Controllers;

import com.P1.Gaser.Entity.Mechanic;
import com.P1.Gaser.Services.MechanicService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mechanics")
public class MechanicController {

    private final MechanicService mechanicService;

    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @PostMapping
    public Mechanic addMechanic(@Valid @RequestBody Mechanic mechanic) {
        return mechanicService.addMechanic(mechanic);
    }

    @GetMapping
    public List<Mechanic> getAllMechanics() {
        return mechanicService.getAllMechanics();
    }

    @GetMapping("/{id}")
    public Mechanic getMechanicById(@PathVariable Long id) {
        return mechanicService.getMechanicById(id);
    }

    @PutMapping("/{id}")
    public Mechanic updateMechanic(
            @PathVariable Long id,
            @Valid @RequestBody Mechanic mechanic) {

        return mechanicService.updateMechanic(id, mechanic);
    }

    @DeleteMapping("/{id}")
    public void deleteMechanic(@PathVariable Long id) {
        mechanicService.deleteMechanic(id);
    }
}