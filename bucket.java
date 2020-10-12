package com.Abhishek;

import java.util.HashMap;
import java.util.Map;

public class bucket {
    private Map<item, Integer> itemList= new HashMap<>();

    public Map<item, Integer> getItemList() {
        return itemList;
    }

    public bucket(String s) {
        System.out.println("your bucket is created with name "+s);
    }

    public  boolean containItem(String s) {
        boolean b = false;
        for (Map.Entry<item, Integer> i : itemList.entrySet()) {
            if (i.getKey().getName().toLowerCase().equals(s.toLowerCase())) {
                b = true;
                break;
            }

        }
        return b;
    }



    public item findItem(String s){
        item b=null;
        for (Map.Entry<item, Integer> i : itemList.entrySet()) {
            if (i.getKey().getName().toLowerCase().equals(s.toLowerCase())) {
               b=i.getKey();
               break;
            }

        }
        return b;
    }

    public void  addItem(item item,int amount){
        if (itemList.containsKey(item)){
                itemList.replace(item,itemList.get(item),itemList.get(item)+amount);
        }else {
            itemList.put(item,amount);
        }


    }
    public void  removeItem(item item,int amount){
        if (itemList.containsKey(item)){
            if (itemList.get(item)>=amount) {
                itemList.replace(item, itemList.get(item), itemList.get(item) - amount);
            }else {
                System.out.println("you are trying to remove a larger amount then present in bucket");
            }
        }else {
            System.out.println("Item is not present in bucket");
        }

    }
    public void  showItemList(){
        System.out.print( String .format("|%-10s|%-6s|%-6s","name","price","quantity"));
        for (Map.Entry<item, Integer> k: itemList.entrySet()) {
            String s="\n------------------------------------------";
            s=s+k.getKey().itemdetail()+"|"+k.getValue();
            System.out.print(s);

        }
        System.out.println("\n------------------------------------------\n");

    }



    public double bill() {
        double bill=0;
        for (Map.Entry<item,Integer> c: itemList.entrySet()
             ) {
            bill=bill+(double)c.getValue()*c.getKey().getPrice();
        }
        return  bill;
    }



    public void emptyBucket(){
        itemList.clear();
    }
}
