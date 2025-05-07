package com;

import java.util.Arrays;

import com.entity.User;

public class testEql {
    public static void main(String[] args) {
        User user1 = new User("stalwarthuang", 22);
        User user2 = new User("raiderhuang", 19);
        User user3 = new User("stalwarthuang", 22);

        System.out.println("User1: " + user1.getClass());
        System.out.println(System.identityHashCode(user1));
        System.out.println("User2: " + user2.getClass());
        System.out.println(System.identityHashCode(user2));
        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(user3));
        System.out.println(user1 == user3);
        String a = "10"; // 字符串常量池
        String b = new String("10"); // new了一个新的对象
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(a == b);
        System.out.println(a.equals(b));

        boolean flag = user1.equals(user3);
        System.out.println(flag);
        System.out.println();
        int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
        int[] arr2 = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(arr1 == arr2);
        System.out.println(arr1.equals(arr2));
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Math.PI);
        

    }
}
