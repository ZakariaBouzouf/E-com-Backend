package com.dezo.e_com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dezo.e_com.model.Product;
import com.dezo.e_com.service.ProductService;

@RestController
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("/products")
  public List<Product> retieveProducts(){
    return productService.retieveProducts();
  }

  @GetMapping("/products/{idProduct}")
  public Optional<Product> retieveOneProduct(@PathVariable Integer idProduct){
    return productService.retieveOneProduct(idProduct);
  }

}
