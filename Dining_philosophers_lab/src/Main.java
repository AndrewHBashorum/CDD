/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 13/10/2021
 * Obtained from https://stackoverflow.com/questions/40721763/dining-philosophers-in-java-using-semaphores
 */

public class Main {
    public static void main(String[] args) {
        String[] names = {"John", "Paul", "Ringo", "George", "Bob"};
        Fork[] fork = new Fork[5];
        Philosopher[] philosopher = new Philosopher[5];

        for (int i = 0; i < fork.length; i++) {
            fork[i] = new Fork(i);
        }

        for (int i = 0; i < philosopher.length; i++) {

            if (i != philosopher.length - 1) {
                philosopher[i] = new Philosopher(fork[i], fork[i+1], names[i]);
                philosopher[i].start();
            } else {
                philosopher[i] = new Philosopher(fork[0], fork[i], names[i]);
                philosopher[i].start();
            }
        }
    }
}
