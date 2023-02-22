package com.computerApi.Abramov.computerShop.repository;

import com.computerApi.Abramov.computerShop.model.entity.Product;
import com.computerApi.Abramov.computerShop.model.enums.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    Set<Product> getAllByType(Type type);
    boolean existsBySeriesNumber(String seriesNumber);
    Product getProductsById (Long id);
    Set<Product> findAll ();

}
