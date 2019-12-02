package com.test.myretails.product.util;

import com.test.myretails.product.ResposeDTO;
import com.test.myretails.product.entity.Currency;
import com.test.myretails.product.entity.Price;
import com.test.myretails.product.entity.Product;

import java.util.Map;

public class ObjectConverter {
    public static Product getProduct(ResposeDTO resposeDTO) {
        return null;
    }

    public static Price getPrice(ResposeDTO resposeDTO) {
        Price price1 = new Price();
        Map map = (Map) resposeDTO.getOutput();
        price1.setCurrency(Currency.valueOf(map.get("currency").toString()));
        price1.setPrice((Integer) map.get("price"));
        return price1;
    }
}
