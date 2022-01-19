/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 19/1/2021
 * Assisted by https://stackoverflow.com/questions/44060558/simple-barrier-synchronisation-in-java
 */
class Task extends Thread {
    private Barrier b;
    private long waitPeriod;

    public Task(long wait, Barrier b) {
        this.b = b;
        this.waitPeriod = wait;
        System.out.println("Thread \n" +
                "instantiated " + this.getName());

    }

    public void waitNowTask() throws InterruptedException {
        b.waitNow();
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread a sleeping " + this.getName());
            sleep(waitPeriod);
            System.out.println("Thread a waking " + this.getName());
            waitNowTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}