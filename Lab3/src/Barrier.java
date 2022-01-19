/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 25/10/2021
 */

import java.util.concurrent.Semaphore;
public class Barrier {
    private int capacity;
    private Semaphore s, exclusion, counter;

    public Barrier(int capacity) {
        this.capacity = capacity;
        counter = new Semaphore(0);
        s = new Semaphore(0);
        exclusion = new Semaphore(1);
    }

    public void waitNow() throws InterruptedException {
        exclusion.acquire();
        if (counter.availablePermits() < capacity - 1) {
            counter.release();
            exclusion.release();

            s.acquire();
        } else {
            exclusion.release();

            System.out.println("RELEASE ALL");
            for (int i = 0; i < capacity; i++) {
                s.release();
            }
        }
    }

}

