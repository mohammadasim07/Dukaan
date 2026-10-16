package com.example.Dukaan.product.controller;


import com.example.Dukaan.product.entity.ProductEntity;
import com.example.Dukaan.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/create")
    public ResponseEntity<ProductEntity>createProduct (@RequestBody ProductEntity product){
        ProductEntity product1 =productService.createProduct(product);
        return ResponseEntity.ok(product1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id , @RequestBody ProductEntity product){
        ProductEntity product1 = productService.updateproduct(product,id);
        if (product1 == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product1);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductEntity> getByIdProduct(@PathVariable Long id ){
        Optional<ProductEntity> product1 = productService.getByIdProduct(id);
        if (product1.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product1.get());
    }

    @GetMapping("/get-all")
    public List<ProductEntity> getAllProduct(){
        return productService.getAllProduct();
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteByIdProduct(@PathVariable Long id){
            Boolean deleteProduct = productService.deleteByIdProduct(id);
            if(!deleteProduct){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unsuccessfull");
            }
            return  ResponseEntity.ok().body("ProductEntity Deleted");
        }

    @GetMapping("search")
    public ResponseEntity<List<ProductEntity>> searchProduct(@RequestParam String name){
        return ResponseEntity.ok(productService.searchProduct(name));
    }
}
