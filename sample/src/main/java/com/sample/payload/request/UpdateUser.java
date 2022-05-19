package com.sample.payload.request;

import lombok.Data;

@Data
public class UpdateUser {
    public String email;
    public String name;
    public int age;
}
