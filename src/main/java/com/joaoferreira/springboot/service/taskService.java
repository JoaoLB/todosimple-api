package com.joaoferreira.springboot.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.joaoferreira.springboot.model.taskModel;
import com.joaoferreira.springboot.model.userModel;
import com.joaoferreira.springboot.repository.taskRepository;

public class taskService {

    @Autowired
    private taskRepository taskRepository;

    @Autowired
    private userService userService;

    public taskModel findById(Long id){
        Optional<taskModel> taskModel = this.taskRepository.findById(id);
        return taskModel.orElseThrow(() -> new RuntimeException(
            "Tarefa não encontrada!"
        ));
    }

    @Transactional
    public taskModel create(taskModel obj){
        userModel userModel = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(userModel);
        obj = this.taskRepository.save(obj);
        return obj;
    }

    @Transactional
    public taskModel update(taskModel obj){
        taskModel newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try{
            this.taskRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não foi possível excluir.");
        }
    }
}
