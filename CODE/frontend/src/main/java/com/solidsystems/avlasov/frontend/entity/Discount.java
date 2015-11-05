package com.solidsystems.avlasov.frontend.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alex Vlasov on 27.10.15.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Discount implements Serializable {

    private Long id;
    private Date startDate;
    private Date expirationDate;
    private Long value;
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", expirationDate=" + expirationDate +
                ", value=" + value +
                ", product=" + product +
                '}';
    }
}
