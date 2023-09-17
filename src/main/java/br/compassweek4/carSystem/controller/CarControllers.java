package br.compassweek4.carSystem.controller;

import br.compassweek4.carSystem.domain.entities.Car;
import br.compassweek4.carSystem.domain.entities.dto.CarDTO;
import br.compassweek4.carSystem.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/cars")
@RequiredArgsConstructor
public class CarControllers {


    private final CarService carService;

    @PostMapping
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

    @GetMapping("/{idChassi}")
    public ResponseEntity<CarDTO> getCarBy(@PathVariable Long idChassi) {
        Car car = carService.getCarBy(idChassi);
        CarDTO carDto = carService.convertToDTO(car);
        return ResponseEntity.ok(carDto);
    }

}









