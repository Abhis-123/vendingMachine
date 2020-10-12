package com.Abhishek;

public class item {
    private String name;
    private  double price;

    public item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public String itemdetail(){
       String s= "\n";

         s=s+ String.format("|%-10s|%-6s",this.name,this.price) ;
    return  s;
    }

}
