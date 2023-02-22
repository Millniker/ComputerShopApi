package com.computerApi.Abramov.computerShop.service;

import com.computerApi.Abramov.computerShop.model.DTO.*;
import com.computerApi.Abramov.computerShop.model.entity.Product;
import com.computerApi.Abramov.computerShop.model.enums.Type;
import com.computerApi.Abramov.computerShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public ResponseEntity<?> getAll (Type type){
        Set<Product> products= productRepository.getAllByType(type);
        switch (type){
            case laptop -> {
                return ResponseEntity.ok(products.stream().map(LaptopDTO::toModel).collect(Collectors.toSet()));
            }
            case monitor -> {
                return ResponseEntity.ok(products.stream().map(MonitorDTO::toModel).collect(Collectors.toSet()));
            }
            case computer ->{
                return ResponseEntity.ok(products.stream().map(ComputerDTO::toModel).collect(Collectors.toSet()));
            }
            case hardDrive -> {
                return ResponseEntity.ok(products.stream().map(HardDriveDTO::toModel).collect(Collectors.toSet()));
            }
        }
        return ResponseEntity.ok(products);
    }
    public ResponseEntity<?> getConcertProduct(Long id){
        Product product = productRepository.getProductsById(id);
        if(product==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found");
        }
        return ResponseEntity.ok(product);

    };
    public ResponseEntity<?> addProduct(ProductDto productDto){
        if(productRepository.existsBySeriesNumber(productDto.getSeriesNumber())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This product is exist");
        }
      Product product = new Product(
              productDto.getSeriesNumber(),
              productDto.getManufacturer(),
              productDto.getPrice(),
              productDto.getCount(),
              productDto.getType(),
              productDto.getDiagonal(),
              productDto.getAmount(),
              productDto.getComputerType(),
              productDto.getLaptopType()
      );
      productRepository.save(product);
      return ResponseEntity.status(HttpStatus.OK).body(product.getId());
    };
    public ResponseEntity<?> editProduct (Long id, ProductEditDto productEditDto){
        Product product = productRepository.getProductsById(id);
        if(product==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found");
        }
        product.setSeriesNumber(productEditDto.getSeriesNumber());
        product.setManufacturer(productEditDto.getManufacturer());
        product.setAmount(productEditDto.getAmount());
        product.setCount(productEditDto.getCount());
        product.setDiagonal(productEditDto.getDiagonal());
        product.setType(productEditDto.getType());
        product.setComputerType(productEditDto.getComputerType());
        product.setLaptopType(productEditDto.getLaptopType());
        product.setPrice(productEditDto.getPrice());
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    public ResponseEntity<?> deleteProduct (Long id){
        Product product = productRepository.getProductsById(id);
        if(product==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found");
        }
        productRepository.delete(product);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    };
}
