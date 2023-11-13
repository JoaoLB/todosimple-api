package com.joaoferreira.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaoferreira.springboot.model.taskModel;

@Repository
public interface taskRepository extends JpaRepository<taskModel, Long>{
    
    List<taskModel> findByUser_Id(Long id);
}
