package com.lottery.lottery.services;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.lottery.lottery.model.Draw;
import com.lottery.lottery.model.DrawDTO;
import com.lottery.lottery.model.User;
import com.lottery.lottery.repository.IDrawRepository;
import com.lottery.lottery.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrawService implements IDrawService {

    @Autowired
    IDrawRepository _drawRepository;

    @Autowired
    IUserRepository _userRepository;

    int MIN_VALUE = 1;
    int MAX_VALUE = 75;
    int QTD_DRAW_NUMBERS = 6;

    @Override
    public Draw save(String email) {
        User user = _userRepository.findByEmail(email);
        if(user == null) {
            throw new Error("User not found.");
        }
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for(int i = 0; i < QTD_DRAW_NUMBERS; ++i){
            int randomNumber = (int) (MIN_VALUE + (float) (Math.random() * ((MAX_VALUE - MIN_VALUE))));
            numbers.add(randomNumber);
        }

        Draw draw = new Draw();
        draw.setNumbers(new Gson().toJson(numbers));
        draw.setUser(user);
        
        return _drawRepository.save(draw);
    }

    @Override
    public DrawDTO getUserDraws(String email) {
        ArrayList<Draw> draws = new ArrayList<Draw>();
        DrawDTO drawsDTO = new DrawDTO();

        User user = _userRepository.findByEmail(email);

        if(user != null) {
            draws = _drawRepository.findByUserId(user.getId());
            drawsDTO = this.toDTO(draws);
        }

        return drawsDTO;
    }

    public DrawDTO toDTO(ArrayList<Draw> draws) {
        DrawDTO drawsDTO = new DrawDTO();
        for(Draw draw : draws) {
            drawsDTO.addDraw(draw.getNumbers());
        }
        drawsDTO.setEmail(draws.get(0).getUser().getEmail());

        return drawsDTO;
    }
    
}
