package com.codesgm.sales.respositories;

import com.codesgm.sales.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

