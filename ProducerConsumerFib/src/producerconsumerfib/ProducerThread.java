/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerfib;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class ProducerThread extends Thread {

    BlockingQueue<Long> shared1;
    BlockingQueue<Long> shared2;

    boolean running = true;

    public ProducerThread(BlockingQueue s1, BlockingQueue s2) {
        shared1 = s1;
        shared2 = s2;
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public void run() {
        while (running) {
            Long fibResult = null;
            Long number = shared1.poll();
            if (number != null) {
                // the list was not empty so calculate the fib
                fibResult = fib(number);

                try {
                    shared2.put(fibResult);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProducerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                running = false;
            }
        }
    }

}
