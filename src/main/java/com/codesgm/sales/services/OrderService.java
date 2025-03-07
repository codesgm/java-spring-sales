package com.codesgm.sales.services;

import com.codesgm.sales.entities.Order;
import com.codesgm.sales.entities.User;
import com.codesgm.sales.respositories.OrderRepository;
import com.codesgm.sales.respositories.UserRepository;
import com.codesgm.sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
