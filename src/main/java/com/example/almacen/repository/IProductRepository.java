package com.example.almacen.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.almacen.model.persistence.Product;

public interface IProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "SELECT * FROM Product", nativeQuery = true)
    Iterable<Product> findAllProducts();

    @Query(value = "SELECT * FROM Product WHERE id = :id", nativeQuery = true)
    Product findProductById(@Param("id") Integer id);
}
