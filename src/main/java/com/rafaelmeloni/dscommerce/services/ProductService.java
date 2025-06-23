package com.rafaelmeloni.dscommerce.services;

import com.rafaelmeloni.dscommerce.dto.ProductDTO;
import com.rafaelmeloni.dscommerce.entities.Product;
import com.rafaelmeloni.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(long id) {

        Product product = productRepository.findById(id).get();
        return  new ProductDTO(product);


    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {

        Page<Product> productList = productRepository.findAll(pageable);
        return  productList.map(ProductDTO::new);

    }

    @Transactional
    public ProductDTO insert (ProductDTO productDTO) {

        Product entity = new Product();
        copyDtoToEntity(productDTO, entity);
        entity = productRepository.save(entity);

        return  new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update (Long id,ProductDTO productDTO) {

        Product entity = productRepository.getReferenceById(id);
        copyDtoToEntity(productDTO,entity);
        return  new ProductDTO(entity);
    }

    @Transactional
    public void  delete (Long id) {

        productRepository.deleteById(id);

    }

    private void copyDtoToEntity(ProductDTO productDTO, Product entity) {

        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setPrice(productDTO.getPrice());
        entity.setImgUrl(productDTO.getImgUrl());

    }
}
