package com.cat.service;

import com.cat.bean.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.cache.annotation.CacheResult;

@Service
public class UserService {

    @CacheResult(cacheName = "first")
//    @Cacheable("first")
    public User getUser(long id) {
        System.err.println("--------get" + id + "----------");
        return new User().setId(id).setName("n:" + id);
    }
}
