package com.cat.service;

import com.cat.bean.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-service.xml")
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    public void getById() {
        System.out.println(carService.getById(6));
    }

    @Test
    public void save() {
        Car car = new Car("a", "bb", 4);
        System.out.println(carService.save(car));
    }
}