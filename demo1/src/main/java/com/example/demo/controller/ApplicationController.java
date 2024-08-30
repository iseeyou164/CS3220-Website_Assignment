package com.example.demo.controller;

import com.example.demo.DataStore;
import org.springframework.stereotype.Controller;
import com.example.demo.model.Player;
import com.example.demo.model.Team;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Year;

@Controller
public class ApplicationController {
    private final DataStore dataStore;
    private final int thisYear = Year.now().getValue();



    public ApplicationController(DataStore dataStore){
        this.dataStore = dataStore;
    }

    @RequestMapping("/")
    public String index(){
        return "home";
    }

    @RequestMapping("/home")
    public String home(Model model){
//        model.addAttribute("image1", "/Hurricane.png");
//        model.addAttribute("image2", "/Hurricane2.png");
        return "home";
    }

    @RequestMapping("/addPlayer")
    public String addPlayer(Model model){
        model.addAttribute("thisYear", this.thisYear);
        return "addPlayer";
    }

    @PostMapping("/addPlayer")
    public String submitPlayer(@RequestParam String name, @RequestParam int birthyear, @RequestParam char gender, Model model){
//        //model.addAttribute("thisYear", thisYear);
        Player newPlayer = new Player(name, gender, birthyear); // Assuming teamID is 1
        dataStore.addPlayer(newPlayer);
        dataStore.addPlayerToTeam();
        model.addAttribute("players", dataStore.getPlayers());
        return "displayPlayers";
    }

    @GetMapping("/displayPlayers")
    public String displayPlayers(Model model){
        model.addAttribute("players", dataStore.getPlayers());
        return "displayPlayers";
    }

    @GetMapping("/displayTeams")
    public String displayTeams(Model model){
        model.addAttribute("teams", dataStore.getTeams());
        return "displayTeams";
    }

    @RequestMapping("/viewRoster2/{id}")
    public String viewRoster2(Model model, @PathVariable("id") Integer id) {
        return viewRoster(model, id);
    }

    @RequestMapping("/viewRoster")
    public String viewRoster(Model model, int id) {
        model.addAttribute("players", dataStore.getPlayersInTeam(id));
        return "viewRoster";
    }

    @RequestMapping("/addTeam")
    public String addTeam(Model model){
        return "addTeam";
    }

    @PostMapping("/addTeam")
    public String submitTeam(@RequestParam char gender, @RequestParam int minage, @RequestParam int maxage, @RequestParam String uniformcolor, Model model){
//        //model.addAttribute("thisYear", thisYear);
        Team newTeam = new Team(uniformcolor, gender, minage, maxage);
        dataStore.addTeam(newTeam);
//        dataStore.addPlayerToTeam();
        model.addAttribute("teams", dataStore.getTeams());
        return "displayTeams";
    }

    //The team field should be a dropdown list including only the teams the player can be assigned to, i.e.,
    // the team gender matches the player's gender, and the player age is within the age limit of the team.
    // If the player is currently on a team, that team should be selected in the dropdown list.
    @RequestMapping("/editPlayer/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        System.out.println("ID: " + id);
        Player player = id != null ? dataStore.getPlayer(id) : null;
        if(player == null){
            return "viewRoster";
        }
        model.addAttribute("thisYear", this.thisYear);
        model.addAttribute("players", dataStore.getPlayer(id));
        model.addAttribute("teams", dataStore.getAllTeams());
        model.addAttribute("totalTeams", dataStore.getTotalTeams);
        return "editPlayer";
    }

    @PostMapping("/editPlayer/{id}")
    public String editPlayer(@RequestParam String name, @RequestParam char gender, @RequestParam int birthyear, @RequestParam int teamid, @PathVariable("id") Integer id, Model model){
        Player editedPlayer = new Player(name, gender, birthyear, teamid);
        dataStore.replacePlayer(id, editedPlayer);
        dataStore.addPlayerToTeam();
        System.out.println("TEST");
        return "redirect:../viewRoster2/" +teamid;
        //return "displayPlayers";
    }

//    @PostMapping("/edit/{id}")
//    public String edit(Student studentInput, int majorId, @PathVariable("id") Integer id) {
//        Student student = dataStore.getStudent(id);
//        student.setName(studentInput.getName());
//        student.setGender(studentInput.getGender());
//        student.setLanguages(studentInput.getLanguages());
//        student.setMajor(dataStore.getMajor(majorId));
//        // Because the current URL is /edit/{id}, we need to use .. to get up one level
//        // to get to /view?id={id}
//        return "redirect:../view?id=" + id;
//    }

}
