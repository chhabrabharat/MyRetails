package com.test.myretails.product.dao;

import com.test.myretails.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
