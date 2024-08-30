package cs3220.demo2.repository;

import cs3220.demo2.model.Player;
import cs3220.demo2.model.Team;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    @Query("SELECT COUNT(t) FROM Team t")
    Integer countAll();
    @Transactional
    @Modifying
    @Query("UPDATE Team SET playerCount = :playerCount WHERE id = :id")
    void updatePlayerCount(@Param("id") Integer id, @Param("playerCount") Integer playerCount);

    @Query("SELECT t.id, t.uniformColor, t.gender, t.minAge, t.maxAge, t.playerCount FROM Team t")
    List<Team> findAllNoLoop();
}
