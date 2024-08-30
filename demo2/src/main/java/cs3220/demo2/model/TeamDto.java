package cs3220.demo2.model;

import java.util.List;
import java.util.stream.Collectors;

public class TeamDto {
    private Integer id;

    private String uniformColor;
    private char gender;
    private Integer minAge;
    private Integer maxAge;
    private Integer playerCount;
    private List<Player> players;

    public TeamDto() {
    }

    public TeamDto(Team t) {
        id = t.getId();
        uniformColor = t.getUniformColor();
        gender = t.getGender();
        minAge = t.getMinAge();
        maxAge = t.getMaxAge();
        playerCount = t.getPlayerCount();
        players = t.getPlayers();
    }

    public Team toTeam() {
        Team t = new Team();
        t.setId(id);
        t.setUniformColor(uniformColor);
        t.setGender(gender);
        t.setMinAge(minAge);
        t.setMaxAge(maxAge);
        t.setPlayerCount(playerCount);
        if (!players.isEmpty()) {
            t.setPlayers(players);
        }
        return t;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public void setPlayers(List<Player> players){
        this.players = players;
    }
    public List<Player> getPlayers(){
        return players;
    }
    public void setPlayerCount(Integer playerCount){
        this.playerCount = playerCount;
    }
    public Integer getPlayerCount(){
        return playerCount;
    }
}
