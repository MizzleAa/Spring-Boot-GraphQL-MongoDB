package com.sample.domain.entity;

import javax.persistence.Column;
//import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Entity(name = "user")
@Document(collection="user")
public class User {
    @Id
    private String id;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;
 
    @Column(name = "name")
    @NotNull
    private String name;
    
    @Column(name = "age")
    private int age;

    @Builder
    public User(String email, String password, String name, int age){
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public void update(String name, int age){
        this.name = name;
        this.age = age;
    }
}
