package com;

import java.util.*;

/**
 * @author stalwarthuang
 * @since 2024-06-25 星期二 22:28:57
 */
public class std_IO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = new String[4];
        for(int i = 0; i < 4; i++) {
            arr[i] = in.next();
        }
        for(String i:arr) {
            System.out.println(i);
        }
        in.close();

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            while (n-- > 0) {
//                int a = scanner.nextInt();
//                int b = scanner.nextInt();
//                System.out.println(a + b);
//            }
//        }

//
//        while (scanner.hasNext()) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            if (a == 0 && b == 0) {
//                break;
//            }
//            System.out.println(a + b);
//        }

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            if (n == 0) {
//                break;
//            }
//            int sum = 0;
//            for (int i = 0; i < n; i++) {
//                sum += scanner.nextInt();
//            }
//            System.out.println(sum);
//        }
    }
}
