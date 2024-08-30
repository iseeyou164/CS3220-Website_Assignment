package com.example.demo;

import com.example.demo.model.Player;
import com.example.demo.model.Team;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataStore {
    public int getTotalTeams;
    private List<Player> players = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();

    Year thisYear = Year.now();

    public DataStore(){
        players.add(new Player("Harold", 'M', 2014, 1 ));
        players.add(new Player("James", 'M', 2015, 1 ));

//        for(int i = 0; i <= players.size(); i++){
//            System.out.println(players.get(i).getName());
//        }

        teams.add(new Team());
        teams.add(new Team("Red", 'M', 4, 12));
        addPlayerToTeam();
    }

    public void addPlayerToTeam(){
        for(int k = 0; k< teams.size(); k++){
            teams.get(k).setPlayerCount(0);
            for(int i = 0; i < players.size(); i++){
                if(players.get(i).getTeamID() == teams.get(k).getId()){
                    teams.get(k).setPlayerCount(teams.get(k).getPlayerCount()+1);
                }
            }
        }
    }

    public List<Player> getPlayersInTeam(int team_id){
        List<Player> playersInTeam = new ArrayList<>();
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getTeamID() == team_id){
                playersInTeam.add(players.get(i));
            }
        }
        return playersInTeam;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public List<Team> getAllTeams(){
        return teams;
    }
    public List<Team> getTeams(){
        List<Team> teamsList = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++){
            if(teams.get(i).getId()>0) {
                teamsList.add(teams.get(i));
            }
        }
        return teamsList;
    }
    public void addPlayer(Player newPlayer) {
        players.add(newPlayer);
    }
    public void addTeam(Team newTeam) {
        teams.add(newTeam);
    }

    public Player getPlayer(int id) {
        return players.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
//        for(int i = 0; i < players.size(); i++){
//            if(players.get(i).getTeamID()==id){
//                return players.get(i);
//            }
//        }
//        return null;
    }

    public int getTotalTeams(){
        return teams.size();
    }

    public void replacePlayer(Integer id, Player editedPlayer) {
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getId()==id){
                players.get(i).setName(editedPlayer.getName());
                players.get(i).setGender(editedPlayer.getGender());
                players.get(i).setBirthYear(editedPlayer.getBirthYear());
                players.get(i).setTeamID(editedPlayer.getTeamID());
                players.remove(editedPlayer);
            }
        }
    }

}
