package com.solidsystems.avlasov.frontend.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by Alex Vlasov on 02.11.15.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class SaleLine implements Serializable {

    private Long id;
    private Product product;
    private Long quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SaleLine{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
