package com.cat.service;

import com.cat.bean.Car;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
@Service
public class CarService {

    @NotNull
    public Car getById(@Min(3) @Max(5) long id) {
        Car car = new Car("", "", 2);
        return id > 10 ? null : car;
    }

    @AssertTrue
    public boolean save(@Valid Car car) {
        System.out.println(car);
        return car.getSeatCount() == 4;
    }
}
