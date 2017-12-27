package com.cat.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml", "classpath:spring/spring-cache.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUser() {
        for (int i = 1; i < 5; i++) {
            userService.getUser(i);
            userService.getUser(i);
        }
    }
}