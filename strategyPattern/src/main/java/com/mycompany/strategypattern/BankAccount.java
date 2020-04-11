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
public class BankAccount {

       private double balance;
 final private String accountNumber ;

    public BankAccount(String accountNumber) {
    this.balance = 100;
    this.accountNumber = "12214587";
    
    }

    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount > balance) {
            System.out.println("Insufficient Funds!!!");
            return false;
        } else {
            balance -= withdrawAmount;
            return true;
        }

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

   
    
}
