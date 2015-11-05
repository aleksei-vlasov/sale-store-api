package com.solidsystems.avlasov.backend.beans.data.manager;

import com.solidsystems.avlasov.backend.beans.data.entity.Product;
import com.solidsystems.avlasov.backend.beans.data.entity.SaleLine;

/**
 * Created by Alex Vlasov on 02.11.15.
 */
public interface SaleLineDataManager extends AbstractDataManager<SaleLine, Long> {
    String HQL_GET_OBJECT_LIST = "FROM SALELINE ORDER BY id)";
}
