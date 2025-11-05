package org.example.springdemo;

import org.springframework.transaction.support.TransactionSynchronization;

public class UncEventSynchronization implements TransactionSynchronization {



    @Override
    public void afterCommit() {
        try {
            System.out.println("afterCommit UncEventSynchronization");
            Thread.sleep(32000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println("afterCommit UncEventSynchronization");
//                        Thread.sleep(32000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }).start();


    }
}
