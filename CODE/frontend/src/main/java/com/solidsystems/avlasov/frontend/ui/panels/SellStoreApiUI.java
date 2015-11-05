package com.solidsystems.avlasov.frontend.ui.panels;

/**
 * Created by Alex Vlasov on 23.10.15.
 */

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

public class SellStoreApiUI extends UI {

    private NavigatorPanel navigator = new NavigatorPanel();
    private InformationPanel information = new InformationPanel();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        HorizontalLayout titleBar = new HorizontalLayout();
        titleBar.setWidth("100%");
        titleBar.setMargin(new MarginInfo(false,false,false,true));
        root.addComponent(titleBar);

        Label title = new Label("Sale Store API 1.0");
        title.addStyleName("h2");
        titleBar.addComponent(title);
        titleBar.setExpandRatio(title, 1.0f);

        HorizontalLayout panels = new HorizontalLayout();
        panels.setSizeFull();
        root.addComponent(panels);
        root.setExpandRatio(panels, 1);

        navigator.setWidth(null);
        navigator.setHeight("100%");
        panels.addComponent(navigator);
        panels.addComponent(information);

        navigator.addListener(information);

        panels.setExpandRatio(information, 1);
        panels.setExpandRatio(navigator, 0);

        setContent(root);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = SellStoreApiUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

}
