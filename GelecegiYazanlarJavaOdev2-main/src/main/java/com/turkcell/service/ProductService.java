package com.turkcell.service;

import com.turkcell.entity.Product;
import com.turkcell.repository.ProductRepository;

public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public void add(Product product) {
        if (product.getPrice()<0)
            return;

       productRepository.save(product);
        System.out.println("Ürün başarıyla eklendi : " + product.getName());
    }

    public void stockControl(String name){
        productRepository.stockControl(name);
    }
}
