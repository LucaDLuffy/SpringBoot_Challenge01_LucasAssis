package br.compassweek4.carSystem.domain.entities.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Long idChassi;
    @NotNull
    private String model;
    @NotNull
    private String brand;
    @NotNull
    private String color;
    @NotNull
    private String fabricationYear;
}
