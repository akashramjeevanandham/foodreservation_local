package com.akash.second.ui.home;

public class foods {
    private int id;
    private String FoodName;
    private String Imageurl;
    private String Shortdesc;
    private String Longdesc;
    private int price;
    private int stock;
    private boolean isexpand;
    private int quanval;

    public foods(int id,String foodName,String imageurl,String shortdesc, String longdesc,int price,int stock )
    {
        this.id=id;
        this.FoodName=foodName;
       this.Imageurl=imageurl;
        this. Shortdesc=shortdesc;
        this. Longdesc=longdesc;
        this.price=price;
        this.stock=stock;
        this. isexpand=false;
        this.quanval=0;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getShortdesc() {
        return Shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        Shortdesc = shortdesc;
    }

    public String getLongdesc() {
        return Longdesc;
    }

    public void setLongdesc(String longdesc) {
        Longdesc = longdesc;
    }


    @Override
    public String toString() {
        return "foods{" +
                "id=" + id +
                ", FoodName='" + FoodName + '\'' +
                ", Imageurl='" + Imageurl + '\'' +
                ", Shortdesc='" + Shortdesc + '\'' +
                ", Longdesc='" + Longdesc + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", isexpand=" + isexpand +
                ", quanval=" + quanval +
                '}';
    }

    public boolean isIsexpand() {
        return isexpand;
    }

    public void setIsexpand(boolean isexpand) {
        this.isexpand = isexpand;
    }
    public void addincr(int change){
        quanval=quanval+change;
    }
    public int getval(){
       return quanval;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
