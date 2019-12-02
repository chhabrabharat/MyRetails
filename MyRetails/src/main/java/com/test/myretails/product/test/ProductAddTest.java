package com.test.myretails.product.test;

import com.test.myretails.product.util.RESTUtil;
import com.test.myretails.product.util.StaticConfig;
import com.test.myretails.product.entity.Currency;
import com.test.myretails.product.entity.Price;
import com.test.myretails.product.entity.Product;

public class ProductAddTest {
    public static void main(String[] args) throws Exception {
        Product product = new Product();
        product.setName("Test");
        Price price = new Price();
        price.setCurrency(Currency.INR);
        price.setPrice(800);
        product.setCurrentPrice(price);
        addProduct(product);
        price.setPrice(5000);//Latest price is current price
        price.setProductId(1);
        addPrice(price);

        String output = searchProduct(1);
        if (output.contains("Test") && output.contains("5000")) {
            System.out.println("Test Pass for id 1 output is : " + output);
        } else {
            System.out.println("Test Fail for id 2 output is : " + output);
        }

        output = searchProduct(2000);
        if (output.contains("Test")) {
            System.out.println("Test Pass for id 2 output is : " + output);
        } else {
            System.out.println("Test Fail for id 2 output is : " + output);
        }

    }

    private static String searchProduct(int i) throws Exception {
        String url = StaticConfig.path + StaticConfig.product_api + "/" + i;
        return RESTUtil.getJsonFromServer(url);
    }


    public static void addProduct(Product product) throws Exception {
        String url = StaticConfig.path + StaticConfig.product_api;
        System.out.println(RESTUtil.postData(url, product));
    }

    public static void addPrice(Price price) throws Exception {
        String url = StaticConfig.path + StaticConfig.price_api;
        System.out.println(RESTUtil.postData(url, price));
    }
}
