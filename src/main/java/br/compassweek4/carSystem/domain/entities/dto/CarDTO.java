package br.compassweek4.carSystem.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Long idChassi;

    private String model;
    private String brand;
    private String color;
    private String fabricationYear;
}
