package com.solidsystems.avlasov.frontend.ui.pages;

import com.solidsystems.avlasov.frontend.entity.Product;
import com.solidsystems.avlasov.frontend.service.ProductLookupService;
import com.vaadin.data.Container;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.*;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Alex Vlasov on 23.10.15.
 */
public class ProductInformationPage extends Panel {



    ProductLookupService service = new ProductLookupService();
    Product selected;

    private BeanContainer<String, Product> beans = new BeanContainer<String, Product>(Product.class);

    private final VerticalLayout layout = new VerticalLayout();
    private final HorizontalLayout menuLayout = new HorizontalLayout();
    private Table productsTable;
    private Table salesTable = new Table("Sales information list");
    private Panel menu = new Panel();
    private Button add = new Button("New");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private ArrayList<Container.ItemSetChangeListener> itemSetChangeListeners = new ArrayList<Container.ItemSetChangeListener>();

    public ProductInformationPage() {
        initProductList();
        initActions();
        setSizeFull();
        layout.setMargin(false);
        layout.setSizeFull();
        setContent(layout);
        menuLayout.addComponent(add);
        menuLayout.addComponent(save);
        menuLayout.addComponent(delete);
        menu.setContent(menuLayout);
        layout.addComponent(productsTable);
        layout.addComponent(salesTable);
        layout.addComponent(menu);
    }

    private void initActions() {
        add.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                Product p = new Product();
                p.setName("New Product");
                p.setPrice(new BigDecimal(0));
                try {
                    p.setId(service.save(p));
                } catch (Exception e) {
                    new RuntimeException(e);
                }
                beans.addBean(p);
                productsTable.refreshRowCache();
            }
        });
    }

    private void initProductList() {
        beans.setBeanIdProperty("id");
        try {
            Product[] products = service.list();
            for (Product p : products)
                beans.addBean(p);
        } catch (Exception e) {
            new RuntimeException(e);
        }
        productsTable = new Table("Product`s information list", beans);
        productsTable.setHeight(50F, Unit.PERCENTAGE);
        productsTable.setWidth(100F, Unit.PERCENTAGE);
        productsTable.setPageLength(productsTable.size());
        productsTable.setSelectable(true);
    }

    private void refresh() {

    }

}
