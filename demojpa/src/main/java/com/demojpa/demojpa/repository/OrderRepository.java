package com.demojpa.demojpa.repository;

import com.demojpa.demojpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long>{
//    @Query("SELECT o FROM Order o WHERE o.orderId = ?1")
//    Order findByAuAh(String orderId);
}
