package com.pavan.ecommerce.controllers;

import com.pavan.ecommerce.dto.CreateProductDTO;
import com.pavan.ecommerce.models.Product;
import com.pavan.ecommerce.service.FakeStoreImpl;
import com.pavan.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {
    Product product;
    FakeStoreImpl fakeStoreImpl;

    ProductController(Product product ,FakeStoreImpl fakeStoreImpl) {
        this.product = product;
        this.fakeStoreImpl = fakeStoreImpl;
    }


    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long productId){
        return fakeStoreImpl.getSingleProduct(productId);
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductDTO request){
        return fakeStoreImpl.createProduct(request.getTitle(), request.getPrice(),request.getDescription(),request.getImage(),request.getCategory());
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable long id, CreateProductDTO request){
        return fakeStoreImpl.updateProduct(id,request.getTitle(),request.getPrice(),request.getDescription(),request.getImage(),request.getCategory());
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return fakeStoreImpl.getAllProducts();
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable long id){
        return fakeStoreImpl.deleteProduct(id);
    }


}
