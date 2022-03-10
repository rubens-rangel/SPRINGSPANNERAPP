package com.test.cloud.SpringSpannerApp.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.Interleaved;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.Data;


@Table(name="orders")
@Data
public class Order {

    @PrimaryKey
    @Column(name="order_id")
    private String id;

    private String description;

    @Column(name="creation_timestamp")
    private LocalDateTime timestamp;

    @Interleaved
    private List<OrderItem> items;
}