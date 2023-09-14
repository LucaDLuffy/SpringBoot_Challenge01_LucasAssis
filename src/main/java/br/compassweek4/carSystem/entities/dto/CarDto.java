package br.compassweek4.carSystem.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private Long idChassi;
    private String model;
    private String brand;
    private String color;
    private String fabricationYear;
}
