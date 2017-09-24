package com.shlak;

import static java.lang.Thread.sleep;

public class Runners implements Runnable {

    private long deliveryTime;

    public Runners(long deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Runners() {

    }

    @Override
    public void run() {

        try {
            sleep(deliveryTime*5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Курьер доставляет пиццу, он будет доступен через "+ deliveryTime*5+ " минут");

    }

}
