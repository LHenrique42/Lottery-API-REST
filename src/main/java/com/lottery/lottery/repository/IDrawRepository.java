package com.lottery.lottery.repository;

import com.lottery.lottery.model.Draw;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDrawRepository extends JpaRepository<Draw, Long>{
    
    Draw findById(long id);
    Draw findByUserId(String email);
}
