package com.rafaelmeloni.dscommerce.services;

import com.rafaelmeloni.dscommerce.dto.ProductDTO;
import com.rafaelmeloni.dscommerce.entities.Product;
import com.rafaelmeloni.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(long id) {

        Product product = productRepository.findById(id).get();
        return  new ProductDTO(product);


    }
}
