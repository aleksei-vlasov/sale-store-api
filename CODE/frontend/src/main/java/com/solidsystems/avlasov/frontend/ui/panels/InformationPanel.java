package com.solidsystems.avlasov.frontend.ui.panels;

import com.solidsystems.avlasov.frontend.entity.StatisticsInfo;
import com.solidsystems.avlasov.frontend.service.StatisticsInformationService;
import com.solidsystems.avlasov.frontend.service.StatisticsServiceListener;
import com.solidsystems.avlasov.frontend.ui.pages.DiscountHistoryInformationPage;
import com.solidsystems.avlasov.frontend.ui.pages.ProductInformationPage;
import com.solidsystems.avlasov.frontend.ui.pages.SalesInformationPage;
import com.solidsystems.avlasov.frontend.ui.pages.StatisticsInformationPage;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.VerticalLayout;
import org.apache.log4j.Logger;

/**
 * Created by Alex Vlasov on 23.10.15.
 */
public class InformationPanel extends Panel implements NavigatorListener, StatisticsServiceListener {

    private final VerticalLayout layout = new VerticalLayout();

    private static final Logger log = Logger.getLogger(InformationPanel.class);

    private ProductInformationPage prodictInfoPage = new ProductInformationPage();
    private SalesInformationPage salesInfoPage = new SalesInformationPage();
    private StatisticsInformationPage statisticsInfoPage = new StatisticsInformationPage();
    private DiscountHistoryInformationPage discountHistoryPage = new DiscountHistoryInformationPage();
    final ProgressBar bar = new ProgressBar(0.0f);


    public InformationPanel() {
        layout.setMargin(true);
        setHeight(100, Unit.PERCENTAGE);
        setWidth(100, Unit.PERCENTAGE);
        bar.setIndeterminate(true);
        setContent(layout);
        layout.addComponent(new Label("Information panel initialized"));
        StatisticsInformationService.getInstance().addListener(this);
    }

    public void changeContent(NavigatorEvent event) {
        if (!(event instanceof NavigatorEvent)) return;
        layout.removeAllComponents();
        if (event.equals(NavigatorEvent.PRODUCTS)) {
            layout.addComponent(prodictInfoPage);
        }
        if (event.equals(NavigatorEvent.SELLS)) {
            layout.addComponent(new Label("Sells information page"));
        }
        if (event.equals(NavigatorEvent.HISTORY)) {
            layout.addComponent(new Label("Discount history page"));

        }
        if (event.equals(NavigatorEvent.STATICTICS)) {
            layout.addComponent(statisticsInfoPage);
        }
        if (event.equals(NavigatorEvent.TEST)) {
        }
        if (event.equals(NavigatorEvent.PROGRESSBAR)) {
            bar.setCaption("Waiting...");
            layout.addComponent(bar);
        }

    }

    public void changeContent(StatisticsInfo info) {
        layout.removeAllComponents();
        statisticsInfoPage.changeContent(info);
        layout.addComponent(statisticsInfoPage);
    }


}


