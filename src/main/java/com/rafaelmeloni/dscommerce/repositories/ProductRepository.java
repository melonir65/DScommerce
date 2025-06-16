package com.rafaelmeloni.dscommerce.repositories;


import com.rafaelmeloni.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}