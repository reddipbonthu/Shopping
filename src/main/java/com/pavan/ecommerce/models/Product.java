package com.pavan.ecommerce.models;

import com.pavan.ecommerce.controllers.ProductController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Product {

    private long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;

}
