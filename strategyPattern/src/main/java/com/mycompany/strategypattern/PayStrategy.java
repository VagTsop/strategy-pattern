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
public interface PayStrategy {
    
    boolean pay (int paymentAmmount);
    void collectPaymentDetails();
}
