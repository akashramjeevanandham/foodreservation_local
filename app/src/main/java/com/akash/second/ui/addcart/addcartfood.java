package com.akash.second.ui.addcart;

public class addcartfood {
    private int id;
    private String Name;
    private int Price;
    private int Quantity;
    private int totalprice;


    public addcartfood(int id, String name, int price, int quantity) {
        this.id = id;
        this.Name = name;
        this.Price = price;
        this.Quantity = quantity;
        this.totalprice=totalprice+price;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int changedquant(int count){
        Quantity=Quantity+count;
        return Quantity;

    }
    public int getTotalprice(){
        return totalprice;
    }

    @Override
    public String toString() {
        return "addcartfood{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Price='" + Price + '\'' +
                ", Quantity='" + Quantity + '\'' +
                '}';
    }
}
