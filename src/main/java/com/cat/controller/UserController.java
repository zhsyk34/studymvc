package com.cat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

    @RequestMapping("/create")
    @ResponseBody
    public Long create(String name, String password) {
        logger.debug("name:{},password:{}", name, password);
        return -1L;
    }
}
