package com.solidsystems.avlasov.frontend.service;

import com.solidsystems.avlasov.frontend.entity.StatisticsInfo;

/**
 * Created by Alex Vlasov on 24.10.15.
 */
public interface StatisticsServiceListener {

    void changeContent(StatisticsInfo content);

}
