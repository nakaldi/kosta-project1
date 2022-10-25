package com.thunderdragon.projectshop.repository;

import com.thunderdragon.projectshop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
