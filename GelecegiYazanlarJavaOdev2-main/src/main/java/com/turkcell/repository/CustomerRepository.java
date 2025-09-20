package com.turkcell.repository;

import com.turkcell.entity.Customer;
import com.turkcell.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements IRepository<Customer> {

    List<Customer> customers = new ArrayList<Customer>();

    public void save(Customer customer) {

        customers.add(customer);
    }

    public Customer search(String name) {


        for (Customer customer : customers) {
            String customerName = customer.getName().toLowerCase();
            if (customerName.equals(name.toLowerCase())) {
                System.out.println("Müşteri sistemde var: " + customer.getName());
                return customer;
            }
        }
        System.out.println("Müşteri sistemde bulunamadı");
        return null;

    }

    public boolean isCustomer(int id) {

        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return true;
            }

        }
        return false;

    }
}
