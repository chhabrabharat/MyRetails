package com.test.myretails.product.controller;

import com.test.myretails.product.ResposeDTO;
import com.test.myretails.product.entity.Product;
import com.test.myretails.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseBody
    public Product post(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping
    @ResponseBody
    public ResposeDTO put(@RequestBody Product product) {
        ResposeDTO resposeDTO = new ResposeDTO();
        resposeDTO.setSuccess(true);
        try {
            resposeDTO.setOutput(productService.addProduct(product));
        } catch (Exception e) {
            resposeDTO.setSuccess(false);
            resposeDTO.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return resposeDTO;
    }

    @GetMapping("/{productId}")
    @ResponseBody
    public ResposeDTO getByPruductId(@PathVariable Integer productId) throws Exception {
        ResposeDTO resposeDTO = new ResposeDTO();
        resposeDTO.setSuccess(true);
        try {
            resposeDTO.setOutput(productService.getProduct(productId));
        } catch (Exception e) {
            resposeDTO.setSuccess(false);
            resposeDTO.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return resposeDTO;
    }

    @GetMapping("/{productId}/price")
    @ResponseBody
    public ResposeDTO getCurrentPrice(@PathVariable Integer productId) {
        ResposeDTO resposeDTO = new ResposeDTO();
        resposeDTO.setSuccess(true);
        try {
            resposeDTO.setOutput(productService.getCurrentPrice(productId));
        } catch (Exception e) {
            resposeDTO.setSuccess(false);
            resposeDTO.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return resposeDTO;
    }

}
