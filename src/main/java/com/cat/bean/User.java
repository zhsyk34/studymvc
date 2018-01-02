package com.cat.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    private long id;

    @NotNull
    private String name;
}
