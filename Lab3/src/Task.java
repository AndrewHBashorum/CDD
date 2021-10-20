/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 13/10/2021
 */

public class Task implements Runnable {
private String name;
    private IntegerObj total;
    public Task(String task_1, IntegerObj total) {
        name=task_1;
        this.total = total;


    }
    
    public void run()
    {
        barrier bar = new barrier();
        try
        {

            total.inc();
            pool.shutdown();
            try
            {
                mutex.acquire();
                count++;
                System.out.println("Being run by " + Thread.currentThread().getName());
                for (int i = 0; i < 5; i++)
                {

                    System.out.println("Running Thread  " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                }
                mutex.release();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }





            System.out.println(name+" complete");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
