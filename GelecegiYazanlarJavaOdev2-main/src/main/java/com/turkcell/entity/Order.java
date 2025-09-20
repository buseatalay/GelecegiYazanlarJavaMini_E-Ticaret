package com.turkcell.entity;

import java.util.List;

public class Order {

    private int id;
    private int customerId;
    private List<OrderItem> orderItemList;
    private double totalPrice;

    public Order(){

    }

    public Order(int id, int customerId, List<OrderItem> orderItemList, double totalPrice) {

        this.id = id;
        this.customerId = customerId;
        this.orderItemList = orderItemList;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
