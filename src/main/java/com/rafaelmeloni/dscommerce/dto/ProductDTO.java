package com.rafaelmeloni.dscommerce.dto;


import com.rafaelmeloni.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public class ProductDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Name must have more than 3 and less than 80 char")
    @NotBlank(message = "Please insert a not blank name")
    private String name;

    @Size(min = 10 , message = "Description must have more than 10 char")
    @NotBlank
    private String description;

    @Positive(message = "the price must be a positive value")
    private Double price;
    private String imgUrl;


    public ProductDTO() {
    }

    public ProductDTO(Product entity) {
       id = entity.getId();
       name = entity.getName();
       description = entity.getDescription();
       price = entity.getPrice();
       imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }


}
