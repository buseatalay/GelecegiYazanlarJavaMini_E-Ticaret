package com.turkcell.repository;

import com.turkcell.entity.Order;
import com.turkcell.entity.OrderItem;
import com.turkcell.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IRepository<Order>{

    List<Order> orders = new ArrayList<Order>();

    public void save(Order order){
        orders.add(order);
  }






}
