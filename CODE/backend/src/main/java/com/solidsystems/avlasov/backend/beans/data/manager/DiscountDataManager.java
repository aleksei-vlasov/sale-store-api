package com.solidsystems.avlasov.backend.beans.data.manager;

import com.solidsystems.avlasov.backend.beans.data.entity.Discount;
import com.solidsystems.avlasov.backend.beans.data.entity.Product;

/**
 * Created by Alex Vlasov on 02.11.15.
 */
public interface DiscountDataManager extends AbstractDataManager<Discount, Long> {
    String HQL_GET_OBJECT_LIST = "FROM DISCOUNT ORDER BY id)";

}
