package com.lottery.lottery.services;

import java.util.ArrayList;

import com.lottery.lottery.model.Draw;
import com.lottery.lottery.model.DrawDTO;

public interface IDrawService {
    
    public Draw save(String email);
    public DrawDTO getUserDraws(String email);
    public DrawDTO toDTO(ArrayList<Draw> draws);
}
