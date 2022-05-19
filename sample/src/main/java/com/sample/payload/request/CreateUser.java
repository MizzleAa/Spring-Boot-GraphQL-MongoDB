package com.sample.payload.request;

import lombok.Data;

@Data
public class CreateUser {
    public String email;
    public String password;
    public String name;
    public int age;
}
