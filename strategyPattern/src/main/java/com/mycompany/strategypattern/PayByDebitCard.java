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
public class PayByDebitCard implements PayStrategy {
     private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
     private DebitCard card;
    
        @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Enter the card number: ");
            String number = READER.readLine();
            System.out.print("Enter the card expiration date 'mm/yy': ");
            String date = READER.readLine();
            System.out.print("Enter the CVV code: ");
            String cvv = READER.readLine();
            card = new DebitCard(number, date, cvv);

            // Validate credit card number...

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
      
  
    }  

    @Override
    public boolean pay(int paymentAmmount) {
      if (cardIsPresent()) {
            System.out.println("Paying " + paymentAmmount + " using Credit Card.");
            card.setAmount(card.getAmount() - paymentAmmount);
            return true;
        } else {
            return false;
        }
    }
        
     private boolean cardIsPresent() {
        return card != null;
    }   
        

    
    
    
}
