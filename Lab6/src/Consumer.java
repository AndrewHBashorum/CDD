
/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 26/10/2021
 */
public class Consumer implements Runnable {

    Q q;
    Consumer(Q q)
    {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
    /**
     Run loops 5 times getting consumer to get items
     */
    public void run()
    {
        for (int i = 0; i < 5; i++)
            // consumer get items
            q.get();
    }

}
