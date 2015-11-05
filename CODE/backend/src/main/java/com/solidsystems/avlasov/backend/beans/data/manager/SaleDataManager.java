package com.solidsystems.avlasov.backend.beans.data.manager;

import com.solidsystems.avlasov.backend.beans.data.entity.Product;
import com.solidsystems.avlasov.backend.beans.data.entity.Sale;

/**
 * Created by Alex Vlasov on 02.11.15.
 */
public interface SaleDataManager extends AbstractDataManager<Sale, Long> {
    String HQL_GET_OBJECT_LIST = "FROM SALE ORDER BY id)";
}
