/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.Semaphore;

/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 20/10/2021
 */
class Task implements Runnable {
    private String name;
    private IntegerObj total;

    /**
     Constructor sets a string an integer object value
     @param
     @return
     @throws
     */
    public Task(String task_1, IntegerObj total) {
        name = task_1;
        this.total = total;
    }
    static Semaphore semaphore = new Semaphore(1);
    /**
     Changed run methods to use a semaphore lock like a mutex lock
     @param
     @return
     @throws
     */
    public void run() {

        try {

            System.out.println(name + " : acquiring lock...");
            System.out.println(name + " : available Semaphore permits now: "
                    + semaphore.availablePermits());

            semaphore.acquire();
            System.out.println(name + " : got the permit!");

            try {

                for (int i = 0; i<500; i++)
                {
                    total.inc();
                    if (i%100==0){
                        Thread.sleep(100);
                    }

                }
                System.out.println(name+" complete");

            } finally {

                // calling release() after a successful acquire()
                System.out.println(name + " : releasing lock...");
                semaphore.release();
                System.out.println(name + " : available Semaphore permits now: "
                        + semaphore.availablePermits());

            }

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }
}