package com.P1.Gaser.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @NotNull(message = "Customer is required")
    private Long customerId;

    @NotNull(message = "Vehicle is required")
    private Long vehicleId;

    @NotNull(message = "Service center is required")
    private Long serviceCenterId;

    private Long mechanicId;

    private LocalDateTime receivedDateTime;

    private LocalDateTime serviceStartDateTime;

    private LocalDateTime serviceCompletedDateTime;

    private String status;
}