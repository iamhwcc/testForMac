package com.threads;

public class Ticket implements Runnable {
    int tickets = 100;

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            synchronized (this) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "售票, 票号为: " + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}
