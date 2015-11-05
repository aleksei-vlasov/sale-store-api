package com.solidsystems.avlasov.backend.beans.controller.rest;

import com.solidsystems.avlasov.backend.beans.data.entity.Product;
import com.solidsystems.avlasov.backend.beans.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Alex Vlasov on 02.11.15.
 */
@RestController("productDataController")
@RequestMapping(value = "/salestoreapi/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductDataController {

    @Autowired
    ProductService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> list() {
        return service.list();
    }

    @RequestMapping(value = "/save/{id}&{name}&{price}", method = RequestMethod.GET)
    @ResponseBody
    public Long save(@PathVariable Long id, @PathVariable String name,  @PathVariable BigDecimal price) {
        Product p = new Product();
        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        return service.save(p);
    }

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return service.echoService();
    }

}
