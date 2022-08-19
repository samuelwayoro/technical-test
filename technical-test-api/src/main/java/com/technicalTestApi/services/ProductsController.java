package com.technicalTestApi.services;

import com.technicalTestApi.exception.ResourceNotFoundException;
import com.technicalTestApi.model.Product;
import com.technicalTestApi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1")
public class ProductsController {

    @Resource
    private ProductRepository productRepository;
    private Logger logger = LoggerFactory.getLogger(ProductsController.class);

    /**
     * avoir la liste de tous les produits
     */
    public List<Product> getAllProducts(){
        logger.info("Find all products");
        return productRepository.findAll();
    }

    /**
     * ajoute un nouveau produit à la bd
     */
    @PostMapping(path = "/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product)  throws ResourceNotFoundException {
        Product newProduct = productRepository.save(product);
        logger.info("Create new product with id : {}",newProduct.getId());
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

}
