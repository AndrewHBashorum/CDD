/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew Bashorum
 * @license GPL
 * @Date 13/10/2021
 */
class IntegerObj extends Thread {

    int value;
    IntegerObj(int val) {
        this.value = val;
    }
    int inc(){
        this.value++;
        return this.value;
    }
}
