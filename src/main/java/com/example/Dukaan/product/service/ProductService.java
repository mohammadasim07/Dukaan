package com.example.Dukaan.product.service;

import com.example.Dukaan.product.entity.ProductEntity;
import com.example.Dukaan.product.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity createProduct(ProductEntity product){
       return productRepository.save(product);
    }

    public ProductEntity updateproduct(ProductEntity product, Long id) {

        ProductEntity product1 = productRepository.getById(id);

        product1.setName(product.getName());
        product1.setQuantity(product.getQuantity());
        product1.setPrice(product.getPrice());

        return productRepository.save(product1);
    }
    public Optional<ProductEntity> getByIdProduct(Long id){
        return productRepository.findById(id);

    }
    public List<ProductEntity> getAllProduct(){
        return productRepository.findAll();
    }

    public Boolean deleteByIdProduct(Long id){
        if(!productRepository.existsById(id)){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    public List<ProductEntity> searchProduct(String name){
        Sort sort = Sort.by("quantity").ascending();
        return  productRepository.findByNameContainingIgnoreCase(name,sort);
    }
}
