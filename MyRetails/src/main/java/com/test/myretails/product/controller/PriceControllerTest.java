package com.test.myretails.product.controller;

import com.test.myretails.product.ResposeDTO;
import com.test.myretails.product.entity.Currency;
import com.test.myretails.product.entity.Price;
import com.test.myretails.product.service.PriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PriceControllerTest {
    @InjectMocks
    private PriceController priceController;

    @Mock
    private PriceService priceService;

//    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        Price price = new Price();
        price.setPrice(100);
        price.setEntryTime(new Date());
        price.setCurrency(Currency.INR);
        TreeSet<Price> prices=new TreeSet<>();
        prices.add(price);
        when(priceService.addPrice(any(Price.class))).thenReturn(price);

        when(priceService.getPrices(any(Integer.class))).thenReturn(prices);
    }

    @Test
    public void post() {
        initMocks();
        Price price = new Price();
        price.setPrice(100);
        price.setEntryTime(new Date());
        price.setCurrency(Currency.INR);
        ResposeDTO resposeDTO=priceController.post(price);
        assertEquals(true,resposeDTO.isSuccess());
        assertEquals(100,((Price)resposeDTO.getOutput()).getPrice());
    }

    @Test
    public void getPrice() {
        initMocks();
        ResposeDTO resposeDTO=priceController.getPrice(1);
        assertEquals(true,resposeDTO.isSuccess());
        assertEquals(1,((TreeSet)resposeDTO.getOutput()).size());


    }
}