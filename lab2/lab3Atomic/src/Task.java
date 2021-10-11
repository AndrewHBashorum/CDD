/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Andrew Bashorm
 *
 * */
class Task implements Runnable {
private String name;
    public static volatile AtomicInteger atomicResult;
    //private IntegerObj total;
    public Task(String task_1, AtomicInteger atomicResult) {
        name=task_1;
        this.atomicResult = atomicResult;
    }



    public void run()
    {
        try
        {
            for (int i = 0; i<500; i++)
            {
                atomicResult.incrementAndGet();
                //total.inc();

                if (i%100==0){
                   Thread.sleep(100); 
                }
                
            }
            System.out.println(name+" complete");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
