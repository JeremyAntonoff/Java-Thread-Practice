package com.JeremyAntonoff;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final BankAccount account = new BankAccount("123", 1000.00, lock);

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (account) {
                    account.deposit(300.00);
                    account.withdraw(50.00);
                }
                account.lock.lock();
                try {
                    account.deposit(500.00);
                    account.withdraw(100.00);

                } finally {
                    account.lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (account) {
                    account.deposit(203.75);
                    account.withdraw(100.00);
                }

                account.lock.lock();

                try {
                    account.deposit(1000.00);
                    account.withdraw(200.00);

                } finally {
                    account.lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();


    }
}
