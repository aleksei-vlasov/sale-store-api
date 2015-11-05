package com.solidsystems.avlasov.backend.beans.data.manager;

import com.solidsystems.avlasov.backend.beans.data.entity.Product;

public interface ProductDataManager extends AbstractDataManager<Product, Long> {
    String HQL_GET_OBJECT_LIST = "FROM Product p ORDER BY p.id ASC)";


    public String echoService();

}