/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerfib;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;



/**
 *
 * @author simon
 */
public class Main {
    
    public final static int NUM_ELEMENTS = 11;
    
    private BlockingQueue<Long> S1 = new ArrayBlockingQueue<>(NUM_ELEMENTS);
    private BlockingQueue<Long> S2 = new ArrayBlockingQueue<>(NUM_ELEMENTS);

    private ProducerThread P1;
    private ProducerThread P2;
    private ProducerThread P3;
    private ProducerThread P4;
    
    ConsumerThread C1;
    
    public Main() {
        

        // create the producer threads
        P1 = new ProducerThread(S1, S2);
        P2 = new ProducerThread(S1, S2);
        P3 = new ProducerThread(S1, S2);
        P4 = new ProducerThread(S1, S2);
        
        // create the consumer thread
        C1 = new ConsumerThread(S2, NUM_ELEMENTS);
        
    }
    
    public BlockingQueue<Long> getS1() {
        return S1;
    }

    public BlockingQueue<Long> getS2() {
        return S2;
    }

    
    public void produce(int numberOfThreads) {
        S1.add(4L);
        S1.add(5L);
        S1.add(8L);
        S1.add(12L);
        S1.add(21L);
        S1.add(22L);
        S1.add(34L);
        S1.add(35L);
        S1.add(36L);
        S1.add(37L);
        S1.add(42L);
        switch (numberOfThreads) {
            case 4:
                P4.start();
            case 3:
                P3.start();
            case 2: 
                P2.start();
            case 1:
                P1.start();
                break;
        }       
        C1.start();
        
        // now do nothing as long at least one of these threads is alive
        while (P1.isAlive() || P2.isAlive() || P3.isAlive() || P4.isAlive() || C1.isAlive())
            ;

        System.out.println("The total sum is: " + C1.getSum());
    }
}
