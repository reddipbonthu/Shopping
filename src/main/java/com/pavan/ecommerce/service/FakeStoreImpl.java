package com.pavan.ecommerce.service;

import com.pavan.ecommerce.dto.FakeStoreDto;
import com.pavan.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreImpl implements ProductService{


    FakeStoreDto fakeStoreDto;
    RestTemplate restTemplate;
    public FakeStoreImpl(RestTemplate restTemplate, FakeStoreDto fakeStoreDto) {
        this.restTemplate = restTemplate;
        this.fakeStoreDto = fakeStoreDto;
    }



    @Override
    public Product getSingleProduct(long id) {
       fakeStoreDto =restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreDto.class);
       return fakeStoreDto.toProduct();

    }

    @Override
    public Product createProduct(String title, double price, String description, String image, String category) {
        FakeStoreDto fakeStoreDto = new FakeStoreDto();
        fakeStoreDto.setTitle(title);
        fakeStoreDto.setPrice(price);
        fakeStoreDto.setDescription(description);
        fakeStoreDto.setImage(image);
        fakeStoreDto.setCategory(category);
        FakeStoreDto response =restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreDto,FakeStoreDto.class);
       return response.toProduct();
    }

    @Override
    public Product updateProduct(long id, String title, double price, String description, String image, String category) {
        FakeStoreDto fakeStoreDto = new FakeStoreDto();
        fakeStoreDto.setTitle(title);
        fakeStoreDto.setPrice(price);
        fakeStoreDto.setDescription(description);
        fakeStoreDto.setImage(image);
        fakeStoreDto.setCategory(category);
        fakeStoreDto.setId(id);
        FakeStoreDto response = restTemplate.postForObject("https://fakestoreapi.com/products"+id,fakeStoreDto,FakeStoreDto.class);
        return response.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
       FakeStoreDto[] fakeStoreDtos = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreDto[].class);
       List<Product> products = new ArrayList<>();
        for(FakeStoreDto fakeStoreDto : fakeStoreDtos){
            products.add(fakeStoreDto.toProduct());
        }
        return products;

    }

    @Override
    public Product deleteProduct(long id) {
        fakeStoreDto= restTemplate.exchange("https://fakestoreapi.com/products/" +id, HttpMethod.DELETE, null,FakeStoreDto.class).getBody();
        return fakeStoreDto.toProduct();
    }
}
