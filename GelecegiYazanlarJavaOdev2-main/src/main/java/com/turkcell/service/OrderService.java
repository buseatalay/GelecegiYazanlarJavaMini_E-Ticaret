package com.turkcell.service;

import com.turkcell.entity.Customer;
import com.turkcell.entity.Order;
import com.turkcell.entity.OrderItem;
import com.turkcell.entity.Product;
import com.turkcell.repository.CustomerRepository;
import com.turkcell.repository.OrderRepository;
import com.turkcell.repository.ProductRepository;

import java.sql.SQLOutput;
import java.util.List;

public class OrderService {

    OrderRepository orderRepository;
    CustomerRepository customerRepository;
    ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;

    }


    public void add(List<OrderItem> orderItemList, Customer customer) {


        if (!customerRepository.isCustomer(customer.getId())) {
            System.out.println("Müşteri bulunamadı: " + customer.getName());
            return;
        }
        for (OrderItem orderItem : orderItemList) {
            // ürün var mı?
            Product product = productRepository.findById(orderItem.getProductId());
            if (product!=null) {
                // stok yeterli mi?
                if (  product.getStock() >= orderItem.getQuantity()) {
                    product.setStock(product.getStock() - orderItem.getQuantity());
                    System.out.println(product.getName() + " için güncel stok: " + product.getStock());
                } else {
                    System.out.println(product.getName() + " için stok yetersiz!");
                    return;
                }
            } else {
                System.out.println("Ürün bulunamadı, ID: " + orderItem.getProductId());
                return;
            }
        }

    }
}
