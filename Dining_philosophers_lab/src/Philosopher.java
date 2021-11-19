
/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 13/10/2021
 * Obtained from https://stackoverflow.com/questions/40721763/dining-philosophers-in-java-using-semaphores
 */

public class Philosopher extends Thread {

    private Fork fork_low;
    private Fork fork_high;
    private String name;

    Philosopher(Fork fork_low, Fork fork_high, String name) { // each person given 2 forks and a name
        this.fork_low = fork_low;
        this.fork_high = fork_high;
        this.name = name;
    }

    public void run() {

        try {
            sleep(1000);
        } catch (InterruptedException ex) {
        }

        while (true) {
            eat();
        }
    }

    private void eat() {
        if (fork_low.take()) { // If fork one can be accuired
            if (fork_high.take()) {
                try {

                    sleep(20000); // eating;
                    System.out.print(this.name + " has ate ");

                } catch (InterruptedException ex) {
                }

                fork_high.putDown(); // release threads to be used by another guy
                fork_low.putDown();

            } else {
                fork_low.putDown(); // One fork or thread was already being used to put the first one you picked up down
            }
        }
    }
}
