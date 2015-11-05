package com.solidsystems.avlasov.backend.beans.data.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alex Vlasov on 02.11.15.
 */

@Entity
@Table(name = "SALELINE")
public class SaleLine implements Serializable {

    private Long id;
    private Product product;
    private Long quantity;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
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
