package com.lottery.lottery.model;

import java.util.ArrayList;

public class DrawDTO {
    private String email;
    private ArrayList<String> draws = new ArrayList<String>();


    public void addDraw(String draw) {
        this.draws.add(draw);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getDraws() {
        return draws;
    }

    public void setDraws(ArrayList<String> draws) {
        this.draws = draws;
    }
}
