package com;

import com.threads.Ticket;

/**
 * @author stalwarthuang
 * @since 2025-04-05 星期六 11:41:05
 */
public class test {
    public static void main(String[] args) throws InterruptedException {
        Ticket t = new Ticket();

        Thread win1 = new Thread(t, "窗口1");
        Thread win2 = new Thread(t, "窗口2");
        Thread win3 = new Thread(t, "窗口3");

        win1.start();
        win2.start();
        win3.start();

    }
}
