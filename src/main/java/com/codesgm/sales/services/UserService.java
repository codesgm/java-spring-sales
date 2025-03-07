package com.codesgm.sales.services;

import com.codesgm.sales.entities.User;
import com.codesgm.sales.respositories.UserRepository;
import com.codesgm.sales.services.exceptions.DatabaseException;
import com.codesgm.sales.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public  User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id){
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public User update(Long id, User user) {
        try{
            User entity = repository.getReferenceById(id);
            updateData(entity, user);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        //return user;
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }


}
