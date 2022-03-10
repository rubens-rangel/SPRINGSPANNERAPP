package com.test.cloud.SpringSpannerApp.entities;

import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.Data;


@Table(name="order_items")
@Data
public class OrderItem {

    @PrimaryKey(keyOrder = 1)
    @Column(name="order_id")
    private String orderId;

    @PrimaryKey(keyOrder = 2)
    @Column(name="order_item_id")
    private String orderItemId;

    private String description;
    private Long quantity;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }
}