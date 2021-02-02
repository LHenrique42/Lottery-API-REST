package com.lottery.lottery.repository;

import java.util.ArrayList;

import com.lottery.lottery.model.Draw;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDrawRepository extends JpaRepository<Draw, Long>{
    
    Draw findById(long id);
    ArrayList<Draw> findByUserId(long id);
    Draw save(String email);
}
