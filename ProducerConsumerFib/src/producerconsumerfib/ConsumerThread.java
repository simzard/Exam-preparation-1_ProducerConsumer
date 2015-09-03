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
public class ConsumerThread extends Thread {

    private Long sum = 0L;

    public Long getSum() {
        return sum;
    }

    private int max;

    int count = 0;
    
    private BlockingQueue<Long> shared2;
    
    
    private boolean running = true;

    public ConsumerThread(BlockingQueue s2, int m) {
        shared2 = s2;
        max = m;
    }

    public void run() {
        while (running) {
            
            Long number = null;
            try {
                number = shared2.take();
                count++;
                if (count == max) {
                    running = false;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (number != null) {
                sum += number;
                System.out.println("Got: " + number + " --- Sum is now: " + sum);
            }
        }
    }

}
