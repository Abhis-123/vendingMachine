package com.Abhishek;

import java.util.*;

public class transaction {
    private  Map<coins,Integer> coinsList= new HashMap<>();
   
    public transaction(){
        coins oneR=new coins("one",1.00);
        coins twoR=new coins("two",5.00);
        coins fiveR=new coins("two",5.00);
        coins tenR=new coins("one",10.00);
        coins hundred=new coins("one",100.00);
        this.coinsList.put(oneR,0);
        this.coinsList.put(twoR,0);
        this.coinsList.put(fiveR,0);
        this.coinsList.put(tenR,0);
        this.coinsList.put(hundred,0);
        
        
    }

    public Map<coins,Integer> payMoney(ArrayList<coins> c){
        Map<coins, Integer> paid = new HashMap<>(this.coinsList);
        Map<coins, Integer> paid2 = new HashMap<>();
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter number of coins according to order as mentioned");
        for (coins cl:c) {
           boolean b= true;
           int ccount = 0;
           while (b) {
               try {
                   System.out.print("Enter count of type  " + cl.getName() + " coins : ");
                    ccount= scan.nextInt();
                    scan.nextLine();
                    b=false;
                   
               }
               catch (InputMismatchException e) {
                   System.out.println("please enter value in integer");
                   scan.nextLine();
               }
           }
           paid2.put(cl,ccount);
        }
      
        return paid2;
    }

    public void perform_transaction(bucket b,vending v,Map<coins,Integer> paid){
        double amount=0;
        System.out.println("amount calculating.....");
        for (Map.Entry<coins,Integer> k:paid.entrySet()) {
            amount=amount+k.getValue()*k.getKey().getValue();
        }
        System.out.println("amount calculated.....:"+amount);
        System.out.println("starting transaction......");
        if (b.bill()==amount){
                v.addMoney(paid);
                b.emptyBucket();
            System.out.println("*********products are dispatched********");
        }else if (b.bill()>amount){
            System.out.println("*********bill is smaller then paid*********");
        }else if (b.bill()<amount){
              amount=amount-b.bill();
            v.tryChange(paid,amount) ;
            System.out.println(amount);
        }
        System.out.println("transaction completed......");

    }



}
