package com.turkcell.repository;

import com.turkcell.entity.Customer;
import com.turkcell.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IRepository<Product>{

    List<Product> products = new ArrayList<Product>();
    @Override
    public void save(Product product) {

        products.add(product);
    }

    public int stockControl(String name){
        int productCount = 0;
        boolean found = false;

        for (Product product : products){
            String productName = product.getName().toLowerCase();
            if(productName.equals(name.toLowerCase())){
                System.out.println("Ürün stok sayısı: " + product.getStock());
                productCount = product.getStock();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Stoklarda ürün bulunamadı");
        }

        return productCount;
    }

    public int stockControl(int id){

        int productCount = 0;
        for (Product product : products){
            if(product.getId() == id){
                //System.out.println("Ürün stok sayısı: " + product.getStock());
                productCount = product.getStock();
                break;
            }
            else {
                System.out.println("Stoklarda ürün bulunamadı");
            }
        }
        return productCount;
    }
    public Product findById(int productId){
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}
