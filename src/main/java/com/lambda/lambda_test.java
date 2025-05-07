package com.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.entity.Vertex;

public class lambda_test {
    public static final String[] names = new String[] { "Tom", "Stalwart", "Jack", "Raider", "Alice", "Jessica" };

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        Integer[] nums1 = new Integer[] { 1, 2, 3, 4, 5 };

        Stream<Integer> stream = Arrays.stream(nums1);
        stream.filter(x -> x % 2 == 0).forEach(System.out::println); // filter过滤掉奇数留下偶数
        
        System.out.println("*****************************");

        Function<String, String> toUpper = s -> s.toUpperCase();
        Consumer<String> prt = System.out::println; // 方法引用
        Function<int[], int[]> changeArr = arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * 2;
            }
            return arr;
        };

        Supplier<Integer> spy = new Supplier<Integer>() {
            public Integer get() {
                return Integer.valueOf(nums[0]);
            };
        };

        Supplier<Integer> spy1 = () -> Integer.valueOf(nums[0]);

        System.out.println(toUpper.apply("aEddeDE"));
        changeArr.apply(nums);
        for (int num : nums) {
            System.out.println(num);
        }

        prt.accept("tttttt");
        System.out.println();

        System.out.println(spy.get());
        System.out.println(spy1.get());

    }
}
