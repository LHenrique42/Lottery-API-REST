package com.lottery.lottery.repository;

import com.lottery.lottery.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long>{
    
    User findById(long id);
    User findByEmail(String email);
}
