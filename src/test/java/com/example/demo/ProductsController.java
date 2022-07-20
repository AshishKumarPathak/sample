package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/pro/")
public class ProductsController {
	
	@Autowired
	ProductService productsService;
	ProductsRepository productRepository;
	@PostMapping("/products")
	private int saveProduct(@RequestBody Products products)
	{
		productsService.saveOrUpdate(products);
		return products.getId();
	}
	@GetMapping("/product")
    private List<Products> getAllProducts()	
	{
    	return productsService.getAllProducts();
	}
    @GetMapping("/product/{id}")
    private Products getProducts(@PathVariable("id") int id)
    {
    	return productsService.getProductById(id);
    }
    @PutMapping("/products")
    private Products update(@RequestBody Products products)
    {
     productsService.saveOrUpdate(products);
     return products;
    }
    @DeleteMapping("product/{id}")
    public void deleteProduct(@PathVariable("id") int id)
    {
    	productsService.delete(id);
    }
}