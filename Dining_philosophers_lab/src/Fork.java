import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 13/10/2021
 * Obtained from https://stackoverflow.com/questions/40721763/dining-philosophers-in-java-using-semaphores
 */

public class Fork {
    public Semaphore fork = new Semaphore(1);
    public int id;
    private static Random random = new Random();
    Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean take() { // Can we pick up this fork
        try{
        return fork.tryAcquire(1, random.nextInt(400) + 100, TimeUnit.MILLISECONDS);
            } catch(InterruptedException e) {

            return false;
        }
    }

    public void putDown() { // release fork when finished or can pick up 2 forks
        fork.release();
    }
}
