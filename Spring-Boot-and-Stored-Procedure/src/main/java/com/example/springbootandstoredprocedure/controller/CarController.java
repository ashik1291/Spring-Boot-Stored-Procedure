package com.example.springbootandstoredprocedure.controller;

import com.example.springbootandstoredprocedure.entity.Car;
import com.example.springbootandstoredprocedure.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(path = "/carsafteryear/{year}")
    public List<Car> findCarsAfterYear(@PathVariable int year){
        return carService.findCarsAfterYear(year);
    }

}
