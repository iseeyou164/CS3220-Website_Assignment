package cs3220.demo2.repository;

import cs3220.demo2.model.Player;
import cs3220.demo2.model.Team;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    @Query("SELECT COUNT(p) FROM Player p INNER JOIN Team t ON p.team.id = t.id WHERE p.team.id = :team_id")
    Integer countPlayersInTeam(@Param("team_id") Integer team_id);
//    @Query("SELECT p FROM Player p INNER JOIN Team t ON p.teamID = t.id WHERE p.teamID = :team_id")
    @Transactional
    @Modifying
    @Query("UPDATE Player SET name = :name, gender = :gender, birthYear = :birthyear, team = :team WHERE id = :id")
    void updatePlayer(@Param("id") Integer id, @Param("name") String name, @Param("gender") char gender, @Param("birthyear") long birthyear, @Param("team") Team team);

    @Query("SELECT p FROM Player p INNER JOIN Team t ON p.team.id = t.id WHERE p.team.id = :team_id")
    List<Player> findAllByTeamId(@Param("team_id") int id);

}
