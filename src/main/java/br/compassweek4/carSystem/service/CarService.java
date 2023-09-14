package br.compassweek4.carSystem.service;

import br.compassweek4.carSystem.entities.Car;
import br.compassweek4.carSystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    public CarService() {
        // adicionando alguns carros à lista no construtor.
        cars.add(new Car(1L, "123", "Camry", "Ford", "Blue","15/14"));
        cars.add(new Car(2L, "1233", "Civic","Ford", "Blue","15/14"));
        cars.add(new Car(3L, "12233", "Focus","Ford", "Blue","15/14"));
    }

    public Car getCarById(String idChassi) {
        //lógica para buscar um carro pelo ID (chassi) no banco de dados.
        //Procurando na lista.
        for (Car car : cars) {
            if (idChassi.equals(car.getIdChassi())) {
                return car;
            }
        }
        return null;
    }

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }
}
