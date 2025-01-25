package com.codesgm.sales.respositories;

import com.codesgm.sales.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

