package com.example.loginacessapp.homologation;

public class ToutTerrainModel {
    private String name;
    private long score;

    private ToutTerrainModel(){}

    private ToutTerrainModel(String name, long score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getScore() {return score;}

    public void setScore(long score) {
        this.score = score;
    }
}
