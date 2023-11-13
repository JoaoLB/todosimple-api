package com.joaoferreira.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaoferreira.springboot.model.userModel;

@Repository
public interface userRepository extends JpaRepository<userModel, Long>{
    
}
