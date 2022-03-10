package com.test.cloud.SpringSpannerApp.repository;


import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.test.cloud.SpringSpannerApp.entities.Order;
import org.springframework.stereotype.*;

@Repository
public interface OrderRepository extends SpannerRepository<Order, String> {
}