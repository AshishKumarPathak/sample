package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Products, Integer> {

}