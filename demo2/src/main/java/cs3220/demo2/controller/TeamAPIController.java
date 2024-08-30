package cs3220.demo2.controller;

import cs3220.demo2.model.Player;
import cs3220.demo2.model.PlayerDto;
import cs3220.demo2.model.Team;
import cs3220.demo2.model.TeamDto;
import cs3220.demo2.repository.TeamRepository;
import cs3220.demo2.repository.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TeamAPIController {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public TeamAPIController(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping("")
    public List<TeamDto> index() {
        List<TeamDto> teams = new ArrayList<TeamDto>();
        for (Team t : teamRepository.findAll())
            teams.add(new TeamDto(t));
        return teams;
    }

    @GetMapping("/{id}")
    public TeamDto getTeam(@PathVariable int id) {
        Team t = teamRepository.findById(id).orElse(null);
        if (t == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found");

        return new TeamDto(t);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer addTeam(@RequestBody TeamDto input) {
        Team t = teamRepository.save(input.toTeam());
        return t.getId();
    }

    @PostMapping("/addTo/{tid}/{pid}")
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto addPlayerToTeam(@PathVariable int tid, @PathVariable int pid) {
        Team t = teamRepository.findById(tid).orElse(null);
        if (t == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found");
//        t.getPlayers().add(input.toPlayer(t));
        Player p = playerRepository.findById(pid).orElse(null);
        if(p.getTeam()==null){
            t.getPlayers().add(p);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player is in another team!");
        }
        return new TeamDto(t);
    }

//    @PatchMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateTeam(@PathVariable int id, @RequestBody Map<String, Object> update) {
//        Team t = teamRepository.findById(id).orElse(null);
//        if (t == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found");
//
//        for (String key : update.keySet()) {
//            switch (key) {
//                case "uniformColor":
//                    t.setUniformColor((String) update.get(key));
//                    break;
//                case "gender":
//                    t.setGender((char) update.get(key));
//                    break;
//                case "minAge":
//                    t.setMinAge((Integer) update.get(key));
//                case "maxAge":
//                    t.setMaxAge((Integer) update.get(key));
//                    break;
//            }
//        }
//        teamRepository.save(t);
//    }


}
