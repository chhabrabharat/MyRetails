package com.test.myretails.product.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.myretails.product.ResposeDTO;
import com.test.myretails.product.util.ObjectConverter;
import com.test.myretails.product.util.RESTUtil;
import com.test.myretails.product.dao.PriceDao;
import com.test.myretails.product.dao.ProductDao;
import com.test.myretails.product.entity.Currency;
import com.test.myretails.product.entity.Price;
import com.test.myretails.product.entity.Product;
import com.test.myretails.product.util.StaticConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private PriceDao priceDao;
    @Autowired
    private PriceService priceService;

    public Product addProduct(Product product) {
        Product save = productDao.save(product);
        if(product.getCurrentPrice()!=null){
            product.getCurrentPrice().setProductId(save.getProductId());
            priceService.addPrice(product.getCurrentPrice());
        }
        return save;
    }

    public Product getProduct(int productId) throws Exception{
        Optional<Product> product = productDao.findById(productId);
        Product product1= product.get();
        Price allPrice = getCurrentPrice(product.get().getProductId());//Calling price API separately as mentioned in case study y\to get the info
        allPrice.setEntryTime(null);
        product.get().setCurrentPrice(allPrice);
        return product1;
    }

    public Price getCurrentPrice(Integer productId) throws Exception {
        String url = StaticConfig.path + StaticConfig.product_api + "/" + productId+ "/" +"price";
        String json= RESTUtil.getJsonFromServer(url);
        ObjectMapper objectMapper=new ObjectMapper();
        ResposeDTO price=objectMapper.readValue(json, ResposeDTO.class);
        return ObjectConverter.getPrice(price);
    }

    public Price getCurrentPrice(int ptoductId) {
        return priceDao.findAllByProductId(ptoductId).first();
    }
}
