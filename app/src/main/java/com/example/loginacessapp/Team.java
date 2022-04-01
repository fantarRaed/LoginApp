package com.example.loginacessapp;

public class Team {
    public String id="";
    public String team_name;
    public String team_chef;
    public String concours;
    public boolean pres=false;
    public String num_tel;
    public int score_jury=0;
    public int score_homologation=0;
    //public String freind_team;
    //public boolean dej;

    public Team(){

    }

    public Team(String id,String team_name, String team_chef, String concours,String num_tel, boolean pres,int score_jury,int score_homologation) {
        this.id = id;
        this.team_name = team_name;
        this.team_chef = team_chef;
        this.concours = concours;
        this.pres = pres;
        this.num_tel = num_tel;
        this.score_jury = score_jury;
        this.score_homologation = score_homologation;
    }
    public Team(String team_name, String team_chef, String concours,String num_tel) {
        this.id = id;
        this.team_name = team_name;
        this.team_chef = team_chef;
        this.concours = concours;
        this.pres = pres;
        this.num_tel = num_tel;
        this.score_jury = score_jury;
        this.score_homologation = score_homologation;
    }


}
