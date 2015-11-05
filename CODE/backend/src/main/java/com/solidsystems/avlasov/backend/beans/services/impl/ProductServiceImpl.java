package com.solidsystems.avlasov.backend.beans.services.impl;

import com.solidsystems.avlasov.backend.beans.data.entity.Product;
import com.solidsystems.avlasov.backend.beans.data.manager.ProductDataManager;
import com.solidsystems.avlasov.backend.beans.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alex Vlasov on 02.11.15.
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDataManager manager;

    public List<Product> list() {
        return manager.list();
    }

    public Long save(Product p) {
        return manager.save(p);
    }

    public String echoService() {
        return "Product echo service!";
    }

}
