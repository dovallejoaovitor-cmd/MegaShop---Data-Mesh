package com.megashop.vendas.Entities;

import java.time.LocalDate;

public class Sale {
    private Long id;
    private Long productId;
    private Integer quantity;
    private Double value;
    private LocalDate data;

    public Sale(Long id, Long productId, Integer quantity, Double value, LocalDate data) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.value = value;
        this.data = data;
    }

    public Sale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
