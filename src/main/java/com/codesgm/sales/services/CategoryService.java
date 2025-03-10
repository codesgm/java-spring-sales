package com.codesgm.sales.services;

import com.codesgm.sales.entities.Category;
import com.codesgm.sales.respositories.CategoryRepository;
import com.codesgm.sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAl() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() ->  new ResourceNotFoundException(id));
    }

}
