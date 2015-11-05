package com.solidsystems.avlasov.frontend.ui.pages;

import com.solidsystems.avlasov.frontend.entity.StatisticsInfo;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Alex Vlasov on 23.10.15.
 */
public class StatisticsInformationPage extends Panel {

    private Label data = new Label("StatisticsInformationPage");


    private final VerticalLayout layout = new VerticalLayout();

    public StatisticsInformationPage() {
        layout.setMargin(false);
        setContent(layout);
        layout.addComponent(data);
    }

    public void changeContent(StatisticsInfo info) {
        data.setValue(info.toString());
    }

}
