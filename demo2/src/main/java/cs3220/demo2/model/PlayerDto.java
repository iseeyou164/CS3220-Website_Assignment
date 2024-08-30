package cs3220.demo2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Year;
import java.util.List;

public class PlayerDto {
    Integer id;
    String name;
    char gender;
    long birthYear;
    Integer age;
//    private Team team;
    public PlayerDto() {
    }

//    public PlayerDto(Player p) {
//        id = p.getId();
//        name = p.getName();
//        gender = p.getGender();
//        birthYear = p.getBirthYear();
////        team = p.getTeam();
//    }
    public PlayerDto(Team t, Player p){
        p.setTeam(t);
    }

    public Player toPlayer(Team t) {
        Player p = new Player();
        p.setId(id);
        p.setName(name);
        p.setGender(gender);
        p.setBirthYear(birthYear);
        p.setAge();
        p.setTeam(t);
        return p;
    }

    //getters and setters for above elements
    public void setId(Integer id){
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
//    public void setTeam(Team team){
//        this.team = team;
//    }
//    public Team getTeam(){
//        return team;
//    }

    public void setAge(){
        this.age = this.getAge();
    }
    public int getAge(){
//        return thisYear.minusYears(this.getBirthYear());
        int currentYear = Year.now().getValue();
        return currentYear - (int) birthYear;
    }
}
