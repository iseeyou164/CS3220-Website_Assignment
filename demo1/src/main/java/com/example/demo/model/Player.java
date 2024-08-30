package com.example.demo.model;

import java.time.Year;

public class Player {
    int id;
    private static int nextID = 1;
    String name;
    char gender;
    long birthYear;
    int teamID;
    //age is read only
    int age;

    //getters and setters for above elements
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
    public char getGender(){
        return gender;
    }
    //might need to import year stuff...
    public void setBirthYear(long birthYear){

        this.birthYear = birthYear;
        this.age = getAge();
    }
    public long getBirthYear(){
        return birthYear;
    }
    public void setTeamID(int teamID){
        this.teamID = teamID;
    }
    public int getTeamID(){
        return teamID;
    }
    public int getAge(){
//        return thisYear.minusYears(this.getBirthYear());
        int currentYear = Year.now().getValue();
        return currentYear - (int) birthYear;
    }

    public Player(String name, char gender, long birthYear){
        this.setId(nextID++);
        this.setName(name);
        this.setGender(gender);
        this.setBirthYear(birthYear);
        this.setTeamID(0);
    }
    public Player(String name, char gender, long birthYear, int teamID){
        this.setId(nextID++);
        this.setName(name);
        this.setGender(gender);
        this.setBirthYear(birthYear);
        this.setTeamID(teamID);
    }

    public Player(){

    }
}
