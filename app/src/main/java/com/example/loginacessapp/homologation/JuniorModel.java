package com.example.loginacessapp.homologation;

public class JuniorModel {
    private String team_id;
    private long score_homologation;

    private JuniorModel(){}

    private JuniorModel(String name, long score){
        this.team_id = name;
        this.score_homologation = score;
    }

    public String getTeam_id() {
        return team_id;
    }

    public long getScore_homologation() {
        return score_homologation;
    }
}