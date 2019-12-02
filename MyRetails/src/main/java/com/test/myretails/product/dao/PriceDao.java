package com.test.myretails.product.dao;

import com.test.myretails.product.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.TreeSet;

public interface PriceDao extends JpaRepository<Price,Integer> {
    TreeSet<Price> findAllByProductId(Integer productId);
}
