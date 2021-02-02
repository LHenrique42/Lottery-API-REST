package com.lottery.lottery.controller;

import java.util.ArrayList;

import com.lottery.lottery.model.Draw;
import com.lottery.lottery.model.DrawDTO;
import com.lottery.lottery.model.User;
import com.lottery.lottery.services.DrawService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/v1")
@Api(value="API REST Lottery")
@CrossOrigin(origins = "*")
public class DrawController {
    
    @Autowired
    DrawService _drawService;

    @PostMapping("/draw")
    @ApiOperation(value = "Cadastra aposta")
    @ResponseBody
    public Draw newDraw(@RequestBody @Validated User user) {
        return _drawService.save(user.getEmail());
    }

    @GetMapping("/user/draw")
    @ApiOperation(value = "Retorna apostas do usuário")
    @ResponseBody
    public DrawDTO getDraws(@RequestBody @Validated User user) {
        return _drawService.getUserDraws(user.getEmail());
    }

}
