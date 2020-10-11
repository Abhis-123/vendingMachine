package com.Abhishek;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner scan= new Scanner(System.in);



    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        vending machine1= new vending("abhishek");

        System.out.print("Enter name of your bucket :");
        bucket bucket= new bucket(scan.nextLine());
        boolean q=true;
        print_option();
        while (q){

                    int option=scanInt();
            switch (option){
                case 0:
                    print_option();
                    break;

                case 1:
                    machine1.showItemList();
                    break;
                case 2:
                    bucket.showItemList();
                    break;
                case 3:
                    addItemToBucket(bucket,machine1);
                    break;
                case 4:

                    removeItemFromBucket(bucket,machine1);
                    break;
                case 5:
                    printBill(bucket);
                    break;
                case 6:
                    payBill(bucket,machine1);
                    break;
                case 7:
                    machine1.allowedCoin();
                    break;
                case 8:
                    q=false;
                    break;
            }


        }

    }






    private static void payBill(bucket bucket, vending machine1) {
        transaction transaction= new transaction();
        Map<coins,Integer> paid= new HashMap<>(transaction.payMoney(machine1.getC()));
        transaction.perform_transaction(bucket,machine1,paid);



    }


    private static void printBill(bucket bucket) {
        System.out.print( String .format("|%-10s|%-6s|%-6s|%-7s ","name","price","quantity","sum"));
        for (Map.Entry<item, Integer> k: bucket.getItemList().entrySet()) {
            String s="\n------------------------------------------";
            s=s+k.getKey().itemdetail()+"|"+k.getValue()+"       |"+k.getKey().getPrice()*k.getValue();
            System.out.print(s);

        }
        System.out.println("\n------------------------------------------");
        System.out.println("Total sum                  "+bucket.bill());
        System.out.println("------------------------------------------");

    }

    private static void removeItemFromBucket(bucket bucket, vending machine1){
        System.out.println("--------------------------------");
        System.out.print("Enter item name:");
        String s= scan.next();
        if (bucket.containItem(s)){
            System.out.print("enter number of "+s+" to be removed ");
            int amount=scanInt();
            item i= bucket.findItem(s);
            bucket.removeItem(i,amount);
            machine1.addItem(i,amount);
        }else {
            System.out.println(" there is no such item in bucket");
        }
        System.out.println("--------------------------------");

    }



    private static void addItemToBucket(bucket bucket, vending machine1) {


        System.out.println("--------------------------------");
        System.out.print("Enter item name:");
        String s= scan.next();
        if (machine1.containItem(s)){
            System.out.print("enter amount of items..  ");
            int amount=scanInt();
             item i= machine1.getProduct(s,amount);
             if (i!=null) {
                 bucket.addItem(i, amount);
             }else {
                 System.out.println("there is a problem.......");

             }

        }else {
            System.out.println(" there is no such item in vending machine");
        }
        System.out.println("--------------------------------");
    }



    private static void print_option() {
        System.out.println("************************************************");
        System.out.println("0:print options");
        System.out.println("1:print items in vending machine");
        System.out.println("2:print items in bucket");
        System.out.println("3:add item in bucket from vending");
        System.out.println("4:remove item in bucket from");
        System.out.println("5:print bill");
        System.out.println("6:pay your bill");
        System.out.println("7:allowed coins");
        System.out.println("8:exit");
        System.out.println("------------------------------------------------");

    }


    public static int scanInt() {
        int option = 0;
        Scanner scan= new Scanner(System.in);
        boolean b = true;
        while (b) {
            try {
                System.out.print("Enter Your choice:");
                option = scan.nextInt();
                scan.nextLine();
                b=false;

            } catch (InputMismatchException e) {
                System.out.println("Error: Enter choice in integer");
                scan.nextLine();
            }

        }

        return option;

      }










}
