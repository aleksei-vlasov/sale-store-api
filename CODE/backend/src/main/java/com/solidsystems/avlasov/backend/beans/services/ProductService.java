package com.solidsystems.avlasov.backend.beans.services;

import com.solidsystems.avlasov.backend.beans.data.entity.Product;

import java.util.List;

/**
 * Created by Alex Vlasov on 02.11.15.
 */
public interface ProductService {

    List<Product> list();
    Long save(Product p);
    String echoService();

}
