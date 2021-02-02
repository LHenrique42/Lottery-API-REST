package com.lottery.lottery.controller;

import com.lottery.lottery.model.Draw;
import com.lottery.lottery.model.User;
import com.lottery.lottery.repository.IDrawRepository;
import com.lottery.lottery.repository.IUserRepository;
import com.lottery.lottery.services.DrawService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/v1")
@Api(value="API REST Lottery")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    IUserRepository _userRepository;

    @PostMapping("/user")
    @ApiOperation(value = "Cadastra usuário")
    public User user(@RequestBody User user) {
        return _userRepository.save(user);
    }

}
