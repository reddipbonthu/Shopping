package com.pavan.ecommerce.dto;

import com.pavan.ecommerce.models.Category;
import com.pavan.ecommerce.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class FakeStoreDto {

    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(image);
        Category productCategory = new Category();
        productCategory.setType(category);
        product.setCategory(productCategory);

        return product;

    }
}
