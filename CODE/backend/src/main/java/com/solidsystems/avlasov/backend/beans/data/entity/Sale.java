package com.solidsystems.avlasov.backend.beans.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex Vlasov on 27.10.15.
 */

@Entity
@Table(name = "SALE")
public class Sale implements Serializable {

    private Long id;
    private Date date;
    private BigDecimal totalAmount;
    private List<SaleLine> saleLines;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @OneToMany
    public List<SaleLine> getSaleLines() {
        return saleLines;
    }

    public void setSaleLines(List<SaleLine> saleLines) {
        this.saleLines = saleLines;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", date=" + date +
                ", totalAmount=" + totalAmount +
                ", saleLines=" + saleLines +
                '}';
    }
}
