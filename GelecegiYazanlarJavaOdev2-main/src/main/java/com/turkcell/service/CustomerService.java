package com.turkcell.service;

import com.turkcell.entity.Customer;
import com.turkcell.repository.CustomerRepository;

public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }


    public void add(Customer customer) {
        if (!customer.getEmail().contains("@"))
           return;

        customerRepository.save(customer);

        System.out.println("Müşteri başarıyla eklendi");
    }

    public void search(String name){

      customerRepository.search(name);
    }




}

