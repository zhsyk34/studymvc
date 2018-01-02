package com.cat.bean;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class CarTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testCar() {
        Car car = new Car("", "a", 1);

        Set<ConstraintViolation<Car>> violations = validator.validate(car);

        violations.forEach(violation -> {
            System.err.println();
            System.err.println("对象属性:" + violation.getPropertyPath());
            System.err.println("国际化key:" + violation.getMessageTemplate());
            System.err.println("错误信息:" + violation.getMessage());
            System.err.println();
        });
    }

}