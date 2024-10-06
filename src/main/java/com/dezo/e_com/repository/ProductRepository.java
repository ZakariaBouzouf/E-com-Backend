package com.dezo.e_com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dezo.e_com.model.Product;

public interface ProductRepository  extends JpaRepository<Product,Integer>{

}
