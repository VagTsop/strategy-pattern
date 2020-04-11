/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.strategypattern;

/**
 *
 * @author vatso
 */
public class Cash {

    
   
    private int balance = 100;
    private int withdrawAmount;

    public Cash(int balance) {
        this.balance = 100;
        this.withdrawAmount = withdrawAmount;
    }

    public int getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(int withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    

    public  void setBalance(int balance) {
        this.balance = 100;
    }
    

    public int getBalance() {
        return balance;
    }
    
    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount > balance) {
            System.out.println("Insufficient cash!!!");
            return false;
        } else {
            balance -= withdrawAmount;
            return true;
        }
    
    }
    
    
    

   

}
