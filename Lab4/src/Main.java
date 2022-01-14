/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Not functional
 * @author Andrew Bashorum
 * @license
 * @date 14/1/2021
 * Assisted by Allen B. Downey, The Little Book of Semaphores
 */
public class Main {
    

      private static final int NUM_ITERATION = 4;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newWorkStealingPool();
        Task danceFloor = new Task(4);


        Callable<Void> danceFloorTask = danceFloor::startDance;
        Callable<Void> newDanceTask = danceFloor::newDancePartner;

        List<Future<Void>> leaderFutures = new ArrayList();
        List<Future<Void>> followersFutures = new ArrayList();


        for (int i=0; i<NUM_ITERATION; i++) {
            Future<Void> barberFuture = executor.submit(danceFloorTask);
            leaderFutures.add(barberFuture);

            Future <Void> customerFuture = executor.submit(newDanceTask);
            followersFutures.add(customerFuture);
        }

        leaderFutures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        followersFutures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
