package com.example.springbootandstoredprocedure.entity;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQuery(name = "Car.findCarsAfterYear", procedureName = "FIND_CARS_AFTER_YEAR",
    parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "year_in", type = Integer.class)})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String model;
    @Column
    private int year;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
