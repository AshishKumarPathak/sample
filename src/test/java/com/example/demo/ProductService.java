package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductsRepository productsRepository;
	public void saveOrUpdate(Products products)
	{
		productsRepository.save(products);
	}
	public List<Products> getAllProducts()
	{
		List<Products> products = new ArrayList<Products>();
	    productsRepository.findAll().forEach(products1->products.add(products1));
	    return products;
	}
	public Products getProductById(int id)
	{
		return productsRepository.findById(id).get();
	}
	public void update(Products products, int id)
	{
		productsRepository.save(products);
	}
	public void delete(int id)
	{
		productsRepository.deleteById(id);
	}
}