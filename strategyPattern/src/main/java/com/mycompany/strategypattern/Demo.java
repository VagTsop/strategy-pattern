/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.strategypattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vatso
 */
public class Demo {

    private static Map<Integer, Integer> priceOnFabric = new HashMap<>();
    private static Map<Integer, Integer> priceOnSize = new HashMap<>();
    private static Map<Integer, Integer> priceOnColor = new HashMap<>();

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnFabric.put(1, 20);
        priceOnFabric.put(2, 21);
        priceOnFabric.put(3, 22);
        priceOnFabric.put(4, 23);
        priceOnFabric.put(5, 25);
        priceOnFabric.put(6, 26);
        priceOnFabric.put(7, 27);
    }

    static {
        priceOnSize.put(1, 21);
        priceOnSize.put(2, 23);
        priceOnSize.put(3, 25);
        priceOnSize.put(4, 26);
        priceOnSize.put(5, 28);
        priceOnSize.put(6, 27);
        priceOnSize.put(7, 29);
    }

    static {
        priceOnColor.put(1, 21);
        priceOnColor.put(2, 22);
        priceOnColor.put(3, 24);
        priceOnColor.put(4, 26);
        priceOnColor.put(5, 24);
        priceOnColor.put(6, 27);
        priceOnColor.put(7, 24);
    }

    public static void main(String[] args) throws IOException {

        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do {

                System.out.print("Please, select a T-shirt Fabric :" + "\n"
                        + " 1 - WOOL " + "\n"
                        + " 2 - COTTON " + "\n"
                        + " 3 - POLYESTER " + "\n"
                        + " 4 - RAYON " + "\n"
                        + " 5 - LINEN " + "\n"
                        + " 6 - CASHMERE " + "\n"
                        + " 7 - SILK " + "\n");
                int fabricChoice = Integer.parseInt(reader.readLine());
                cost = priceOnFabric.get(fabricChoice);
                System.out.print("Count: ");
                int countFabric = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * countFabric);

                System.out.print("Do you wish to continue selecting Tshirt variations? Y/N: ");
                continueChoice = reader.readLine();

                System.out.print("Please, select a T-shirt Size :" + "\n"
                        + " 1 - XS " + "\n"
                        + " 2 - S" + "\n"
                        + " 3 - M" + "\n"
                        + " 4 - L" + "\n"
                        + " 5 - XL " + "\n"
                        + " 6 - XXL" + "\n"
                        + " 7 - XXXL" + "\n");
                int sizeChoice = Integer.parseInt(reader.readLine());
                cost = priceOnSize.get(sizeChoice);
                System.out.print("Count: ");
                int countSize = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * countSize);
                
                
                
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();

                System.out.print("Please, select a T-shirt Color :" + "\n"
                        + " 1 - RED " + "\n"
                        + " 2 -ORANGE " + "\n"
                        + " 3 -YELLOW " + "\n"
                        + " 4 -GREEN " + "\n"
                        + " 5 -BLUE " + "\n"
                        + " 6 -INDIGO " + "\n"
                        + " 7 -VIOLET " + "\n");
                
                int colorChoice = Integer.parseInt(reader.readLine());
                cost = priceOnColor.get(colorChoice);
                System.out.print("Count: ");
                int countColor = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * countColor);
                
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
                

            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {

                System.out.println("Please, select a payment method: " + "\n"
                        + "1 - Banktransfer " + "\n"
                        + "2 - Debit Card " + "\n"
                        + "3 - Cash ");
                String paymentMethod = reader.readLine();

                // different strategies created based on input from user
              
                if (paymentMethod.equals("1")) {
                    strategy = new PayByBankTransfer();
                } else if (paymentMethod.equals("2")) {
                    strategy = new PayByDebitCard();
                } else if (paymentMethod.equals("3")) {
                    strategy = new PayByCash();
                }
                
                order.processOrder(strategy);

                System.out.print("Pay " + order.getTotalCost() + " Euro or Continue shopping? P/C: ");
                String proceed = reader.readLine();
                if (proceed.equalsIgnoreCase("P")) {
                     // strategy handles the payment.
                    if (strategy.pay(order.getTotalCost())) {
                        System.out.println("Payment has been successful.");
                    } else {
                        System.out.println("FAIL! Please, check your data.");
                    }
                    order.setClosed();
                }
            }
        }
    }
}
