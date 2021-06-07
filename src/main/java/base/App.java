package base;

import  java.text.DecimalFormat;
import  java.math.BigDecimal;
import  java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 10 Solution
 *  Copyright 2021 Bao Kastan
 */

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        final double taxRate = .055;
        final int amountOfDifferentItems = 3;

        BigDecimal subTotal = BigDecimal.ZERO;
        subTotal = myApp.getSubTotal(subTotal, amountOfDifferentItems);
        BigDecimal tax = subTotal.multiply(new BigDecimal(taxRate));
        BigDecimal total = subTotal.add(tax);

        myApp.printOutput(subTotal, tax, total);
    }

    public void printOutput(BigDecimal subTotal, BigDecimal tax, BigDecimal total) {
        DecimalFormat decFormat = new DecimalFormat("#.00");
        System.out.println("Subtotal: $" + decFormat.format(subTotal));
        System.out.println("Tax: $" + decFormat.format(tax));
        System.out.println("Total: $" + decFormat.format(total));
    }

    public BigDecimal getSubTotal(BigDecimal subTotal,int amountOfDifferentItems) {
        for (int i = 1; i <= amountOfDifferentItems; ++i) {
            BigDecimal itemsTotal = getPackCost(i);
            subTotal = subTotal.add(itemsTotal);
        }
        return subTotal;
    }

    public BigDecimal getPackCost(int i) {
        System.out.println("Enter the price of the item " + i + ": ");
        BigDecimal price = new BigDecimal(in.nextInt());
        System.out.println("Enter the quantity of the item " + i + ": ");
        int quantity = in.nextInt();
        return price.multiply(new BigDecimal(quantity));
    }
}