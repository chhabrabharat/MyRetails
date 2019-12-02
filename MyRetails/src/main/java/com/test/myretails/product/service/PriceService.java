package com.test.myretails.product.service;

import com.test.myretails.product.dao.PriceDao;
import com.test.myretails.product.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TreeSet;


@Service
public class PriceService {
    @Autowired
    private PriceDao priceDao;
    public Price addPrice(Price price){
        price.setEntryTime(new Date());
        return priceDao.save(price);
    }
    public TreeSet getPrices(Integer productId){
        return priceDao.findAllByProductId(productId);
    }
}