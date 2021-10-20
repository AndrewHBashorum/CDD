import java.util.concurrent.Semaphore;

public class barrier
{
    int N;
    int count;
    Semaphore turnstiles1 = new Semaphore(1);
    Semaphore turnstiles2 = new Semaphore(1);
    //Semaphore mutex = new Semaphore(1);


    public void init() {
        this.N = 4;
        this.count = 0;
    }

    public void sephBar() throws InterruptedException {

        turnstiles1.acquire();
        count = count + 1;
        if (count == N){
            turnstiles2.wait();
        }
        turnstiles1.wait();

        turnstiles2.wait();

        turnstiles1.wait();
        count=count-1;
        turnstiles2.wait();
        if(count==0){
            turnstiles2.wait();
        }
        turnstiles1.wait();
    }
}


