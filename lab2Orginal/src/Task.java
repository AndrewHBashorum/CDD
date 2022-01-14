/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 20/10/2021
 */
public class Task implements Runnable {
private String name;
    private IntegerObj total;
    /**
     The constucter of the task class
     @param takes a string for a name and an integer object
     @return Nothing
     */
    public Task(String task_1, IntegerObj total) {
        name=task_1;
        this.total = total;
    }
    /**
     Function to do a simple task
     */
    public void run()
    {
        try
        {
            for (int i = 0; i<=500; i++)
            {
                total.inc();
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
