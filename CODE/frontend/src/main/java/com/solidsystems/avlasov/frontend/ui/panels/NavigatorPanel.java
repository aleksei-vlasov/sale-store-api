package com.solidsystems.avlasov.frontend.ui.panels;

import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex Vlasov on 23.10.15.
 */

public class NavigatorPanel extends Panel {

    Button products = new Button("Products");
    Button sells = new Button("Sells");
    Button history = new Button("History");
    Button stat = new Button("Statistics");
    Button progressbar = new Button("progressbar");
    Set<NavigatorListener> listeners = new HashSet<NavigatorListener>();

    final VerticalLayout layout = new VerticalLayout();

    public NavigatorPanel() {
        layout.setMargin(true);
        setContent(layout);
        products.addClickListener(new Button.ClickListener() {

            public void buttonClick(Button.ClickEvent event) {
                notifyListeners(NavigatorListener.NavigatorEvent.PRODUCTS);
            }
        });
        sells.addClickListener(new Button.ClickListener() {

            public void buttonClick(Button.ClickEvent event) {
                notifyListeners(NavigatorListener.NavigatorEvent.SELLS);
            }
        });
        history.addClickListener(new Button.ClickListener() {

            public void buttonClick(Button.ClickEvent event) {
                notifyListeners(NavigatorListener.NavigatorEvent.HISTORY);
            }
        });
        stat.addClickListener(new Button.ClickListener() {

            public void buttonClick(Button.ClickEvent event) {
                notifyListeners(NavigatorListener.NavigatorEvent.STATICTICS);
            }
        });
        progressbar.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                notifyListeners(NavigatorListener.NavigatorEvent.PROGRESSBAR);
            }
        });

        layout.addComponent(products);
        layout.addComponent(sells);
        layout.addComponent(history);
        layout.addComponent(stat);
        layout.addComponent(progressbar);
    }

    public void addListener(NavigatorListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners(NavigatorListener.NavigatorEvent event) {
        for(NavigatorListener l: listeners)
            l.changeContent(event);
    }

}
