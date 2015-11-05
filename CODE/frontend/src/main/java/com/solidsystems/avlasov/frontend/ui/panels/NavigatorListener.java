package com.solidsystems.avlasov.frontend.ui.panels;

/**
 * Created by Alex Vlasov on 23.10.15.
 */
public interface NavigatorListener {

    public enum NavigatorEvent {PRODUCTS, SELLS, HISTORY, STATICTICS, TEST, PROGRESSBAR};

    void changeContent(NavigatorEvent event);

}
