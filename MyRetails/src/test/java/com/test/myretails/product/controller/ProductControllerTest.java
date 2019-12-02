package com.test.myretails.product.controller;

import com.test.myretails.product.ResposeDTO;
import com.test.myretails.product.entity.Currency;
import com.test.myretails.product.entity.Price;
import com.test.myretails.product.entity.Product;
import com.test.myretails.product.service.PriceService;
import com.test.myretails.product.service.ProductService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductControllerTest {
    @InjectMocks
    private ProductController productController;

    @Mock
    private PriceService priceService;

    @Mock
    private ProductService productService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        Price price = new Price();
        price.setPrice(100);
        price.setEntryTime(new Date());
        price.setCurrency(Currency.INR);
        TreeSet<Price> prices = new TreeSet<>();
        prices.add(price);
        when(priceService.addPrice(any(Price.class))).thenReturn(price);

        when(priceService.getPrices(any(Integer.class))).thenReturn(prices);
        Product product = new Product();
        product.setName("Test");
        product.setCurrentPrice(price);
        when(productService.addProduct(any(Product.class))).thenReturn(product);
        try {
            when(productService.getCurrentPrice(any(Integer.class))).thenReturn(price);
            when(productService.getProduct(any(Integer.class))).thenReturn(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void post() {
        initMocks();
        Product post = productController.post(new Product());
        assertEquals("Test", post.getName());
    }

    @Test
    void getByPruductId() {
        initMocks();
        ResposeDTO post = productController.getByPruductId(1);
        assertEquals("Test", ((Product)post.getOutput()).getName());
        assertEquals(true,post.isSuccess());
    }

    @Test
    void getCurrentPrice() {
        initMocks();
        ResposeDTO post = productController.getCurrentPrice(1);
        assertEquals(100, ((Price)post.getOutput()).getPrice());
        assertEquals(true,post.isSuccess());
    }
}