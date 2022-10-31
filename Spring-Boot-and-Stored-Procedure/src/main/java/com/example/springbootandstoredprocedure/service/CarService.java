package com.example.springbootandstoredprocedure.service;

import com.example.springbootandstoredprocedure.entity.Car;
import com.example.springbootandstoredprocedure.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> findCarsAfterYear(int year){
        return carRepository.findCarsAfterYear(year);
    }
}
