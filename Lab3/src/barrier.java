/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 25/10/2021
 */

import java.util.concurrent.Semaphore;


public class barrier
{
    int N;
    int count; /** used to tell a semaphore to wait on the first loop */
    Semaphore turnstiles1 = new Semaphore(1); /** First Semaphore */
    Semaphore turnstiles2 = new Semaphore(1); /** Second Semaphore */
    //Semaphore mutex = new Semaphore(1);

    /**
     Constructor which sets the value for N and count
     @param
     @return
     @throws
     */
    public void init() {
        this.N = 4;
        this.count = 0;
    }

    public void sephBar() throws InterruptedException {

        turnstiles1.acquire();
        count = count + 1;
        if (count == N){
            turnstiles2.wait();
        }
        turnstiles1.wait();

        turnstiles2.wait();

        turnstiles1.wait();
        count=count-1;
        turnstiles2.wait();
        if(count==0){
            turnstiles2.wait();
        }
        turnstiles1.wait();
    }
}


