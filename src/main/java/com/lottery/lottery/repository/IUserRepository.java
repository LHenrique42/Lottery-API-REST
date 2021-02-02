package com.lottery.lottery.repository;

import com.lottery.lottery.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User, Long>{
    
    User findById(long id);
    @Query("SELECT t FROM User t WHERE t.email = :email")
    User findByEmail(@Param("email") String email);
}
