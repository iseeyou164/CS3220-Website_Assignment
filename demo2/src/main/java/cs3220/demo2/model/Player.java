package cs3220.demo2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Year;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    char gender;
    long birthYear;
    Integer age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

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
    public void setTeam(Team team){
        this.team = team;
    }
    public Team getTeam(){
        return team;
    }
    public void setAge(){
        this.age = this.getAge();
    }
    public int getAge(){
//        return thisYear.minusYears(this.getBirthYear());
        int currentYear = Year.now().getValue();
        return currentYear - (int) birthYear;
    }

    public Player(){}
}
