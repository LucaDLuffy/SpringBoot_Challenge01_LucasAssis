package br.compassweek4.carSystem.controller;

import br.compassweek4.carSystem.entities.Car;
import br.compassweek4.carSystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarControllers {


    private final CarService carService;

    @Autowired
    public CarControllers(CarService carService) {
        this.carService = carService;
    }

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
    public ResponseEntity<Car> getCarById(@PathVariable String idChassi) {
        Car car = carService.getCarById(idChassi);

        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
