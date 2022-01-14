/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 26/10/2021
 */
public class Main
{
    public static void main(String args[])
    {
        // creating buffer queue
        Q q = new Q();

        // starting consumer thread
        new Consumer(q);

        // starting producer thread
        new Producer(q);
    }
}
