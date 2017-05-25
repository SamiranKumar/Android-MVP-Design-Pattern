package com.appsghor.skh.mvpdesignpattern.Common;

/**
 * Created by SKH PC on 5/24/2017.
 */

public abstract class Util {

    /**
     * A simulateNetworkLatency method is a network latency.
     * What is does it to delay the running thread by the specified number of milli seconds.
     *
     * @param millis
     */
    public static void simulateNetworkLatency(int millis) {
        //pause current thread
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
