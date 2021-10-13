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
 * @Date 13/10/2021
 */
class IntegerObj {
    //Semaphore sem = new Semaphore(1);
    int value;

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
