package cs3220.demo2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
//    static int nextID = 1;
    String uniformColor;
    char gender;
    Integer minAge;
    Integer maxAge;
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "team_id", inverseJoinColumns = @JoinColumn(name = "member_id"))
//    private List<Player> players;
    Integer playerCount;
    @OneToMany(mappedBy = "team")
    private List<Player> players;

    public void setId(int id){
        this.id = id;
    }
    public Integer getId(){
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
    public void setMinAge(Integer minAge){
        this.minAge = minAge;
    }
    public Integer getMinAge(){
        return minAge;
    }
    public void setMaxAge(Integer maxAge){
        this.maxAge = maxAge;
    }
    public Integer getMaxAge(){
        return maxAge;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players){
        this.players = players;
    }
    public void setPlayerCount(Integer playerCount){
        this.playerCount = playerCount;
    }
    public Integer getPlayerCount(){
        return playerCount;
    }

    public Team(){}

}
