package com.Abhishek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class vending {
    private  Map<item, Integer> itemList= new HashMap<>();
    private  Map<coins,Integer> coinsList= new HashMap<>();
    private ArrayList<coins> c= new ArrayList<>();



    public  vending(String na) {
        coins oneR=new coins("one",1.00);
        coins twoR=new coins("two",5.00);
        coins fiveR=new coins("five",5.00);
        coins tenR=new coins("ten",10.00);
        coins hundred=new coins("hundred",100.00);
        item coke =new item("coke",12);
        item pepsi =new item("pepsi",12);
        item dew =new item("dew",18);
        item s100pipers =new item("100pipers",40);
        item teacher =new item("teacher",50);


        this.itemList.put(coke,50);
         this.itemList.put(pepsi,50);
         this.itemList.put(dew,50);
         this.itemList.put(s100pipers,50);
         this.itemList.put(teacher,50);
         this.coinsList.put(oneR,10);
         this.coinsList.put(twoR,10);
         this.coinsList.put(tenR,10);
         this.coinsList.put(hundred,4);
         this.coinsList.put(fiveR,15);
         this.c.add(oneR); this.c.add(twoR);  this.c.add(fiveR);this.c.add(tenR); this.c.add(hundred);

    }


    public Map<coins, Integer> getCoinsList()
    {
        return coinsList;
    }

    public ArrayList<coins> getC() {
        return c;
    }

    public void  showItemList(){
        System.out.print( String .format("|%-10s|%-6s|%-6s","name","price","quantity Available"));
      for (Map.Entry<item, Integer> k: itemList.entrySet()) {
            String s="\n------------------------------------------";
            s=s+k.getKey().itemdetail()+"|"+k.getValue();
            System.out.print(s);

        }
        System.out.println("\n------------------------------------------\n");
    
    }


    public  void  allowedCoin(){
        System.out.print("*************Allowed coins are:- \n");
        System.out.println("Name  | value \n ---------------");
        for (coins c:c ) {
            System.out.printf("%-8s|%-5",c.getName(), c.getValue());
        }
    }


    public  boolean containItem(String s) {
        boolean b = false;
        for (Map.Entry<item, Integer> i : itemList.entrySet()) {
            if (i.getKey().getName().toLowerCase().equals(s.toLowerCase())) {
                b = true;
            }

        }
        return b;
    }


    public item getProduct(String s ,int amount){
        item query=null;

        String query1=" ";
        for (Map.Entry<item,Integer> k: itemList.entrySet()){
            if (s.toLowerCase().equals(k.getKey().getName().toLowerCase())){
                     String itemdetail="\n------------------------------------------";
                    itemdetail=itemdetail+k.getKey().itemdetail()+"|"+k.getValue();
                    if (amount<=k.getValue()){
                        query1 = String.format("product name:%-10s product price:%-5s product amount:%-5s \n",k.getKey().getName(),k.getKey().getPrice(),amount);
                        int updated_amount =k.getValue()-amount;
                        itemList.replace(k.getKey(),k.getValue(),updated_amount);
                        query=k.getKey();

                    }else {
                        query1 = "amount of product demanded is larger than available\n"+itemdetail+"amount avilabele: "+k.getValue();
                    }
            }
        }
        System.out.println(query1);
        return  query;
    }



    public void addItem(item i,int j) {
        itemList.replace(i,itemList.get(i),itemList.get(i)+j);
        System.out.println("added to vending machine back.........");
    }

    public void addMoney(Map<coins, Integer> paid) {

        System.out.println(paid);
        for (Map.Entry<coins,Integer> k:paid.entrySet()         ) {
            coinsList.replace(k.getKey(),coinsList.get(k.getKey()),coinsList.get(k.getKey())+paid.get(k.getKey()));
        }
        System.out.println("***************All coins got added****************8888");
    }


    public void tryChange(Map<coins, Integer> paid, double amount) {
        boolean sucess=false;
            coins oneR=new coins("one",1.00);
            coins twoR=new coins("two",5.00);
            coins fiveR=new coins("five",5.00);
            coins tenR=new coins("ten",10.00);
            coins hundred=new coins("hundred",100.00);



            Map<coins,Integer> co= new HashMap<coins,Integer>(this.coinsList);
                 for (Map.Entry<coins,Integer> k:paid.entrySet() ) {

                   //  System.out.println(k.getKey().getName()+"  "+paid.get(k.getKey()));
                     co.replace(k.getKey(),co.get(k.getKey()),co.get(k.getKey()) + paid.get(k.getKey()));
                  //   System.out.println(co.get(k.getKey())+"  "+co.get(k.getKey()) );
                 }


               int  amount1= (int)amount;
                 int i= amount1/100;
                 if (i<=co.get(hundred)){
                      amount1=amount1-i*100;
                    int j=amount1/10;
                    if (j<=co.get(tenR)){
                        amount1=amount1-10*j;
                        int k=amount1/5;
                        if (k<=co.get(fiveR)){
                            amount1=amount1-5*k;
                            int l=amount1/2;
                            if (j<=co.get(twoR)){
                                amount1=amount1-2*l;
                                int m=amount1/1;
                                if (m<=co.get(oneR)){

                                    co.replace(oneR,co.get(oneR),co.get(oneR)-m)  ;
                                    co.replace(twoR,co.get(twoR),co.get(twoR)-l)  ;
                                    co.replace(fiveR,co.get(fiveR),co.get(fiveR)-k)  ;
                                    co.replace(tenR,co.get(tenR),co.get(tenR)-j)  ;
                                    co.replace(hundred,co.get(hundred),co.get(hundred)-i)  ;

                                    System.out.println("collect your change....\n*************************");
                                    System.out.println(i+" hundred rupee coin");
                                    System.out.println(j+" ten rupee coin");
                                    System.out.println(k+" five rupee coin");
                                    System.out.println(l+" two rupee coin");
                                    System.out.println(m+" one rupee coin");
                                    System.out.println("***************************************************");
                                    sucess=true;

                                }else {
                                    System.out.println("not sufficient 1 rupee coins...");
                                    System.out.println("not sufficient change");
                                }


                            }else {
                                System.out.println("not sufficient 2 rupee coins...");
                                if (amount>co.get(oneR)){
                                    System.out.println("not sufficient change");
                                }else {
                                    co.replace(oneR, (int) (co.get(oneR)-amount));
                                    sucess=true;
                                }

                            }

                        }else {
                            System.out.println("not sufficient 5 rupee coins...");
                            amount1= (int) amount;
                            int l=amount1/2;
                            if (j<=co.get(twoR)){
                                amount1=amount1-2*l;
                                int m=amount1/1;
                                if (m<=co.get(oneR)){

                                    co.replace(oneR,co.get(oneR),co.get(oneR)-m)  ;
                                    co.replace(twoR,co.get(twoR),co.get(twoR)-l)  ;
                                    System.out.println("collect your change....\n*************************");
                                    System.out.println(l+" two rupee coin");
                                    System.out.println(m+" one rupee coin");
                                    System.out.println("***************************************************");


                                    sucess=true;

                                }else {
                                    System.out.println("not sufficient 1 rupee coins...");
                                    System.out.println("not sufficient change");
                                }


                            }else {
                                System.out.println("not sufficient 2 rupee coins...");
                                if (amount>co.get(oneR)){
                                    System.out.println("not sufficient change");
                                }else {
                                    co.replace(oneR, (int) (co.get(oneR)-amount));
                                    sucess=true;
                                }

                            }

                        }



                    }else {
                        System.out.println("not sufficient 10 rupee coins...");
                        amount1= (int) amount;

                        int k=amount1/5;
                        if (k<=co.get(fiveR)){
                            amount1=amount1-5*k;
                            int l=amount1/2;
                            if (j<=co.get(twoR)){
                                amount1=amount1-2*l;
                                int m=amount1/1;
                                if (m<=co.get(oneR)){

                                    co.replace(oneR,co.get(oneR),co.get(oneR)-m)  ;
                                    co.replace(twoR,co.get(twoR),co.get(twoR)-l)  ;
                                    co.replace(fiveR,co.get(fiveR),co.get(fiveR)-k)  ;
                                    System.out.println("collect your change....\n*************************");
                                    System.out.println(k+" five rupee coin");
                                    System.out.println(l+" two rupee coin");
                                    System.out.println(m+" one rupee coin");
                                    System.out.println("***************************************************");

                                    sucess=true;

                                }else {
                                    System.out.println("not sufficient 1 rupee coins...");
                                    System.out.println("not sufficient change");
                                }


                            }else {
                                System.out.println("not sufficient 2 rupee coins...");
                                if (amount>co.get(oneR)){
                                    System.out.println("not sufficient change");
                                }else {
                                    co.replace(oneR, (int) (co.get(oneR)-amount));
                                    sucess=true;
                                }

                            }

                        }else {
                            System.out.println("not sufficient 5 rupee coins...");
                            amount1= (int) amount;
                            int l=amount1/2;
                            if (j<=co.get(twoR)){
                                amount1=amount1-2*l;
                                int m=amount1/1;
                                if (m<=co.get(oneR)){

                                    co.replace(oneR,co.get(oneR),co.get(oneR)-m)  ;
                                    co.replace(twoR,co.get(twoR),co.get(twoR)-l)  ;
                                    System.out.println("collect your change....\n*************************");
                                    System.out.println(l+" two rupee coin");
                                    System.out.println(m+" one rupee coin");
                                    System.out.println("***************************************************");

                                    sucess=true;
                                }else {
                                    System.out.println("not sufficient 1 rupee coins...");
                                    System.out.println("not sufficient change");
                                }
                            }else {
                                System.out.println("not sufficient 2 rupee coins...");
                                if (amount>co.get(oneR)){
                                    System.out.println("not sufficient change");
                                }else {
                                    co.replace(oneR, (int) (co.get(oneR)-amount));
                                    sucess=true;
                                }
                            }
                        }
                    }

                 }else {
                     System.out.println("there are not sufficient 100 rupee coins");
                     System.out.println("no change....");
                 }

                 if(sucess){
                     coinsList.putAll(co);
                 }
    }
}





