/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 19/1/2021
 * Assisted by https://stackoverflow.com/questions/44060558/simple-barrier-synchronisation-in-java
 */
public class Main {
    
      // Maximum number of threads in thread pool
      public static void main(String[] args) throws InterruptedException {
          Barrier BR = new Barrier(5);

          Task[] testTask = new Task[5];
          for (int i = 0; i < testTask.length; i++) {
              testTask[i] = new Task((long) (Math.random() * 1000), BR);
              testTask[i].start();
          }
          for (int i = 0; i < testTask.length; i++) {
              testTask[i].join();
          }

      }
}
