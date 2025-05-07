package com.entity;

import com.Fly;

import lombok.Data;

import java.util.Map;

@Data
public class User implements Eat, Fly {
    private String name;
    private int age;
    Map<Integer, Integer> mp;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof User) {
            User user = (User) obj;
            if (this.age == user.age && this.name.equals(user.name)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}
