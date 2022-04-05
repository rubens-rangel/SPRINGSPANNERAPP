package com.test.cloud.SpringSpannerApp.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.google.cloud.Date;
import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.Interleaved;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.Data;
import lombok.Generated;


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

    private String idtest1;

    @Interleaved
    private String idtest2;

    @Interleaved
    private String idtest3;


    public String getIdtest1() {
        return idtest1;
    }

    public void setIdtest1(String idtest1) {
        this.idtest1 = idtest1;
    }

    public String getIdtest2() {
        return idtest2;
    }

    public void setIdtest2(String idtest2) {
        this.idtest2 = idtest2;
    }

    public String getIdtest3() {
        return idtest3;
    }

    public void setIdtest3(String idtest3) {
        this.idtest3 = idtest3;
    }
}