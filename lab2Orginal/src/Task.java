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
