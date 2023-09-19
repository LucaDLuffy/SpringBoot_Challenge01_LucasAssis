package br.compassweek4.carSystem.service;

import br.compassweek4.carSystem.domain.entities.Car;
import br.compassweek4.carSystem.domain.entities.dto.CarDTO;
import br.compassweek4.carSystem.exception.CarNotFoundException;
import br.compassweek4.carSystem.repository.CarRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    private CarRepository carRepository;

    public Car getCarBy (Long idChassi){
        var byId = carRepository.findById(idChassi);
        return byId.get();
    }

    public Car createCar(@NotNull Car car) {
        String[] allowedBrands = {"Ford", "Chevrolet", "BMW", "Volvo"};
        String brand = car.getBrand();
        boolean validBrand = false;
        for (String allowedBrand : allowedBrands) {
            if (allowedBrand.equals(brand)) {
                validBrand = true;
                break;
            }
        }
        if (!validBrand) {
            throw new CarNotFoundException("The car brand is not valid.");
        }
        return carRepository.save(car);
    }


    public CarDTO convertToDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setIdChassi(car.getIdChassi());
        carDTO.setModel(car.getModel());
        carDTO.setBrand(car.getBrand());
        carDTO.setColor(car.getColor());
        carDTO.setFabricationYear(car.getFabricationYear());
        return carDTO;
    }


}
