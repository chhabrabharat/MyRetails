package com.test.myretails.product.entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Price implements Comparable{
    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;
    @JsonIgnore
    private int productId;
    private Currency currency;
    private long price;
    private Date entryTime;

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        return (((Price)o).getEntryTime()).compareTo(this.getEntryTime());
    }
}
