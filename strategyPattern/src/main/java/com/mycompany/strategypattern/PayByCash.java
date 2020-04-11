/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.strategypattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.print.DocFlavor.READER;

/**
 *
 * @author vatso
 */
public class PayByCash implements PayStrategy {

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private Cash cash;

    @Override
    public boolean pay(int paymentAmmount) {

        if (cashIsPresent()) {
            System.out.println("Paying " + paymentAmmount + " with cash.");
            cash.setBalance(cash.getBalance() - paymentAmmount);
            return true;
        } else {
            return false;
        }

    }

    private boolean cashIsPresent() {
        return cash != null;

    }

    @Override
    public void collectPaymentDetails() {

        try {
            System.out.print("Pay with Cash ");
            String number = READER.readLine();

            //validate accountnumber number
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
