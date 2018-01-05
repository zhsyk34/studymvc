package com.cat.spi;

import com.cat.bean.User;

public class SimpleUserProvider implements UserProvider {
    @Override
    public User provide() {
        return new User().setId(1).setName("001");
    }
}
