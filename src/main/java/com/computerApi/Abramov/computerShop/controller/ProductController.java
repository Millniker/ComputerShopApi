package com.computerApi.Abramov.computerShop.controller;

import com.computerApi.Abramov.computerShop.model.DTO.ProductDto;
import com.computerApi.Abramov.computerShop.model.DTO.ProductEditDto;
import com.computerApi.Abramov.computerShop.model.enums.Type;
import com.computerApi.Abramov.computerShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping("/create")

    public ResponseEntity<?> addProduct (@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }
    @GetMapping("/{type}")
    public ResponseEntity<?> getAll(@PathVariable Type type){
        return productService.getAll(type);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return productService.getConcertProduct(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody ProductEditDto productEditDto){
        return productService.editProduct(id, productEditDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
