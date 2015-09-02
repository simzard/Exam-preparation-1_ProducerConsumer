/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerfib;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author simon
 */
public class ProducerConsumerFib {

    public final static int NUM_ELEMENTS = 11;
    
    private BlockingQueue<Long> S1 = new ArrayBlockingQueue<>(NUM_ELEMENTS);
    private BlockingQueue<Long> S2 = new ArrayBlockingQueue<>(NUM_ELEMENTS);

    ProducerThread P1;
    ProducerThread P2;
    ProducerThread P3;
    ProducerThread P4;
    
    ConsumerThread C1;
    
    public BlockingQueue<Long> getS1() {
        return S1;
    }

    public BlockingQueue<Long> getS2() {
        return S2;
    }

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws InterruptedException {

        Main main = new Main();
        long time = System.currentTimeMillis();
        main.produce(4);
        long time2 = System.currentTimeMillis();
        long timeElapsed = time2 - time;
        System.out.println("It took " + timeElapsed + " milliseconds!");
        
    }

}
