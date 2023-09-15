package br.compassweek4.carSystem.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(String message){
        super(message);
    }
}
