package br.compassweek4.carSystem.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChassi;
    @NotNull
    @NotBlank(message = "Model is required")
    private String model;
    @NotNull
    @NotBlank(message = "Brand is required")
    private String brand;
    @NotNull
    @NotBlank(message = "Color is required")
    private String color;
    @NotNull
    @NotBlank
    private String fabricationYear;




}
