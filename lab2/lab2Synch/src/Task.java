/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew Bashorm
 *
 * */
class Task implements Runnable {
private String name;
    private IntegerObj total;

    /**
     Constructor which sets a tasks name and inter object value
     @param
     @return
     @throws
     */
    public Task(String task_1, IntegerObj total) {
        name=task_1;
        this.total = total;
    }
    /**
     Run just loops 500 times sleeping every 100 loops
     @param
     @return
     @throws
     */
    public void run()
    {
        try
        {
            for (int i = 0; i<500; i++)
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
