package cs3220.demo2.controller;

import cs3220.demo2.model.Player;
import cs3220.demo2.model.Team;
import cs3220.demo2.repository.PlayerRepository;
import cs3220.demo2.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Year;

import static java.sql.Types.NULL;

@Controller
public class ApplicationController {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final int thisYear = Year.now().getValue();

    public ApplicationController(PlayerRepository playerRepository, TeamRepository teamRepository){
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
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
    public String submitPlayer(Player player, @RequestParam int birth_year){
        player.setBirthYear(birth_year);
//        player.setTeamID(0);
        playerRepository.save(player);
        return "redirect:/displayPlayers";
    }

    @GetMapping("/displayPlayers")
    public String displayPlayers(Model model){
        model.addAttribute("players", playerRepository.findAll());
        return "displayPlayers";
    }

    @GetMapping("/displayTeams")
    public String displayTeams(Model model){
        model.addAttribute("teams", teamRepository.findAll());
        return "displayTeams";
    }

    @RequestMapping("/viewRoster2/{id}")
    public String viewRoster2(Model model, @PathVariable("id") Integer id) {
        return viewRoster(model, id);
    }

    @RequestMapping("/viewRoster")
    public String viewRoster(Model model, int id) {
//        Team team = teamRepository.findById(id).orElse(null);
//        List<Player> player = playerRepository.findAllByTeamId(id);
        model.addAttribute("players", playerRepository.findAllByTeamId(id));
//        if(team!=null) {
//            model.addAttribute("players", team.getPlayers());
//        }
//        else{
//            System.out.println("Error?");
//        }
        return "viewRoster";
    }

    @RequestMapping("/addTeam")
    public String addTeam(Model model){
        return "addTeam";
    }

    @PostMapping("/addTeam")
    public String submitTeam(Team team, @RequestParam int minage, @RequestParam int maxage, @RequestParam String uniformcolor){
        team.setMinAge(minage);
        team.setMaxAge(maxage);
        team.setUniformColor(uniformcolor);
        team.setPlayerCount(playerRepository.countPlayersInTeam(team.getId()));
        teamRepository.save(team);
//        return "displayTeams";
        return "redirect:/displayTeams";
    }

    //The team field should be a dropdown list including only the teams the player can be assigned to, i.e.,
    // the team gender matches the player's gender, and the player age is within the age limit of the team.
    // If the player is currently on a team, that team should be selected in the dropdown list.
    @RequestMapping("/editPlayer/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("thisYear", this.thisYear);
        model.addAttribute("players", playerRepository.findById(id).orElse(null));
        model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("totalTeams", teamRepository.countAll());
        return "editPlayer";
    }

    @PostMapping("/editPlayer/{id}")
    public String editPlayer(Player player, @RequestParam String name, @RequestParam char gender, @RequestParam Integer birthyear, @RequestParam Integer teamid, @PathVariable("id") Integer id, Model model){
//Player editedPlayer = new Player(name, gender, birthyear, teamid);
        playerRepository.updatePlayer(id, name, gender, birthyear, teamRepository.findById(teamid).orElse(null));
        for(int i = 1; i <= teamRepository.countAll(); i++){
            System.out.println("Team " + i + " has " + playerRepository.countPlayersInTeam(i) + " players!");
            teamRepository.updatePlayerCount(i, playerRepository.countPlayersInTeam(i));
        }
        System.out.println("TEST");
        return "redirect:/displayPlayers";
        //return "displayPlayers";
    }

}
