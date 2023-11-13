package com.joaoferreira.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoferreira.springboot.model.userModel;
import com.joaoferreira.springboot.repository.userRepository;

@Service
public class userService {
    
    @Autowired
    private userRepository userRepository;

    public userModel findById(Long id){
        Optional<userModel> userModel = this.userRepository.findById(id);
        return userModel.orElseThrow(() -> new RuntimeException(
            "Usuário não encontrado!"
        ));
    }

    @Transactional
    public userModel create(userModel obj){
        obj.setId(null);
        obj = this.userRepository.save(obj);
         return obj;
    }

    @Transactional
    public userModel update(userModel obj){
        userModel newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try{
            this.userRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

}
