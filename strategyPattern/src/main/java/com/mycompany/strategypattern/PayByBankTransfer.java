/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.strategypattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author vatso
 */
public class PayByBankTransfer implements PayStrategy {

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private BankAccount bankAccount;

   

    
    
    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Enter the accountnumber: ");
            String number = READER.readLine();

            //validate accountnumber number
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public boolean pay(int paymentAmmount) {

        if (accountNumberIsPresent()) {
            System.out.println("Paying " + paymentAmmount + " using  Bank transfer.");
            bankAccount.setBalance(bankAccount.getBalance() - paymentAmmount);
            return true;
        } else {
            return false;
        }

    }

    private boolean accountNumberIsPresent() {
        return bankAccount != null;

    }

}
