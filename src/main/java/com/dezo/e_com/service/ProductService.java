package com.dezo.e_com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dezo.e_com.model.Product;
import com.dezo.e_com.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public List<Product> retieveProducts(){
    return productRepository.findAll();
  }

  public Optional<Product> retieveOneProduct(Integer id){
    return productRepository.findById(id);
  }



}
