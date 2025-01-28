package com.codesgm.sales.respositories;

import com.codesgm.sales.entities.Product;
import com.codesgm.sales.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

