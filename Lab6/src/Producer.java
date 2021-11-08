
/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 13/10/2021
 */
class Producer implements Runnable
{
    Q q;
    Producer(Q q)
    {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run()
    {
        for (int i = 0; i < 5; i++)
            // producer put items
            q.put(i);
    }
}
