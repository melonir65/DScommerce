package com.rafaelmeloni.dscommerce.controllers;

import com.rafaelmeloni.dscommerce.dto.ProductDTO;
import com.rafaelmeloni.dscommerce.entities.Product;
import com.rafaelmeloni.dscommerce.repositories.ProductRepository;
import com.rafaelmeloni.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);

    }
}
