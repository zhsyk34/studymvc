package com.cat.spi;

import com.cat.bean.User;

public class CustomUserProvider implements UserProvider {
    @Override
    public User provide() {
        return new User().setId(-1).setName("undefined");
    }
}
