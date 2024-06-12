package com.example.card.bean;

public class CardBean {
    private String id;
    private String name;
    private String xl;
    private String qy;
    private String price;
    private String total;

    public CardBean(String id, String name, String xl, String qy, String price, String total) {
        this.id = id;
        this.name = name;
        this.xl = xl;
        this.qy = qy;
        this.price = price;
        this.total = total;
    }

    public CardBean() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getQy() {
        return qy;
    }

    public void setQy(String qy) {
        this.qy = qy;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
