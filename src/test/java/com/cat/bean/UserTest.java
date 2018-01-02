package com.cat.bean;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

public class UserTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testUser() {
        User user = new User();

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        Iterator<ConstraintViolation<User>> it = violations.iterator();
        if (it.hasNext()) {
            String errMessage = it.next().getMessage();
            System.out.println(errMessage);
        }
    }
}