package br.compassweek4.carSystem.service;

import br.compassweek4.carSystem.entities.Car;
import br.compassweek4.carSystem.entities.dto.CarDto;
import br.compassweek4.carSystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

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

    public Car getCarById(String idChassi) {
        //lógica para buscar um carro pelo ID (chassi).
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

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public CarDto convertToDTO(Car car) {
        CarDto carDTO = new CarDto();
        carDTO.setIdChassi(car.getIdChassi());
        carDTO.setModel(car.getModel());
        carDTO.setBrand(car.getBrand());
        carDTO.setColor(car.getColor());
        carDTO.setFabricationYear(car.getFabricationYear());
        return carDTO;
    }
}
