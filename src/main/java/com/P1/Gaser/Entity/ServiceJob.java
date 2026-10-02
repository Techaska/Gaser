package com.P1.Gaser.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceJobId;

    @NotBlank(message = "Service reference is required")
    private String serviceReference;

    @ManyToOne
    @NotNull(message = "Vehicle is required")
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @NotNull(message = "Service center is required")
    @JoinColumn(name = "service_center_id", nullable = false)
    private ServiceCenter serviceCenter;

    private LocalDateTime receivedDateTime;

    private LocalDateTime serviceStartDateTime;

    private LocalDateTime serviceCompletedDateTime;

    private String status;
}