package com.example.demo.model;

public class Team {
    int id;
    static int nextID = 1;
    String uniformColor;
    char gender;
    int minAge;
    int maxAge;
    int playerCount;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setUniformColor(String uniformColor){
        this.uniformColor = uniformColor;
    }
    public String getUniformColor(){
        return uniformColor;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
    public char getGender(){
        return gender;
    }
    public void setMinAge(int minAge){
        this.minAge = minAge;
    }
    public int getMinAge(){
        return minAge;
    }
    public void setMaxAge(int maxAge){
        this.maxAge = maxAge;
    }
    public int getMaxAge(){
        return maxAge;
    }
    public void setPlayerCount(int playerCount){
        this.playerCount = playerCount;
    }
    public int getPlayerCount(){
        return playerCount;
    }

//    public Team(){
//        this.setId(0);
//        this.setUniformColor(null);
//        this.setGender('0');
//        this.setMinAge(0);
//        this.setMaxAge(0);
//        this.setPlayerCount(0);
//    }

    public Team(){

    }

    public Team(String uniformColor, char gender, int minAge, int maxAge){
        this.setId(nextID++);
        this.setUniformColor(uniformColor);
        this.setGender(gender);
        this.setMinAge(minAge);
        this.setMaxAge(maxAge);
        this.setPlayerCount(0);
    }

}
