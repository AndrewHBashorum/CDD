/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.Semaphore;

/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 20/10/2021
 */
class IntegerObj {
    //Semaphore sem = new Semaphore(1);
    int value;
    /**
     Changed run methods to use a semaphore lock like a mutex lock
     @param Input value
     @return Input value
     @throws InterruptedException
     */
    IntegerObj(int val) {
        this.value = val;
    }
     int inc() throws InterruptedException {
         //sem.acquire();
        this.value++;
         //
         return this.value;
    }
}
