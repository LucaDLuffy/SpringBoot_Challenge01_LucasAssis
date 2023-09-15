package br.compassweek4.carSystem.service;

import br.compassweek4.carSystem.domain.entities.Car;
import br.compassweek4.carSystem.domain.entities.dto.CarDTO;
import br.compassweek4.carSystem.exception.InvalidDataException;
import br.compassweek4.carSystem.repository.CarRepository;
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
    //retirar o construtor e as coisas relacionadas
    private List<Car> cars = new ArrayList<>();

    public CarService() {
        // adicionando alguns carros à lista no construtor.
        //data.sql inicializ de dados
        cars.add(new Car(1L, "Camry", "Ford", "Blue","15/14"));
        cars.add(new Car(2L, "Civic","Ford", "Blue","15/14"));
        cars.add(new Car(3L, "Focus","Ford", "Blue","15/14"));
    }

    public Car getCarById(Long idChassi) {
        for (Car car : cars) {
            if (idChassi.equals(car.getIdChassi())) {
                return car;
            }
        }
        return null;
    }



    public Car getCarBy (Long idChassi){
        var byId = carRepository.findById(idChassi);
        return byId.get();

    }

    public Car createCar(Car car) {
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
            throw new InvalidDataException("The car brand is not valid.");
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

    public Car convertToEntity(CarDTO carDTO) {
        if (carDTO == null) {
            throw new IllegalArgumentException("CarDto not Null.");
        }
        Car carD = new Car();
        carD.setIdChassi(carDTO.getIdChassi());
        carD.setModel(carDTO.getModel());
        carD.setBrand(carDTO.getBrand());
        carD.setColor(carDTO.getColor());
        carD.setFabricationYear(carDTO.getFabricationYear());
        return carD;
    }


}
