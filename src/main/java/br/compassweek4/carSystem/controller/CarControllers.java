package br.compassweek4.carSystem.controller;

import br.compassweek4.carSystem.domain.entities.Car;
import br.compassweek4.carSystem.domain.entities.dto.CarDTO;
import br.compassweek4.carSystem.service.CarService;
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
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        if (createdCar != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{idChassi}")
    public ResponseEntity<CarDTO> getCarBy(@PathVariable Long idChassi) {
        Car car = carService.getCarBy(idChassi);
        if (car != null) {
            CarDTO carDto = carService.convertToDTO(car);
            return ResponseEntity.ok(carDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}







