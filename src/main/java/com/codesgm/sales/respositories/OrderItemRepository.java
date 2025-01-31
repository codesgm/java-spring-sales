package com.codesgm.sales.respositories;

import com.codesgm.sales.entities.OrderItem;
import com.codesgm.sales.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

