package com.codesgm.sales.services;

import com.codesgm.sales.entities.User;
import com.codesgm.sales.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public  User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id){
         repository.deleteById(id);
    }

    public User update(Long id, User user) {
        User entity = repository.getReferenceById(id);
        updateData(entity, user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }


}
