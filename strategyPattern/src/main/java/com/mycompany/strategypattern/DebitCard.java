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
public class DebitCard {
    private int amount;
    final private String number;
    final private String date;
    final private String cvv;

    DebitCard(String number, String date, String cvv) {
        this.amount = 100;
        this.number = "454632";
        this.date = date;
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getCvv() {
        return cvv;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return  amount;
    }
}  

