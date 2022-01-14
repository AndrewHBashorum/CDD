import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Not functional
 * @author Andrew Bashorum
 * @license
 * @date 14/1/2021
 * Assisted by Allen B. Downey, The Little Book of Semaphores
 */
public class Task {
    private final int limit;
    public int customers;
    private final Leader leader;

    private final Semaphore customerReady;
    private final Semaphore barberReady;

    private final Semaphore customerDone;
    private final Semaphore barberDone;

    private final ReentrantLock mutex;

    public Task(int limit) {
        this.limit = limit;
        customers = 0;

        customerReady = new Semaphore(0);
        barberReady = new Semaphore(0);

        customerDone = new Semaphore(0);
        barberDone = new Semaphore(0);

        mutex = new ReentrantLock();

        leader = new Leader();
    }

    public Void startDance() {

        // wait for a customer to arrive
        try {
            customerReady.acquire();
        } catch (InterruptedException e) {
            System.out.println("Barber wait task is interrupted: " + e.getMessage());
        }

        // signal that barber is ready
        barberReady.release();

        // give a haircut
        Leader.dance();


        // wait for a customer to approve done
        try {
            customerDone.acquire();
        } catch (InterruptedException e) {
            System.out.println("Barber wait task is interrupted: " + e.getMessage());
        }
        // signal the customer that barber is done
        barberDone.release();
        System.out.println("Haircut is done");
        return null;
    }

    public Void newDancePartner() {

        Follower follower = new Follower();

        follower.enter();

        mutex.lock();
        if (customers == limit) {
            mutex.unlock();
            follower.leave();
            return null;
        }
        customers += 1;
        mutex.unlock();

        customerReady.release();

        // wait for the barber to be available
        try {
            barberReady.acquire();
        } catch (InterruptedException e) {
            System.out.println("Customer wait task is interrupted: " + e.getMessage());
        }

        // get the haircut
        follower.getHairCut();

        // signal that customer is done
        customerDone.release();

        // wait for barber to approve done
        try {
            barberDone.acquire();
        } catch (InterruptedException e) {
            System.out.println("Customer wait task is interrupted: " + e.getMessage());
        }

        mutex.lock();
        customers -= 1;
        mutex.unlock();

        return null;
    }
}
