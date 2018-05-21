package no.difi.statsregnskap;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {
    List<Team> findAll();
    List<Team> findByFirstname(String firstname);
}
