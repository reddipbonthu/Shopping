package com.pavan.ecommerce.service;

import com.pavan.ecommerce.models.Product;

import java.util.List;

public interface ProductService {

    public Product getSingleProduct(long id);
    public Product createProduct(String title,double price,String description,String image,String category);
    public Product updateProduct(long id,String title,double price,String description,String image,String category);
    public List<Product> getAllProducts();
    public Product deleteProduct(long id);
}
