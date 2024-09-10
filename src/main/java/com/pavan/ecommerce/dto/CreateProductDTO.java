package com.pavan.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDTO {

    String title;
    double price;
    String description;
    String image;
    String category;
}
