package com.test.myretails.product.controller;

import com.test.myretails.product.ResposeDTO;
import com.test.myretails.product.entity.Price;
import com.test.myretails.product.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/price")
public class PriceController {
    @Autowired
    PriceService priceService;

    @PostMapping
    @ResponseBody
    public ResposeDTO post(@RequestBody Price price) {
        ResposeDTO resposeDTO = new ResposeDTO();
        resposeDTO.setSuccess(true);
        try {
            resposeDTO.setOutput(priceService.addPrice(price));
        } catch (Exception e) {
            resposeDTO.setSuccess(false);
            resposeDTO.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return resposeDTO;
    }


    @GetMapping("/{productId}")
    @ResponseBody
    public ResposeDTO getPrice(@PathVariable Integer productId) {
        ResposeDTO resposeDTO = new ResposeDTO();
        resposeDTO.setSuccess(true);
        try {
            resposeDTO.setOutput(priceService.getPrices(productId));
        } catch (Exception e) {
            resposeDTO.setSuccess(false);
            resposeDTO.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return resposeDTO;
    }

}
